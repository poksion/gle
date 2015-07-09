package net.poksion.gle.word.filter;

import net.poksion.gle.word.Word;

public class WordFilterRepresentative extends WordFilter {

    public WordFilterRepresentative(WordFilter decoratedFilter){
        super(decoratedFilter);
    }

    public Word refineWord(Word word){
        if(decoratedFilter != null){
            word = decoratedFilter.refineWord(word);
        }

        if(word == null){
            return null;
        }

        if(word.getValue().contains("활용")){
            word = new Word("활용", Word.LANG.KO);
        }

        if(word.getValue().contains("흥미")){
            word = new Word("흥미", Word.LANG.KO);
        }

        if(word.getValue().contains("활동")){
            word = new Word("활동", Word.LANG.KO);
        }

        if(word.getValue().contains("회사동료")){
            word = new Word("회사동료", Word.LANG.KO);
        }else if(word.getValue().contains("회사분")){
            word = new Word("회사동료", Word.LANG.KO);
        }else if(word.getValue().contains("회사사람")){
            word = new Word("회사동료", Word.LANG.KO);
        }else if(word.getValue().contains("회사")){
            String value = word.getValue();
            if( value.length() == 3 || value.equals("회사에서") ||
                value.equals("회사라서") || value.equals("회사보다") ||
                value.equals("회사이다") || value.equals("회사가고") ||
                value.equals("회사내의") || value.equals("회사내에서") ){
                word = new Word("회사", Word.LANG.KO);
            }
        }

        return word;
    }
}
