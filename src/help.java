import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class help {
	help(String st) {
		
		JFrame frame = new JFrame();
		JLabel lab = new JLabel("HELP desk");
		
		
		BufferedImage img = null;
		try {
		img = ImageIO.read(new File("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\www.jpg"));
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JLabel(new ImageIcon(img)));
		frame.setLayout(null);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		
		
		JLabel lab2 = new JLabel("Web Developer/Engineer " );
				JLabel lab3 = new JLabel ("Web Programming");
				JLabel lab4 = new JLabel("Web Applications");
				JLabel lab5 = new JLabel ("Desktop Applications");
				JLabel lab56 = new JLabel ("Front End/Back End progrmmaing");
				JLabel lab6 = new JLabel ("Contact Phone:   +234701-116-3715");
				
		
		
		lab2.setBounds(30, 115, 300, 100);
		lab2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lab2.setForeground(new Color(0,54,0));
		
		lab3.setBounds(30, 145, 300, 100);
		lab3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lab3.setForeground(new Color(0,54,0));
		
		lab4.setBounds(30, 175, 300, 100);
		lab4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lab4.setForeground(new Color(0,54,0));
		
		lab5.setBounds(30, 205, 300, 100);
		lab5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lab5.setForeground(new Color(0,54,0));
		
		lab56.setBounds(30, 235, 300, 100);
		lab56.setFont(new Font("Tahoma", Font.BOLD, 17));
		lab56.setForeground(new Color(0,54,0));
		
		lab6.setBounds(30, 450, 400, 100);
		lab6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lab6.setForeground(new Color(0,54,0));
		
		
		lab.setBounds(30, 50, 300, 100);
		lab.setFont(new Font("Tahoma", Font.BOLD, 45));
		lab.setForeground(new Color(0,54,0));
		
		
		JPanel pan = new JPanel();
		pan.setBounds(0, 0, 900, 100);
		pan.setBackground(Color.white);
		
		JPanel pan2 = new JPanel();
		pan2.setBounds(0, 583, 900, 100);
		pan2.setBackground(Color.white);
		

		 JButton back = new JButton("Back");
		 back.setBounds(30, 610, 70, 30);
		 back.setBackground(new Color(0,54,0));
		 back.setForeground(new Color(255,255,255));
		 back.setFocusable(false);
		 frame.add(back);
		 
		 back.addMouseListener(new java.awt.event.MouseAdapter() {
			   public void mouseClicked(java.awt.event.MouseEvent evt) {
					new dash(st);
					frame.setVisible(false);
					
				}
			});
		
		frame.add(lab2);
		frame.add(lab3);
		frame.add(lab4);
		frame.add(lab5);
		frame.add(lab56);
		frame.add(lab6);
		frame.add(lab);
		frame.setLayout(null);
		frame.setSize(900, 700);
		frame.add(pan);
		frame.add(pan2);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.white);
		frame.setResizable(false);
		
	}
	
	
}
