package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

public class SearchFrame extends JFrame{
    JTextField searchBar = new JTextField();
    JButton logoBt  = new JButton(new ImageIcon("src/main/resources/imges/daniel.png"));
    JButton searchBT  = new JButton(new ImageIcon("src/main/resources/imges/searchBT.png"));
    JButton adminBt  = new JButton(new ImageIcon("src/main/resources/imges/adminBt.png"));
    Font font ;
    DefaultListModel<ResultItem> listModel = new DefaultListModel<>();
    JList<ResultItem> resultList;



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
    //this function set the first Screen
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
    //this function set the result screen
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
    //this functions set the button listeners
    private void clickListenrs(){
        searchBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });

        adminBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open Admin window");
                //call admin program here
            }
        });

        searchBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    search();
                }
            }
        });
    }
    //this function is for showing the results
    private void results(){

        //insert the real results from query here
        for (int i = 0 ; i < 30 ; i ++ ){
            listModel.addElement(new ResultItem("AUTUMN","src/main/resources/storage/AUTUMN.txt","NOW droops the troubled year\n" + "And now her tiny sunset stains the leaf.\n" + "A holy fear,\n"));
        }

        //create the list
        resultList = new JList<ResultItem>(listModel);

        resultList.setCellRenderer(new ResultItemRanderer());

        // dabble click to open file listenr
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                JList theList = (JList) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2) {
                    int index = theList.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        ResultItem o = (ResultItem) theList.getModel().getElementAt(index);
                        System.out.println("open file : " + o.getFilePath());
                        openFile(o.filePath);
                    }
                }
            }
        };

        resultList.addMouseListener(mouseListener);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(resultList);
        scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent ae) {
                int extent = scrollPane.getVerticalScrollBar().getModel().getExtent();

                if (scrollPane.getVerticalScrollBar().getValue()+ extent >= scrollPane.getVerticalScrollBar().getMaximum()/2 ){
                    System.out.println("reach the half wat brig more results");
                    addRes();
                }
            }
        });

        scrollPane.setBounds(20,100,1240,685);
        add(scrollPane);

    }
    //this function open file if it its path is exists with default program
    public void openFile(String path){
        File file = new File(path);
        try {
            if (!file.exists()){
                ErrorMsgBox.infoBox("file not found!","Error");
            }
            else {
                Desktop.getDesktop().open(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //this function should activate the query and when its done show the result layout
    private void search(){
        if (!searchBar.getText().isEmpty()){
            //call query hear
            System.out.println("Search");
            resulteLayout();
        }
    }
    //this function need to fetch more data if needed
    private void addRes(){
        // bring more results
    }
}
