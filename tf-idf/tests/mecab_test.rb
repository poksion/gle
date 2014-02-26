require 'MeCab'

def cat_mecab
    model = MeCab::Model.new
    tagger = model.createTagger()

    File.open("classic.txt", "r") do | file |
        while (sentence = file.gets)
            n = tagger.parseToNode(sentence)
            while n do
                if n.feature.include?('NN,') and n.surface.length > 1
                    puts n.surface
                else
                    print n.surface,  "--t--", n.feature, "--t--", n.cost, "\n"
                end
                n = n.next
            end
        end
    end
end

if __FILE__ == $0
    cat_mecab
end
