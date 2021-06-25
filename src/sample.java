import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

public class sample extends JPanel{
	public static void main(String[] args) {
	JFrame frame = new JFrame();
	
	
	String st[] = {"give","take","buy"};
	JComboBox comb  = new JComboBox(st);
	comb.setBounds(100, 100, 100, 50);
	
	JButton but = new JButton("click");
	but.setBounds(250, 100, 50, 50);
	
	but.addMouseListener(new java.awt.event.MouseAdapter() {
	   
	    public void mouseClicked(java.awt.event.MouseEvent evt) {
	    	if (comb.getSelectedItem() != null) {
	            System.out.println(comb.getSelectedItem().toString());
	            String one = comb.getSelectedItem().toString();
	        }
		}
			
	
	});
	
	
	
	
	
	
	
	
	frame.add(but);
	frame.add(comb);
	frame.setLayout(null);
	frame.setSize(300, 500);
	frame.setVisible(true);


	
	
   
	}
}