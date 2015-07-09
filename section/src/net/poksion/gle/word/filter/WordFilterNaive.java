package net.poksion.gle.word.filter;

import java.util.HashSet;
import java.util.Set;

import net.poksion.gle.word.Word;

public class WordFilterNaive extends WordFilter {
    private static Set<Word> filteringList = new HashSet<>();
    static {
        filteringList.add(new Word("은", Word.LANG.KO));
        filteringList.add(new Word("는", Word.LANG.KO));
        filteringList.add(new Word("이", Word.LANG.KO));
        filteringList.add(new Word("가", Word.LANG.KO));

        filteringList.add(new Word("을", Word.LANG.KO));
        filteringList.add(new Word("를", Word.LANG.KO));

        filteringList.add(new Word("의", Word.LANG.KO));
        filteringList.add(new Word("수", Word.LANG.KO));
        filteringList.add(new Word("에", Word.LANG.KO));
        filteringList.add(new Word("할", Word.LANG.KO));
        filteringList.add(new Word("로", Word.LANG.KO));
        filteringList.add(new Word("와", Word.LANG.KO));
        filteringList.add(new Word("과", Word.LANG.KO));
        filteringList.add(new Word("라고", Word.LANG.KO));
        filteringList.add(new Word("있게", Word.LANG.KO));
        filteringList.add(new Word("으로", Word.LANG.KO));

        filteringList.add(new Word("g", Word.LANG.EN));
    }

    public WordFilterNaive(){
        super(null);
    }

    public Word refineWord(Word word){
        if(filteringList.contains(word)){
            return null;
        }

        return word;
    }
}
