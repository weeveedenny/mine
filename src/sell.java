import javax.swing.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;
import java.awt.event.*;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

import com.sun.istack.internal.logging.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
  
public class sell extends Canvas{
	private static Map<String, java.util.List<String>> values;
	
	 
	sell(String names) {
		
		
		JFrame frame = new JFrame();
		JLabel date = new JLabel("Date");
		date.setBounds(20, 5, 50, 50);
		date.setFont(new Font("Serif", Font.BOLD, 20));
		date.setForeground(new Color(0, 54, 0));
		frame.add(date);
		
		
		JLabel staff = new JLabel("Staff");
		staff.setBounds(20, 55, 50, 50);
		staff.setFont(new Font("Serif", Font.BOLD, 20));
		staff.setForeground(new Color(0, 54, 0));
		frame.add(staff);
		
		JTextField staf = new JTextField(names);
		staf.setBounds(140, 65, 250, 30);
		staf.setBackground(new Color(0, 54, 0));
		staf.setForeground(new Color(255, 255, 255));
		staf.setFont(new Font("Serif", Font.BOLD, 20));
		frame.add(staf);
		
		
		JLabel Category = new JLabel("Category");
		Category.setBounds(20, 105, 100, 50);
		Category.setFont(new Font("Serif", Font.BOLD, 20));
		Category.setForeground(new Color(0, 54, 0));
		frame.add(Category);
		
		JLabel item = new JLabel("Item");
		item.setBounds(20, 155, 50, 50);
		item.setFont(new Font("Serif", Font.BOLD, 20));
		item.setForeground(new Color(0, 54, 0));
		frame.add(item);
		
		JLabel qtyleft = new JLabel("Quantity left: ");
		qtyleft.setBounds(498, 150, 400, 50);
		qtyleft.setFont(new Font("Tahoma", Font.BOLD, 25));
		qtyleft.setForeground(new Color(0, 54, 0));
		frame.add(qtyleft);
		
		JLabel figure = new JLabel("");
		figure.setBounds(690, 150, 400, 50);
		figure.setFont(new Font("Tahoma", Font.BOLD, 25));
		figure.setForeground(new Color(196,91, 254));
		frame.add(figure);
		
		
		JTable jt = new JTable();
		
		Object[] columns = {"DATE","ITEM","CATEGORY","UNIT","QUANTITY","PRICE",};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		jt.setModel(model);
		
		
		jt.getColumnModel().getColumn(0).setPreferredWidth(50);
		jt.getColumnModel().getColumn(1).setPreferredWidth(130);
		jt.getColumnModel().getColumn(2).setPreferredWidth(160);
		jt.getColumnModel().getColumn(3).setPreferredWidth(5);
		jt.getColumnModel().getColumn(4).setPreferredWidth(5);
		jt.getColumnModel().getColumn(5).setPreferredWidth(5);
		
		
		     jt.setBounds(0,0,850,200);  
		     jt.setBackground(new Color(0, 54, 0));
			 jt.setForeground(new Color(255, 255, 255));
			 jt.setFont(new Font("Roman", Font.BOLD, 14));
			 JScrollPane sp=new JScrollPane(jt);  
			 sp.setBounds(20,340,830,250);
			 sp.getViewport().setBackground(new Color(0, 54, 0));
		     frame.add(sp);
		  
		    

		String f[] = {"Toiletries","Cosmetics","Diary","Tobacco","Groceries","Bakery","Beverages","Frozen foods","Electronics","---Select a Categroy---"};
		
		JComboBox first = new JComboBox(f);

        first.setBounds(140, 115, 250, 30);
        first.setBackground(new Color(0, 54, 0));
	    first.setForeground(new Color(255, 255, 255));
	    first.setFont(new Font("Serif", Font.BOLD, 20));
	   

		String sec[] = {};
		
		JComboBox second = new JComboBox(sec);
        second.setBounds(140, 164, 250, 30);
	    second.setBackground(new Color(0, 54, 0));
	    second.setForeground(new Color(255, 255, 255));
	    second.setFont(new Font("Serif", Font.BOLD, 20));
	    frame.add(first);
        frame.add(second);
		
	

		 SpinnerModel value =   new SpinnerNumberModel(0, 0,100, 1); 
		 JSpinner spinner = new JSpinner(value);   
        spinner.setBounds(320,215,70,30);   
        spinner.setFont(new Font("Serif", Font.BOLD, 18));
        spinner.setBackground(new Color(0, 54, 0));
	    spinner.setForeground(new Color(255, 255, 255));
        frame.add(spinner);  
		
        
        
        first.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
            	 
             //Clear Combobox before loading from DB
             values = new HashMap<>();
 		        String value = (String) first.getSelectedItem();
                 List<String> secondValues = values.get(value);
                 DefaultComboBoxModel model = (DefaultComboBoxModel) second.getModel();
                 model.removeAllElements();
               //End..
                 
                 spinner.setValue(1);
                String selectedItem = (String)first.getSelectedItem();
                if(selectedItem.equals("Toiletries"))
                {
                	
                	String dbname, username, password, url, driver;
    		        dbname="dnenis";
    		        username="root";
    		        password="root";
    		        url= "jdbc:mysql://localhost:8080/";
    		        driver="com.mysql.jdbc.Driver";
    		        Connection dbConnect =null;
    		        PreparedStatement pst=null;

    		        try{
    			        Class.forName(driver).newInstance();
    			        dbConnect =DriverManager.getConnection(url+dbname, username, password);
    			       
    			       
    			        String sql = "SELECT * FROM toiletries";
    			        
    			        pst = dbConnect.prepareStatement(sql);
    			        ResultSet rs = pst.executeQuery();
    			        
    			        
    			        
    			        while(rs.next()) {
    			        	second.addItem(rs.getString("ITEM"));
    			        }
    			 

    			    
    			        dbConnect.close();

    			       
    		        }
    			    catch(Exception ex)
    			    {
    			    JOptionPane.showMessageDialog(null, ex.toString());
    			    }
    		        
    	          
                }
                
                
                
             else if(selectedItem.equals("Bakery")) {
                	
                	String dbname, username, password, url, driver;
    		        dbname="dnenis";
    		        username="root";
    		        password="root";
    		        url= "jdbc:mysql://localhost:8080/";
    		        driver="com.mysql.jdbc.Driver";
    		        Connection dbConnect =null;
    		        PreparedStatement pst=null;

    		        try{
    			        Class.forName(driver).newInstance();
    			        dbConnect =DriverManager.getConnection(url+dbname, username, password);
    			     
    			       
    			        String sql = "SELECT * FROM bakery";
    			        pst = dbConnect.prepareStatement(sql);
    			        ResultSet rs = pst.executeQuery();
    			        
    			      
    			        
    			        while(rs.next()) {
    			        	second.addItem(rs.getString("ITEM"));
    			        }
    			 

    			    

    			        dbConnect.close();
    		        }
    			    catch(Exception ex)
    			    {
    			    JOptionPane.showMessageDialog(null, ex.toString());
    			    }
    		        
                }
                
                
             else if(selectedItem.equals("Cosmetics")) {
                	
                	String dbname, username, password, url, driver;
    		        dbname="dnenis";
    		        username="root";
    		        password="root";
    		        url= "jdbc:mysql://localhost:8080/";
    		        driver="com.mysql.jdbc.Driver";
    		        Connection dbConnect =null;
    		        PreparedStatement pst=null;

    		        try{
    			        Class.forName(driver).newInstance();
    			        dbConnect =DriverManager.getConnection(url+dbname, username, password);
    			        
    			       
    			        String sql = "SELECT * FROM cosmetics";
    			        pst = dbConnect.prepareStatement(sql);
    			        ResultSet rs = pst.executeQuery();
    			        
    			        while(rs.next()) {
    			        	second.addItem(rs.getString("ITEM"));
    			        }
    			 

    			    
    			   

    			        dbConnect.close();
    		        }
    			    catch(Exception ex)
    			    {
    			    JOptionPane.showMessageDialog(null, ex.toString());
    			    }
    		        
                }
                
                
                
             else if(selectedItem.equals("Diary")) {
                	
                	String dbname, username, password, url, driver;
    		        dbname="dnenis";
    		        username="root";
    		        password="root";
    		        url= "jdbc:mysql://localhost:8080/";
    		        driver="com.mysql.jdbc.Driver";
    		        Connection dbConnect =null;
    		        PreparedStatement pst=null;

    		        try{
    			        Class.forName(driver).newInstance();
    			        dbConnect =DriverManager.getConnection(url+dbname, username, password);
    			       
    			       
    			        String sql = "SELECT * FROM diary";
    			        pst = dbConnect.prepareStatement(sql);
    			        ResultSet rs = pst.executeQuery();
    			        
    			        while(rs.next()) {
    			        	second.addItem(rs.getString("ITEM"));
    			        }
    			 

    			   

    			        dbConnect.close();
    		        }
    			    catch(Exception ex)
    			    {
    			    JOptionPane.showMessageDialog(null, ex.toString());
    			    }
    		        
                }
                
                
                
                
             else if(selectedItem.equals("Tobacco")) {
                	
                	String dbname, username, password, url, driver;
    		        dbname="dnenis";
    		        username="root";
    		        password="root";
    		        url= "jdbc:mysql://localhost:8080/";
    		        driver="com.mysql.jdbc.Driver";
    		        Connection dbConnect =null;
    		        PreparedStatement pst=null;

    		        try{
    			        Class.forName(driver).newInstance();
    			        dbConnect =DriverManager.getConnection(url+dbname, username, password);
    			       
    			       
    			        String sql = "SELECT * FROM tobacco";
    			        pst = dbConnect.prepareStatement(sql);
    			        ResultSet rs = pst.executeQuery();
    			        
    			        while(rs.next()) {
    			        	second.addItem(rs.getString("ITEM"));
    			        }
    			 

    			    
    			   
    			        dbConnect.close();
    			       
    		        }
    			    catch(Exception ex)
    			    {
    			    JOptionPane.showMessageDialog(null, ex.toString());
    			    }
    		        
                }
                
                
                
                
             else if(selectedItem.equals("Groceries")) {
                	
                	String dbname, username, password, url, driver;
    		        dbname="dnenis";
    		        username="root";
    		        password="root";
    		        url= "jdbc:mysql://localhost:8080/";
    		        driver="com.mysql.jdbc.Driver";
    		        Connection dbConnect =null;
    		        PreparedStatement pst=null;

    		        try{
    			        Class.forName(driver).newInstance();
    			        dbConnect =DriverManager.getConnection(url+dbname, username, password);
    			       
    			       
    			        String sql = "SELECT * FROM groceries";
    			        pst = dbConnect.prepareStatement(sql);
    			        ResultSet rs = pst.executeQuery();
    			        
    			        while(rs.next()) {
    			        	second.addItem(rs.getString("ITEM"));
    			        }
    			 

    			    
    			    
    			        dbConnect.close();
    			       
    		        }
    			    catch(Exception ex)
    			    {
    			    JOptionPane.showMessageDialog(null, ex.toString());
    			    }
    		        
                }
                 
                
                
                
             else if(selectedItem.equals("Beverages")) {
                	
                	String dbname, username, password, url, driver;
    		        dbname="dnenis";
    		        username="root";
    		        password="root";
    		        url= "jdbc:mysql://localhost:8080/";
    		        driver="com.mysql.jdbc.Driver";
    		        Connection dbConnect =null;
    		        PreparedStatement pst=null;

    		        try{
    			        Class.forName(driver).newInstance();
    			        dbConnect =DriverManager.getConnection(url+dbname, username, password);
    			       
    			       
    			        String sql = "SELECT * FROM beverage";
    			        pst = dbConnect.prepareStatement(sql);
    			        ResultSet rs = pst.executeQuery();
    			        
    			        while(rs.next()) {
    			        	second.addItem(rs.getString("ITEM"));
    			        }
    			 

    			    
    			    
    			        dbConnect.close();
    			       
    		        }
    			    catch(Exception ex)
    			    {
    			    JOptionPane.showMessageDialog(null, ex.toString());
    			    }
    		        
                }
                
                
                
             else if(selectedItem.equals("Frozen foods")) {
                	
                	String dbname, username, password, url, driver;
    		        dbname="dnenis";
    		        username="root";
    		        password="root";
    		        url= "jdbc:mysql://localhost:8080/";
    		        driver="com.mysql.jdbc.Driver";
    		        Connection dbConnect =null;
    		        PreparedStatement pst=null;

    		        try{
    			        Class.forName(driver).newInstance();
    			        dbConnect =DriverManager.getConnection(url+dbname, username, password);
    			       
    			       
    			        String sql = "SELECT * FROM frozen";
    			        pst = dbConnect.prepareStatement(sql);
    			        ResultSet rs = pst.executeQuery();
    			        
    			        while(rs.next()) {
    			        	second.addItem(rs.getString("ITEM"));
    			        }
    			 

    			    
    			     

    			        dbConnect.close();
    		        }
    			    catch(Exception ex)
    			    {
    			    JOptionPane.showMessageDialog(null, ex.toString());
    			    }
    		        
                }
                
		       
                
             else if(selectedItem.equals("Electronics")) {
                	
                	String dbname, username, password, url, driver;
    		        dbname="dnenis";
    		        username="root";
    		        password="root";
    		        url= "jdbc:mysql://localhost:8080/";
    		        driver="com.mysql.jdbc.Driver";
    		        Connection dbConnect =null;
    		        PreparedStatement pst=null;

    		        try{
    			        Class.forName(driver).newInstance();
    			        dbConnect =DriverManager.getConnection(url+dbname, username, password);
    			        
    			       
    			        String sql = "SELECT * FROM electronics";
    			        pst = dbConnect.prepareStatement(sql);
    			        ResultSet rs = pst.executeQuery();
    			        
    			        while(rs.next()) {
    			        	second.addItem(rs.getString("ITEM"));
    			        }
    			 

    			    
    			    
    			        dbConnect.close();
    		        }
    			    catch(Exception ex)
    			    {
    			    JOptionPane.showMessageDialog(null, ex.toString());
    			    }
    		        
                }
                
                
                
             }
                
            
        }); 
        
        
        
		JLabel Unit = new JLabel("Unit");
		Unit.setBounds(20, 205, 50, 50);
		Unit.setFont(new Font("Serif", Font.BOLD, 20));
		Unit.setForeground(new Color(0, 54, 0));
		frame.add(Unit);
		
		String un[] = {"Single","Pack"};
		JComboBox uni = new JComboBox(un);
		uni.setBounds(140, 215, 80, 30);
	    uni.setBackground(new Color(0, 54, 0));
	    uni.setForeground(new Color(255, 255, 255));
	    uni.setFont(new Font("Serif", Font.BOLD, 18));
		frame.add(uni);
		
		JLabel Qty = new JLabel("Quantity");
		Qty.setBounds(245, 205 ,100, 50);
		Qty.setFont(new Font("Serif", Font.BOLD, 18));
		Qty.setForeground(new Color(0, 54, 0));
		frame.add(Qty);
		
		
		JLabel Price = new JLabel("Price");
		Price.setBounds(20, 255, 50, 50);
		Price.setFont(new Font("Serif", Font.BOLD, 20));
		Price.setForeground(new Color(0, 54, 0));
		frame.add(Price);
		
		JTextField pri = new JTextField();
		pri.setBounds(140,263,150,35);
		pri.setBackground(new Color(0, 54, 0));
	    pri.setForeground(new Color(255, 255, 255));
	    pri.setFont(new Font("Serif", Font.BOLD, 20));
		frame.add(pri);
		
		
		JLabel name = new JLabel("Customer name");
		name.setBounds(500, 5, 150, 50);
		name.setFont(new Font("Serif", Font.BOLD, 20));
		name.setForeground(new Color(0, 54, 0));
		frame.add(name);
		
		JTextField cusname = new JTextField();
		cusname.setBounds(650,15,200,30);
		cusname.setBackground(new Color(0, 54, 0));
	    cusname.setForeground(new Color(255, 255, 255));
	    cusname.setFont(new Font("Serif", Font.BOLD, 20));
		frame.add(cusname);
		
		
		JLabel number = new JLabel("Customer nunber");
		number.setBounds(500, 55, 150, 50);
		number.setFont(new Font("Serif", Font.BOLD, 20));
		number.setForeground(new Color(0, 54, 0));
		frame.add(number);
		
		 JTextField cusnum = new JTextField();
		cusnum.setBounds(650,65,200,30);
		cusnum.setBackground(new Color(0, 54, 0));
	    cusnum.setForeground(new Color(255, 255, 255));
	    cusnum.setFont(new Font("Serif", Font.BOLD, 20));
		frame.add(cusnum);
		
		// date segment
		JTextField text = new JTextField();
		text.setBounds(140,15,150,30);
		text.setBackground(new Color(0, 54, 0));
		text.setForeground(new Color(255, 255, 255));
		text.setFont(new Font("Serif", Font.BOLD, 16));
		JButton b = new JButton("Select");
		b.setBackground(new Color(0, 54, 0));
	    b.setForeground(new Color(255, 255, 255));
	    b.setFont(new Font("Serif", Font.BOLD, 18));
		b.setBounds(310,15,80,29);
		b.setFocusable(false);
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				text.setText(new Date(frame).setPickedDate());
			}
			
		});
			
		
		
		JLabel cart = new JLabel("Add to Cart");
		cart.setBounds(330, 290, 250, 60);
		cart.setFont(new Font("Roman", Font.BOLD, 40));
		cart.setForeground(new Color(0, 54, 0));
		frame.add(cart);
		
		
		
		JButton add = new JButton(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\add2.png").getImage()
		.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH))));
		add.setBounds(603, 308, 60, 30);
		add.setBackground(new Color(44,226,9));
		add.setFocusable(false);
		add.setBorderPainted(false);
		frame.add(add);
		
		
		
		

        second.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
            	
            	
            	spinner.setValue(1);
            	String dbname, username, password, url, driver;
		        dbname="dnenis";
		        username="root";
		        password="root";
		        url= "jdbc:mysql://localhost:8080/";
		        driver="com.mysql.jdbc.Driver";
		        Connection dbConnect =null;
		        PreparedStatement pst=null;

		        try{
			        Class.forName(driver).newInstance();
			        dbConnect =DriverManager.getConnection(url+dbname, username, password);
			     
			       
			        String sql = "SELECT * FROM bakery where ITEM=?";
			        pst = dbConnect.prepareStatement(sql);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet rs = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(rs.next()) {
			        	int gem =rs.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(rs.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(rs.next()) {
			        		 int gem =rs.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(rs.getString("STOCK"));
					        }
			        }
			        
			        
			        
			        
			        
			        
			        
			        
			        String bev = "SELECT * FROM beverage where ITEM=?";
			        pst = dbConnect.prepareStatement(bev);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet bevrs = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(bevrs.next()) {
			        	int gem =bevrs.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(bevrs.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(bevrs.next()) {
			        		 int gem =bevrs.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(bevrs.getString("STOCK"));
					        }
			        }
			        
 
			       
			        
			        
			        
			        
			        
			        String dia = "SELECT * FROM diary where ITEM=?";
			        pst = dbConnect.prepareStatement(dia);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet diars = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(diars.next()) {
			        	int gem =diars.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(diars.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(diars.next()) {
			        		 int gem =diars.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(diars.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        String cos = "SELECT * FROM cosmetics where ITEM=?";
			        pst = dbConnect.prepareStatement(cos);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet cosrs = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(cosrs.next()) {
			        	int gem =cosrs.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(cosrs.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(cosrs.next()) {
			        		 int gem =cosrs.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(cosrs.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        String tob = "SELECT * FROM tobacco where ITEM=?";
			        pst = dbConnect.prepareStatement(tob);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet tobrs = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(tobrs.next()) {
			        	int gem =tobrs.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(tobrs.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(tobrs.next()) {
			        		 int gem =tobrs.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(tobrs.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        String toi = "SELECT * FROM toiletries where ITEM=?";
			        pst = dbConnect.prepareStatement(toi);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet toirs = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(toirs.next()) {
			        	int gem =toirs.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(toirs.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(toirs.next()) {
			        		 int gem =toirs.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(toirs.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        String fro = "SELECT * FROM frozen where ITEM=?";
			        pst = dbConnect.prepareStatement(fro);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet frors = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(frors.next()) {
			        	int gem =frors.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(frors.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(frors.next()) {
			        		 int gem =frors.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(frors.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        
			        String ele = "SELECT * FROM electronics where ITEM=?";
			        pst = dbConnect.prepareStatement(ele);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet elers = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(elers.next()) {
			        	int gem =elers.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(elers.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(elers.next()) {
			        		 int gem =elers.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(elers.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        String gro = "SELECT * FROM groceries where ITEM=?";
			        pst = dbConnect.prepareStatement(gro);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet grors = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(grors.next()) {
			        	int gem =grors.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(grors.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(grors.next()) {
			        		 int gem =grors.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(grors.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			       
			        
			        dbConnect.close();
			       }
			       
		       

		   
		        
			    catch(Exception ex)
			    {
			    JOptionPane.showMessageDialog(null, ex.toString());
			    }

            	
		        
		        	}
	            }); 
		    
            	
        uni.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
            	  

            	String dbname, username, password, url, driver;
		        dbname="dnenis";
		        username="root";
		        password="root";
		        url= "jdbc:mysql://localhost:8080/";
		        driver="com.mysql.jdbc.Driver";
		        Connection dbConnect =null;
		        PreparedStatement pst=null;

		        try{
			        Class.forName(driver).newInstance();
			        dbConnect =DriverManager.getConnection(url+dbname, username, password);
			     
			       
			        String sql = "SELECT * FROM bakery where ITEM=?";
			        pst = dbConnect.prepareStatement(sql);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet rs = pst.executeQuery();
			     
			        if(uni.getSelectedIndex() != 0) {
			        while(rs.next()) {
			        	int gem = rs.getInt("PACK");
			        	int p = (int) spinner.getValue();
			        	pri.setText("" + gem*p);
			        	}
			        
			        }
			        
			        else {
			        	 while(rs.next()) {
			        		 int gem = rs.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
						        pri.setText("" + gem*p);
					        }
			        	 
			        }
			        
			        
			        
			        
			        

			        String bev = "SELECT * FROM beverage where ITEM=?";
			        pst = dbConnect.prepareStatement(bev);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet bevrs = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(bevrs.next()) {
			        	int gem =bevrs.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(bevrs.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(bevrs.next()) {
			        		 int gem =bevrs.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(bevrs.getString("STOCK"));
					        }
			        }
			        
 
			       
			        
			        
			        
			        
			        
			        String dia = "SELECT * FROM diary where ITEM=?";
			        pst = dbConnect.prepareStatement(dia);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet diars = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(diars.next()) {
			        	int gem =diars.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(diars.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(diars.next()) {
			        		 int gem =diars.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(diars.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        String cos = "SELECT * FROM cosmetics where ITEM=?";
			        pst = dbConnect.prepareStatement(cos);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet cosrs = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(cosrs.next()) {
			        	int gem =cosrs.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(cosrs.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(cosrs.next()) {
			        		 int gem =cosrs.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(cosrs.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        String tob = "SELECT * FROM tobacco where ITEM=?";
			        pst = dbConnect.prepareStatement(tob);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet tobrs = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(tobrs.next()) {
			        	int gem =tobrs.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(tobrs.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(tobrs.next()) {
			        		 int gem =tobrs.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(tobrs.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        String toi = "SELECT * FROM toiletries where ITEM=?";
			        pst = dbConnect.prepareStatement(toi);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet toirs = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(toirs.next()) {
			        	int gem =toirs.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(toirs.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(toirs.next()) {
			        		 int gem =toirs.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(toirs.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        String fro = "SELECT * FROM frozen where ITEM=?";
			        pst = dbConnect.prepareStatement(fro);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet frors = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(frors.next()) {
			        	int gem =frors.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(frors.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(frors.next()) {
			        		 int gem =frors.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(frors.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        
			        String ele = "SELECT * FROM electronics where ITEM=?";
			        pst = dbConnect.prepareStatement(ele);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet elers = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(elers.next()) {
			        	int gem =elers.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(elers.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(elers.next()) {
			        		 int gem =elers.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(elers.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        String gro = "SELECT * FROM groceries where ITEM=?";
			        pst = dbConnect.prepareStatement(gro);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet grors = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(grors.next()) {
			        	int gem =grors.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(grors.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(grors.next()) {
			        		 int gem =grors.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(grors.getString("STOCK"));
					        }
			        }
			        
			        
			        
			        
			        
			        
			        
			        
			        
			     
			        dbConnect.close();
			       }
			       
		       
		       
			       
		        
			    catch(Exception ex)
			    {
			    JOptionPane.showMessageDialog(null, ex.toString());
			    }

        	}
        }); 
    
        
        
        
        spinner.addChangeListener(new ChangeListener() {      
        	 
        	  public void stateChanged(ChangeEvent e) {
        	 
            	String dbname, username, password, url, driver;
		        dbname="dnenis";
		        username="root";
		        password="root";
		        url= "jdbc:mysql://localhost:8080/";
		        driver="com.mysql.jdbc.Driver";
		        Connection dbConnect =null;
		        PreparedStatement pst=null;

		        try{
			        Class.forName(driver).newInstance();
			        dbConnect =DriverManager.getConnection(url+dbname, username, password);
			     
			       
			        String sql = "SELECT * FROM bakery where ITEM=?";
			        pst = dbConnect.prepareStatement(sql);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet rs = pst.executeQuery();
			     
			        if(uni.getSelectedIndex() != 0) {
			        while(rs.next()) {
			        	int gem =rs.getInt("PACK");
			        	int p = (int) spinner.getValue();
			        	pri.setText("" + gem*p);
			        	}
			        
			        }
			        
			        else {
			        	 while(rs.next()) {
			        		 int gem =rs.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
						        pri.setText("" + gem*p);
					        }
			        	 
			        }
			        
			        
			        
			        

			        String bev = "SELECT * FROM beverage where ITEM=?";
			        pst = dbConnect.prepareStatement(bev);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet bevrs = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(bevrs.next()) {
			        	int gem =bevrs.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(bevrs.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(bevrs.next()) {
			        		 int gem =bevrs.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(bevrs.getString("STOCK"));
					        }
			        }
			        
 
			       
			        
			        
			        
			        
			        
			        String dia = "SELECT * FROM diary where ITEM=?";
			        pst = dbConnect.prepareStatement(dia);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet diars = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(diars.next()) {
			        	int gem =diars.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(diars.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(diars.next()) {
			        		 int gem =diars.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(diars.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        String cos = "SELECT * FROM cosmetics where ITEM=?";
			        pst = dbConnect.prepareStatement(cos);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet cosrs = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(cosrs.next()) {
			        	int gem =cosrs.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(cosrs.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(cosrs.next()) {
			        		 int gem =cosrs.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(cosrs.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        String tob = "SELECT * FROM tobacco where ITEM=?";
			        pst = dbConnect.prepareStatement(tob);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet tobrs = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(tobrs.next()) {
			        	int gem =tobrs.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(tobrs.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(tobrs.next()) {
			        		 int gem =tobrs.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(tobrs.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        String toi = "SELECT * FROM toiletries where ITEM=?";
			        pst = dbConnect.prepareStatement(toi);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet toirs = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(toirs.next()) {
			        	int gem =toirs.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(toirs.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(toirs.next()) {
			        		 int gem =toirs.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(toirs.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        String fro = "SELECT * FROM frozen where ITEM=?";
			        pst = dbConnect.prepareStatement(fro);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet frors = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(frors.next()) {
			        	int gem =frors.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(frors.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(frors.next()) {
			        		 int gem =frors.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(frors.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        
			        String ele = "SELECT * FROM electronics where ITEM=?";
			        pst = dbConnect.prepareStatement(ele);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet elers = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(elers.next()) {
			        	int gem =elers.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(elers.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(elers.next()) {
			        		 int gem =elers.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(elers.getString("STOCK"));
					        }
			        }
			        
 
			        
			        
			        
			        
			        String gro = "SELECT * FROM groceries where ITEM=?";
			        pst = dbConnect.prepareStatement(gro);
			        pst.setString(1,(String)second.getSelectedItem());
			        ResultSet grors = pst.executeQuery();
			        
			        
			        if(uni.getSelectedIndex() != 0) {
			        while(grors.next()) {
			        	int gem =grors.getInt("PACK");
			            int p = (int) spinner.getValue();
			            pri.setText("" + gem*p);
			            figure.setText(grors.getString("STOCK"));
			        	}
			        
			        }
			        
			        else {
			        	 while(grors.next()) {
			        		 int gem =grors.getInt("SINGLE");
			        		 int p = (int) spinner.getValue();
			        		 pri.setText("" + gem*p);
			        		 figure.setText(grors.getString("STOCK"));
					        }
			        }
			        
			        
			        
			        
			     
			        dbConnect.close();
			       }
			       
		       
		       
			       
		        
			    catch(Exception ex)
			    {
			    JOptionPane.showMessageDialog(null, ex.toString());
			    }

        	}
        }); 
    
        
        
        
		
		
		
		add.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	add.setIcon(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\ref.pn").getImage()
		    	.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH))));
		    	add.setBackground(new Color(255, 255, 255));
		    	add.setText("Add");
		    	add.setFont(new Font("Roman", Font.BOLD, 14));
		    	add.setForeground(new Color(44,226,9));
		    	
		    	add.setBorderPainted(true);
		    	add.setBorder(new LineBorder((new Color(44,226,9)), 3));
		    	
		   }
		  
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	
		    	if(first.getSelectedIndex() != 9) {
		    		
		    		
		    		if(first.getSelectedItem().equals("Bakery")&& uni.getSelectedIndex() != 0) {
		    			
		    			String dbname, username, password, url, driver;
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				        Connection dbConnect =null;
				        PreparedStatement pst=null;

				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					     
					       
					        String sql = "SELECT * FROM bakery where ITEM=?";
					        String item = (String)second.getSelectedItem();
					        pst = dbConnect.prepareStatement(sql);
					        pst.setString(1,item);
					        ResultSet rs = pst.executeQuery();
					     
					       
					        while(rs.next()) {
					        	int stoc = (rs.getInt("STOCK"));
					        	int qty = (int) spinner.getValue();
					        	int qtyy = qty*5;
					        	
					        	if(qtyy>stoc) {
					        		UIManager.put("OptionPane.background", Color.RED);
									 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
									 
									 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
								     label.setForeground(Color.WHITE);
								     label.setFont(new Font("cursive", Font.BOLD, 25 ));
								       
								     JOptionPane.showMessageDialog(frame, label);;
							    		
					        				}
					        	else {
					        		
					        		 Object[] row = new Object[6];
							    		//Add fields to JTable
							    		   row[0] = text.getText();
							 	           row[1] = second.getSelectedItem();
							 	           row[2] = first.getSelectedItem();
							 	           row[3] = uni.getSelectedItem();
							 	           row[4] = spinner.getValue();
							 	           row[5] = pri.getText();
							 	           
							 	          model.addRow(row);
							 	          jt.setDefaultEditor(Object.class, null);
							 	          
							 	          
							 	          //Add fields values to DB
							 	          
							 	     
									        dbname="dnenis";
									        username="root";
									        password="root";
									        url= "jdbc:mysql://localhost:8080/";
									        driver="com.mysql.jdbc.Driver";
									     
									        try{
										        Class.forName(driver).newInstance();
										        dbConnect =DriverManager.getConnection(url+dbname, username, password);
										      
										        String sqll = "INSERT INTO report values(?,?,?,?,?,?,?,?)"; 
										    
										     pst = dbConnect.prepareStatement(sqll);
										     pst.setString(1, text.getText());
										     pst.setString(2, staf.getText());
										     pst.setString(3, (String) second.getSelectedItem());
										     pst.setString(4, (String) first.getSelectedItem());
										     pst.setString(5, (String) uni.getSelectedItem());
										     pst.setInt(6, (int) spinner.getValue());
										     pst.setString(7, (String) pri.getText());
										     pst.setString(8, (String) cusname.getText());
										     pst.executeUpdate();
											 dbConnect.close();
										    }
										    catch (SQLException e) {
										    	 e.printStackTrace();
										    } catch (InstantiationException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (IllegalAccessException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (ClassNotFoundException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}   
							 	          
							 	        
					        	}
					        }
					         
					        
					        	
					        dbConnect.close();
					       }
					       
					    catch(Exception ex)
					    {
					    JOptionPane.showMessageDialog(null, ex.toString());
					    }
		    			
		    			}
		    		
		    		else if (first.getSelectedItem().equals("Bakery")&& uni.getSelectedIndex() != 1) {
		    			
		    			String dbname, username, password, url, driver;
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				        Connection dbConnect =null;
				        PreparedStatement pst=null;

				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					     
					       
					        String sql = "SELECT * FROM bakery where ITEM=?";
					        String item = (String)second.getSelectedItem();
					        pst = dbConnect.prepareStatement(sql);
					        pst.setString(1,item);
					        ResultSet rs = pst.executeQuery();
					     
					       
					        while(rs.next()) {
					        	int stoc = (rs.getInt("STOCK"));
					        	int qty = (int) spinner.getValue();
					        	
					        	
					        	if(qty>stoc) {
					        		UIManager.put("OptionPane.background", Color.RED);
									 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
									 
									 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
								     label.setForeground(Color.WHITE);
								     label.setFont(new Font("cursive", Font.BOLD, 25 ));
								       
								     JOptionPane.showMessageDialog(frame, label);;
							    		
					        				}
					        	else {
					        		
					        		 Object[] row = new Object[6];
							    		//Add fields to JTable
							    		   row[0] = text.getText();
							 	           row[1] = second.getSelectedItem();
							 	           row[2] = first.getSelectedItem();
							 	           row[3] = uni.getSelectedItem();
							 	           row[4] = spinner.getValue();
							 	           row[5] = pri.getText();
							 	           
							 	          model.addRow(row);
							 	          jt.setDefaultEditor(Object.class, null);
							 	          
							 	          
							 	          //Add fields values to DB
							 	          
							 	     
									        dbname="dnenis";
									        username="root";
									        password="root";
									        url= "jdbc:mysql://localhost:8080/";
									        driver="com.mysql.jdbc.Driver";
									     
									        try{
										        Class.forName(driver).newInstance();
										        dbConnect =DriverManager.getConnection(url+dbname, username, password);
										      
										        String sqll = "INSERT INTO report values(?,?,?,?,?,?,?,?)"; 
										    
										     pst = dbConnect.prepareStatement(sqll);
										     pst.setString(1, text.getText());
										     pst.setString(2, staf.getText());
										     pst.setString(3, (String) second.getSelectedItem());
										     pst.setString(4, (String) first.getSelectedItem());
										     pst.setString(5, (String) uni.getSelectedItem());
										     pst.setInt(6, (int) spinner.getValue());
										     pst.setString(7, (String) pri.getText());
										     pst.setString(8, (String) cusname.getText());
										     pst.executeUpdate();
											 dbConnect.close();
										    }
										    catch (SQLException e) {
										    	 e.printStackTrace();
										    } catch (InstantiationException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (IllegalAccessException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (ClassNotFoundException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}   
							 	          
							 	        
					        	}
					        }
					         
					        
					        	
					        dbConnect.close();
					       }
					       
					    catch(Exception ex)
					    {
					    JOptionPane.showMessageDialog(null, ex.toString());
					    }
		    		
		    		}
		    			
		    		
if(first.getSelectedItem().equals("Beverages")&& uni.getSelectedIndex() != 0) {
		    			
		    			String dbname, username, password, url, driver;
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				        Connection dbConnect =null;
				        PreparedStatement pst=null;

				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					     
					       
					        String sql = "SELECT * FROM beverage where ITEM=?";
					        String item = (String)second.getSelectedItem();
					        pst = dbConnect.prepareStatement(sql);
					        pst.setString(1,item);
					        ResultSet rs = pst.executeQuery();
					     
					       
					        while(rs.next()) {
					        	int stoc = (rs.getInt("STOCK"));
					        	int qty = (int) spinner.getValue();
					        	int qtyy = qty*5;
					        	
					        	if(qtyy>stoc) {
					        		UIManager.put("OptionPane.background", Color.RED);
									 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
									 
									 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
								     label.setForeground(Color.WHITE);
								     label.setFont(new Font("cursive", Font.BOLD, 25 ));
								       
								     JOptionPane.showMessageDialog(frame, label);;
							    		
					        				}
					        	else {
					        		
					        		 Object[] row = new Object[6];
							    		//Add fields to JTable
							    		   row[0] = text.getText();
							 	           row[1] = second.getSelectedItem();
							 	           row[2] = first.getSelectedItem();
							 	           row[3] = uni.getSelectedItem();
							 	           row[4] = spinner.getValue();
							 	           row[5] = pri.getText();
							 	           
							 	          model.addRow(row);
							 	          jt.setDefaultEditor(Object.class, null);
							 	          
							 	          
							 	          //Add fields values to DB
							 	          
							 	     
									        dbname="dnenis";
									        username="root";
									        password="root";
									        url= "jdbc:mysql://localhost:8080/";
									        driver="com.mysql.jdbc.Driver";
									     
									        try{
										        Class.forName(driver).newInstance();
										        dbConnect =DriverManager.getConnection(url+dbname, username, password);
										      
										        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
										    
										     pst = dbConnect.prepareStatement(sqll);
										     pst.setString(1, text.getText());
										     pst.setString(2, staf.getText());
										     pst.setString(3, (String) second.getSelectedItem());
										     pst.setString(4, (String) first.getSelectedItem());
										     pst.setString(5, (String) uni.getSelectedItem());
										     pst.setInt(6, (int) spinner.getValue());
										     pst.setString(7, (String) pri.getText());
										     pst.setString(8, (String) cusname.getText());
										     pst.executeUpdate();
											 dbConnect.close();
										    }
										    catch (SQLException e) {
										    	 e.printStackTrace();
										    } catch (InstantiationException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (IllegalAccessException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (ClassNotFoundException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}   
							 	          
							 	        
					        	}
					        }
					         
					        
					        	
					        dbConnect.close();
					       }
					       
					    catch(Exception ex)
					    {
					    JOptionPane.showMessageDialog(null, ex.toString());
					    }
		    			
		    			}
		    		
		    		else if (first.getSelectedItem().equals("Beverages")&& uni.getSelectedIndex() != 1) {
		    			
		    			String dbname, username, password, url, driver;
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				        Connection dbConnect =null;
				        PreparedStatement pst=null;

				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					     
					       
					        String sql = "SELECT * FROM beverage where ITEM=?";
					        String item = (String)second.getSelectedItem();
					        pst = dbConnect.prepareStatement(sql);
					        pst.setString(1,item);
					        ResultSet rs = pst.executeQuery();
					     
					       
					        while(rs.next()) {
					        	int stoc = (rs.getInt("STOCK"));
					        	int qty = (int) spinner.getValue();
					        	
					        	
					        	if(qty>stoc) {
					        		UIManager.put("OptionPane.background", Color.RED);
									 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
									 
									 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
								     label.setForeground(Color.WHITE);
								     label.setFont(new Font("cursive", Font.BOLD, 25 ));
								       
								     JOptionPane.showMessageDialog(frame, label);;
							    		
					        				}
					        	else {
					        		
					        		 Object[] row = new Object[6];
							    		//Add fields to JTable
							    		   row[0] = text.getText();
							 	           row[1] = second.getSelectedItem();
							 	           row[2] = first.getSelectedItem();
							 	           row[3] = uni.getSelectedItem();
							 	           row[4] = spinner.getValue();
							 	           row[5] = pri.getText();
							 	           
							 	          model.addRow(row);
							 	          jt.setDefaultEditor(Object.class, null);
							 	          
							 	          
							 	          //Add fields values to DB
							 	          
							 	     
									        dbname="dnenis";
									        username="root";
									        password="root";
									        url= "jdbc:mysql://localhost:8080/";
									        driver="com.mysql.jdbc.Driver";
									     
									        try{
										        Class.forName(driver).newInstance();
										        dbConnect =DriverManager.getConnection(url+dbname, username, password);
										      
										        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
										    
										     pst = dbConnect.prepareStatement(sqll);
										     pst.setString(1, text.getText());
										     pst.setString(2, staf.getText());
										     pst.setString(3, (String) second.getSelectedItem());
										     pst.setString(4, (String) first.getSelectedItem());
										     pst.setString(5, (String) uni.getSelectedItem());
										     pst.setInt(6, (int) spinner.getValue());
										     pst.setString(7, (String) pri.getText());
										     pst.setString(8, (String) cusname.getText());
										     pst.executeUpdate();
											 dbConnect.close();
										    }
										    catch (SQLException e) {
										    	 e.printStackTrace();
										    } catch (InstantiationException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (IllegalAccessException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (ClassNotFoundException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}   
							 	          
							 	        
					        	}
					        }
					         
					        
					        	
					        dbConnect.close();
					       }
					       
					    catch(Exception ex)
					    {
					    JOptionPane.showMessageDialog(null, ex.toString());
					    }
		    		
		    		}
		    			

if(first.getSelectedItem().equals("Cosmetics")&& uni.getSelectedIndex() != 0) {
	
	String dbname, username, password, url, driver;
    dbname="dnenis";
    username="root";
    password="root";
    url= "jdbc:mysql://localhost:8080/";
    driver="com.mysql.jdbc.Driver";
    Connection dbConnect =null;
    PreparedStatement pst=null;

    try{
        Class.forName(driver).newInstance();
        dbConnect =DriverManager.getConnection(url+dbname, username, password);
     
       
        String sql = "SELECT * FROM cosmetics where ITEM=?";
        String item = (String)second.getSelectedItem();
        pst = dbConnect.prepareStatement(sql);
        pst.setString(1,item);
        ResultSet rs = pst.executeQuery();
     
       
        while(rs.next()) {
        	int stoc = (rs.getInt("STOCK"));
        	int qty = (int) spinner.getValue();
        	int qtyy = qty*5;
        	
        	if(qtyy>stoc) {
        		UIManager.put("OptionPane.background", Color.RED);
				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
				 
				 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
			     label.setForeground(Color.WHITE);
			     label.setFont(new Font("cursive", Font.BOLD, 25 ));
			       
			     JOptionPane.showMessageDialog(frame, label);;
		    		
        				}
        	else {
        		
        		 Object[] row = new Object[6];
		    		//Add fields to JTable
		    		   row[0] = text.getText();
		 	           row[1] = second.getSelectedItem();
		 	           row[2] = first.getSelectedItem();
		 	           row[3] = uni.getSelectedItem();
		 	           row[4] = spinner.getValue();
		 	           row[5] = pri.getText();
		 	           
		 	          model.addRow(row);
		 	          jt.setDefaultEditor(Object.class, null);
		 	          
		 	          
		 	          //Add fields values to DB
		 	          
		 	     
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				     
				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					      
					        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
					    
					     pst = dbConnect.prepareStatement(sqll);
					     pst.setString(1, text.getText());
					     pst.setString(2, staf.getText());
					     pst.setString(3, (String) second.getSelectedItem());
					     pst.setString(4, (String) first.getSelectedItem());
					     pst.setString(5, (String) uni.getSelectedItem());
					     pst.setInt(6, (int) spinner.getValue());
					     pst.setString(7, (String) pri.getText());
					     pst.setString(8, (String) cusname.getText());
					     pst.executeUpdate();
						 dbConnect.close();
					    }
					    catch (SQLException e) {
					    	 e.printStackTrace();
					    } catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
		 	          
		 	        
        	}
        }
         
        
        	
        dbConnect.close();
       }
       
    catch(Exception ex)
    {
    JOptionPane.showMessageDialog(null, ex.toString());
    }
	
	}

else if (first.getSelectedItem().equals("Cosmetics")&& uni.getSelectedIndex() != 1) {
	
	String dbname, username, password, url, driver;
    dbname="dnenis";
    username="root";
    password="root";
    url= "jdbc:mysql://localhost:8080/";
    driver="com.mysql.jdbc.Driver";
    Connection dbConnect =null;
    PreparedStatement pst=null;

    try{
        Class.forName(driver).newInstance();
        dbConnect =DriverManager.getConnection(url+dbname, username, password);
     
       
        String sql = "SELECT * FROM cosmetics where ITEM=?";
        String item = (String)second.getSelectedItem();
        pst = dbConnect.prepareStatement(sql);
        pst.setString(1,item);
        ResultSet rs = pst.executeQuery();
     
       
        while(rs.next()) {
        	int stoc = (rs.getInt("STOCK"));
        	int qty = (int) spinner.getValue();
        	
        	
        	if(qty>stoc) {
        		UIManager.put("OptionPane.background", Color.RED);
				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
				 
				 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
			     label.setForeground(Color.WHITE);
			     label.setFont(new Font("cursive", Font.BOLD, 25 ));
			       
			     JOptionPane.showMessageDialog(frame, label);;
		    		
        				}
        	else {
        		
        		 Object[] row = new Object[6];
		    		//Add fields to JTable
		    		   row[0] = text.getText();
		 	           row[1] = second.getSelectedItem();
		 	           row[2] = first.getSelectedItem();
		 	           row[3] = uni.getSelectedItem();
		 	           row[4] = spinner.getValue();
		 	           row[5] = pri.getText();
		 	           
		 	          model.addRow(row);
		 	          jt.setDefaultEditor(Object.class, null);
		 	          
		 	          
		 	          //Add fields values to DB
		 	          
		 	     
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				     
				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					      
					        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
					    
					     pst = dbConnect.prepareStatement(sqll);
					     pst.setString(1, text.getText());
					     pst.setString(2, staf.getText());
					     pst.setString(3, (String) second.getSelectedItem());
					     pst.setString(4, (String) first.getSelectedItem());
					     pst.setString(5, (String) uni.getSelectedItem());
					     pst.setInt(6, (int) spinner.getValue());
					     pst.setString(7, (String) pri.getText());
					     pst.setString(8, (String) cusname.getText());
					     pst.executeUpdate();
						 dbConnect.close();
					    }
					    catch (SQLException e) {
					    	 e.printStackTrace();
					    } catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
		 	          
		 	        
        	}
        }
         
        
        	
        dbConnect.close();
       }
       
    catch(Exception ex)
    {
    JOptionPane.showMessageDialog(null, ex.toString());
    }

}
	
if(first.getSelectedItem().equals("Toiletries")&& uni.getSelectedIndex() != 0) {
	
	String dbname, username, password, url, driver;
    dbname="dnenis";
    username="root";
    password="root";
    url= "jdbc:mysql://localhost:8080/";
    driver="com.mysql.jdbc.Driver";
    Connection dbConnect =null;
    PreparedStatement pst=null;

    try{
        Class.forName(driver).newInstance();
        dbConnect =DriverManager.getConnection(url+dbname, username, password);
     
       
        String sql = "SELECT * FROM toiletries where ITEM=?";
        String item = (String)second.getSelectedItem();
        pst = dbConnect.prepareStatement(sql);
        pst.setString(1,item);
        ResultSet rs = pst.executeQuery();
     
       
        while(rs.next()) {
        	int stoc = (rs.getInt("STOCK"));
        	int qty = (int) spinner.getValue();
        	int qtyy = qty*5;
        	
        	if(qtyy>stoc) {
        		UIManager.put("OptionPane.background", Color.RED);
				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
				 
				 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
			     label.setForeground(Color.WHITE);
			     label.setFont(new Font("cursive", Font.BOLD, 25 ));
			       
			     JOptionPane.showMessageDialog(frame, label);;
		    		
        				}
        	else {
        		
        		 Object[] row = new Object[6];
		    		//Add fields to JTable
		    		   row[0] = text.getText();
		 	           row[1] = second.getSelectedItem();
		 	           row[2] = first.getSelectedItem();
		 	           row[3] = uni.getSelectedItem();
		 	           row[4] = spinner.getValue();
		 	           row[5] = pri.getText();
		 	           
		 	          model.addRow(row);
		 	          jt.setDefaultEditor(Object.class, null);
		 	          
		 	          
		 	          //Add fields values to DB
		 	          
		 	     
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				     
				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					      
					        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
					    
					     pst = dbConnect.prepareStatement(sqll);
					     pst.setString(1, text.getText());
					     pst.setString(2, staf.getText());
					     pst.setString(3, (String) second.getSelectedItem());
					     pst.setString(4, (String) first.getSelectedItem());
					     pst.setString(5, (String) uni.getSelectedItem());
					     pst.setInt(6, (int) spinner.getValue());
					     pst.setString(7, (String) pri.getText());
					     pst.setString(8, (String) cusname.getText());
					     pst.executeUpdate();
						 dbConnect.close();
					    }
					    catch (SQLException e) {
					    	 e.printStackTrace();
					    } catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
		 	          
		 	        
        	}
        }
         
        
        	
        dbConnect.close();
       }
       
    catch(Exception ex)
    {
    JOptionPane.showMessageDialog(null, ex.toString());
    }
	
	}

else if (first.getSelectedItem().equals("Toiletries")&& uni.getSelectedIndex() != 1) {
	
	String dbname, username, password, url, driver;
    dbname="dnenis";
    username="root";
    password="root";
    url= "jdbc:mysql://localhost:8080/";
    driver="com.mysql.jdbc.Driver";
    Connection dbConnect =null;
    PreparedStatement pst=null;

    try{
        Class.forName(driver).newInstance();
        dbConnect =DriverManager.getConnection(url+dbname, username, password);
     
       
        String sql = "SELECT * FROM toiletries where ITEM=?";
        String item = (String)second.getSelectedItem();
        pst = dbConnect.prepareStatement(sql);
        pst.setString(1,item);
        ResultSet rs = pst.executeQuery();
     
       
        while(rs.next()) {
        	int stoc = (rs.getInt("STOCK"));
        	int qty = (int) spinner.getValue();
        	
        	
        	if(qty>stoc) {
        		UIManager.put("OptionPane.background", Color.RED);
				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
				 
				 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
			     label.setForeground(Color.WHITE);
			     label.setFont(new Font("cursive", Font.BOLD, 25 ));
			       
			     JOptionPane.showMessageDialog(frame, label);;
		    		
        				}
        	else {
        		
        		 Object[] row = new Object[6];
		    		//Add fields to JTable
		    		   row[0] = text.getText();
		 	           row[1] = second.getSelectedItem();
		 	           row[2] = first.getSelectedItem();
		 	           row[3] = uni.getSelectedItem();
		 	           row[4] = spinner.getValue();
		 	           row[5] = pri.getText();
		 	           
		 	          model.addRow(row);
		 	          jt.setDefaultEditor(Object.class, null);
		 	          
		 	          
		 	          //Add fields values to DB
		 	          
		 	     
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				     
				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					      
					        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
					    
					     pst = dbConnect.prepareStatement(sqll);
					     pst.setString(1, text.getText());
					     pst.setString(2, staf.getText());
					     pst.setString(3, (String) second.getSelectedItem());
					     pst.setString(4, (String) first.getSelectedItem());
					     pst.setString(5, (String) uni.getSelectedItem());
					     pst.setInt(6, (int) spinner.getValue());
					     pst.setString(7, (String) pri.getText());
					     pst.setString(8, (String) cusname.getText());
					     pst.executeUpdate();
						 dbConnect.close();
					    }
					    catch (SQLException e) {
					    	 e.printStackTrace();
					    } catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
		 	          
		 	        
        	}
        }
         
        
        	
        dbConnect.close();
       }
       
    catch(Exception ex)
    {
    JOptionPane.showMessageDialog(null, ex.toString());
    }

}
	
if(first.getSelectedItem().equals("Tobacco")&& uni.getSelectedIndex() != 0) {
	
	String dbname, username, password, url, driver;
    dbname="dnenis";
    username="root";
    password="root";
    url= "jdbc:mysql://localhost:8080/";
    driver="com.mysql.jdbc.Driver";
    Connection dbConnect =null;
    PreparedStatement pst=null;

    try{
        Class.forName(driver).newInstance();
        dbConnect =DriverManager.getConnection(url+dbname, username, password);
     
       
        String sql = "SELECT * FROM tobacco where ITEM=?";
        String item = (String)second.getSelectedItem();
        pst = dbConnect.prepareStatement(sql);
        pst.setString(1,item);
        ResultSet rs = pst.executeQuery();
     
       
        while(rs.next()) {
        	int stoc = (rs.getInt("STOCK"));
        	int qty = (int) spinner.getValue();
        	int qtyy = qty*5;
        	
        	if(qtyy>stoc) {
        		UIManager.put("OptionPane.background", Color.RED);
				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
				 
				 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
			     label.setForeground(Color.WHITE);
			     label.setFont(new Font("cursive", Font.BOLD, 25 ));
			       
			     JOptionPane.showMessageDialog(frame, label);;
		    		
        				}
        	else {
        		
        		 Object[] row = new Object[6];
		    		//Add fields to JTable
		    		   row[0] = text.getText();
		 	           row[1] = second.getSelectedItem();
		 	           row[2] = first.getSelectedItem();
		 	           row[3] = uni.getSelectedItem();
		 	           row[4] = spinner.getValue();
		 	           row[5] = pri.getText();
		 	           
		 	          model.addRow(row);
		 	          jt.setDefaultEditor(Object.class, null);
		 	          
		 	          
		 	          //Add fields values to DB
		 	          
		 	     
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				     
				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					      
					        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
					    
					     pst = dbConnect.prepareStatement(sqll);
					     pst.setString(1, text.getText());
					     pst.setString(2, staf.getText());
					     pst.setString(3, (String) second.getSelectedItem());
					     pst.setString(4, (String) first.getSelectedItem());
					     pst.setString(5, (String) uni.getSelectedItem());
					     pst.setInt(6, (int) spinner.getValue());
					     pst.setString(7, (String) pri.getText());
					     pst.setString(8, (String) cusname.getText());
					     pst.executeUpdate();
						 dbConnect.close();
					    }
					    catch (SQLException e) {
					    	 e.printStackTrace();
					    } catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
		 	          
		 	        
        	}
        }
         
        
        	
        dbConnect.close();
       }
       
    catch(Exception ex)
    {
    JOptionPane.showMessageDialog(null, ex.toString());
    }
	
	}

else if (first.getSelectedItem().equals("Tobacco")&& uni.getSelectedIndex() != 1) {
	
	String dbname, username, password, url, driver;
    dbname="dnenis";
    username="root";
    password="root";
    url= "jdbc:mysql://localhost:8080/";
    driver="com.mysql.jdbc.Driver";
    Connection dbConnect =null;
    PreparedStatement pst=null;

    try{
        Class.forName(driver).newInstance();
        dbConnect =DriverManager.getConnection(url+dbname, username, password);
     
       
        String sql = "SELECT * FROM tobacco where ITEM=?";
        String item = (String)second.getSelectedItem();
        pst = dbConnect.prepareStatement(sql);
        pst.setString(1,item);
        ResultSet rs = pst.executeQuery();
     
       
        while(rs.next()) {
        	int stoc = (rs.getInt("STOCK"));
        	int qty = (int) spinner.getValue();
        	
        	
        	if(qty>stoc) {
        		UIManager.put("OptionPane.background", Color.RED);
				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
				 
				 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
			     label.setForeground(Color.WHITE);
			     label.setFont(new Font("cursive", Font.BOLD, 25 ));
			       
			     JOptionPane.showMessageDialog(frame, label);;
		    		
        				}
        	else {
        		
        		 Object[] row = new Object[6];
		    		//Add fields to JTable
		    		   row[0] = text.getText();
		 	           row[1] = second.getSelectedItem();
		 	           row[2] = first.getSelectedItem();
		 	           row[3] = uni.getSelectedItem();
		 	           row[4] = spinner.getValue();
		 	           row[5] = pri.getText();
		 	           
		 	          model.addRow(row);
		 	          jt.setDefaultEditor(Object.class, null);
		 	          
		 	          
		 	          //Add fields values to DB
		 	          
		 	     
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				     
				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					      
					        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
					    
					     pst = dbConnect.prepareStatement(sqll);
					     pst.setString(1, text.getText());
					     pst.setString(2, staf.getText());
					     pst.setString(3, (String) second.getSelectedItem());
					     pst.setString(4, (String) first.getSelectedItem());
					     pst.setString(5, (String) uni.getSelectedItem());
					     pst.setInt(6, (int) spinner.getValue());
					     pst.setString(7, (String) pri.getText());
					     pst.setString(8, (String) cusname.getText());
					     pst.executeUpdate();
						 dbConnect.close();
					    }
					    catch (SQLException e) {
					    	 e.printStackTrace();
					    } catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
		 	          
		 	        
        	}
        }
         
        
        	
        dbConnect.close();
       }
       
    catch(Exception ex)
    {
    JOptionPane.showMessageDialog(null, ex.toString());
    }

}
	


if(first.getSelectedItem().equals("Diary")&& uni.getSelectedIndex() != 0) {
	
	String dbname, username, password, url, driver;
    dbname="dnenis";
    username="root";
    password="root";
    url= "jdbc:mysql://localhost:8080/";
    driver="com.mysql.jdbc.Driver";
    Connection dbConnect =null;
    PreparedStatement pst=null;

    try{
        Class.forName(driver).newInstance();
        dbConnect =DriverManager.getConnection(url+dbname, username, password);
     
       
        String sql = "SELECT * FROM diary where ITEM=?";
        String item = (String)second.getSelectedItem();
        pst = dbConnect.prepareStatement(sql);
        pst.setString(1,item);
        ResultSet rs = pst.executeQuery();
     
       
        while(rs.next()) {
        	int stoc = (rs.getInt("STOCK"));
        	int qty = (int) spinner.getValue();
        	int qtyy = qty*5;
        	
        	if(qtyy>stoc) {
        		UIManager.put("OptionPane.background", Color.RED);
				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
				 
				 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
			     label.setForeground(Color.WHITE);
			     label.setFont(new Font("cursive", Font.BOLD, 25 ));
			       
			     JOptionPane.showMessageDialog(frame, label);;
		    		
        				}
        	else {
        		
        		 Object[] row = new Object[6];
		    		//Add fields to JTable
		    		   row[0] = text.getText();
		 	           row[1] = second.getSelectedItem();
		 	           row[2] = first.getSelectedItem();
		 	           row[3] = uni.getSelectedItem();
		 	           row[4] = spinner.getValue();
		 	           row[5] = pri.getText();
		 	           
		 	          model.addRow(row);
		 	          jt.setDefaultEditor(Object.class, null);
		 	          
		 	          
		 	          //Add fields values to DB
		 	          
		 	     
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				     
				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					      
					        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
					    
					     pst = dbConnect.prepareStatement(sqll);
					     pst.setString(1, text.getText());
					     pst.setString(2, staf.getText());
					     pst.setString(3, (String) second.getSelectedItem());
					     pst.setString(4, (String) first.getSelectedItem());
					     pst.setString(5, (String) uni.getSelectedItem());
					     pst.setInt(6, (int) spinner.getValue());
					     pst.setString(7, (String) pri.getText());
					     pst.setString(8, (String) cusname.getText());
					     pst.executeUpdate();
						 dbConnect.close();
					    }
					    catch (SQLException e) {
					    	 e.printStackTrace();
					    } catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
		 	          
		 	        
        	}
        }
         
        
        	
        dbConnect.close();
       }
       
    catch(Exception ex)
    {
    JOptionPane.showMessageDialog(null, ex.toString());
    }
	
	}

else if (first.getSelectedItem().equals("Diary")&& uni.getSelectedIndex() != 1) {
	
	String dbname, username, password, url, driver;
    dbname="dnenis";
    username="root";
    password="root";
    url= "jdbc:mysql://localhost:8080/";
    driver="com.mysql.jdbc.Driver";
    Connection dbConnect =null;
    PreparedStatement pst=null;

    try{
        Class.forName(driver).newInstance();
        dbConnect =DriverManager.getConnection(url+dbname, username, password);
     
       
        String sql = "SELECT * FROM diary where ITEM=?";
        String item = (String)second.getSelectedItem();
        pst = dbConnect.prepareStatement(sql);
        pst.setString(1,item);
        ResultSet rs = pst.executeQuery();
     
       
        while(rs.next()) {
        	int stoc = (rs.getInt("STOCK"));
        	int qty = (int) spinner.getValue();
        	
        	
        	if(qty>stoc) {
        		UIManager.put("OptionPane.background", Color.RED);
				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
				 
				 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
			     label.setForeground(Color.WHITE);
			     label.setFont(new Font("cursive", Font.BOLD, 25 ));
			       
			     JOptionPane.showMessageDialog(frame, label);;
		    		
        				}
        	else {
        		
        		 Object[] row = new Object[6];
		    		//Add fields to JTable
		    		   row[0] = text.getText();
		 	           row[1] = second.getSelectedItem();
		 	           row[2] = first.getSelectedItem();
		 	           row[3] = uni.getSelectedItem();
		 	           row[4] = spinner.getValue();
		 	           row[5] = pri.getText();
		 	           
		 	          model.addRow(row);
		 	          jt.setDefaultEditor(Object.class, null);
		 	          
		 	          
		 	          //Add fields values to DB
		 	          
		 	     
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				     
				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					      
					        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
					    
					     pst = dbConnect.prepareStatement(sqll);
					     pst.setString(1, text.getText());
					     pst.setString(2, staf.getText());
					     pst.setString(3, (String) second.getSelectedItem());
					     pst.setString(4, (String) first.getSelectedItem());
					     pst.setString(5, (String) uni.getSelectedItem());
					     pst.setInt(6, (int) spinner.getValue());
					     pst.setString(7, (String) pri.getText());
					     pst.setString(8, (String) cusname.getText());
					     pst.executeUpdate();
						 dbConnect.close();
					    }
					    catch (SQLException e) {
					    	 e.printStackTrace();
					    } catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
		 	          
		 	        
        	}
        }
         
        
        	
        dbConnect.close();
       }
       
    catch(Exception ex)
    {
    JOptionPane.showMessageDialog(null, ex.toString());
    }

}
	


if(first.getSelectedItem().equals("Electronics")&& uni.getSelectedIndex() != 0) {
	
	String dbname, username, password, url, driver;
    dbname="dnenis";
    username="root";
    password="root";
    url= "jdbc:mysql://localhost:8080/";
    driver="com.mysql.jdbc.Driver";
    Connection dbConnect =null;
    PreparedStatement pst=null;

    try{
        Class.forName(driver).newInstance();
        dbConnect =DriverManager.getConnection(url+dbname, username, password);
     
       
        String sql = "SELECT * FROM electronics where ITEM=?";
        String item = (String)second.getSelectedItem();
        pst = dbConnect.prepareStatement(sql);
        pst.setString(1,item);
        ResultSet rs = pst.executeQuery();
     
       
        while(rs.next()) {
        	int stoc = (rs.getInt("STOCK"));
        	int qty = (int) spinner.getValue();
        	int qtyy = qty*5;
        	
        	if(qtyy>stoc) {
        		UIManager.put("OptionPane.background", Color.RED);
				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
				 
				 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
			     label.setForeground(Color.WHITE);
			     label.setFont(new Font("cursive", Font.BOLD, 25 ));
			       
			     JOptionPane.showMessageDialog(frame, label);;
		    		
        				}
        	else {
        		
        		 Object[] row = new Object[6];
		    		//Add fields to JTable
		    		   row[0] = text.getText();
		 	           row[1] = second.getSelectedItem();
		 	           row[2] = first.getSelectedItem();
		 	           row[3] = uni.getSelectedItem();
		 	           row[4] = spinner.getValue();
		 	           row[5] = pri.getText();
		 	           
		 	          model.addRow(row);
		 	          jt.setDefaultEditor(Object.class, null);
		 	          
		 	          
		 	          //Add fields values to DB
		 	          
		 	     
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				     
				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					      
					        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
					    
					     pst = dbConnect.prepareStatement(sqll);
					     pst.setString(1, text.getText());
					     pst.setString(2, staf.getText());
					     pst.setString(3, (String) second.getSelectedItem());
					     pst.setString(4, (String) first.getSelectedItem());
					     pst.setString(5, (String) uni.getSelectedItem());
					     pst.setInt(6, (int) spinner.getValue());
					     pst.setString(7, (String) pri.getText());
					     pst.setString(8, (String) cusname.getText());
					     pst.executeUpdate();
						 dbConnect.close();
					    }
					    catch (SQLException e) {
					    	 e.printStackTrace();
					    } catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
		 	          
		 	        
        	}
        }
         
        
        	
        dbConnect.close();
       }
       
    catch(Exception ex)
    {
    JOptionPane.showMessageDialog(null, ex.toString());
    }
	
	}

else if (first.getSelectedItem().equals("Electronics")&& uni.getSelectedIndex() != 1) {
	
	String dbname, username, password, url, driver;
    dbname="dnenis";
    username="root";
    password="root";
    url= "jdbc:mysql://localhost:8080/";
    driver="com.mysql.jdbc.Driver";
    Connection dbConnect =null;
    PreparedStatement pst=null;

    try{
        Class.forName(driver).newInstance();
        dbConnect =DriverManager.getConnection(url+dbname, username, password);
     
       
        String sql = "SELECT * FROM electronics where ITEM=?";
        String item = (String)second.getSelectedItem();
        pst = dbConnect.prepareStatement(sql);
        pst.setString(1,item);
        ResultSet rs = pst.executeQuery();
     
       
        while(rs.next()) {
        	int stoc = (rs.getInt("STOCK"));
        	int qty = (int) spinner.getValue();
        	
        	
        	if(qty>stoc) {
        		UIManager.put("OptionPane.background", Color.RED);
				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
				 
				 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
			     label.setForeground(Color.WHITE);
			     label.setFont(new Font("cursive", Font.BOLD, 25 ));
			       
			     JOptionPane.showMessageDialog(frame, label);;
		    		
        				}
        	else {
        		
        		 Object[] row = new Object[6];
		    		//Add fields to JTable
		    		   row[0] = text.getText();
		 	           row[1] = second.getSelectedItem();
		 	           row[2] = first.getSelectedItem();
		 	           row[3] = uni.getSelectedItem();
		 	           row[4] = spinner.getValue();
		 	           row[5] = pri.getText();
		 	           
		 	          model.addRow(row);
		 	          jt.setDefaultEditor(Object.class, null);
		 	          
		 	          
		 	          //Add fields values to DB
		 	          
		 	     
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				     
				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					      
					        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
					    
					     pst = dbConnect.prepareStatement(sqll);
					     pst.setString(1, text.getText());
					     pst.setString(2, staf.getText());
					     pst.setString(3, (String) second.getSelectedItem());
					     pst.setString(4, (String) first.getSelectedItem());
					     pst.setString(5, (String) uni.getSelectedItem());
					     pst.setInt(6, (int) spinner.getValue());
					     pst.setString(7, (String) pri.getText());
					     pst.setString(8, (String) cusname.getText());
					     pst.executeUpdate();
						 dbConnect.close();
					    }
					    catch (SQLException e) {
					    	 e.printStackTrace();
					    } catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
		 	          
		 	        
        	}
        }
         
        
        	
        dbConnect.close();
       }
       
    catch(Exception ex)
    {
    JOptionPane.showMessageDialog(null, ex.toString());
    }

}
	


if(first.getSelectedItem().equals("Groceries")&& uni.getSelectedIndex() != 0) {
	
	String dbname, username, password, url, driver;
    dbname="dnenis";
    username="root";
    password="root";
    url= "jdbc:mysql://localhost:8080/";
    driver="com.mysql.jdbc.Driver";
    Connection dbConnect =null;
    PreparedStatement pst=null;

    try{
        Class.forName(driver).newInstance();
        dbConnect =DriverManager.getConnection(url+dbname, username, password);
     
       
        String sql = "SELECT * FROM groceries where ITEM=?";
        String item = (String)second.getSelectedItem();
        pst = dbConnect.prepareStatement(sql);
        pst.setString(1,item);
        ResultSet rs = pst.executeQuery();
     
       
        while(rs.next()) {
        	int stoc = (rs.getInt("STOCK"));
        	int qty = (int) spinner.getValue();
        	int qtyy = qty*5;
        	
        	if(qtyy>stoc) {
        		UIManager.put("OptionPane.background", Color.RED);
				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
				 
				 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
			     label.setForeground(Color.WHITE);
			     label.setFont(new Font("cursive", Font.BOLD, 25 ));
			       
			     JOptionPane.showMessageDialog(frame, label);;
		    		
        				}
        	else {
        		
        		 Object[] row = new Object[6];
		    		//Add fields to JTable
		    		   row[0] = text.getText();
		 	           row[1] = second.getSelectedItem();
		 	           row[2] = first.getSelectedItem();
		 	           row[3] = uni.getSelectedItem();
		 	           row[4] = spinner.getValue();
		 	           row[5] = pri.getText();
		 	           
		 	          model.addRow(row);
		 	          jt.setDefaultEditor(Object.class, null);
		 	          
		 	          
		 	          //Add fields values to DB
		 	          
		 	     
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				     
				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					      
					        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
					    
					     pst = dbConnect.prepareStatement(sqll);
					     pst.setString(1, text.getText());
					     pst.setString(2, staf.getText());
					     pst.setString(3, (String) second.getSelectedItem());
					     pst.setString(4, (String) first.getSelectedItem());
					     pst.setString(5, (String) uni.getSelectedItem());
					     pst.setInt(6, (int) spinner.getValue());
					     pst.setString(7, (String) pri.getText());
					     pst.setString(8, (String) cusname.getText());
					     pst.executeUpdate();
						 dbConnect.close();
					    }
					    catch (SQLException e) {
					    	 e.printStackTrace();
					    } catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
		 	          
		 	        
        	}
        }
         
        
        	
        dbConnect.close();
       }
       
    catch(Exception ex)
    {
    JOptionPane.showMessageDialog(null, ex.toString());
    }
	
	}

else if (first.getSelectedItem().equals("Groceries")&& uni.getSelectedIndex() != 1) {
	
	String dbname, username, password, url, driver;
    dbname="dnenis";
    username="root";
    password="root";
    url= "jdbc:mysql://localhost:8080/";
    driver="com.mysql.jdbc.Driver";
    Connection dbConnect =null;
    PreparedStatement pst=null;

    try{
        Class.forName(driver).newInstance();
        dbConnect =DriverManager.getConnection(url+dbname, username, password);
     
       
        String sql = "SELECT * FROM groceries where ITEM=?";
        String item = (String)second.getSelectedItem();
        pst = dbConnect.prepareStatement(sql);
        pst.setString(1,item);
        ResultSet rs = pst.executeQuery();
     
       
        while(rs.next()) {
        	int stoc = (rs.getInt("STOCK"));
        	int qty = (int) spinner.getValue();
        	
        	
        	if(qty>stoc) {
        		UIManager.put("OptionPane.background", Color.RED);
				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
				 
				 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
			     label.setForeground(Color.WHITE);
			     label.setFont(new Font("cursive", Font.BOLD, 25 ));
			       
			     JOptionPane.showMessageDialog(frame, label);;
		    		
        				}
        	else {
        		
        		 Object[] row = new Object[6];
		    		//Add fields to JTable
		    		   row[0] = text.getText();
		 	           row[1] = second.getSelectedItem();
		 	           row[2] = first.getSelectedItem();
		 	           row[3] = uni.getSelectedItem();
		 	           row[4] = spinner.getValue();
		 	           row[5] = pri.getText();
		 	           
		 	          model.addRow(row);
		 	          jt.setDefaultEditor(Object.class, null);
		 	          
		 	          
		 	          //Add fields values to DB
		 	          
		 	     
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				     
				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					      
					        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
					    
					     pst = dbConnect.prepareStatement(sqll);
					     pst.setString(1, text.getText());
					     pst.setString(2, staf.getText());
					     pst.setString(3, (String) second.getSelectedItem());
					     pst.setString(4, (String) first.getSelectedItem());
					     pst.setString(5, (String) uni.getSelectedItem());
					     pst.setInt(6, (int) spinner.getValue());
					     pst.setString(7, (String) pri.getText());
					     pst.setString(8, (String) cusname.getText());
					     pst.executeUpdate();
						 dbConnect.close();
					    }
					    catch (SQLException e) {
					    	 e.printStackTrace();
					    } catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
		 	          
		 	        
        	}
        }
         
        
        	
        dbConnect.close();
       }
       
    catch(Exception ex)
    {
    JOptionPane.showMessageDialog(null, ex.toString());
    }

}
	

if(first.getSelectedItem().equals("Frozen foods")&& uni.getSelectedIndex() != 0) {
	
	String dbname, username, password, url, driver;
    dbname="dnenis";
    username="root";
    password="root";
    url= "jdbc:mysql://localhost:8080/";
    driver="com.mysql.jdbc.Driver";
    Connection dbConnect =null;
    PreparedStatement pst=null;

    try{
        Class.forName(driver).newInstance();
        dbConnect =DriverManager.getConnection(url+dbname, username, password);
     
       
        String sql = "SELECT * FROM frozen where ITEM=?";
        String item = (String)second.getSelectedItem();
        pst = dbConnect.prepareStatement(sql);
        pst.setString(1,item);
        ResultSet rs = pst.executeQuery();
     
       
        while(rs.next()) {
        	int stoc = (rs.getInt("STOCK"));
        	int qty = (int) spinner.getValue();
        	int qtyy = qty*5;
        	
        	if(qtyy>stoc) {
        		UIManager.put("OptionPane.background", Color.RED);
				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
				 
				 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
			     label.setForeground(Color.WHITE);
			     label.setFont(new Font("cursive", Font.BOLD, 25 ));
			       
			     JOptionPane.showMessageDialog(frame, label);;
		    		
        				}
        	else {
        		
        		 Object[] row = new Object[6];
		    		//Add fields to JTable
		    		   row[0] = text.getText();
		 	           row[1] = second.getSelectedItem();
		 	           row[2] = first.getSelectedItem();
		 	           row[3] = uni.getSelectedItem();
		 	           row[4] = spinner.getValue();
		 	           row[5] = pri.getText();
		 	           
		 	          model.addRow(row);
		 	          jt.setDefaultEditor(Object.class, null);
		 	          
		 	          
		 	          //Add fields values to DB
		 	          
		 	     
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				     
				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					      
					        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
					    
					     pst = dbConnect.prepareStatement(sqll);
					     pst.setString(1, text.getText());
					     pst.setString(2, staf.getText());
					     pst.setString(3, (String) second.getSelectedItem());
					     pst.setString(4, (String) first.getSelectedItem());
					     pst.setString(5, (String) uni.getSelectedItem());
					     pst.setInt(6, (int) spinner.getValue());
					     pst.setString(7, (String) pri.getText());
					     pst.setString(8, (String) cusname.getText());
					     pst.executeUpdate();
						 dbConnect.close();
					    }
					    catch (SQLException e) {
					    	 e.printStackTrace();
					    } catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
		 	          
		 	        
        	}
        }
         
        
        	
        dbConnect.close();
       }
       
    catch(Exception ex)
    {
    JOptionPane.showMessageDialog(null, ex.toString());
    }
	
	}

else if (first.getSelectedItem().equals("Frozen foods")&& uni.getSelectedIndex() != 1) {
	
	String dbname, username, password, url, driver;
    dbname="dnenis";
    username="root";
    password="root";
    url= "jdbc:mysql://localhost:8080/";
    driver="com.mysql.jdbc.Driver";
    Connection dbConnect =null;
    PreparedStatement pst=null;

    try{
        Class.forName(driver).newInstance();
        dbConnect =DriverManager.getConnection(url+dbname, username, password);
     
       
        String sql = "SELECT * FROM frozen where ITEM=?";
        String item = (String)second.getSelectedItem();
        pst = dbConnect.prepareStatement(sql);
        pst.setString(1,item);
        ResultSet rs = pst.executeQuery();
     
       
        while(rs.next()) {
        	int stoc = (rs.getInt("STOCK"));
        	int qty = (int) spinner.getValue();
        	
        	
        	if(qty>stoc) {
        		UIManager.put("OptionPane.background", Color.RED);
				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
				 
				 JLabel label = new JLabel("Quantity of " +item+ " is not Enough");
			     label.setForeground(Color.WHITE);
			     label.setFont(new Font("cursive", Font.BOLD, 25 ));
			       
			     JOptionPane.showMessageDialog(frame, label);;
		    		
        				}
        	else {
        		
        		 Object[] row = new Object[6];
		    		//Add fields to JTable
		    		   row[0] = text.getText();
		 	           row[1] = second.getSelectedItem();
		 	           row[2] = first.getSelectedItem();
		 	           row[3] = uni.getSelectedItem();
		 	           row[4] = spinner.getValue();
		 	           row[5] = pri.getText();
		 	           
		 	          model.addRow(row);
		 	          jt.setDefaultEditor(Object.class, null);
		 	          
		 	          
		 	          //Add fields values to DB
		 	          
		 	     
				        dbname="dnenis";
				        username="root";
				        password="root";
				        url= "jdbc:mysql://localhost:8080/";
				        driver="com.mysql.jdbc.Driver";
				     
				        try{
					        Class.forName(driver).newInstance();
					        dbConnect =DriverManager.getConnection(url+dbname, username, password);
					      
					        String sqll = "INSERT INTO report  values(?,?,?,?,?,?,?,?)"; 
					    
					     pst = dbConnect.prepareStatement(sqll);
					     pst.setString(1, text.getText());
					     pst.setString(2, staf.getText());
					     pst.setString(3, (String) second.getSelectedItem());
					     pst.setString(4, (String) first.getSelectedItem());
					     pst.setString(5, (String) uni.getSelectedItem());
					     pst.setInt(6, (int) spinner.getValue());
					     pst.setString(7, (String) pri.getText());
					     pst.setString(8, (String) cusname.getText());
					     pst.executeUpdate();
						 dbConnect.close();
					    }
					    catch (SQLException e) {
					    	 e.printStackTrace();
					    } catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
		 	          
		 	        
        	}
        }
         
        
        	
        dbConnect.close();
       }
       
    catch(Exception ex)
    {
    JOptionPane.showMessageDialog(null, ex.toString());
    }

}
	


		 	         
		    			 }
		    		
		    		else {
					    	UIManager.put("OptionPane.background", Color.WHITE);
							 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
							 
							 JLabel label = new JLabel("Select a Category");
						     label.setForeground(Color.RED);
						     label.setFont(new Font("cursive", Font.BOLD, 25 ));
						       
						     JOptionPane.showMessageDialog(frame, label);;
					    		
		    				}
		    	
		    	}
		 		
		    
		
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	add.setBorderPainted(false);
		    	add.setIcon(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\add2.png").getImage()
		    	.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH))));
		    	
		    	add.setText(null);
		    	
		    	add.setBackground(new Color(44,226,9));
		   }
		});
		
		
		
		
		JButton ref = new JButton(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\ref.png").getImage()
		.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH))));
		ref.setBounds(665, 308, 60, 30);
		ref.setBackground(Color.white);
		ref.setFocusable(false);
		ref.setBorderPainted(true);
		ref.setBorder(new LineBorder((new Color(255, 200, 15)), 3));
		frame.add(ref);
		
		ref.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	
		ref.setIcon(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\ref.pn").getImage()
		.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH))));
		    	ref.setBackground(new Color(255, 200, 15));
		    	ref.setText("Refresh");
		    	ref.setFont(new Font("Roman", Font.BOLD, 13));
		    	ref.setForeground(new Color(255, 255, 255));
		    	
		   }
		    
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	pri.setText("");
		    	text.setText("");
		    	second.setSelectedItem(null);
		    	first.setSelectedIndex(9);
		    	cusname.setText("");
		    	cusnum.setText("");
		    	spinner.setValue(0);
		    	figure.setText("");
		    	
		    	// remove all rows when i press refresh button.
		    
		    	DefaultTableModel tMOdel = (DefaultTableModel) jt.getModel();
		    	tMOdel.setRowCount(0);
		    }
		
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	ref.setBorderPainted(true);
		    	ref.setIcon(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\ref.png").getImage()
		    	.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH))));
		    	ref.setText(null);
		    	ref.setBackground(new Color(255, 255, 255));
		   }
		});
		
		
		     
		     JButton up = new JButton(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\update.png").getImage()
						.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH))));
						up.setBounds(727, 308, 60, 30);
						up.setBackground(Color.BLUE);
						up.setFocusable(false);
						up.setBorderPainted(true);
						up.setBorder(new LineBorder(new Color(0, 0, 255), 3));
						frame.add(up);
						
						
						up.addMouseListener(new java.awt.event.MouseAdapter() {
						    public void mouseEntered(java.awt.event.MouseEvent evt) {
						    	
								up.setIcon(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\ref.pn").getImage()
								.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH))));
						    	up.setBackground(new Color(255, 255, 255));
						    	up.setText("Update");
						    	up.setFont(new Font("Roman", Font.BOLD, 14));
						    	up.setForeground(new Color(0, 0, 255));
						    	
						   }
						    
						    public void mouseClicked(java.awt.event.MouseEvent evt) {
						    	int i = jt.getSelectedRow();
						    	
						    	if(i>=0) {
						    		model.setValueAt(text.getText(),i,0);
						    	model.setValueAt(first.getSelectedItem(),i,2);
						    	model.setValueAt(second.getSelectedItem(),i,1);
						    	model.setValueAt(uni.getSelectedItem(),i,3);
						    	model.setValueAt(spinner.getValue(),i,4);
						    	model.setValueAt(pri.getText(),i,5);
						    	}
						    	
						    	else {}
						    }
						    	 	
						    	 	
					
						    public void mouseExited(java.awt.event.MouseEvent evt) {
						    	up.setBorderPainted(true);
						    	up.setIcon(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\update.png").getImage()
						    	.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH))));
						    	up.setText(null);
						    	up.setBackground(new Color(0, 0, 255));
						   }
						});
						
						
					JButton del = new JButton(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\del2.png").getImage()
					.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH))));
					del.setBounds(789, 308, 60, 30);
					del.setBackground(Color.RED);
					del.setFocusable(false);
					del.setBorderPainted(true);
					del.setBorder(new LineBorder(new Color(255, 0, 0), 3));
					frame.add(del);
					
					
					del.addMouseListener(new java.awt.event.MouseAdapter() {
					    public void mouseEntered(java.awt.event.MouseEvent evt) {
					    	
							del.setIcon(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\ref.pn").getImage()
							.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH))));
					    	del.setBackground(new Color(255, 255, 255));
					    	del.setText("Delete");
					    	del.setFont(new Font("Roman", Font.BOLD, 16));
					    	del.setForeground(new Color(255, 0, 0));
					    	
					   }
					    
					    public void mouseClicked(java.awt.event.MouseEvent evt) {
					    	 	int i = jt.getSelectedRow();
					    	 	if(i>=0) {
					    	 		model.removeRow(i);
					    	 	}
					    	 	else {}
					    }
					    	 	
					    	 	
					
					    public void mouseExited(java.awt.event.MouseEvent evt) {
					    	del.setBorderPainted(true);
					    	del.setIcon(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\del2.png").getImage()
					    	.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH))));
					    	del.setText(null);
					    	del.setBackground(new Color(255, 0, 0));
					   }
					});
					
					
		 JButton back = new JButton("Back");
		 back.setBounds(20, 610, 70, 30);
		 back.setBackground(new Color(0,54,0));
		 back.setForeground(new Color(255,255,255));
		 back.setFocusable(false);
		 frame.add(back);
		 
		 back.addMouseListener(new java.awt.event.MouseAdapter() {
			   public void mouseClicked(java.awt.event.MouseEvent evt) {
				   	new dash(names);
					frame.setVisible(false);
					
				}
			});
			
			
		 
		 JButton sell = new JButton("Sell");
		 sell.setBounds(380, 600, 100, 50);
		 sell.setBackground(new Color(255,255,255));
		 sell.setForeground(new Color(0,54,0));
		 sell.setFont(new Font("Roman", Font.BOLD, 30));
		 sell.setBorderPainted(true);
		 sell.setFocusable(false);
		 sell.setBorder(new LineBorder(new Color(0,54,0), 5));
		 frame.add(sell);
		 
		 sell.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseClicked(java.awt.event.MouseEvent evt) {
				 
				 
			if(jt.getRowCount() != 0) {	 
				
				
				
				
				// Sum up Cart items
				 double sum = 0;
				 for(int i = 0; i < jt.getRowCount(); i++) {
					 sum = sum + Integer.parseInt(jt.getValueAt(i, 5).toString());
					  
					 
					 }
				
				 UIManager.put("OptionPane.background", new Color(0,54,0));
				 UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(0,54,0));
				 
				 JLabel label = new JLabel("Total sum is:  N "+ sum);
			        label.setForeground(Color.white);
			        label.setFont(new Font("cursive", Font.BOLD, 35 ));
			       
			        JOptionPane.showMessageDialog(frame, label);;
			        
			      
			        // Add jtable into database
			    	
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
				       
				       
				        PreparedStatement pst= dbConnect.prepareStatement("INSERT into sel VALUES(?,?,?,?,?,?)");

				    

				        for (int i = 0; i < jt.getRowCount(); i++) {
				            for (int j = 0; j < jt.getColumnCount(); j++) {
				                Object o = jt.getValueAt(i, j);
				             
				                pst.setObject(j+1, o);
				            }
				             pst.executeUpdate();
				             pst.clearParameters();
				            
				        }
				    }
				    catch (Exception e) {
				        e.printStackTrace();
				    }
			       
			        
			        
			       
			       //Decrease stock from DB 
			      
			        for(int i = 0; i < jt.getRowCount(); i++) {
			        	String o = (String) jt.getModel().getValueAt(i,2);
			        	String ite = (String) jt.getModel().getValueAt(i,1);
			        	int sub = (int) jt.getModel().getValueAt(i,4);
			        	String u = (String) jt.getModel().getValueAt(i, 3);
			        	
			        	if (o.equals("Bakery")) {
			        		if(u.equals("Pack")) {
			        		
			        				dbname="dnenis";
							        username="root";
							        password="root";
							        url= "jdbc:mysql://localhost:8080/";
							        driver="com.mysql.jdbc.Driver";
							        PreparedStatement pst=null;
							        PreparedStatement p=null;
							        try{
							            Class.forName(driver).newInstance();
							            dbConnect =DriverManager.getConnection(url+dbname, username, password);
							            String gro = " UPDATE bakery SET STOCK = STOCK -'"+(sub*5)+"' WHERE ITEM= '"+ite+"'";
							            String sql = "SELECT * FROM bakery where ITEM='"+ite+"'";
							            pst = dbConnect.prepareStatement(gro);
							            p = dbConnect.prepareStatement(sql);
							            ResultSet rs = p.executeQuery();
							         	pst.executeUpdate();
							         	
							         	
							         	while(rs.next()) {
							         		int remain =rs.getInt("STOCK")-(sub*5);
							         		if (remain<= 15) {
							         			UIManager.put("OptionPane.background", Color.WHITE);
							   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
							   				 
							   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
							   			     labe.setForeground(Color.RED);
							   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
							   			       
							   			     JOptionPane.showMessageDialog(frame, labe);  
								         	}
							         	}
							         	
							         	dbConnect.close();
								       }
							
							        
								    catch(Exception ex)
								    {
								    JOptionPane.showMessageDialog(null, ex.toString());
								    }
			        			}
			        		else {
			        			
			        			dbname="dnenis";
						        username="root";
						        password="root";
						        url= "jdbc:mysql://localhost:8080/";
						        driver="com.mysql.jdbc.Driver";
						        PreparedStatement pst=null;
						        PreparedStatement p=null;
						        try{
						            Class.forName(driver).newInstance();
						            dbConnect =DriverManager.getConnection(url+dbname, username, password);
						            String gro = " UPDATE bakery SET STOCK = STOCK -'"+sub+"' WHERE ITEM= '"+ite+"'";
						            String sql = "SELECT * FROM bakery where ITEM='"+ite+"'";
						            pst = dbConnect.prepareStatement(gro);
						            p = dbConnect.prepareStatement(sql);
						            ResultSet rs = p.executeQuery();
						         	pst.executeUpdate();
						         	
						         	
						         	while(rs.next()) {
						         		int remain =rs.getInt("STOCK")-sub;
						         		if (remain<= 15) {
						         			UIManager.put("OptionPane.background", Color.WHITE);
						   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
						   				 
						   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
						   			     labe.setForeground(Color.RED);
						   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
						   			       
						   			     JOptionPane.showMessageDialog(frame, labe);  
							         	}
						         	}
						         	
						         	dbConnect.close();
							       }
						
						        
							    catch(Exception ex)
							    {
							    JOptionPane.showMessageDialog(null, ex.toString());
							    }
			        			
			        			
			        			
			        		}
			        		
			        	
						        
							        
							        
			        		
			        	}

			        	else if (o.equals("Beverages")) {
			        		
			        		if(u.equals("Pack")) {
				        		
		        				dbname="dnenis";
						        username="root";
						        password="root";
						        url= "jdbc:mysql://localhost:8080/";
						        driver="com.mysql.jdbc.Driver";
						        PreparedStatement pst=null;
						        PreparedStatement p=null;
						        try{
						            Class.forName(driver).newInstance();
						            dbConnect =DriverManager.getConnection(url+dbname, username, password);
						            String gro = " UPDATE baverage SET STOCK = STOCK -'"+(sub*5)+"' WHERE ITEM= '"+ite+"'";
						            String sql = "SELECT * FROM beverage where ITEM='"+ite+"'";
						            pst = dbConnect.prepareStatement(gro);
						            p = dbConnect.prepareStatement(sql);
						            ResultSet rs = p.executeQuery();
						         	pst.executeUpdate();
						         	
						         	
						         	while(rs.next()) {
						         		int remain =rs.getInt("STOCK")-(sub*5);
						         		if (remain<= 15) {
						         			UIManager.put("OptionPane.background", Color.WHITE);
						   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
						   				 
						   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
						   			     labe.setForeground(Color.RED);
						   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
						   			       
						   			     JOptionPane.showMessageDialog(frame, labe);  
							         	}
						         	}
						         	
						         	dbConnect.close();
							       }
						
						        
							    catch(Exception ex)
							    {
							    JOptionPane.showMessageDialog(null, ex.toString());
							    }
		        			}
		        		else {
		        			
		        			dbname="dnenis";
					        username="root";
					        password="root";
					        url= "jdbc:mysql://localhost:8080/";
					        driver="com.mysql.jdbc.Driver";
					        PreparedStatement pst=null;
					        PreparedStatement p=null;
					        try{
					            Class.forName(driver).newInstance();
					            dbConnect =DriverManager.getConnection(url+dbname, username, password);
					            String gro = " UPDATE beverage SET STOCK = STOCK -'"+sub+"' WHERE ITEM= '"+ite+"'";
					            String sql = "SELECT * FROM beverage where ITEM='"+ite+"'";
					            pst = dbConnect.prepareStatement(gro);
					            p = dbConnect.prepareStatement(sql);
					            ResultSet rs = p.executeQuery();
					         	pst.executeUpdate();
					         	
					         	
					         	while(rs.next()) {
					         		int remain =rs.getInt("STOCK")-sub;
					         		if (remain<= 15) {
					         			UIManager.put("OptionPane.background", Color.WHITE);
					   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
					   				 
					   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
					   			     labe.setForeground(Color.RED);
					   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
					   			       
					   			     JOptionPane.showMessageDialog(frame, labe);  
						         	}
					         	}
					         	
					         	dbConnect.close();
						       }
					
					        
						    catch(Exception ex)
						    {
						    JOptionPane.showMessageDialog(null, ex.toString());
						    }
		        			
		        			
		        			
		        		}
		        		
		        	
	        		
	        		
			        		
			        	}

			        	else if (o.equals("Cosmetics")) {

			        		if(u.equals("Pack")) {
				        		
		        				dbname="dnenis";
						        username="root";
						        password="root";
						        url= "jdbc:mysql://localhost:8080/";
						        driver="com.mysql.jdbc.Driver";
						        PreparedStatement pst=null;
						        PreparedStatement p=null;
						        try{
						            Class.forName(driver).newInstance();
						            dbConnect =DriverManager.getConnection(url+dbname, username, password);
						            String gro = " UPDATE cosmetics SET STOCK = STOCK -'"+(sub*5)+"' WHERE ITEM= '"+ite+"'";
						            String sql = "SELECT * FROM cosmetics where ITEM='"+ite+"'";
						            pst = dbConnect.prepareStatement(gro);
						            p = dbConnect.prepareStatement(sql);
						            ResultSet rs = p.executeQuery();
						         	pst.executeUpdate();
						         	
						         	
						         	while(rs.next()) {
						         		int remain =rs.getInt("STOCK")-(sub*5);
						         		if (remain<= 15) {
						         			UIManager.put("OptionPane.background", Color.WHITE);
						   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
						   				 
						   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
						   			     labe.setForeground(Color.RED);
						   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
						   			       
						   			     JOptionPane.showMessageDialog(frame, labe);  
							         	}
						         	}
						         	
						         	dbConnect.close();
							       }
						
						        
							    catch(Exception ex)
							    {
							    JOptionPane.showMessageDialog(null, ex.toString());
							    }
		        			}
		        		else {
		        			
		        			dbname="dnenis";
					        username="root";
					        password="root";
					        url= "jdbc:mysql://localhost:8080/";
					        driver="com.mysql.jdbc.Driver";
					        PreparedStatement pst=null;
					        PreparedStatement p=null;
					        try{
					            Class.forName(driver).newInstance();
					            dbConnect =DriverManager.getConnection(url+dbname, username, password);
					            String gro = " UPDATE cosmetics SET STOCK = STOCK -'"+sub+"' WHERE ITEM= '"+ite+"'";
					            String sql = "SELECT * FROM cosmetics where ITEM='"+ite+"'";
					            pst = dbConnect.prepareStatement(gro);
					            p = dbConnect.prepareStatement(sql);
					            ResultSet rs = p.executeQuery();
					         	pst.executeUpdate();
					         	
					         	
					         	while(rs.next()) {
					         		int remain =rs.getInt("STOCK")-sub;
					         		if (remain<= 15) {
					         			UIManager.put("OptionPane.background", Color.WHITE);
					   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
					   				 
					   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
					   			     labe.setForeground(Color.RED);
					   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
					   			       
					   			     JOptionPane.showMessageDialog(frame, labe);  
						         	}
					         	}
					         	
					         	dbConnect.close();
						       }
					
					        
						    catch(Exception ex)
						    {
						    JOptionPane.showMessageDialog(null, ex.toString());
						    }
		        			
		        			
		        			
		        		}
		        		
		        	
					        
						        
			        		
			        		
			        		
			        	}

			        	else if (o.equals("Tobacco")) {
			        		
			        		if(u.equals("Pack")) {
				        		
		        				dbname="dnenis";
						        username="root";
						        password="root";
						        url= "jdbc:mysql://localhost:8080/";
						        driver="com.mysql.jdbc.Driver";
						        PreparedStatement pst=null;
						        PreparedStatement p=null;
						        try{
						            Class.forName(driver).newInstance();
						            dbConnect =DriverManager.getConnection(url+dbname, username, password);
						            String gro = " UPDATE tobacco SET STOCK = STOCK -'"+(sub*5)+"' WHERE ITEM= '"+ite+"'";
						            String sql = "SELECT * FROM tobacco where ITEM='"+ite+"'";
						            pst = dbConnect.prepareStatement(gro);
						            p = dbConnect.prepareStatement(sql);
						            ResultSet rs = p.executeQuery();
						         	pst.executeUpdate();
						         	
						         	
						         	while(rs.next()) {
						         		int remain =rs.getInt("STOCK")-(sub*5);
						         		if (remain<= 15) {
						         			UIManager.put("OptionPane.background", Color.WHITE);
						   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
						   				 
						   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
						   			     labe.setForeground(Color.RED);
						   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
						   			       
						   			     JOptionPane.showMessageDialog(frame, labe);  
							         	}
						         	}
						         	
						         	dbConnect.close();
							       }
						
						        
							    catch(Exception ex)
							    {
							    JOptionPane.showMessageDialog(null, ex.toString());
							    }
		        			}
		        		else {
		        			
		        			dbname="dnenis";
					        username="root";
					        password="root";
					        url= "jdbc:mysql://localhost:8080/";
					        driver="com.mysql.jdbc.Driver";
					        PreparedStatement pst=null;
					        PreparedStatement p=null;
					        try{
					            Class.forName(driver).newInstance();
					            dbConnect =DriverManager.getConnection(url+dbname, username, password);
					            String gro = " UPDATE tobacco SET STOCK = STOCK -'"+sub+"' WHERE ITEM= '"+ite+"'";
					            String sql = "SELECT * FROM tobacco where ITEM='"+ite+"'";
					            pst = dbConnect.prepareStatement(gro);
					            p = dbConnect.prepareStatement(sql);
					            ResultSet rs = p.executeQuery();
					         	pst.executeUpdate();
					         	
					         	
					         	while(rs.next()) {
					         		int remain =rs.getInt("STOCK")-sub;
					         		if (remain<= 15) {
					         			UIManager.put("OptionPane.background", Color.WHITE);
					   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
					   				 
					   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
					   			     labe.setForeground(Color.RED);
					   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
					   			       
					   			     JOptionPane.showMessageDialog(frame, labe);  
						         	}
					         	}
					         	
					         	dbConnect.close();
						       }
					
					        
						    catch(Exception ex)
						    {
						    JOptionPane.showMessageDialog(null, ex.toString());
						    }
		        			
		        			
		        			
		        		}
		        		
		        	
					        
						        
			        		
			        		
			        		
			        		
			        	}

			        	else if (o.equals("Electronics")) {
			        		
			        		
			        		if(u.equals("Pack")) {
				        		
		        				dbname="dnenis";
						        username="root";
						        password="root";
						        url= "jdbc:mysql://localhost:8080/";
						        driver="com.mysql.jdbc.Driver";
						        PreparedStatement pst=null;
						        PreparedStatement p=null;
						        try{
						            Class.forName(driver).newInstance();
						            dbConnect =DriverManager.getConnection(url+dbname, username, password);
						            String gro = " UPDATE electronics SET STOCK = STOCK -'"+(sub*5)+"' WHERE ITEM= '"+ite+"'";
						            String sql = "SELECT * FROM electronics where ITEM='"+ite+"'";
						            pst = dbConnect.prepareStatement(gro);
						            p = dbConnect.prepareStatement(sql);
						            ResultSet rs = p.executeQuery();
						         	pst.executeUpdate();
						         	
						         	
						         	while(rs.next()) {
						         		int remain =rs.getInt("STOCK")-(sub*5);
						         		if (remain<= 15) {
						         			UIManager.put("OptionPane.background", Color.WHITE);
						   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
						   				 
						   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
						   			     labe.setForeground(Color.RED);
						   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
						   			       
						   			     JOptionPane.showMessageDialog(frame, labe);  
							         	}
						         	}
						         	
						         	dbConnect.close();
							       }
						
						        
							    catch(Exception ex)
							    {
							    JOptionPane.showMessageDialog(null, ex.toString());
							    }
		        			}
		        		else {
		        			
		        			dbname="dnenis";
					        username="root";
					        password="root";
					        url= "jdbc:mysql://localhost:8080/";
					        driver="com.mysql.jdbc.Driver";
					        PreparedStatement pst=null;
					        PreparedStatement p=null;
					        try{
					            Class.forName(driver).newInstance();
					            dbConnect =DriverManager.getConnection(url+dbname, username, password);
					            String gro = " UPDATE electronics SET STOCK = STOCK -'"+sub+"' WHERE ITEM= '"+ite+"'";
					            String sql = "SELECT * FROM electronics where ITEM='"+ite+"'";
					            pst = dbConnect.prepareStatement(gro);
					            p = dbConnect.prepareStatement(sql);
					            ResultSet rs = p.executeQuery();
					         	pst.executeUpdate();
					         	
					         	
					         	while(rs.next()) {
					         		int remain =rs.getInt("STOCK")-sub;
					         		if (remain<= 15) {
					         			UIManager.put("OptionPane.background", Color.WHITE);
					   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
					   				 
					   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
					   			     labe.setForeground(Color.RED);
					   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
					   			       
					   			     JOptionPane.showMessageDialog(frame, labe);  
						         	}
					         	}
					         	
					         	dbConnect.close();
						       }
					
					        
						    catch(Exception ex)
						    {
						    JOptionPane.showMessageDialog(null, ex.toString());
						    }
		        			
		        			
		        			
		        		}
		        		
		        	
					        
						        
			        		
			        		
			        		
			        	}

			        	else if (o.equals("Diary")) {

			        		
			        		if(u.equals("Pack")) {
				        		
		        				dbname="dnenis";
						        username="root";
						        password="root";
						        url= "jdbc:mysql://localhost:8080/";
						        driver="com.mysql.jdbc.Driver";
						        PreparedStatement pst=null;
						        PreparedStatement p=null;
						        try{
						            Class.forName(driver).newInstance();
						            dbConnect =DriverManager.getConnection(url+dbname, username, password);
						            String gro = " UPDATE diary SET STOCK = STOCK -'"+(sub*5)+"' WHERE ITEM= '"+ite+"'";
						            String sql = "SELECT * FROM diary where ITEM='"+ite+"'";
						            pst = dbConnect.prepareStatement(gro);
						            p = dbConnect.prepareStatement(sql);
						            ResultSet rs = p.executeQuery();
						         	pst.executeUpdate();
						         	
						         	
						         	while(rs.next()) {
						         		int remain =rs.getInt("STOCK")-(sub*5);
						         		if (remain<= 15) {
						         			UIManager.put("OptionPane.background", Color.WHITE);
						   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
						   				 
						   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
						   			     labe.setForeground(Color.RED);
						   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
						   			       
						   			     JOptionPane.showMessageDialog(frame, labe);  
							         	}
						         	}
						         	
						         	dbConnect.close();
							       }
						
						        
							    catch(Exception ex)
							    {
							    JOptionPane.showMessageDialog(null, ex.toString());
							    }
		        			}
		        		else {
		        			
		        			dbname="dnenis";
					        username="root";
					        password="root";
					        url= "jdbc:mysql://localhost:8080/";
					        driver="com.mysql.jdbc.Driver";
					        PreparedStatement pst=null;
					        PreparedStatement p=null;
					        try{
					            Class.forName(driver).newInstance();
					            dbConnect =DriverManager.getConnection(url+dbname, username, password);
					            String gro = " UPDATE diary SET STOCK = STOCK -'"+sub+"' WHERE ITEM= '"+ite+"'";
					            String sql = "SELECT * FROM diary where ITEM='"+ite+"'";
					            pst = dbConnect.prepareStatement(gro);
					            p = dbConnect.prepareStatement(sql);
					            ResultSet rs = p.executeQuery();
					         	pst.executeUpdate();
					         	
					         	
					         	while(rs.next()) {
					         		int remain =rs.getInt("STOCK")-sub;
					         		if (remain<= 15) {
					         			UIManager.put("OptionPane.background", Color.WHITE);
					   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
					   				 
					   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
					   			     labe.setForeground(Color.RED);
					   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
					   			       
					   			     JOptionPane.showMessageDialog(frame, labe);  
						         	}
					         	}
					         	
					         	dbConnect.close();
						       }
					
					        
						    catch(Exception ex)
						    {
						    JOptionPane.showMessageDialog(null, ex.toString());
						    }
		        			
		        			
		        			
		        		}
		        		
		        	
					        
						        
			        		
			        		
			        		
			        	}

			        	else if (o.equals("Groceries")) {

			        		
			        		if(u.equals("Pack")) {
				        		
		        				dbname="dnenis";
						        username="root";
						        password="root";
						        url= "jdbc:mysql://localhost:8080/";
						        driver="com.mysql.jdbc.Driver";
						        PreparedStatement pst=null;
						        PreparedStatement p=null;
						        try{
						            Class.forName(driver).newInstance();
						            dbConnect =DriverManager.getConnection(url+dbname, username, password);
						            String gro = " UPDATE groceries SET STOCK = STOCK -'"+(sub*5)+"' WHERE ITEM= '"+ite+"'";
						            String sql = "SELECT * FROM groceries where ITEM='"+ite+"'";
						            pst = dbConnect.prepareStatement(gro);
						            p = dbConnect.prepareStatement(sql);
						            ResultSet rs = p.executeQuery();
						         	pst.executeUpdate();
						         	
						         	
						         	while(rs.next()) {
						         		int remain =rs.getInt("STOCK")-(sub*5);
						         		if (remain<= 15) {
						         			UIManager.put("OptionPane.background", Color.WHITE);
						   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
						   				 
						   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
						   			     labe.setForeground(Color.RED);
						   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
						   			       
						   			     JOptionPane.showMessageDialog(frame, labe);  
							         	}
						         	}
						         	
						         	dbConnect.close();
							       }
						
						        
							    catch(Exception ex)
							    {
							    JOptionPane.showMessageDialog(null, ex.toString());
							    }
		        			}
		        		else {
		        			
		        			dbname="dnenis";
					        username="root";
					        password="root";
					        url= "jdbc:mysql://localhost:8080/";
					        driver="com.mysql.jdbc.Driver";
					        PreparedStatement pst=null;
					        PreparedStatement p=null;
					        try{
					            Class.forName(driver).newInstance();
					            dbConnect =DriverManager.getConnection(url+dbname, username, password);
					            String gro = " UPDATE groceries SET STOCK = STOCK -'"+sub+"' WHERE ITEM= '"+ite+"'";
					            String sql = "SELECT * FROM groceries where ITEM='"+ite+"'";
					            pst = dbConnect.prepareStatement(gro);
					            p = dbConnect.prepareStatement(sql);
					            ResultSet rs = p.executeQuery();
					         	pst.executeUpdate();
					         	
					         	
					         	while(rs.next()) {
					         		int remain =rs.getInt("STOCK")-sub;
					         		if (remain<= 15) {
					         			UIManager.put("OptionPane.background", Color.WHITE);
					   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
					   				 
					   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
					   			     labe.setForeground(Color.RED);
					   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
					   			       
					   			     JOptionPane.showMessageDialog(frame, labe);  
						         	}
					         	}
					         	
					         	dbConnect.close();
						       }
					
					        
						    catch(Exception ex)
						    {
						    JOptionPane.showMessageDialog(null, ex.toString());
						    }
		        			
		        			
		        			
		        		}
		        		
		        	
					        
						        
			        		
			        		
			        		
			        	}

			        	else if (o.equals("Frozen foods")) {

			        		if(u.equals("Pack")) {
				        		
		        				dbname="dnenis";
						        username="root";
						        password="root";
						        url= "jdbc:mysql://localhost:8080/";
						        driver="com.mysql.jdbc.Driver";
						        PreparedStatement pst=null;
						        PreparedStatement p=null;
						        try{
						            Class.forName(driver).newInstance();
						            dbConnect =DriverManager.getConnection(url+dbname, username, password);
						            String gro = " UPDATE frozen SET STOCK = STOCK -'"+(sub*5)+"' WHERE ITEM= '"+ite+"'";
						            String sql = "SELECT * FROM frozen where ITEM='"+ite+"'";
						            pst = dbConnect.prepareStatement(gro);
						            p = dbConnect.prepareStatement(sql);
						            ResultSet rs = p.executeQuery();
						         	pst.executeUpdate();
						         	
						         	
						         	while(rs.next()) {
						         		int remain =rs.getInt("STOCK")-(sub*5);
						         		if (remain<= 15) {
						         			UIManager.put("OptionPane.background", Color.WHITE);
						   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
						   				 
						   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
						   			     labe.setForeground(Color.RED);
						   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
						   			       
						   			     JOptionPane.showMessageDialog(frame, labe);  
							         	}
						         	}
						         	
						         	dbConnect.close();
							       }
						
						        
							    catch(Exception ex)
							    {
							    JOptionPane.showMessageDialog(null, ex.toString());
							    }
		        			}
		        		else {
		        			
		        			dbname="dnenis";
					        username="root";
					        password="root";
					        url= "jdbc:mysql://localhost:8080/";
					        driver="com.mysql.jdbc.Driver";
					        PreparedStatement pst=null;
					        PreparedStatement p=null;
					        try{
					            Class.forName(driver).newInstance();
					            dbConnect =DriverManager.getConnection(url+dbname, username, password);
					            String gro = " UPDATE frozen SET STOCK = STOCK -'"+sub+"' WHERE ITEM= '"+ite+"'";
					            String sql = "SELECT * FROM frozen where ITEM='"+ite+"'";
					            pst = dbConnect.prepareStatement(gro);
					            p = dbConnect.prepareStatement(sql);
					            ResultSet rs = p.executeQuery();
					         	pst.executeUpdate();
					         	
					         	
					         	while(rs.next()) {
					         		int remain =rs.getInt("STOCK")-sub;
					         		if (remain<= 15) {
					         			UIManager.put("OptionPane.background", Color.WHITE);
					   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
					   				 
					   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
					   			     labe.setForeground(Color.RED);
					   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
					   			       
					   			     JOptionPane.showMessageDialog(frame, labe);  
						         	}
					         	}
					         	
					         	dbConnect.close();
						       }
					
					        
						    catch(Exception ex)
						    {
						    JOptionPane.showMessageDialog(null, ex.toString());
						    }
		        			
		        			
		        			
		        		}
		        		
		        	
					        
						        
				      
			        
			        	}

			        	else if (o.equals("Toiletries")) {

			        		if(u.equals("Pack")) {
				        		
		        				dbname="dnenis";
						        username="root";
						        password="root";
						        url= "jdbc:mysql://localhost:8080/";
						        driver="com.mysql.jdbc.Driver";
						        PreparedStatement pst=null;
						        PreparedStatement p=null;
						        try{
						            Class.forName(driver).newInstance();
						            dbConnect =DriverManager.getConnection(url+dbname, username, password);
						            String gro = " UPDATE toiletries SET STOCK = STOCK -'"+(sub*5)+"' WHERE ITEM= '"+ite+"'";
						            String sql = "SELECT * FROM toiletries where ITEM='"+ite+"'";
						            pst = dbConnect.prepareStatement(gro);
						            p = dbConnect.prepareStatement(sql);
						            ResultSet rs = p.executeQuery();
						         	pst.executeUpdate();
						         	
						         	
						         	while(rs.next()) {
						         		int remain =rs.getInt("STOCK")-(sub*5);
						         		if (remain<= 15) {
						         			UIManager.put("OptionPane.background", Color.WHITE);
						   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
						   				 
						   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
						   			     labe.setForeground(Color.RED);
						   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
						   			       
						   			     JOptionPane.showMessageDialog(frame, labe);  
							         	}
						         	}
						         	
						         	dbConnect.close();
							       }
						
						        
							    catch(Exception ex)
							    {
							    JOptionPane.showMessageDialog(null, ex.toString());
							    }
		        			}
			        		
		        		else {
		        			
		        			dbname="dnenis";
					        username="root";
					        password="root";
					        url= "jdbc:mysql://localhost:8080/";
					        driver="com.mysql.jdbc.Driver";
					        PreparedStatement pst=null;
					        PreparedStatement p=null;
					        try{
					            Class.forName(driver).newInstance();
					            dbConnect =DriverManager.getConnection(url+dbname, username, password);
					            String gro = " UPDATE toiletries SET STOCK = STOCK -'"+sub+"' WHERE ITEM= '"+ite+"'";
					            String sql = "SELECT * FROM toiletries where ITEM='"+ite+"'";
					            pst = dbConnect.prepareStatement(gro);
					            p = dbConnect.prepareStatement(sql);
					            ResultSet rs = p.executeQuery();
					         	pst.executeUpdate();
					         	
					         	
					         	while(rs.next()) {
					         		int remain =rs.getInt("STOCK")-sub;
					         		if (remain<= 15) {
					         			UIManager.put("OptionPane.background", Color.WHITE);
					   				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
					   				 
					   				 JLabel labe = new JLabel(ite+" is Remaining Just  "+ remain +" Pieces");
					   			     labe.setForeground(Color.RED);
					   			     labe.setFont(new Font("cursive", Font.BOLD, 25 ));
					   			       
					   			     JOptionPane.showMessageDialog(frame, labe);  
						         	}
					         	}
					         	
					         	dbConnect.close();
						       }
					
					        
						    catch(Exception ex)
						    {
						    JOptionPane.showMessageDialog(null, ex.toString());
						    }
		        			
		        			
		        			
		        		}
		        		
		        	
			        		
			        		}
			        	
			        	
			        	
			        	}
			        
					}
			  
			else {
				 UIManager.put("OptionPane.background", Color.WHITE);
				 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.WHITE);
				 
				 JLabel label = new JLabel("Cart is Empty !!!");
			     label.setForeground(Color.RED);
			     label.setFont(new Font("cursive", Font.BOLD, 25 ));
			       
			     JOptionPane.showMessageDialog(frame, label);  
		}
			      
			        
			        
			 }
		 });
			     
			     
		 
		 	pri.setText("");pri.setEditable(false);
	    	text.setText("");
	    	second.setSelectedItem(null);
	    	first.setSelectedIndex(9);
	    	cusname.setText("");
	    	cusnum.setText("");
	    	spinner.setValue(0);
	    	text.setEditable(false);
	    	
	    	staf.setEditable(false);
		 
		 
		 
		 
		frame.add(text);
		frame.add(b);
		frame.setLayout(null);
		
		frame.getContentPane().setBackground(Color.WHITE);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(900, 700);
		frame.setResizable(false);
}
	
	
		
	
}
