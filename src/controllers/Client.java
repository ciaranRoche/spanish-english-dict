package controllers;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import models.Word;
import utils.Heap;

/**
 * Created by ciaran on 08/02/2017.
 */
public class Client {
    public Heap heap;
    public DictionaryAPI dicAPI;
    public Word word;

    public void Client(){}

    public static void main(String[] args) throws Exception{
        Client client = new Client();
        Shell shell = ShellFactory.createConsoleShell("DIC", "<----------------------->\n   Welcome to Spanish/\n    English Dictonary\n<----------------------->\n- ?help for instructions", client);
        shell.commandLoop();
    }

    @Command(description = "Load Data")
    public String load() throws Exception{
        dicAPI.prime();
        return "Data Loaded";
    }

    @Command(description = "View Heap Dictionary")
    public String getData(){
        return dicAPI.getWords();
    }

    @Command(description = "Add a Word")
    public String addAWord(@Param(name="Spanish Word")String spanishWord,
                           @Param(name="English Word")String englishWord){
        word =  dicAPI.addWord(spanishWord, englishWord);
        return word.spanishWord + " added.\nThank You.";
    }
}