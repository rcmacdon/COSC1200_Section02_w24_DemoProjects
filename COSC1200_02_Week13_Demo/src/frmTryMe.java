/* **********************************
File:
Author:     Clint MacDonald
Date:
Purpose:
************************************* */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


/**
 *
 */
public class frmTryMe {
    private JComboBox cboCars;
    private JFrame frame;
    private JPanel panel;

    public frmTryMe() {
        createFormElements();

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("New Form Opened");
        frame.pack();
        frame.setVisible(true);
    }

    private void createFormElements() {
        frame = new JFrame();

        // Panel
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        panel.setLayout(new GridLayout(0,2));

        cboCars = new JComboBox();
        String[] cars = new String[] {"Civic", "Corolla", "F-150", "Forrester", "CRV", "Elantra"};
        for (String car: cars) {
            cboCars.addItem(car);
        }
        panel.add(cboCars);

    }


}
