import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class rom extends JFrame
{
    JTextField text;
    public void read(){
        JLabel l=new JLabel("Name: ");
        text=new JTextField(20);
        JButton b=new JButton("Send");
        setLayout(null);
        l.setBounds(10,10,100,20);
        text.setBounds(120,10,150,20);
        b.setBounds(120,40,80,20);
        add(l);
        add(text);
        add(b);
        setVisible(true);
        setSize(900,700);
          b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	
          
            ram page=new ram("fffffffffffffffffff");
            page.setVisible(true);
            setVisible(false);
            
            }
        });
    }
        public static void main(String[] args) 
    {
        rom make = new rom();
        make.read();
    }
}