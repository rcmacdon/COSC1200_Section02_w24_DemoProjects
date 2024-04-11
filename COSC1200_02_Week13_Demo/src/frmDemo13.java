import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmDemo13 {
    private JPanel panelMain;
    private JComboBox cboColours;
    private JTextField txtAddColour;
    private JButton btnAddColour;
    private JLabel lblColours;
    private JButton btnNewWindow;
    private JLabel lblMC;
    private JRadioButton radOption1;
    private JRadioButton radOption2;
    private JRadioButton radOption3;
    private JRadioButton radOption4;
    private JCheckBox chkActive;

    private String radButtonSelected;

    public frmDemo13() {


        cboColours.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(cboColours, "You selected " + cboColours.getSelectedItem());
            }
        });

        cboColours.addItem("Green");
        cboColours.addItem("Purple");
        cboColours.addItem("Orange");

        btnAddColour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtAddColour.getText().trim().length() > 0) {
                    cboColours.addItem(txtAddColour.getText().trim());
                    txtAddColour.setText("");
                }
            }
        });

        btnNewWindow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new frmTryMe();
            }
        });
        radOption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doRadioButton("Option 1");
            }
        });
        radOption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doRadioButton("Option 2");
            }
        });
        radOption3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doRadioButton("Option 3");
            }
        });
        radOption4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doRadioButton("Option 4");
            }
        });

        chkActive.isSelected();
    }

    private void doRadioButton(String inputString) {
        radButtonSelected = inputString;
        JOptionPane.showMessageDialog(lblMC, "You selected " + inputString);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("frmDemo13");
        frame.setContentPane(new frmDemo13().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
