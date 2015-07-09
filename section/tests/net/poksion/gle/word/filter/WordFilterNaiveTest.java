package net.poksion.gle.word.filter;

import static org.junit.Assert.*;
import net.poksion.gle.word.Word;

import org.junit.Test;


public class WordFilterNaiveTest {

    @Test
    public void testWordFilterNaive(){
        WordFilter filter = new WordFilterNaive();
        assertTrue(filter.inFilterList(new Word("은", Word.LANG.KO)));
    }
}
