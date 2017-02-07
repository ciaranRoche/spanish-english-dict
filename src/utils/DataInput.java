package utils;

import edu.princeton.cs.introcs.In;
import models.Word;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by ciaran on 07/02/2017.
 */
public class DataInput {

    public static void main(String[] args){

    }

    public List<Word> loadData(String filename) throws Exception {
        File wordsFile = new File(filename);
        In inWords = new In(wordsFile);

        String delims = "�\t";

        return null;
    }
}
