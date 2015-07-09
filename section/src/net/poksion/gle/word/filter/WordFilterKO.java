package net.poksion.gle.word.filter;

import net.poksion.gle.word.Word;

public class WordFilterKO extends WordFilter {

    public WordFilterKO(WordFilter decoratedFilter){
        super(decoratedFilter);
    }

    public Word refineWord(Word word){
        if(decoratedFilter != null){
            word = decoratedFilter.refineWord(word);
        }

        if(word == null){
            return null;
        }

        if(word.getLanguage() != Word.LANG.KO){
            return null;
        }

        return word;
    }
}
