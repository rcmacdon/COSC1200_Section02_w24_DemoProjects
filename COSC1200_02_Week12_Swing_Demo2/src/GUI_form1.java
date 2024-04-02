/* **********************************
File:
Author:     Clint MacDonald
Date:
Purpose:
************************************* */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_form1 {

    //<editor-fold desc="Form Objects">
    private JFrame frame;
    private JLabel lblNum1, lblNum2, lblAnswer;
    private JTextField txtNum1, txtNum2;
    private JButton btnAdd, btnSub;
    //</editor-fold>

    //<editor-fold desc="Class Scope Variables">
    private enum Operation {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }
    //</editor-fold>

    public GUI_form1() {
        createFormObjects();
    }

    private void createFormObjects() {
        frame = new JFrame();

        // Panel / Pane
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));
        panel.setLayout(new GridLayout(0,1));

        //<editor-fold desc="Labels and TextBoxes">
        lblNum1 = new JLabel("First Number");
        lblNum2 = new JLabel("Second Number");
        txtNum1 = new JTextField();
        txtNum2 = new JTextField();
        // change all properties desired
        // none right now but would be here

        // add to the panel
        panel.add(lblNum1);
        panel.add(txtNum1);
        panel.add(lblNum2);
        panel.add(txtNum2);
        //</editor-fold>

        //<editor-fold desc="Buttons">
        btnAdd = new JButton("+");
        btnSub = new JButton("-");

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // do addition
                doOperation(Operation.ADD);
            }
        });

        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // do subtraction
                doOperation(Operation.SUBTRACT);
            }
        });

        panel.add(btnAdd);
        panel.add(btnSub);

        //</editor-fold>

        lblAnswer = new JLabel();
        panel.add(lblAnswer);

        // finish by setting the frame
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Calculator");
        frame.pack();
        frame.setVisible(true);
    }

    private void doOperation(Operation op) {
        double num1 = 0, num2 = 0, answer = 0;

        try {
            if (Tools.isStringDouble(txtNum1.getText())) {
                num1 = Double.parseDouble(txtNum1.getText());
            } else {
                JOptionPane.showMessageDialog(btnAdd, "An error occurred, check your first value are numbers!");
            }
            if (Tools.isStringDouble(txtNum2.getText())) {
                num2 = Double.parseDouble(txtNum2.getText());
            } else {
                JOptionPane.showMessageDialog(btnAdd, "An error occurred, check your second value are numbers!");
            }

            switch (op) {
                case ADD:
                    answer = num1 + num2;
                    break;
                case SUBTRACT:
                    answer = num1 - num2;
                    break;
                case MULTIPLY:
                case DIVIDE:
            }

            lblAnswer.setText(String.format("%.2f", answer));

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(btnAdd, "An error occurred, check your values are numbers!");
        }

    }

}
