package net.poksion.gle.word;

public class WordCountInfo implements Comparable<WordCountInfo> {

    public Word word;
    public int count;

    @Override
    public int compareTo(WordCountInfo o) {
        if(count == o.count) {
            if(word.getValue() == null || o.word.getValue() == null){
                return 0;
            }
            return word.getValue().compareTo(o.word.getValue());
        }

        // 앞 객체의 count가 더 클때 뒤로 보내고 싶지 않으므로 -1
        // cf. 뒤로 보내고 싶다면 1 (positive)을 리턴한다.
        if(count > o.count) {
            return -1;
        }

        return 1;
    }
}