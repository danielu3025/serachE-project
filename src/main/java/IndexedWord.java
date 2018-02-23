import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class IndexedWord {
    HashMap<String,Integer> frequency = new HashMap<>();
    public IndexedWord(String name) {
        frequency.put(name,1);
    }
    public void updateOccerncey(String name){
        frequency.put(name,frequency.get(name)+1);
    }

}
