import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
public class newswing extends Canvas{
	
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Password frame");
		
		
		
		JButton b  = new JButton("Enter");
		JLabel l3 = new JLabel("LOGIN");
			l3.setBounds(650,50, 80,30);
			
		 JLabel l1=new JLabel("Username:");     
		   	l1.setBounds(650,90, 80,30); 
		 JLabel l2=new JLabel("Password:");  
		  	l2.setBounds(650,150, 80,30); 
		    b.setBounds(650,220, 70,30);     
		    JPasswordField value = new JPasswordField();   
		    value.setBounds(650,175,200,30);    
		    final JTextField text = new JTextField();   
		    text.setBounds(650,120, 200,30);     
		    
		frame.add(value);
		frame.add(text);
		frame.add(b);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		
		
		
		
		
		
		

		JButton ab  = new JButton("SIGN UP");
		JLabel al3 = new JLabel("CREATE NEW USER");
			al3.setBounds(650,350, 280,30);
		 JLabel al1=new JLabel("Username:");     
		   	al1.setBounds(650,390, 80,30); 
		 JLabel al2=new JLabel("Password:");  
		  	al2.setBounds(650,450, 80,30); 
		  	 JLabel al2s=new JLabel("Comfirm Password:");  
			  	al2s.setBounds(650,505, 150,30); 
		    ab.setBounds(650,570, 70,30);     
		    JPasswordField values = new JPasswordField();   
		    values.setBounds(650,475,200,30);    
		    JPasswordField valuess = new JPasswordField();   
		    valuess.setBounds(650,530,200,30); 
		    final JTextField texts = new JTextField();   
		    texts.setBounds(650,420, 200,30);     
		    
		frame.add(values);
		frame.add(valuess);
		frame.add(texts);
		frame.add(ab);
		frame.add(al1);
		frame.add(al2);
		frame.add(al3);
		frame.add(al2s);
		
		
		
		frame.setLayout(null);
		frame.setVisible(true);
		
		frame.setSize(900, 700);
	}
}
