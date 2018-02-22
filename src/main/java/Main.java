import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by danielluzgarten on 22/02/2018.
 */
public class Main {
    public static void main(String args[]){
        Model appModel = Model.getInstance();
        SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
        DocParser docParser = new DocParser( appModel.storageRef+"/autumn.txt");
        docParser = new DocParser( appModel.storageRef+"/my doves.txt");
        //testing
        IndexedWord x =  appModel.indexedWords.get("and");
    }
}
