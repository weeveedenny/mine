import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class report {
	report(String st) {
		
		JFrame frame = new JFrame();
		
		JLabel report = new JLabel("REPORT");
		
		String data[][] = {{}};
		
		
		Object[] columns = {"DATE","STAFF","SOLD ITEM","CATEGORY","UNIT","QTY","PRICE","CUSTOMER"};

		JTable jt = new JTable(data,columns);
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
		       
	   
	    PreparedStatement pst =dbConnect.prepareStatement("Select * from report;");
	    ResultSet rs = pst.executeQuery();
	    jt.setModel(DbUtils.resultSetToTableModel(rs));

		jt.getColumnModel().getColumn(0).setPreferredWidth(70);
		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(120);
		jt.getColumnModel().getColumn(3).setPreferredWidth(100);
		jt.getColumnModel().getColumn(4).setPreferredWidth(10);
		jt.getColumnModel().getColumn(5).setPreferredWidth(10);
		jt.getColumnModel().getColumn(6).setPreferredWidth(37);
		jt.getColumnModel().getColumn(7).setPreferredWidth(120);
	    dbConnect.close();
	    }
	    catch(Exception ex)
	    {
	    JOptionPane.showMessageDialog(null, ex.toString());
	    }
		
		
		
		
		
		report.setBounds(30, 5, 300, 100);
		report.setFont(new Font("cursive", Font.BOLD, 50));
		report.setForeground(new Color(0, 54, 0));
		
		
		sp.setBounds(30, 100, 810, 500);
		sp.getViewport().setBackground(new Color(0, 54, 0));
		
		
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
		
		
		frame.add(report);
		frame.setLayout(null);
		frame.setSize(900, 700);
		frame.add(sp);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.white);
		frame.setResizable(false);
		
		
	}
	
	
}
