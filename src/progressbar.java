import javax.swing.*;    
public class progressbar extends JFrame{    
	JProgressBar jb;     
	int i=0,num=0;     
	progressbar(){   
		jb=new JProgressBar(0,500); 
		jb.setBounds(40,40,160,30);      
		jb.setValue(0);    
		jb.setStringPainted(true);  
		add(jb);    
		setSize(250,150);  
		setLayout(null);    
		}    
	
	public void iterate(){  
		while(i<=500){    
			jb.setValue(i);  
			i=i+1;     
			try{Thread.sleep(150);}catch(Exception e){}   
			} 
		}     
	
	public static void main(String[] args) {   
		progressbar m=new progressbar();   
		m.setVisible(true);   
		m.iterate();   
		}   
	}    