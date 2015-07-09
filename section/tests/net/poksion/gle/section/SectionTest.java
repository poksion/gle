package net.poksion.gle.section;

import static org.junit.Assert.*;

import java.util.Set;

import net.poksion.gle.sentence.Sentence;
import net.poksion.gle.word.WordCountInfo;

import org.junit.Test;


public class SectionTest {

    @Test
    public void testAddSentence() {
        Section section = new Section();
        Sentence added = section.addSentence("나의 살던 고향은", true);
        assertNotNull(added);
        assertTrue(added.isParsed());
    }

    @Test
    public void testGetWordCountInfo() {
        Section section = new Section();
        section.addSentence("나는 정말 사과를 좋아한다.", true);
        section.addSentence("나는 인조인간도 좋아하는 편이다.", true);

        assertTrue(section.getSentences().size() == 2);

        Set<WordCountInfo> counts = section.getWordCountInfo();
        assertFalse(counts.isEmpty());
        for(WordCountInfo info : counts){
            if(info.word.getValue().equals("나는")){
                assertTrue(info.count == 2);
            }
        }
    }

}
