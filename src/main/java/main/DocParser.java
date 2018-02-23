package main;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import datamodel.Model;

public class DocParser {
    private Model appModel = Model.getInstance();
    private List<String> lines = new ArrayList<String>();
    private String fileName = "";

    public DocParser(String filename) {
        this.fileName= filename;
    }

    public void parse() {
        Scanner scanner = null;
        String line = "";
        try {
            scanner = new Scanner(new FileReader(fileName));
            while (scanner.hasNextLine()){
                line = scanner.nextLine().toLowerCase();
                if (!line.equals("")){
                    lines.add(parseLine(line));
                }
            }
            indexTheDoc();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (scanner!=null){
                scanner.close();
                appModel.indexedWords.size();
            }
        }
    }

    private String parseLine(String txt){
        txt =  txt.replaceAll(" ","~");
        txt =  txt.replaceAll("-","~");
        txt =  txt.replaceAll("_","~");
        txt =  txt.replaceAll("/","~");
        txt =  txt.replaceAll(Pattern.quote("."),"~");
        txt =  txt.replaceAll(",","~");
        txt =  txt.replaceAll(";","~");
        txt =  txt.replaceAll(":","~");
        txt =  txt.replaceAll("\"","~");
        txt =  txt.replaceAll(Pattern.quote("?"),"~");
        txt =  txt.replaceAll(Pattern.quote(")"),"~");
        txt =  txt.replaceAll(Pattern.quote("("),"~");
        txt =  txt.replaceAll(Pattern.quote("{"),"~");
        txt =  txt.replaceAll(Pattern.quote("}"),"~");
        txt =  txt.replaceAll(Pattern.quote("="),"~");
        txt =  txt.replaceAll(Pattern.quote("+"),"~");
        txt =  txt.replaceAll(Pattern.quote("-"),"~");
        txt =  txt.replaceAll(Pattern.quote("!"),"~");
        txt =  txt.replaceAll(Pattern.quote("~~~"),"~");
        txt =  txt.replaceAll(Pattern.quote("~~"),"~");
        return  txt;
    }

    private void indexTheDoc(){
        String lineWords[];
        for (String row:lines) {
            lineWords = row.split("~",-1);
            for (String word: lineWords) {
                Map<String, Integer> wordIndexMap = appModel.indexedWords.get(word);
                if (wordIndexMap != null) {
                    Integer wordInFileNumber = wordIndexMap.get(fileName);
                    if (wordInFileNumber != null){
                        wordIndexMap.put(fileName, wordInFileNumber +1);
                    }
                    else {
                        wordIndexMap.put(fileName, 1);
                    }
                } else {
                    wordIndexMap = new HashMap<>();
                    wordIndexMap.put(fileName,1);
                    appModel.indexedWords.put(word, wordIndexMap);
                }
            }
        }
    }
}
