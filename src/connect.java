import javax.swing.*;

import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

import javax.swing.table.DefaultTableModel;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
  
public class connect extends Canvas{
	private static Map<String, java.util.List<String>> values;
	 
	public void run() {
		
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
		
		JTextField staf = new JTextField();
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
		
		
		JTable jt = new JTable();
		
		Object[] columns = {"ITEM","CATEGORY","UNIT","QUANTITY","PRICE",};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		jt.setModel(model);
		
		
		     jt.setBounds(0,0,850,200);  
		     jt.setBackground(new Color(0, 54, 0));
			 jt.setForeground(new Color(255, 255, 255));
			 jt.setFont(new Font("Roman", Font.BOLD, 16));
			 JScrollPane sp=new JScrollPane(jt);  
			 sp.setBounds(20,340,830,250);
			 sp.getViewport().setBackground(new Color(0, 54, 0));
		     frame.add(sp);
		     
		
		values = new HashMap<>();
		values.put("---Select a Category---", Arrays.asList());
        values.put("Toiletries", Arrays.asList("Oral-B Toothpaste", "Close-up Toothpaste", "Joy soap", "Toilet Paper","Harpic toilet wash","Ariel detergent 50g","Jik 100g","Tetmosol soap","Detol soap","Pepsodyne mouth wash 70g"));
        values.put("Cosmetics", Arrays.asList("Clear Essence cream 200g", "Nivea body spray", "Sure Roll-on","Vaselene Jelly 50g","Excel Relaxer 100g"));
        values.put("Diary", Arrays.asList("Crate of Egg", "Cheeze", "Honey","Can-Milk","Bottle-Milk"));
        values.put("Tobacco", Arrays.asList("St-Moritz","Benson/Hedges", "Refill-Snuff"));
        values.put("Grocery", Arrays.asList("Carrot", "Cauliflower", "Brussels Sprouts","Vegetables","Tomatoes","Vegetable-oil","Noodles","Maccarony","Sardine"));
        values.put("Bakery", Arrays.asList("Sliced Bread", "Unsliced Bread", "Dough-nut","cake"));
        values.put("Beverages", Arrays.asList("Cocacola","Fanta", "Pepsi","Sprite","Maltina","Eva water","Eva wine","Don-simoen","Schwepps","Mountain Deu"));
        values.put("Frozen foods", Arrays.asList("Jumbo Chicken 1kg", "Tilapia fish 1kg", "Turkey 1kg","Broiler Chicken 1kg","Old-Layer Chicken 1kg"));
        values.put("Electronics", Arrays.asList("Samsung ipad", "Apple ipad", "iphone 6 16GB","Nokia 3310"));
         
       

        JComboBox<String> first = new JComboBox<>(values.keySet().toArray(new String[values.keySet().size()]));
        first.setSelectedItem(null);
        JComboBox<String> second = new JComboBox<>(new DefaultComboBoxModel<>());

        first.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = (String) first.getSelectedItem();
                List<String> secondValues = values.get(value);

                DefaultComboBoxModel model = (DefaultComboBoxModel) second.getModel();
                model.removeAllElements();
                for (String s : secondValues) {
                    model.addElement(s);
                }
            }
        });
        
       
        first.setBounds(140, 115, 250, 30);
        
	    first.setBackground(new Color(0, 54, 0));
	    first.setForeground(new Color(255, 255, 255));
	    first.setFont(new Font("Serif", Font.BOLD, 20));
	   
        
        second.setBounds(140, 164, 250, 30);
	    second.setBackground(new Color(0, 54, 0));
	    second.setForeground(new Color(255, 255, 255));
	    second.setFont(new Font("Serif", Font.BOLD, 20));
	    
	    
        frame.add(first);
        frame.add(second);
		
		

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
		
		 SpinnerModel value =   new SpinnerNumberModel(0, 0,100, 1); 
		 JSpinner spinner = new JSpinner(value);   
         spinner.setBounds(320,215,70,30);   
         spinner.setFont(new Font("Serif", Font.BOLD, 18));
         spinner.setBackground(new Color(0, 54, 0));
 	    spinner.setForeground(new Color(255, 255, 255));
         frame.add(spinner);  
		
		
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
		
		
		Object[] row = new Object[5];
		
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
		    
		 	           row[0] = first.getSelectedItem();
		 	           row[1] = second.getSelectedItem();
		 	           row[2] = uni.getSelectedItem();
		 	           row[3] = spinner.getValue();
		 	           row[4] = pri.getText();
		 	           
		 	          model.addRow(row);
		 	        
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
		    	uni.setSelectedItem(null);
		    	
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
						    	
						    	if(i>0) {
						    	model.setValueAt(first.getSelectedItem(),i,0);
						    	model.setValueAt(second.getSelectedItem(),i,1);
						    	model.setValueAt(uni.getSelectedItem(),i,2);
						    	model.setValueAt(spinner.getValue(),i,3);
						    	model.setValueAt(pri.getText(),i,4);
						    	}
						    	
						    	else {System.out.print("Error");}
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
					    	 	if(i>0) {
					    	 		model.removeRow(i);
					    	 	}
					    	 	else {System.out.println("Delete Error");}
					    }
					    	 	
					    	 	
					
					    public void mouseExited(java.awt.event.MouseEvent evt) {
					    	del.setBorderPainted(true);
					    	del.setIcon(new ImageIcon((new ImageIcon("C:\\Users\\weeveedenn\\Desktop\\Zootopia (2016) [720p] BluRay\\src\\.metadata\\Swing2\\src\\del2.png").getImage()
					    	.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH))));
					    	del.setText(null);
					    	del.setBackground(new Color(255, 0, 0));
					   }
					});
					
					
			     
					jt.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int i = jt.getSelectedRow();
							first.setSelectedItem(model.getValueAt(i, 0).toString());
							second.setSelectedItem(model.getValueAt(i, 1).toString());
							uni.setSelectedItem(model.getValueAt(i, 2).toString());
							spinner.setValue(model.getValueAt(i, 3).toString());
							pri.setText(model.getValueAt(i, 4).toString());
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
				   	dash make = new dash();
					make.run();
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
			     
			     
		frame.add(text);
		frame.add(b);
		frame.setLayout(null);
		
		frame.getContentPane().setBackground(Color.WHITE);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(900, 700);
	
}
	
		
	
	public static void main(String[] args) {
		
		connect make = new connect();
		make.run();
		
	}
}
