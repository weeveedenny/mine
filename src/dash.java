import java.awt.*;


import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.*
;  
public class dash extends javax.swing.JFrame{
	
	

	 dash(String st) {
		
		JFrame frame = new JFrame();
	    JPanel panel = new JPanel();
	    JPanel panel2 = new JPanel(); 
	    
	    panel.setBounds(0, 550, 900, 150);
	    panel2.setBounds(0, 0, 900, 110);
	    
	    JLabel top = new JLabel("Spring SUPERMART");
		top.setBounds(150,0, 750,100);
		top.setFont(new Font("Serif", Font.BOLD, 50));
		top.setForeground(new Color(255, 255, 255));
		frame.add(top);
		
		JLabel side = new JLabel("You are logged in as ");
		side.setBounds(150,45, 750,150);
		side.setFont(new Font("Serif", Font.PLAIN, 20));
		side.setForeground(new Color(0, 54, 0));
		frame.add(side);
		
		JLabel l3 = new JLabel(st);
		l3.setBounds(320,45, 750,150);
		l3.setFont(new Font("Serif", Font.BOLD, 23));
		l3.setForeground(new Color(0, 54, 0));
		frame.add(l3);
		
		
		JButton b = new JButton(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\6.jpg").getImage()
		.getScaledInstance(112, 120, java.awt.Image.SCALE_SMOOTH))));
		b.setBounds(150,190, 100,100);  
		b.setBorderPainted(false);
		frame.add(b);
		b.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		
		JLabel inventory = new JLabel("INVENTORY");
		inventory.setBounds(155, 260, 100, 100);
		inventory.setFont(new Font("Tahoma", Font.BOLD, 15));
		inventory.setForeground(new Color(0, 54, 0));
		frame.add(inventory);
		
		b.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	b.setBorderPainted(true);
		    	b.setBorder(new LineBorder((new Color(0, 54, 0)), 3));
		    	
		    }
		    
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	 new inventory(st);
		    	
		    	frame.setVisible(false);
		    	
		    }
		
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	b.setBorderPainted(false);
		    	 
		    }
		});
		
		
		JButton ab = new JButton(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\report.png").getImage()
		.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH))));
		ab.setBounds(380,360, 100,100); 
		ab.setBorderPainted(false);
		frame.add(ab);
		
		
		
		JLabel report = new JLabel("REPORT");
		report.setBounds(395, 430, 100, 100);
		report.setFont(new Font("Tahoma", Font.BOLD, 15));
		report.setForeground(new Color(0, 54, 0));
		frame.add(report);
		
		ab.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	ab.setBorderPainted(true);
		    	ab.setBorder(new LineBorder((new Color(0, 54, 0)), 3));
		    }
		    
		    public void mouseClicked(java.awt.event.MouseEvent evt){
		    	 new report(st);
		    	
		    	frame.setVisible(false);
		    }
		
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	ab.setBorderPainted(false);
		    }
		});
		
		
		
		JButton a = new JButton(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\sh.jpg").getImage()
		.getScaledInstance(130, 120, java.awt.Image.SCALE_SMOOTH))));
		a.setBounds(380,190, 100,100);  
		a.setBorderPainted(false);
		frame.add(a);
		
		JLabel sell = new JLabel("SELL");
		sell.setBounds(400, 260, 100, 100);
		sell.setFont(new Font("Tahoma", Font.BOLD, 15));
		sell.setForeground(new Color(0, 54, 0));
		frame.add(sell);
		
		a.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	a.setBorderPainted(true);
		    	a.setBorder(new LineBorder((new Color(0, 54, 0)), 3));
		    }
		    
		    
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	new sell(st);
				
				frame.setVisible(false);
			}
				
		
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	a.setBorderPainted(false);
		    }
		});
		
		
		
		JButton abc = new JButton(new ImageIcon(new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\cus.jpg").getImage()
		.getScaledInstance(110, 100, java.awt.Image.SCALE_SMOOTH)));
		abc.setBounds(600,190, 100,100);  
		abc.setBorderPainted(false);
		frame.add(abc);
		
		JLabel customers = new JLabel("CUSTOMERS");
		customers.setBounds(605, 260, 100, 100);
		customers.setFont(new Font("Tahoma", Font.BOLD, 15));
		customers.setForeground(new Color(0, 54, 0));
		frame.add(customers);
		
		abc.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	abc.setBorderPainted(true);
		    	abc.setBorder(new LineBorder((new Color(0, 54, 0)), 3));
		    }
		
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	 new customers(st);
			
				frame.setVisible(false);
			}
		    
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	abc.setBorderPainted(false);
		    }
		});
		
		
		
		JButton abcd = new JButton(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\cccc.jpg").getImage()
		.getScaledInstance(110, 100, java.awt.Image.SCALE_SMOOTH))));
		abcd.setBounds(600,360, 100,100);   
		abcd.setBorderPainted(false);
		frame.add(abcd);
		
		JLabel staff = new JLabel("HELP desk");
		staff.setBounds(610, 430, 100, 100);
		staff.setFont(new Font("Tahoma", Font.BOLD, 15));
		staff.setForeground(new Color(0, 54, 0));
		frame.add(staff);
		
		abcd.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	abcd.setBorderPainted(true);
		    	abcd.setBorder(new LineBorder((new Color(0, 54, 0)), 3));
		    }
		
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	abcd.setBorderPainted(false);
		    }
		    
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	 new help(st);
				
				frame.setVisible(false);
		    }
		});
		
		
		
		JButton abcde = new JButton(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\cashh.png").getImage()
		.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH))));
		abcde.setBounds(150,360, 100,100);  
		abcde.setBackground(new Color(255, 255, 255));
		abcde.setBorderPainted(false);
		frame.add(abcde);
		
		
		JLabel cash = new JLabel("CASH");
		cash.setBounds(170, 430, 100, 100);
		cash.setFont(new Font("Tahoma", Font.BOLD, 15));
		cash.setForeground(new Color(0, 54, 0));
		frame.add(cash);
		
		abcde.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	abcde.setBorderPainted(true);
		    	abcde.setBorder(new LineBorder((new Color(0, 54, 0)), 3));
		    }
		
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	abcde.setBorderPainted(false);
		    }
		});
		
		
		JButton back = new JButton("Log out");
		back.setBounds(355, 20, 150, 50);
		
		back.setBackground(new Color(0, 54, 0));
		back.setFont(new Font("Serif",Font.BOLD,25));
		back.setForeground(new Color(255,255,255));
		back.setFocusable(false);
		back.setBorderPainted(false);
		
		back.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				back make = new back();
				make.bath();
				frame.setVisible(false);
			}
			
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				back.setBorderPainted(true);
				back.setBorder(new LineBorder((new Color(255, 255, 255)), 3));
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) {
				back.setBorderPainted(false);
			}
		});
	    
		 frame.setDefaultCloseOperation(javax.swing. WindowConstants.DISPOSE_ON_CLOSE);
		 frame.getContentPane().setBackground(Color.WHITE);
	     panel.setLayout(null);
	     panel2.setLayout(null);
	     frame.setLayout(null);
	     frame.add(panel);
	     panel.add(back);
	     panel.setBackground(new Color(0, 54, 0));
	     frame.add(panel2);
	     panel2.setBackground(new Color(0, 54, 0));
	     frame.setResizable(false);
	     frame.setVisible(true);
	     frame.setSize(900,700);
		
	}
	
	
}
