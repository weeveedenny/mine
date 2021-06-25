import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class customers {
	customers(String st){
		
		JFrame frame = new JFrame();
		
		JLabel repor = new JLabel("Customers");
		
		
		BufferedImage img = null;
		try {
		img = ImageIO.read(new File("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\ggfff.jpg"));
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JLabel(new ImageIcon(img)));
		frame.setLayout(null);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		
		
		String data[][] = {{}};
		
		Object[] column = {"CUSTOMER NAME", "PHONE NUMBER"};
		
		JTable jt = new JTable(data,column);
		JScrollPane sp = new JScrollPane(jt);
		jt.setDefaultEditor(Object.class, null);
		
		
		
		 jt.setBackground(new Color(0, 54, 0));
		 jt.setForeground(new Color(255, 255, 255));
		 jt.setFont(new Font("Roman", Font.BOLD, 16));

		 
		 
		 

			//populate JTable from DB
			 
	        String dbname, username, password, url, driver;
		        dbname="dnenis";
		        username="root";
		        password="root";
		        url= "jdbc:mysql://localhost:8080/";
		        driver="com.mysql.jdbc.Driver";
		        Connection dbConnect =null;
		        

		        try{
			        Class.forName(driver).newInstance();
			        dbConnect =DriverManager.getConnection(url+dbname, username, password);
			        System.out.println("Connection established");
			       
		   
		    PreparedStatement pst =dbConnect.prepareStatement("Select * from CUSTOMERS;");
		    ResultSet rs = pst.executeQuery();
		    jt.setModel(DbUtils.resultSetToTableModel(rs));
		   
			jt.getColumnModel().getColumn(0).setPreferredWidth(190);
			jt.getColumnModel().getColumn(1).setPreferredWidth(30);
			
		    dbConnect.close();
		    }
		    catch(Exception ex)
		    {
		    JOptionPane.showMessageDialog(null, ex.toString());
		    }
			
			
		JPanel pan = new JPanel();
		pan.setBounds(0, 0, 900, 100);
		pan.setBackground(new Color(0,54,0));
		
		
		JPanel pan2 = new JPanel();
		pan2.setBounds(0, 450, 900, 400);
		pan2.setBackground(new Color(255,255,255));
		
		
		repor.setBounds(30, 5, 300, 100);
		repor.setFont(new Font("cursive", Font.BOLD, 50));
		repor.setForeground(new Color(255, 255, 255));
		
		
		sp.setBounds(370, 20, 500, 170);
		sp.getViewport().setBackground(new Color(0, 54,0));
		
		
	    
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
		
		pan2.setLayout(null);
		pan.setLayout(null);
		frame.add(pan);
		frame.add(pan2);
		pan.add(repor);
		frame.setLayout(null);
		frame.setSize(900, 700);
		pan2.add(sp);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.white);
		frame.setResizable(false);
		
		
		
	}
	
}
