require 'kramdown'
require 'redcarpet'

def cat_file_kramdown
    text = File.open(File.expand_path('~/notes/btl-diary.md')) { |file| file.read }
    puts Kramdown::Document.new(text).to_html
end

def cat_file_redcarpet
    text = File.open(File.expand_path('~/notes/btl-diary.md')) { |file| file.read }
    markdown = Redcarpet::Markdown.new(Redcarpet::Render::HTML, :autolink => true, :space_after_headers => true)
    puts markdown.render(text)
end

if __FILE__ == $0
    #cat_file_kramdown
    cat_file_redcarpet
end
