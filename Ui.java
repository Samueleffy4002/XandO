import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ui {

    Frame window = new Frame("Physics");
    JTextField tfMass = new JTextField("Enter Mass");
    JTextField tfAcceleration = new JTextField("Enter Acceleration");

    JButton btnCalculate = new JButton("Calculate");

    void drawUI() {
        window.add(tfMass);
        window.add(tfAcceleration);
        window.add(btnCalculate);

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Physics physics = new Physics();

                try {
                    float mass = Float.valueOf(tfMass.getText());
                    float acceleration = Float.valueOf(tfAcceleration.getText());

                    JOptionPane.showMessageDialog(null, physics.calculateForce(mass, acceleration));
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Enter only numeric values");
                    nfe.printStackTrace();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Something strange just happened");
                }
            }
        });

        //window.setDefaultCloseOperation()
        window.setLayout(new GridLayout());
        window.setSize(200, 250);
        window.setVisible(true);
    }
}
