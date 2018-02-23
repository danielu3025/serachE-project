package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchFrame extends JFrame{
    JTextField searchBar = new JTextField();
    JButton logoBt  = new JButton(new ImageIcon("src/main/resources/imges/daniel.png"));
    JButton searchBT  = new JButton(new ImageIcon("src/main/resources/imges/searchBT.png"));
    JButton adminBt  = new JButton(new ImageIcon("src/main/resources/imges/adminBt.png"));
    Font font ;
    JList<String> resultList;


    public SearchFrame() throws HeadlessException {
        initLayout();
        clickListenrs();

    }

    private void frameCreator(){
        setLayout(new FlowLayout());
        setResizable(false);
        setLayout(null);
        setSize(1280,850);
        setTitle("D A N I E L");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void initLayout(){
        searchBar.setBounds(183,376,819,99);
        font = new Font("SansSerif", Font.PLAIN, 40);
        searchBar.setFont(font);
        add(searchBar);

        logoBt.setFocusable(false);
        logoBt.setBorderPainted(false);
        logoBt.setBounds(430,215,396,118);
        add(logoBt);

        searchBT.setBorderPainted(false);
        searchBT.setBounds(1000,378,96,93);
        add(searchBT);

        adminBt.setBorderPainted(false);
        adminBt.setBounds(1187,20,64,64);
        add(adminBt);

        frameCreator();

    }
    private void resulteLayout(){
        font = new Font("SansSerif", Font.PLAIN, 20);
        searchBar.setFont(font);
        logoBt.setIcon(new ImageIcon("src/main/resources/imges/danielSmall.png"));
        logoBt.setBounds(17,31,185,51);
        searchBar.setBounds(212,31,818,47);
        searchBT.setIcon(new ImageIcon("src/main/resources/imges/searchBTSmall.png"));
        searchBT.setBounds(1026,31,45,46);

        results();
    }

    private void clickListenrs(){
        searchBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("im Cliked");
                resulteLayout();
            }
        });
    }

    private void results(){
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("doc1");
        listModel.addElement("doc2");
        listModel.addElement("doc3");
        listModel.addElement("doc4");
        listModel.addElement("doc5");
        listModel.addElement("doc5");
        listModel.addElement("doc6");
        listModel.addElement("doc7");
        listModel.addElement("doc1");
        listModel.addElement("doc2");
        listModel.addElement("doc3");
        listModel.addElement("doc4");
        listModel.addElement("doc5");
        listModel.addElement("doc5");
        listModel.addElement("doc6");
        listModel.addElement("doc7");
        listModel.addElement("doc1");
        listModel.addElement("doc2");
        listModel.addElement("doc3");
        listModel.addElement("doc4");
        listModel.addElement("doc5");
        listModel.addElement("doc5");
        listModel.addElement("doc6");
        listModel.addElement("doc7");
        listModel.addElement("doc1");
        listModel.addElement("doc2");
        listModel.addElement("doc3");
        listModel.addElement("doc4");
        listModel.addElement("doc5");
        listModel.addElement("doc5");
        listModel.addElement("doc6");
        listModel.addElement("doc7");

        //create the list
        resultList = new JList<>(listModel);
        resultList.setFont(new Font("SansSerif", Font.PLAIN, 40));
        resultList.setBounds(20,100,1227,685);
        resultList.setAutoscrolls(true);

        add(resultList);

    }

}
