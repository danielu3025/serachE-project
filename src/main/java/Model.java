import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {
    private static Model ourInstance = new Model();

    public static Model getInstance() {
        return ourInstance;
    }

    public String storageRef = "src/main/resources/storage";
    File storageFolder = new File(storageRef);


    public Map<String, Map <String,Integer> > indexedWords = new HashMap<>();

    private Model() {
    }
}
