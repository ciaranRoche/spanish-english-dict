package models;


import com.google.common.base.Objects;

/**
 * Created by ciaran on 07/02/2017.
 * Class the constructs type Word, which implements Comparable
 * This class builds two strings,one spanish word and english word
 * The class consists of the usual getter and setters and toString
 * Along with a compare to method to which overrides the inherited compare to method
 * This is so type word can be compared by spanish word only
 * Also contains an equals to method along with hash code method
 */
public class Word implements Comparable<Word>{
    public String spanishWord;
    public String englishWord;

    public Word(String spanishWord, String englishWord){
        this.spanishWord = spanishWord;
        this.englishWord = englishWord;
    }

    public String toString(){
        return spanishWord + " : " + englishWord + "\n";
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
    public int hashCode(){
        return Objects.hashCode(this.spanishWord, this.englishWord);
    }

    @Override
    public boolean equals(final Object obj){
        if(obj instanceof Word){
            final Word other = (Word) obj;
            return Objects.equal(spanishWord, other.spanishWord)
                    && Objects.equal(englishWord, other.englishWord);
        }else{
            return false;
        }
    }

    @Override
    public int compareTo(Word o) {
        return this.spanishWord.compareTo(o.spanishWord);
    }
}
