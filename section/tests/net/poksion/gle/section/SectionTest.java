package net.poksion.gle.section;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;


public class SectionTest {

    @Test
    public void testAddSentence() {
        Section section = new Section();
        Sentence added = section.addSentence("나의 살던 고향은");
        assertNotNull(added);

        assertFalse(added.isParsed());
        added.parse();
        assertTrue(added.isParsed());
    }

    @Test
    public void testGetWordCountInfo() {
        Section section = new Section();
        section.addSentence("나는 정말 사과를 좋아한다.");
        section.addSentence("나는 인조인간도 좋아하는 편이다.");

        assertTrue(section.getSentences().size() == 2);
        for(Sentence sentence : section.getSentences()){
            sentence.parse();
        }

        Set<Word.CountInfo> counts = section.getWordCountInfo();
        assertFalse(counts.isEmpty());
        for(Word.CountInfo info : counts){
            if(info.word.getValue().equals("나는")){
                assertTrue(info.count == 2);
            }
        }
    }

}
