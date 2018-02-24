package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocRenderer extends JPanel implements ListCellRenderer<DocFile> {

    private JLabel lbTitle = new JLabel();
    private JButton removeBt = new JButton(new ImageIcon("src/main/resources/imges/stop.png"));


    public DocRenderer() {
        setLayout(new BorderLayout(5, 5));
        add(lbTitle,BorderLayout.WEST);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends DocFile> list, DocFile value, int index, boolean isSelected, boolean cellHasFocus) {
        lbTitle.setText(value.getPath());
        lbTitle.setFont(new Font("SansSerif", Font.PLAIN, 30));
        lbTitle.setForeground(Color.BLACK);
        lbTitle.setOpaque(true);
        if (isSelected) {
            lbTitle.setBackground(list.getSelectionBackground());
            lbTitle.setForeground(Color.white);
            setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbTitle.setBackground(list.getBackground());
            lbTitle.setForeground(Color.BLACK);
            setBackground(list.getBackground());
        }
        return this;    }
}
