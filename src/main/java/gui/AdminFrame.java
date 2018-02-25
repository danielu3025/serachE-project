package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame extends JFrame {
    JLabel icon = new JLabel(new ImageIcon("src/main/resources/imges/bigAdmin.png"));
    JButton addDocs = new JButton(new ImageIcon("src/main/resources/imges/addDocs.png"));
    JButton manageDocs = new JButton(new ImageIcon("src/main/resources/imges/manageDocs.png"));

    public AdminFrame() throws HeadlessException {
        frameCreator();
        setclickEvents();
    }
    private void frameCreator(){

        icon.setBounds(110,61,141,141); add(icon);
        addDocs.setBounds(44,284,273,73);add(addDocs);
        manageDocs.setBounds(44,414,273,73);add(manageDocs);

        setLayout(new FlowLayout());
        setResizable(false);
        setLayout(null);
        setSize(360,640);
        setTitle("ADMIN");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setclickEvents(){
        addDocs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminInsertFrame adminInsertFrame = new AdminInsertFrame();
            }
        });
        manageDocs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminManegeDocsFrame adminManegeDocsFrame = new AdminManegeDocsFrame();

            }
        });
    }

}
