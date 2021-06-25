import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.*
;  
public class inventory extends javax.swing.JFrame{
	
	


	inventory(String st) {
		
		JSplitPane splitPane = new JSplitPane();
		JPanel leftPanel = new JPanel() ;
		JPanel rightPanel = new JPanel();
		
		
		getContentPane().setLayout(new GridLayout());
		getContentPane().add(splitPane);  
		
		 splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);  
	     splitPane.setDividerLocation(550);                    
	     splitPane.setTopComponent(leftPanel);                  
	     splitPane.setBottomComponent(rightPanel);            
	     

		
	     
		
		JLabel l3 = new JLabel("Categories");
		l3.setBounds(190,5, 450,150);
		l3.setFont(new Font("Serif", Font.PLAIN, 45));
		l3.setForeground(new Color(255, 255, 255));
		leftPanel.add(l3);
		
		JLabel r3 = new JLabel("Toiletries");
		r3.setBounds(100,0, 300,30);
		r3.setFont(new Font("Serif", Font.BOLD, 25));
		r3.setForeground(new Color(0, 54, 0));
		rightPanel.add(r3);
		
		JButton a = new JButton("Toiletries");
		a.setBounds(65, 160, 140, 140);
		leftPanel.add(a);
		a.setBackground(Color.RED);
		a.setFont(new Font("Serif", Font.BOLD, 20));
		a.setForeground(new Color(0, 54, 0));
		a.setFocusable(false);
		
		
		
		JButton b = new JButton("cosmetics");
		b.setBounds(210, 160, 140, 140);
		leftPanel.add(b);
		b.setBackground(new Color(232, 247, 27));
		b.setFont(new Font("Serif", Font.BOLD, 20));
		b.setForeground(new Color(0, 54, 0));
		b.setFocusable(false);
		
