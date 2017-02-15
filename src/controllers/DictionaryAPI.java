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

//    private static Heap<Word> testHeap = new Heap<>();
    private static ArrayList<Word> heapArray = new ArrayList<>();

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

//    public static String searchHeap(String s){
//        for(Word word : heapArray){
//            if(word.getSpanishWord().toLowerCase().startsWith(s)){
//                match = word.getEnglishWord();
//            }
//        }
//        return match;
//
//    }
//

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

    public static String searchHeap(String spanishWord, int index){
        int k = index;
        int l = 2 * k + 1;
        int r = l + 1;

        if(index == 0) {
            if (heapArray.get(k).getSpanishWord().equals((spanishWord))) {
                return heapArray.get(k).englishWord;
            }
        }
        if (l < heapArray.size()) {
            if (heapArray.get(l).spanishWord.equals((spanishWord))) {
                return heapArray.get(l).englishWord;
            }
            String leftChild;
            if(heapArray.get(l).spanishWord.compareTo(spanishWord) > 0) {
                leftChild = searchHeap(spanishWord, l);
                if(leftChild != "") {
                    return leftChild;
                }
            }
            if (r < heapArray.size()) {
                if(heapArray.get(r).spanishWord.equals((spanishWord))) {
                    return heapArray.get(r).englishWord;
                }
                if(heapArray.get(r).spanishWord.compareTo(spanishWord) > 0) {
                    String rightChild = searchHeap(spanishWord, r);
                    if(rightChild != "") {
                        return rightChild;
                    } else {
                        return "";
                    }
                }
            }
        }
        return "";
    }

//    public static String searchHeap(String item) {
//        boolean check = true;
//        int k = 0;
//        int l = 2 * k + 1;
//        String temp = "";
//        while ((l < testHeap.size()) && (check)) {
//            int max = l, r = l + l;
//            if (r < testHeap.size()) {
//                if (!testHeap.get(r).spanishWord.equals(item)) {
//                    max++;
//                }
//            }
//            if (heapArray.get(k).spanishWord.equals(item)) {
//                temp = heapArray.get(k).englishWord;
//                return temp;
//            } else {
//                check = false;
//            }
//        }return temp;
//    }


//    public static void prime() throws Exception{
//        DataInput loader = new DataInput();
//        List<Word> words = loader.loadData("././data/spanish");
//        for(Word word : words){
//            addToHeap(word);
//        }
//    }
//
//    public static void addToHeap(Word newEntry){
//        testHeap.add(newEntry);
//    }
//
//    public static String getWords(){
//        return testHeap.toString();
//    }
}
