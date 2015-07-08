package net.poksion.gle.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;


public class FileUtilsTest {

    @Test
    public void testExpandPathWithBash() {
        String expanedPath = FileUtils.expandPathWithBash("~/blog");
        assertNotNull(expanedPath);

        File blogDir = new File(expanedPath);
        assertTrue(blogDir.exists());
    }

    @Test
    public void testGetFiles() {
        String expanedPath = FileUtils.expandPathWithBash("~/blog");
        List<String> mdFiles = FileUtils.getFiles(expanedPath, ".md");
        assertFalse(mdFiles.isEmpty());
    }

}
