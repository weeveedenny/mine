import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ram extends JFrame
{
  ram(String stuuu)
   {
     setLayout(null);
     setDefaultCloseOperation(javax.swing. WindowConstants.DISPOSE_ON_CLOSE);
     setTitle("Welcome");
     JLabel lab=new JLabel("Welcome  "+stuuu);
     lab.setBounds(10,10,500,20);
     add(lab);
     setSize(900, 700);
      }
 }