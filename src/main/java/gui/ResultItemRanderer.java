package gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
/**
 this class is responsible to create the result item row in the result layout
 **/
public class ResultItemRanderer  extends JPanel implements ListCellRenderer<ResultItem> {

    private JLabel lbTitle = new JLabel();
    private JLabel lbDescription = new JLabel();

    public ResultItemRanderer() {
        setLayout(new BorderLayout(5, 5));
        add(lbTitle,BorderLayout.NORTH);
        add(lbDescription,BorderLayout.SOUTH);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends ResultItem> list, ResultItem value, int index, boolean isSelected, boolean cellHasFocus) {
        lbTitle.setText(value.getTitle());
        lbTitle.setFont(new Font("SansSerif", Font.BOLD, 25));
        lbTitle.setForeground(Color.BLUE);
        lbDescription.setText(value.description);
        lbDescription.setFont(new Font("SansSerif", Font.PLAIN, 20));

        lbTitle.setOpaque(true);
        lbDescription.setOpaque(true);

        if (isSelected) {
            lbTitle.setBackground(list.getSelectionBackground());
            lbTitle.setForeground(Color.white);
            lbDescription.setBackground(list.getSelectionBackground());
            lbDescription.setForeground(Color.white);
            setBackground(list.getSelectionBackground());

        } else { // when don't select
            lbTitle.setBackground(list.getBackground());
            lbTitle.setForeground(Color.blue);
            lbDescription.setBackground(list.getBackground());
            lbDescription.setForeground(Color.black);
            setBackground(list.getBackground());
        }

        return this;
    }



}
