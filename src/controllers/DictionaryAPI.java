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
 * API Class to which runs behind the client, bringing all other classes together.
 */
public class DictionaryAPI {

//    private static Heap<Word> testHeap = new Heap<>();
    private static ArrayList<Word> heapArray = new ArrayList<>();

    public DictionaryAPI(){}

    /**
     * Method to add word to heapArray of type words
     * @param spanishWord
     * @param englishWord
     * @return
     */
    public static Word addWord(String spanishWord, String englishWord){
        Word word = new Word(spanishWord, englishWord);
        heapArray.add(word);
        siftUp();
        return word;
    }

    /**
     * Get method to which returns array to string
     * @return
     */
    public static String getWords(){
        return heapArray.toString();
    }

    /**
     * Basic array search method, iterates through a class looking for a match
     * @throws Exception
     */
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

    /**
     * Prime method which uses data input which populates a list of type words
     * from an external final.
     * For each loops through list adding each element from list to heapArray
     * @throws Exception
     */
    public static void prime() throws Exception{
        DataInput loader = new DataInput();
        List<Word> words = loader.loadData("././data/spanish");
        for(Word word : words){
            addToHeap(word);
        }
    }

    /**
     * Method which is called to added an element of type word to the heapArray.
     * Performs sift up in order to arrange array in heap format
     * @param newEntry
     */
    public static void addToHeap(Word newEntry){
        heapArray.add(newEntry);
        siftUp();
    }

    /**
     * Method Sift Up, used for adding an Item to heap. As their is a pattern to a heap
     * the order to which items appear in the heap, it is possible to find a nodes parent
     * by compairing to the parent if result is greater than 0 swap the parent for the node,
     * keep going until parent is less than 0
     */
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

    /**
     * Search heap which takes in element to be searched, and a starting index
     * checks first element in heap, if match returns,  else checks the left child
     * if match returns match
     * else compares to child, if greater than zero if calls method again incrementing to check next left child
     * else checks right child, if match returns match
     * else compares to right child if greater than zero it call method again incrementing to check next child.
     * @param searchWord
     * @param index
     * @return
     */
    public static String searchHeap(String searchWord, int index){
        int k = index;
        int l = 2 * k + 1;
        int r = l + 1;

        if(index == 0) {
            if (heapArray.get(k).spanishWord.equals((searchWord))) {
                return heapArray.get(k).englishWord;
            }
        }
        if (l < heapArray.size()) {
            if (heapArray.get(l).spanishWord.equals((searchWord))) {
                return heapArray.get(l).englishWord;
            }
            String leftChild;
            if(heapArray.get(l).spanishWord.compareTo(searchWord) > 0) {
                leftChild = searchHeap(searchWord, l);
                if(leftChild != "") {
                    return leftChild;
                }
            }
            if (r < heapArray.size()) {
                if(heapArray.get(r).spanishWord.equals((searchWord))) {
                    return heapArray.get(r).englishWord;
                }
                if(heapArray.get(r).spanishWord.compareTo(searchWord) > 0) {
                    String rightChild = searchHeap(searchWord, r);
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
}
