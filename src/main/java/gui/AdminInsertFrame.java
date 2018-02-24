package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

            }
        });
    }

    private void results(){

        for (int i = 0 ; i < 5 ; i ++ ){
            listModel.addElement(new DocFile("src/main/resources/storage/AUTUMN.txt",true));
        }
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
                        listModel.remove(index);
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
        String contentType="";
        FileDialog fd = new FileDialog(new JFrame());
        fd.setVisible(true);
        fd.setMultipleMode(true);
        File[] f = fd.getFiles();
        for (File doc :f){
            listModel.addElement(new DocFile(doc.getAbsolutePath(),true));
        }
    }
    private void loadSingleFile(String path){
        File file = new File(path);
        if (file.exists()){
            listModel.addElement(new DocFile(file.getAbsolutePath(),true));
        }
        else ErrorMsgBox.infoBox("file dosent exists","Error");
    }
}
