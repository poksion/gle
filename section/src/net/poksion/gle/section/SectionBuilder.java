package net.poksion.gle.section;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import net.poksion.gle.utils.FileUtils;

public class SectionBuilder {

    public static void main(String[] args) {
        Section section = new Section();

        if(args.length == 1){
            String directoryPath = args[0];
            buildFromDirectory(section, directoryPath);
        }else{
            buildFromSystemIn(section);
        }

        printWordCountInfo(section);
    }

    public static void buildFromSystemIn(Section section){
        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in))){

            String line = null;
            while( (line = input.readLine()) != null ) {
                buildSectionOnSentenceAdded(section, line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buildFromDirectory(Section section, String dirPath){
        List<String> mdFiles = FileUtils.getFiles(dirPath, ".md");
        for(String fileName : mdFiles){
            try(BufferedReader input = new BufferedReader(new FileReader(new File(fileName)))){

                String line = null;
                while( (line = input.readLine()) != null ) {
                    buildSectionOnSentenceAdded(section, line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void buildSectionOnSentenceAdded(Section section, String line){
        Sentence sentence = section.addSentence(line);
        sentence.parse();
    }

    private static void printWordCountInfo(Section section){
        for(Word.CountInfo info : section.getWordCountInfo()){
            System.out.println(info.word.getValue() + " : " + info.count);
        }
    }
}
