package net.poksion.gle.word.filter;

import net.poksion.gle.word.Word;

public abstract class WordFilter {

    public static Word makeFilteredWord(WordFilter filter, String value, Word.LANG lang){
        Word word = new Word(value, lang);
        return filter.refineWord(word);
    }

    protected WordFilter decoratedFilter;
    public WordFilter(WordFilter decoratedFilter){
        this.decoratedFilter = decoratedFilter;
    }

    public abstract Word refineWord(Word word);
}
