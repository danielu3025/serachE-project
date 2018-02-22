import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DocParser {
    Model appModel = Model.getInstance();
    List<String> lines = new ArrayList<String>();
    String fileName = "";
    public DocParser(String filename) {
        Scanner scanner = null;
        fileName = filename;
        String line = "";
        try {
            scanner = new Scanner(new FileReader(filename));
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
    public String parseLine(String txt){
        txt =  txt.replaceAll(" ","~");
        txt =  txt.replaceAll("-","~");
        txt =  txt.replaceAll("_","~");
        txt =  txt.replaceAll("/","~");
        txt =  txt.replaceAll(Pattern.quote("."),"~");
        txt =  txt.replaceAll(",","~");
        txt =  txt.replaceAll(";","~");
        txt =  txt.replaceAll("\"","~");
        txt =  txt.replaceAll(Pattern.quote("?"),"~");
        txt =  txt.replaceAll(Pattern.quote("!"),"~");
        txt =  txt.replaceAll(Pattern.quote("~~~"),"~");
        txt =  txt.replaceAll(Pattern.quote("~~"),"~");
        return  txt;
    }
    public void indexTheDoc(){
        String arr[];
        for (String row:lines) {
            arr = row.split("~",-1);
            for (String word: arr) {
               if (appModel.indexedWords.containsKey(word)){
                   appModel.indexedWords.get(word).updateLocations(fileName,lines.indexOf(row));
               }
               else {
                   appModel.indexedWords.put(word,new IndexedWord(word,lines.indexOf(row),fileName));
               }
            }
        }
    }



}
