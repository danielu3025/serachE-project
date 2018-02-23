import java.io.File;

/**
 * Created by danielluzgarten on 22/02/2018.
 */
public class Main {
    public static void main(String args[]){
        Model appModel = Model.getInstance();
        SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
        DocParser docParser;

        File [] fp = appModel.storageFolder.listFiles();

        for (File doc: fp) {
            docParser = new DocParser( doc.getAbsolutePath());
        }



        //testing

        appModel.indexedWords.size();
    }
}
