package net.poksion.gle.sentence;

import static org.junit.Assert.*;

import org.junit.Test;


public class SentenceTest {

    @Test
    public void testGetValue() {
        String value = "할 수 밖에";
        Sentence sentence = new Sentence(value);
        assertEquals(sentence.getValue(), value);
    }

    @Test
    public void testParse() {
        Sentence sentence = new Sentence("할 수 밖에");
        sentence.parse(null);

        assertTrue(sentence.isParsed());
        assertTrue(sentence.getWords().size() == 3);

        sentence.clearParsed();
        assertFalse(sentence.isParsed());
        assertTrue(sentence.getWords().isEmpty());
    }
}
