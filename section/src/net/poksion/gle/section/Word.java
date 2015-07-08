package net.poksion.gle.section;

public class Word {

    public enum LANG {
        KO,
        EN
    }

    private String value = null;
    private LANG language = null;

    public Word(String wordStr, LANG lang){
        value = wordStr;
        language = lang;
    }

    public String getValue(){
        return value;
    }

    public LANG getLanguage(){
        return language;
    }

    @Override
    public boolean equals(Object other){
        if(value == null){
            return false;
        }

        if(other == null || !(other instanceof Word)){
            return false;
        }

        Word otherWord = (Word)other;
        boolean checkLang = (language == otherWord.language);
        boolean checkValue = value.equals(otherWord.value);
        return (checkValue && checkLang);
    }

    @Override
    public int hashCode(){
        if(value == null){
            return 0;
        }

        return value.hashCode();
    }

    public static class CountInfo implements Comparable<CountInfo> {
        public Word word;
        public int count;

        @Override
        public int compareTo(CountInfo o) {
            if(count == o.count) {
                if(word.value == null || o.word.value == null){
                    return 0;
                }
                return word.value.compareTo(o.word.value);
            }

            // 앞 객체의 count가 더 클때 뒤로 보내고 싶지 않으므로 -1
            // cf. 뒤로 보내고 싶다면 1 (positive)을 리턴한다.
            if(count > o.count) {
                return -1;
            }

            return 1;
        }
    }
}
