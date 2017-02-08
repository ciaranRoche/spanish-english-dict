package models;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * Created by ciaran on 07/02/2017.
 */
public class Word implements Comparable<Word>{
    public String spanishWord;
    public String englishWord;

    public Word(String spanishWord, String englishWord){
        this.spanishWord = spanishWord;
        this.englishWord = englishWord;
    }

    public String toString() {
        return toStringHelper(this).addValue(spanishWord)
                .addValue(englishWord)
                .toString();
    }

    public void addSpanishWord(String spanishWord){
        this.spanishWord = spanishWord;
    }

    public void addEnglishWord(String englishWord){
        this.englishWord = englishWord;
    }

    public String getSpanishWord(){
        return spanishWord;
    }

    public String getEnglishWord(){
        return englishWord;
    }

    @Override
    public int compareTo(Word o) {
        return this.englishWord.compareTo(o.englishWord);
    }
}
