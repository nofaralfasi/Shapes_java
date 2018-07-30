import java.awt.Rectangle;

import javax.swing.JFrame;

public class Program {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		DrawPanel dp = new DrawPanel();

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(dp);
		f.setSize(880, 640);
		f.setLocationRelativeTo(null);
		f.setMaximizedBounds(new Rectangle(510, 240, 880, 640));			
		f.setVisible(true);

	}

}
