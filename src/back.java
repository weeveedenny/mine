import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import com.mkyong.common.mysql-connector-java-5.0.8.src.com.mysql.jdbc.Connection;
import com.mkyong.common.mysql-connector-java-5.0.8.src.com.mysql.jdbc.PreparedStatement;
import com.mkyong.common.mysql-connector-java-5.0.8.src.com.mysql.jdbc.ResultSet;
public class back  {
	
	public void bath() {
		
		BufferedImage img = null;
		try {
		img = ImageIO.read(new File("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\dim.jpg"));
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		JFrame frame = new JFrame("testing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JLabel(new ImageIcon(img)));
		frame.setLayout(null);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		
		
		JButton b  = new JButton("Enter");
		JLabel l3 = new JLabel("LOGIN");
			l3.setBounds(650,60, 180,30);
			l3.setFont(new Font("Roman", Font.BOLD, 35));
			l3.setForeground(new Color(0, 54, 0));
			
			
		 JLabel l1=new JLabel("Username:");     
		   	l1.setBounds(650,90, 80,30); 
		 JLabel l2=new JLabel("Password:");  
		  	l2.setBounds(650,150, 80,30); 
		    b.setBounds(650,220, 70,30);

			
			b.setOpaque(false);
			b.setContentAreaFilled(false);
			b.setBorderPainted(true);
			b.setBorder(new LineBorder(new Color(0,54,0), 3));
			b.setFont(new Font("Roman", Font.BOLD, 17));
			b.setForeground(new Color(0, 54, 0));
			b.setFocusable(false);

		   
		    JPasswordField value = new JPasswordField();   
		    value.setBounds(650,175,200,30); 
		    value.setFont(new Font("Serif", Font.BOLD, 17));
		    value.setBackground(new Color(0, 54, 0));
		    final JTextField text = new JTextField();   
		    text.setBounds(650,120, 200,30);
		    text.setFont(new Font("Serif", Font.BOLD, 17));
		    text.setBackground(new Color(0, 54, 0));
		    value.setForeground(new Color(255, 255, 255));
		    text.setForeground(new Color(255, 255, 255));
		    
		    
		    
		    b.addMouseListener(new java.awt.event.MouseAdapter() {
				   
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			    	
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
				        String sql ="SELECT * FROM login WHERE USERNAME=? AND PASSWORD=?";
				        pst = dbConnect.prepareStatement(sql);
				        pst.setString(1, text.getText());
				        pst.setString(2, value.getText());
				        ResultSet rs=pst.executeQuery();
				        
				        if(rs.next()) {
				        	String send = rs.getString("NAME");
				        	dash take = new dash(send);
				        	 
				    		frame.setVisible(false);				        }
				        else {
				        	 UIManager.put("OptionPane.background", Color.RED);
							 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
							 JLabel label = new JLabel("Invalid Username or Password");
						     label.setForeground(Color.white);
						     label.setFont(new Font("Roman", Font.BOLD, 20 ));
						     JOptionPane.showMessageDialog(frame, label,"Login Error", JOptionPane.ERROR_MESSAGE);;
				        }
				   
				     
				    
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
			});
			
		    
					    
			frame.add(value);
			frame.add(text);
			frame.add(b);
			frame.add(l1);
			frame.add(l2);
			frame.add(l3);
					
					
					
			JButton ab  = new JButton("SIGN UP");
			JLabel al3 = new JLabel("CREATE NEW USER");
				al3.setBounds(650,360, 230,30);
				al3.setFont(new Font("Roman", Font.BOLD, 30));
				al3.setForeground(new Color(0, 54, 0));
			 JLabel al0 = new JLabel("Name");
			 	al0.setBounds(650, 390, 80, 40);
			 JLabel al1=new JLabel("Username:");     
			   	al1.setBounds(650,447, 80,30); 
			 JLabel al2=new JLabel("Password:");  
				al2.setBounds(650,497, 80,30); 
		 	 JLabel al2s=new JLabel("Comfirm Password:");  
			  	al2s.setBounds(650,547, 150,30); 
			  	
			  	
			  	
			  	
				 JTextField valu = new JTextField(); 
				 	valu.setBounds(650, 420, 200, 30);
				 	valu.setBackground(new Color(0, 54, 0));
					valu.setForeground(new Color(255, 255, 255));
					valu.setFont(new Font("Serif", Font.BOLD, 17));
				 JPasswordField values = new JPasswordField();   
				  	values.setBounds(650,520,200,30); 
					values.setBackground(new Color(0, 54, 0));
					values.setForeground(new Color(255, 255, 255));
					values.setFont(new Font("Serif", Font.BOLD, 17));
					JPasswordField valuess = new JPasswordField();   
					valuess.setBounds(650,568,200,30); 
					valuess.setBackground(new Color(0, 54, 0));
					valuess.setForeground(new Color(255, 255, 255));
					valuess.setFont(new Font("Serif", Font.BOLD, 17));
					final JTextField texts = new JTextField(); 
					texts.setFont(new Font("Serif", Font.BOLD, 17));
					texts.setBounds(650,470, 200,30);
					texts.setBackground(new Color(0, 54, 0));
					texts.setForeground(new Color(255, 255, 255));
						    
			  	
			  	
			  	ab.setBounds(650,610, 70,30);  
			  	ab.setOpaque(false);
				ab.setContentAreaFilled(false);
				ab.setBorderPainted(true);
				ab.setBorder(new LineBorder(new Color(0,54,0), 3));
				ab.setFont(new Font("Roman", Font.BOLD, 17));
				ab.setForeground(new Color(0, 54, 0));
				ab.setFocusable(false);
				
				 ab.addMouseListener(new java.awt.event.MouseAdapter() {
					   
					    public void mouseClicked(java.awt.event.MouseEvent evt) {
					    	
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
						     
						     if(valu.getText().equals("")||texts.getText().equals("")|| values.getText().equals("")||valuess.getText().equals("")) {
						    	 
						    	 UIManager.put("OptionPane.background", Color.RED);
								 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
								 JLabel label = new JLabel("One or More Field(s) Empty");
							     label.setForeground(Color.white);
							     label.setFont(new Font("Roman", Font.BOLD, 20 ));
							     JOptionPane.showMessageDialog(frame, label,"Login Error", JOptionPane.ERROR_MESSAGE);;
							    
						     }
						     
						     else {	
						    	 	if(values.getText().equals(valuess.getText())) {
						    	 
						    	 	 String sqll = "INSERT INTO login values(NULL,?,?,?)"; 
						     		 pst = dbConnect.prepareStatement(sqll);
								     pst.setString(1, valu.getText());
								     pst.setString(2, texts.getText());
								     pst.setString(3, values.getText());
								     pst.executeUpdate();
								     
								     UIManager.put("OptionPane.background", new Color(0,54,0));
									 UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(0,54,0));
									 JLabel label = new JLabel("User Created");
								     label.setForeground(Color.white);
								     label.setFont(new Font("Roman", Font.BOLD, 20 ));
								     JOptionPane.showMessageDialog(frame, label);;
						    	 	}
						    	 	else {
						    	 		UIManager.put("OptionPane.background", Color.RED);
										 UIManager.getLookAndFeelDefaults().put("Panel.background", Color.RED);
										 JLabel label = new JLabel("Password Mismatch");
									     label.setForeground(Color.white);
									     label.setFont(new Font("Roman", Font.BOLD, 20 ));
									     JOptionPane.showMessageDialog(frame, label,"Login Error", JOptionPane.ERROR_MESSAGE);;
						    	 	}
						     }
						    
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
					});
				
				
				
			  	
			  	
			
				frame.add(values);
				frame.add(valuess);
				frame.add(texts);
				frame.add(ab);
				frame.add(al1);
				frame.add(al2);
				frame.add(al3);
				frame.add(al2s);
				frame.add(al0);
				frame.add(valu);
					
				frame.pack();
				frame.setResizable(false);
				frame.setVisible(true);
				frame.setSize(900, 700);
				
			}
				
	public static void main(String[] args) {
		back make = new back();
		make.bath();
		
		}
	
			
		
	}
	
	

