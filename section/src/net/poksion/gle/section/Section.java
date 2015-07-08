package net.poksion.gle.section;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Section {

    private List<Sentence> sentences = new ArrayList<>();

    public Sentence addSentence(String sentenceStr){
        Sentence sentence = new Sentence(sentenceStr);
        sentences.add(sentence);

        return sentence;
    }

    public List<Sentence> getSentences(){
        return sentences;
    }

    public Set<Word.CountInfo> getWordCountInfo(){
        Map<Word, Word.CountInfo> result = new HashMap<>();
        for(Sentence sentence : getSentences()){
            for(Word word : sentence.getWords()){
                Word.CountInfo info = result.get(word);
                if(info == null){
                    info = new Word.CountInfo();
                    info.word = word;
                    info.count = 1;
                    result.put(word, info);
                }else{
                    info.count += 1;
                }
            }
        }

        Set<Word.CountInfo> sorted = new TreeSet<>();
        for(Word.CountInfo info : result.values()){
            sorted.add(info);
        }

        return sorted;
    }
}
