package net.poksion.gle.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static String expandPathWithBash(String path) {
        String expandedPath = null;
        try {
            String command = "ls -d " + path;
            Process shellExec = Runtime.getRuntime().exec(new String[]{"bash", "-c", command});
            BufferedReader reader = new BufferedReader(new InputStreamReader(shellExec.getInputStream()));
            expandedPath = reader.readLine();
        } catch (IOException exception) {
            expandedPath = null;
        }

        return expandedPath;
    }

    private static void aggregateFiles(final File folder, List<String> files, String fileExtWithDot) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                aggregateFiles(fileEntry, files, fileExtWithDot);
            } else {
                String fileName = fileEntry.getAbsolutePath();
                if(fileName.endsWith(fileExtWithDot)){
                    files.add(fileName);
                }
            }
        }
    }

    public static List<String> getFiles(String dirPath, String fileExtWithDot){
        final File folder = new File(dirPath);
        List<String> result = new ArrayList<>();
        aggregateFiles(folder, result, fileExtWithDot);

        return result;
    }
}
