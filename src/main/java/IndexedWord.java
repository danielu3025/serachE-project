import java.util.ArrayList;

public class IndexedWord {
    String word;
    class Location{
        String fileName;
        int line ;

        public Location(String fileName, int line) {
            this.fileName = fileName;
            this.line = line;
        }
    }
    ArrayList<Location> wordLoctions = new ArrayList<>();

    public IndexedWord(String word,int line , String file) {
        this.word = word;
        wordLoctions.add(new Location(file,line));
    }

    public void updateLocations(String txt , int num){
        Location location = new Location(txt,num);
        if (!wordLoctions.contains(location)){
            wordLoctions.add(location);
        }
    }

}
