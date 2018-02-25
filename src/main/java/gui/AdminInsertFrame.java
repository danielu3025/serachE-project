package gui;

import datamodel.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdminInsertFrame extends JFrame {
    JLabel icon = new JLabel(new ImageIcon("src/main/resources/imges/bigAdmin.png"));

    JTextField searchBar = new JTextField();
    JButton folder = new JButton(new ImageIcon("src/main/resources/imges/folder.png"));
    JButton addDoc = new JButton(new ImageIcon("src/main/resources/imges/addfile.png"));
    JButton submitBt = new JButton(new ImageIcon("src/main/resources/imges/submit.png"));

    DefaultListModel<DocFile> listModel = new DefaultListModel<>();
    JList<DocFile> doccList;

    public AdminInsertFrame() throws HeadlessException {
        frameCreator();
        setclickEvents();
    }
    private void frameCreator(){

        icon.setBounds(570,26,141,141); add(icon);
        searchBar.setBounds(244,228,688,57);
        searchBar.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(searchBar);
        submitBt.setBounds(951,228,172,57);add(submitBt);
        folder.setBounds(312,304,50,39);add(folder);
        addDoc.setBounds(244,301,45,45);add(addDoc);


        results();


        setLayout(new FlowLayout());
        setResizable(false);
        setLayout(null);
        setSize(1280,850);
        setTitle("ADMIN");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setclickEvents(){
        folder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadFilesFromExplorer();
            }
        });
        addDoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!searchBar.getText().isEmpty()){
                    loadSingleFile(searchBar.getText());
                    searchBar.setText("");
                }
            }
        });
        submitBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //run the parser and load to DB
            }
        });
    }

    private void results(){
        //create the list
        doccList  = new JList<DocFile>(listModel);
        doccList.setCellRenderer(new DocRenderer());

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                JList theList = (JList) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2) {
                    int index = theList.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        DocFile o = (DocFile) theList.getModel().getElementAt(index);
                        System.out.println("remove: " + o.getPath());
                        try {

                            File f = new File(Model.getInstance().getTempFolder()
                                    .getAbsolutePath()+"/"+new File(o.path).getName());
                            f.delete();
                            listModel.remove(index);
                        }catch (Exception e){
                            ErrorMsgBox.infoBox("Error","");
                        }
                    }
                }
            }

        };
        JScrollPane scrollPane = new JScrollPane();
        doccList.addMouseListener(mouseListener);

        scrollPane.setViewportView(doccList);
        scrollPane.setBounds(244,386,879,420);
        add(scrollPane);

    }
    private  void loadFilesFromExplorer(){
        FileDialog fd = new FileDialog(new JFrame());
        fd.setVisible(true);
        fd.setMultipleMode(true);
        File[] f = fd.getFiles();
        for (File doc :f){
            try{
                copyFileUsingFileStreams(doc,new File(Model.getInstance().getTempFolder().getAbsolutePath()+"/"+doc.getName()));
                listModel.addElement(new DocFile(doc.getAbsolutePath(),true));
            }
            catch (Exception e){
                ErrorMsgBox.infoBox("error","");
            }
        }
    }
    private void loadSingleFile(String path){

        File file = new File(path);
        if (file.exists()){
            try{
                copyFileUsingFileStreams(file,new File(Model.getInstance().getTempFolder().getAbsolutePath()+"/"+file.getName()));
            }catch (Exception e){
                e.getMessage();
                ErrorMsgBox.infoBox("file dosent exists","Error");
            }
            listModel.addElement(new DocFile(file.getAbsolutePath(),true));
        }
        else ErrorMsgBox.infoBox("file dosent exists","Error");
    }
    private static void copyFileUsingFileStreams(File source, File dest) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }
}
