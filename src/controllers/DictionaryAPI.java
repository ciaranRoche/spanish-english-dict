package controllers;

import com.google.common.base.Stopwatch;
import models.Word;
import utils.DataInput;
import utils.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * Created by ciaran on 07/02/2017.
 */
public class DictionaryAPI {

    //private static Heap<Word> testHeap = new Heap<>();
    private static ArrayList<Word> heapArray = new ArrayList<>();
    private static ArrayList<Word> sortedArray = new ArrayList<Word>();

    public static String match;

    public DictionaryAPI(){}

    public static Word addWord(String spanishWord, String englishWord){
        Word word = new Word(spanishWord, englishWord);
        heapArray.add(word);
        siftUp();
        return word;
    }

    public static String getWords(){
        return heapArray.toString();
    }

    public static String searchHeap(String s){
        Stopwatch stopwatch = Stopwatch.createStarted();

        for(Word word : heapArray){
            if(word.getSpanishWord().toLowerCase().startsWith(s)){
                match = word.getEnglishWord();
            }
        }
        stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("Time taken to run heap search: " + stopwatch);
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
        heapArray.add(newEntry);
        siftUp();
    }


    public static void siftUp(){
        boolean check = true;
        int k = heapArray.size() - 1;
        while ((k > 0)&&(check)){
            int p = (k-1)/2;
            Word item = heapArray.get(k);
            Word parent = heapArray.get(p);

            if(item.compareTo(parent) > 0){
                heapArray.set(k, parent);
                heapArray.set(p, item);

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
        while ((l<heapArray.size())&&(check)){
            int max = l, r=l+l;
            if(r < heapArray.size()){
                if(heapArray.get(r).compareTo(heapArray.get(l))>0){
                    max ++;
                }
            }
            if(heapArray.get(k).compareTo(heapArray.get(max))<0){
                Word temp =heapArray.get(k);
                heapArray.set(k, heapArray.get(max));
                heapArray.set(max, temp);
                k = max;
                l = 2*k+1;
            }else{
                check = false;
            }
        }
    }

    public static void primeSorted() throws Exception{
        DataInput loader = new DataInput();
        List<Word> words = loader.loadData("././data/spanish");
        for(Word word : words){
            addAndSort(word);
        }
    }

    public static void addAndSort(Word newEntry){
        sortedArray.add(newEntry);
        Collections.sort(sortedArray);
    }

    public static String getSorted(){
        return sortedArray.toString();
    }

    public static String searchSorted(String input){
        int first = 0;
        int last = sortedArray.size() - 1;
        while(first - last > 0){
            int middle = (first + last)/2;
            if(getAllWords().get(middle).spanishWord.equals(input)){
                return getAllWords().get(middle).englishWord;
            }else if(getAllWords().get(middle).spanishWord.compareTo(input) < 0){
                first = middle + 1;
            }else if(getAllWords().get(middle).spanishWord.compareTo(input) > 0){
                last = middle - 1;
            }
        }
        if(getAllWords().get(first).spanishWord.equals(input)){
            return getAllWords().get(first).englishWord;
        }else{
            return "***no match***";
        }
    }

    public static List<Word> getAllWords(){
        return sortedArray;
    }
}
