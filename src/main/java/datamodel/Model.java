package datamodel;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Model {
    private final File storageFolder;
    private final File tempFolder;
    public Map<String, Map<String,Integer>> indexedWords;
    
    private static Model ourInstance;

    private Model() {
        storageFolder = new File("src/main/resources/storage");
        tempFolder = new File("src/main/resources/temp");
        indexedWords = new HashMap<>();
    }
    
    public static Model getInstance() {
        if (ourInstance == null) {
            ourInstance = new Model();
        }
        
        return ourInstance;
    }
    
    public File[] getListFiles() {
        return storageFolder.listFiles();
    }

    public File getTempFolder() {
        return tempFolder;
    }
}