		b.addMouseListener(new java.awt.event.MouseAdapter() {
		  
		    
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	new cosmetics(st);
		    	setVisible(false);
		    }
		
		   
		});
		
		
		JButton c = new JButton("Tobacco");
		c.setBounds(355, 160, 140, 140);
		leftPanel.add(c);
		c.setBackground(new Color(193, 96, 5));
		c.setFont(new Font("Serif", Font.BOLD, 20));
		c.setForeground(new Color(0, 54, 0));
		c.setFocusable(false);
		
		c.addMouseListener(new java.awt.event.MouseAdapter() {
		  
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	 new tobacco(st);
		    	
		    	setVisible(false);
		    }
		
		});
		
		JButton d = new JButton("Diary");
		d.setBounds(65, 305, 140, 140);
		leftPanel.add(d);
		d.setBackground(new Color(138, 139, 127));
		d.setFont(new Font("Serif", Font.BOLD, 20));
		d.setForeground(new Color(0, 54, 0));
		d.setFocusable(false);
		
		d.addMouseListener(new java.awt.event.MouseAdapter() {
		  
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	new diary(st);
		    	
		    	setVisible(false);
		    }
		
		});
		
		JButton e = new JButton("Beverages");
		e.setBounds(210, 305, 140, 140);
		leftPanel.add(e);
		e.setBackground(new Color(4, 179, 237));
		e.setFont(new Font("Serif", Font.BOLD, 20));
		e.setForeground(new Color(0, 54, 0));
		e.setFocusable(false);
		
		e.addMouseListener(new java.awt.event.MouseAdapter() {
			  
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	new beverage(st);
		    	
		    	setVisible(false);
		    }
		
		});
		
		JButton f = new JButton("Frozen Foods");
		f.setBounds(355, 305, 140, 140);
		leftPanel.add(f);
		f.setBackground(new Color(173, 255, 119));
		f.setFont(new Font("Serif", Font.BOLD, 20));
		f.setForeground(new Color(0, 54, 0));
		f.setFocusable(false);
		
		f.addMouseListener(new java.awt.event.MouseAdapter() {
			  
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	 new frozen(st);
		    	
		    	setVisible(false);
		    }
		
		});
		
		JButton g = new JButton("Electronics");
		g.setBounds(65, 450, 140, 140);
		leftPanel.add(g);
		g.setBackground(new Color(134, 0, 200));
		g.setFont(new Font("Serif", Font.BOLD, 20));
		g.setForeground(new Color(0, 54, 0));
		g.setFocusable(false);
		
		g.addMouseListener(new java.awt.event.MouseAdapter() {
			  
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	 new electronic(st);
		    	
		    	setVisible(false);
		    }
		
		});
		
		JButton h = new JButton("Bakery");
		h.setBounds(210, 450, 140, 140);
		leftPanel.add(h);
		h.setBackground(new Color(255, 45, 244));
		h.setFont(new Font("Serif", Font.BOLD, 20));
		h.setForeground(new Color(0, 54, 0));
		h.setFocusable(false);
		
		h.addMouseListener(new java.awt.event.MouseAdapter() {
			  
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	 new bakery(st);
		    	
		    	setVisible(false);
		    }
		
		});
		
		JButton i = new JButton("Grocery");
		i.setBounds(355, 450, 140, 140);
		leftPanel.add(i);
		i.setBackground(new Color(255, 240, 0));
		i.setFont(new Font("Serif", Font.BOLD, 20));
		i.setForeground(new Color(0, 54, 0));
		i.setFocusable(false);
		
		i.addMouseListener(new java.awt.event.MouseAdapter() {
			  
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	 new grocery(st);
		    	
		    	setVisible(false);
		    }
		
		});
		
		
		
		JButton j = new JButton("Back");
		j.setBounds(240, 600, 80, 50);
		leftPanel.add(j);
		j.setBackground(new Color(0, 54, 0));
		j.setFont(new Font("Serif",Font.BOLD,17));
		j.setForeground(new Color(255,255,255));
		j.setFocusable(false);
		j.setBorderPainted(false);
		
		j.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				 new dash(st);
				
				setVisible(false);
			}
			
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				j.setBorderPainted(true);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) {
				j.setBorderPainted(false);
			}
		});
	    
		
		
	     rightPanel.setBackground(Color.WHITE);
	     leftPanel.setLayout(null);
	     rightPanel.setLayout(null);
	    
	     
	     JLabel pic = new JLabel(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\imm.png").getImage()
	    			.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH))));
			pic.setBounds(10,30, 300,200);  
	     rightPanel.add(pic);
	
	     
			
			JTable jt = new JTable();
			
			Object[] columns = {"ID","ITEM","SINGLE","PACK","STOCK"};
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(columns);
			jt.setModel(model);
			
			
			
			

			
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
			       
		   
		    PreparedStatement pst =dbConnect.prepareStatement("Select * from toiletries;");
		    ResultSet rs = pst.executeQuery();
		    jt.setModel(DbUtils.resultSetToTableModel(rs));
		    dbConnect.close();
		    }
		    catch(Exception ex)
		    {
		    JOptionPane.showMessageDialog(null, ex.toString());
		    }

			
			
			jt.getColumnModel().getColumn(0).setPreferredWidth(1);
			jt.getColumnModel().getColumn(1).setPreferredWidth(90);
			jt.getColumnModel().getColumn(2).setPreferredWidth(20);
			jt.getColumnModel().getColumn(3).setPreferredWidth(20);
			jt.getColumnModel().getColumn(4).setPreferredWidth(10);
			
			
			
			     jt.setBounds(0,0,150,200);  
			     jt.setBackground(new Color(0, 54, 0));
				 jt.setForeground(new Color(255, 255, 255));
				 jt.setFont(new Font("Roman", Font.BOLD, 14));
				 JScrollPane sp=new JScrollPane(jt);  
				 sp.setBounds(2,250,320,250);
				 sp.getViewport().setBackground(new Color(0, 54, 0));
			     rightPanel.add(sp);
	     
			     JLabel lab1 = new JLabel("Enter Item Name");
			     lab1.setBounds(2, 492, 200, 50);
			     lab1.setFont(new Font("Cursive", Font.BOLD, 13));
			     lab1.setForeground(new Color(0, 54, 0));
				rightPanel.add(lab1);
	     
	     JTextField productentry = new JTextField();
	     productentry.setBounds(2,525,150,30);
	     productentry.setBackground(new Color(0, 54, 0));
	     productentry.setForeground(new Color(255, 255, 255));
	     productentry.setFont(new Font("Serif", Font.BOLD, 20));
			rightPanel.add(productentry);
			
			
			 JLabel lab2 = new JLabel("Single price");
		     lab2.setBounds(2, 550, 200, 50);
		     lab2.setFont(new Font("Cursive", Font.BOLD, 13));
		     lab2.setForeground(new Color(0, 54, 0));
			rightPanel.add(lab2);
			
	     JTextField pricesingle = new JTextField();
	     pricesingle.setBounds(80,557,73,30);
	     pricesingle.setBackground(new Color(0, 54, 0));
	     pricesingle.setForeground(new Color(255, 255, 255));
	     pricesingle.setFont(new Font("Serif", Font.BOLD, 20));
			rightPanel.add(pricesingle);
			
			
			 JLabel lab3 = new JLabel("Pack price");
		     lab3.setBounds(9, 580, 200, 50);
		     lab3.setFont(new Font("Cursive", Font.BOLD, 13));
		     lab3.setForeground(new Color(0, 54, 0));
			rightPanel.add(lab3);
			
	     JTextField pricepack = new JTextField();
	     pricepack.setBounds(80,589,73,30);
	     pricepack.setBackground(new Color(0, 54, 0));
	     pricepack.setForeground(new Color(255, 255, 255));
	     pricepack.setFont(new Font("Serif", Font.BOLD, 20));
			rightPanel.add(pricepack);
			
			
			 JLabel lab4 = new JLabel("Stock");
		     lab4.setBounds(39, 612, 200, 50);
		     lab4.setFont(new Font("Cursive", Font.BOLD, 13));
		     lab4.setForeground(new Color(0, 54, 0));
			rightPanel.add(lab4);
			
			
	     JTextField stock = new JTextField();
	     stock.setBounds(80,620,73,30);
	     stock.setBackground(new Color(0, 54, 0));
	     stock.setForeground(new Color(255, 255, 255));
	     stock.setFont(new Font("Serif", Font.BOLD, 20));
			rightPanel.add( stock);
			
			
			
			
			
			JButton add = new JButton();
					add.setBounds(190, 557, 130, 30);
					add.setBackground(new Color(44,226,9));
					add.setText("Add Product");
					add.setFont(new Font("Roman", Font.BOLD, 14));
					add.setForeground(new Color(255,255,255));
					add.setBorderPainted(false);
					rightPanel.add(add);
					
			add.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	
			    	add.setBackground(new Color(255, 255, 255));
			    	add.setText("Add");
			    	add.setFont(new Font("Roman", Font.BOLD, 14));
			    	add.setForeground(new Color(44,226,9));
			    	
			    	add.setBorderPainted(true);
			    	add.setBorder(new LineBorder((new Color(44,226,9)), 3));
			    	
			   }
			    
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			    	add.setFocusable(false);
			    	

			    	  
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
					        System.out.println("Connection established");
					       
					        
					        
					        String sql = "INSERT INTO toiletries values(NULL,?,?,?,?)";
					    
					     pst = dbConnect.prepareStatement(sql);
					     pst.setString(1, productentry.getText());
					     pst.setString(2, pricesingle.getText());
					     pst.setString(3, pricepack.getText());
					     pst.setString(4, stock.getText());
					    


					     pst.executeUpdate();
					     System.out.println("insert established");
					     dbConnect.close();
					       
				        }
					    catch(Exception ex)
					    {
					    JOptionPane.showMessageDialog(null, ex.toString());
					    }

		 	          
		 	          
				        
				        
				        
			    	
			    		}
			    	
			 		
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	add.setFont(new Font("Roman", Font.BOLD, 14));
					add.setForeground(new Color(255,255,255));
					add.setBorderPainted(false);
					add.setText("To Database");
			    	add.setBackground(new Color(44,226,9));
			   }
			});
			
			
			
			
			
			

			JButton edit = new JButton();
					edit.setBounds(190, 589, 130, 30);
					edit.setBackground(new Color(0, 0, 255));
					edit.setText("Edit Product");
					edit.setFont(new Font("Roman", Font.BOLD, 14));
					edit.setForeground(new Color(255,255,255));
					edit.setBorderPainted(false);
					rightPanel.add(edit);
					
			edit.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	
			    	edit.setBackground(new Color(255, 255, 255));
			    	edit.setText("Edit");
			    	edit.setFont(new Font("Roman", Font.BOLD, 14));
			    	edit.setForeground(new Color(0, 0, 255));
			    	
			    	edit.setBorderPainted(true);
			    	edit.setBorder(new LineBorder((new Color(0, 0, 255)), 3));
			    	
			   }
			    
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			    	edit.setFocusable(false);
			    	
			    	

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
					        System.out.println("Connection established");
					        int row = jt.getSelectedRow();
					        String val = (jt.getModel().getValueAt(row, 0).toString());
					        String queryl = "UPDATE toiletries SET ITEM =?, SINGLE =?, PACK =?, STOCK =? WHERE ID ="+val;
					        pst =dbConnect.prepareStatement(queryl);
					        pst.setString(1, productentry.getText());
					        pst.setString(2, pricesingle.getText());
					        pst.setString(3, pricepack.getText());
					        pst.setString(4, stock.getText());
					        pst.executeUpdate();
					       
					        System.out.print("update successful");
					        dbConnect.close();
				    }
				    catch(Exception ex)
				    {
				    JOptionPane.showMessageDialog(null, ex.toString());
				    }

					
			    	
			    		}
			    	
			 		
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	edit.setFont(new Font("Roman", Font.BOLD, 14));
					edit.setForeground(new Color(255,255,255));
					edit.setBorderPainted(false);
					edit.setText("From Database");
			    	edit.setBackground(new Color(0, 0, 255));
			   }
			});
			
			
			
			
			
			
			

			JButton ref = new JButton();
					ref.setBounds(190, 621, 130, 30);
					ref.setBackground(new Color(255, 200, 15));
					ref.setText("Refresh");
					ref.setFont(new Font("Roman", Font.BOLD, 14));
					ref.setForeground(new Color(255,255,255));
					ref.setBorderPainted(false);
					rightPanel.add(ref);
					
			ref.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	
			    	ref.setBackground(new Color(255, 255, 255));
			    	ref.setText("To see");
			    	ref.setFont(new Font("Roman", Font.BOLD, 14));
			    	ref.setForeground(new Color(255, 200, 15));
			    	
			    	ref.setBorderPainted(true);
			    	ref.setBorder(new LineBorder((new Color(255, 200, 15)), 3));
			    	
			   }
			    
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			    	ref.setFocusable(false);
			    	 new inventory(st);
					
					setVisible(false);
			    		}
			    	
			 		
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	ref.setFont(new Font("Roman", Font.BOLD, 14));
					ref.setForeground(new Color(255,255,255));
					ref.setBorderPainted(false);
					ref.setText("Change");
			    	ref.setBackground(new Color(255, 200, 15));
			   }
			});
			
	     
	     leftPanel.setBackground(new Color(0, 54, 0));
	     setFocusable(false);
	     setVisible(true);
	     setSize(900,700);
	     setResizable(false);
	}
	

	
}
