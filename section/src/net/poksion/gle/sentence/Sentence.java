package net.poksion.gle.sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.poksion.gle.word.Word;
import net.poksion.gle.word.filter.WordFilter;

public class Sentence {

    private String value = null;
    private List<Word> words = new ArrayList<>();
    private boolean parsed = false;

    public Sentence(String sentenceStr) {
        value = sentenceStr;
    }

    public void parse(WordFilter wordFilter){
        if(value == null || parsed){
            return;
        }

        // 한글 단어 선택
        Pattern p = Pattern.compile("([ㄱ-ㅎㅏ-ㅣ가-힣]+|[a-zA-Z]+)");
        Matcher m = p.matcher(value);
        while(m.find()){
            String wordStr = m.group(0);
            Word.LANG lang = Word.LANG.KO;
            if(isAlphabet(wordStr.charAt(0))){
                wordStr = wordStr.toLowerCase();
                lang = Word.LANG.EN;
            }

            Word word = WordFilter.makeFilteredWord(wordFilter, wordStr, lang);
            if(word != null){
                words.add(word);
            }
        }

        parsed = true;
    }

    public boolean isParsed(){
        return parsed;
    }

    public void clearParsed(){
        words.clear();
        parsed = false;
    }

    public String getValue() {
        return value;
    }

    public List<Word> getWords(){
        return words;
    }

    private boolean isAlphabet(char character){
        if(character >= 'a' && character <= 'z'){
            return true;
        }

        if(character >= 'A' && character <= 'Z'){
            return true;
        }

        return false;
    }
}
