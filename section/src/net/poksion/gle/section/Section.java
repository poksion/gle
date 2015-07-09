package net.poksion.gle.section;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import net.poksion.gle.sentence.Sentence;
import net.poksion.gle.word.Word;
import net.poksion.gle.word.WordCountInfo;
import net.poksion.gle.word.filter.WordFilter;

public class Section {

    private List<Sentence> sentences = new ArrayList<>();
    private WordFilter wordFilter = null;

    public Section(){
        this(null);
    }

    public Section(WordFilter wordFilter){
        this.wordFilter = wordFilter;
    }

    public Sentence addSentence(String sentenceStr, boolean withParse){
        Sentence sentence = new Sentence(sentenceStr);
        sentences.add(sentence);

        if(withParse){
            sentence.parse(wordFilter);
        }

        return sentence;
    }

    public List<Sentence> getSentences(){
        return sentences;
    }

    public Set<WordCountInfo> getWordCountInfo(){
        Map<Word, WordCountInfo> result = new HashMap<>();
        for(Sentence sentence : getSentences()){
            for(Word word : sentence.getWords()){
                WordCountInfo info = result.get(word);
                if(info == null){
                    info = new WordCountInfo();
                    info.word = word;
                    info.count = 1;
                    result.put(word, info);
                }else{
                    info.count += 1;
                }
            }
        }

        Set<WordCountInfo> sorted = new TreeSet<>();
        for(WordCountInfo info : result.values()){
            sorted.add(info);
        }

        return sorted;
    }
}
