package controllers;

import models.Word;
import utils.DataInput;
import utils.Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ciaran on 07/02/2017.
 */
public class DictionaryAPI {

    private static Heap<Word> testHeap = new Heap<>();

    public DictionaryAPI(){}

    public static void main(String [] args) throws Exception {
        System.out.print("Start test");
        prime();
        System.out.println(testHeap.toString());
        addWord("test", "ztest");
        System.out.println(testHeap.toString());
        addWord("test", "atest");
        System.out.println(testHeap.toString());
    }

    public static void addWord(String spanishWord, String englishWord){
        testHeap.add(new Word(spanishWord, englishWord));
    }

    public static void prime() throws Exception{
        DataInput loader = new DataInput();
        List<Word> words = loader.loadData("././data/spanish");
        for(Word word : words){
            testHeap.add(word);
        }
    }
}
