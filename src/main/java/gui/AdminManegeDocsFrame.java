package gui;

import db.Doc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminManegeDocsFrame extends JFrame{
    JLabel icon = new JLabel(new ImageIcon("src/main/resources/imges/bigAdmin.png"));

    JTextField searchBar = new JTextField();
    JTextField resField = new JTextField();
    JCheckBox checkBox = new JCheckBox();
    JButton sreach = new JButton(new ImageIcon("src/main/resources/imges/searchBT.png"));

    DefaultListModel<DocFile> listModel = new DefaultListModel<>();
    JList<DocFile> doccList;

    public AdminManegeDocsFrame() throws HeadlessException {
        frameCreator();
        setclickEvents();
    }
    private void frameCreator(){

        icon.setBounds(570,26,141,141); add(icon);
        searchBar.setBounds(244,228,688,57);
        resField.setBounds(244,474,688,57);add(resField);
        resField.setFocusable(false);
        searchBar.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(searchBar);
        checkBox.setBounds(1037,474,57,57);add(checkBox);
        sreach.setBounds(951,228,55,55);add(sreach);
        setLayout(new FlowLayout());
        setResizable(false);
        setLayout(null);
        setSize(1280,850);
        setTitle("ADMIN");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setclickEvents(){
        sreach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!searchBar.getText().isEmpty()){
                    // get do from DB to Doc File OBj
                    DocFile docFile = new DocFile("file path",true);
                    resField.setText(docFile.path);
                    checkBox.setSelected(docFile.isActive);
                }
            }
        });
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!resField.getText().isEmpty()){
                    //update DB
                    System.out.println("testing");
                }
            }
        });
    }
}

