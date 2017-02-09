package controllers;

import models.Word;
import utils.DataInput;
import utils.Heap;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ciaran on 07/02/2017.
 */
public class DictionaryAPI {

    private static Heap<Word> testHeap = new Heap<>();
    private static ArrayList<Word> testArray = new ArrayList<>();

    public static String match;

    public DictionaryAPI(){}

    public static Word addWord(String spanishWord, String englishWord){
        Word word = new Word(spanishWord, englishWord);
        testArray.add(word);
        siftUp();
        return word;
    }

    public static String getWords(){
        return testArray.toString();
    }

    public static String searchHeap(String s){
        for(Word word : testArray){
            if(word.getSpanishWord().toLowerCase().startsWith(s)){
                match = word.getEnglishWord();
            }
        }
        return match;
    }


    public static void prime() throws Exception{
        DataInput loader = new DataInput();
        List<Word> words = loader.loadData("././data/spanish");
        for(Word word : words){
            addToHeap(word);
        }
    }

    public static void addToHeap(Word newEntry){
        testArray.add(newEntry);
        siftUp();
    }

    public static void siftUp(){
        boolean check = true;
        int k = testArray.size() - 1;
        while ((k > 0)&&(check)){
            int p = (k-1)/2;
            Word item = testArray.get(k);
            Word parent = testArray.get(p);

            if(item.compareTo(parent) > 0){
                testArray.set(k, parent);
                testArray.set(p, item);

                k = p;
            }else{
                check = false;
            }
        }
    }

    public static void siftDown(){
        boolean check = true;
        int k = 0;
        int l = 2*k+1;
        while ((l<testArray.size())&&(check)){
            int max = l, r=l+l;
            if(r < testArray.size()){
                if(testArray.get(r).compareTo(testArray.get(l))>0){
                    max ++;
                }
            }
            if(testArray.get(k).compareTo(testArray.get(max))<0){
                Word temp =testArray.get(k);
                testArray.set(k, testArray.get(max));
                testArray.set(max, temp);
                k = max;
                l = 2*k+1;
            }else{
                check = false;
            }
        }
    }
}
