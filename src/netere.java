

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class netere{


    public netere(String ... args) {
    }

    public void go() {
    
        JPanel headerPanel = getPanel(Color.RED);
        headerPanel.setBackground(Color.RED);
        headerPanel.setPreferredSize(new Dimension(0,50));
        JPanel footerPanel = getPanel(Color.BLUE);

        JPanel p1 = getPanel(Color.GRAY);
        JPanel p2 = getPanel(Color.GRAY);
        JPanel p3 = getPanel(Color.GRAY);
        JPanel p4 = getPanel(Color.GRAY);

        GridLayout gridLayout = (null);
        JPanel middlePanel = new JPanel(gridLayout);
        middlePanel.add(p1);
        middlePanel.add(p2);
        middlePanel.add(p3);
        middlePanel.add(p4);

        JFrame mainFrame = new JFrame();
        mainFrame.add(headerPanel, BorderLayout.NORTH);
        mainFrame.add(middlePanel, BorderLayout.CENTER);
        mainFrame.add(footerPanel, BorderLayout.SOUTH);
        mainFrame.pack();
        mainFrame.setSize(600,600);
        mainFrame.setVisible(true);

    }

     JPanel getPanel(Color c) {
    
        JPanel result = new JPanel();
        result.setBorder(BorderFactory.createLineBorder(c));
        return result;
        
    }
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        netere main = new netere(args);
        main.go();
    }
    

}