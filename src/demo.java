import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class demo {

	public static void main(String[] args) {
		
		
		
		SwingUtilities.invokeLater(new Runnable () {

		
			public void run() {
				JFrame frame = new JFrame("Hello world");
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(700,700);

				
			}
			
		});
		
	}

}
