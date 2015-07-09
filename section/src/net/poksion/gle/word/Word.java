package net.poksion.gle.word;

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
}
