package main;
import java.io.File;

import datamodel.Model;
import db.SQLiteJDBC;
import gui.AdminFrame;
import gui.AdminInsertFrame;
import gui.SearchFrame;

import javax.swing.*;

/**
 * Created by danielluzgarten on 22/02/2018.
 */
public class Main {

    private JPanel mainPanel;

    public static void main(String args[]){
        // parse and index docs
        Model appModel = Model.getInstance();
        File [] fp = appModel.getListFiles();
        for (File doc: fp) {
            new DocParser(doc.getAbsolutePath()).parse();
        }
        
        // save the index in DB
       // SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();



        //    public static void openMainWindow(){
        //        JFrame frame = new JFrame("D A N I E L");
        //        frame.setContentPane(new App().mainPanel);
        //        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //        frame.pack();
        //        frame.setVisible(true);
        //    }

        //SearchFrame searchFrame = new SearchFrame();
        AdminInsertFrame adminFrame = new AdminInsertFrame();


    }
}
