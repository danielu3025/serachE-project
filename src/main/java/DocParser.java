import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
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
    public void indexTheDoc(){
        String arr[];
        for (String row:lines) {
            arr = row.split("~",-1);
            for (String word: arr) {
               if (appModel.indexedWords.containsKey(word)){
                   if (appModel.indexedWords.get(word).containsKey(fileName)){
                       int freq  = appModel.indexedWords.get(word).get(fileName);
                       appModel.indexedWords.get(word).put(fileName,freq +1);
                   }
                   else {
                        appModel.indexedWords.get(word).put(fileName,1);
                   }
               }

               else {
                    Map<String,Integer> obj = new HashMap<>();
                    obj.put(fileName,1);
                    appModel.indexedWords.put(word,obj);
               }
            }
        }
    }



}
