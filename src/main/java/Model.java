import java.util.ArrayList;
import java.util.HashMap;

public class Model {
    private static Model ourInstance = new Model();

    public static Model getInstance() {
        return ourInstance;
    }

    public String storageRef = "src/main/resources/storage";

    public HashMap<String, IndexedWord> indexedWords = new HashMap<>();

    private Model() {
    }
}
