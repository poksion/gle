package net.poksion.gle.section;

import static org.junit.Assert.*;

import net.poksion.gle.utils.FileUtils;

import org.junit.Test;

public class SectionBuilderTest {

    @Test
    public void testBuildFromDirectory() {
        String expanedPath = FileUtils.expandPathWithBash("~/blog");
        Section section = new Section();
        SectionBuilder.buildFromDirectory(section, expanedPath);
        assertFalse(section.getSentences().isEmpty());
        assertTrue(section.getSentences().get(0).isParsed());
    }
}
