package gui;
import javax.swing.JOptionPane;
/**
 this class is responsible to create  a pop window with a message
 **/

public class ErrorMsgBox {

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
