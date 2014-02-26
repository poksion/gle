require 'MeCab'
require 'set'
require 'rubyvis'

class TermCounter
    @@exclusive_words = Set.new ["공연", "음악회", "연주회", "콘서트", "예술", "전당", "생명", "무대", "점검"]

    def make_from_file(tagger, file_name)
        word_map = Hash.new{ |hash, key| hash[key] = 0 }
        File.open(file_name, "r") do | file |
            while (sentence = file.gets)
                n = tagger.parseToNode(sentence)
                while n do
                    if n.feature.include?('NN,')
                        word = n.surface
                        if word.length > 1 and false == @@exclusive_words.include?(word)
                            word_map[word] += 1
                        end
                    end
                    n = n.next
                end
            end
        end
        return word_map
    end

    def cat_mecab
        model = MeCab::Model.new
        tagger = model.createTagger()

        word_map = make_from_file(tagger, "classic.txt")

        word_map.sort {|a1,a2| a2[1]<=>a1[1]}.each do | key, value |
            puts "#{key}(#{value})"
        end
    
    end
    
    def cat_mecab_visual
        model = MeCab::Model.new
        tagger = model.createTagger()
        
        files = make_from_file(tagger, "classic.txt")
        
        classes = Rubyvis.nodes(Rubyvis.flatten(files).leaf(lambda {|v| v.is_a? Numeric}).array)
        
        classes[1,classes.size-1].each {|d|
          #p d.node_value.keys
          d.node_name = "/" + d.node_value[:keys].join("/")
          i = d.node_name.rindex("/")
          class << d
            attr_accessor :class_name, :package_name
          end
          d.class_name = d.node_name[i+1,d.node_name.size-(i+1)].gsub(".rb","")
          d.package_name = d.node_name[0,i]
          d.node_value = d.node_value[:value]
        }
        # For pretty number formatting.
        format = Rubyvis.Format.number
        
        vis = Rubyvis::Panel.new.width(800).height(800)
        c20=Rubyvis::Colors.category20()
        vis.add(pv.Layout.Pack)\
            .top(-50).bottom(-50)\
            .nodes(classes)              \
            .size(lambda {|d| d.node_value})\
            .spacing(0)\
            .order(nil)\
            .node.add(Rubyvis::Dot)\
            .fill_style(lambda {|d| c20.scale(d.class_name)})\
            .stroke_style(lambda {|d| c20.scale(d.class_name).darker})\
            .visible(lambda {|d| d.parent_node})\
            .title(lambda {|d| d.node_name + ": " + format.format(d.node_value)})\
            .anchor("center")\
            .add(pv.Label)\
            .text(lambda {|d| d.class_name})
#            .text(lambda {|d| d.class_name[0, Math.sqrt(d.node_value).to_i / 8]})

        vis.render();
        File.open('chart.svg', 'w') do |f|  
            f.puts vis.to_svg
        end 
    end

end

if __FILE__ == $0
    #TermCounter.new.cat_mecab_visual
    TermCounter.new.cat_mecab
end
