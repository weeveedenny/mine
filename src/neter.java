import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class neter extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 5259700796854880162L;
    private JTextField textField;
    private JLabel lblNewLabel;
    static Window frame;
    int i = 0;

    public neter() {

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        lblNewLabel = new JLabel("New label");
        lblNewLabel.setBackground(Color.LIGHT_GRAY);
        lblNewLabel.setBounds(137, 38, 114, 70);
        panel.add(lblNewLabel);
        lblNewLabel.addMouseListener((MouseListener) new LabelAdapter());

        textField = new JTextField();
        textField.setBounds(122, 119, 86, 20);
        panel.add(textField);
        textField.setColumns(10);

    }

    private class LabelAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            textField.setText(String.valueOf(i));
            i++;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            lblNewLabel.setBackground(Color.CYAN);

        }

        @Override
        public void mouseExited(MouseEvent e) {
            lblNewLabel.setBackground(Color.LIGHT_GRAY);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        frame = new neter();

        frame.setSize(900, 700);
        frame.setVisible(true);
    }
}