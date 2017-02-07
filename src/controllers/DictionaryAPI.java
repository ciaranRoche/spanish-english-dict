package controllers;

import models.Word;
import utils.DataInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ciaran on 07/02/2017.
 */
public class DictionaryAPI {

    public Map<Long, Word> testIndex = new HashMap<>();
    public static List<Word> testInput = new ArrayList<>();


    public DictionaryAPI(){}

    public static void main(String [] args) throws Exception {
        System.out.print("Start test");
        prime();
        System.out.println(testInput.toString());
    }

    public static void prime() throws Exception{
        DataInput loader = new DataInput();
        List<Word> words = loader.loadData("././data/spanish");
        for(Word word : words){
            testInput.add(word);
        }
    }
}
