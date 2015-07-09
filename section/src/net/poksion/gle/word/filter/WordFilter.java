package net.poksion.gle.word.filter;

import net.poksion.gle.word.Word;

public interface WordFilter {
    public boolean inFilterList(Word word);
}
