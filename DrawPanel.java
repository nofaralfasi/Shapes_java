import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final Color C = new Color(210, 255, 255);
	public Color clr;
	private Shape[] shapes;
	private Shape lastNewShape;
	public final int SHAPES = 5;
	public final int L = 740;
	public final int R = 850;
	private MyMouse ms = new MyMouse();
	private JButton jb = new JButton("X");;

	public DrawPanel() {
		shapes = new Shape[SHAPES];

		shapes[0] = new TriangleUpShape(L, 10, R, 100, C, false);
		shapes[1] = new TriangleDownShape(L, 140, R, 230, C, false);
		shapes[2] = new RoundShape(L, 260, R, 340, C, false);
		shapes[3] = new RectangleShape(L, 385, 845, 455, C, false);
		shapes[4] = new DiamondShape(L, 500, R, 580, C, false);

		addMouseListener(ms);
		addMouseMotionListener(ms);
		jb.addActionListener(ms);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(250, 240, 255));
		g.setColor(C);
		drawMenuShapes(g);

		for (int i = 0; i < shapes.length; i++)
			shapes[i].drawMe(g);
	}

	public void drawMenuShapes(Graphics g) {
		int k = 720;
		g.setColor(new Color(100, 44, 102));
		g.fillRect(k, 0, k, k);
		g.setColor(new Color(250, 240, 255));
		g.drawLine(k, 0, k, k);
		for (int i = 0; i <= SHAPES; i++)
			g.drawLine(k, i * 120, 880, i * 120);

	}

	public void createNewShapeObject(int x, int y, int index, Shape s) {
		s.setIsChosen(false);
		int w = s.getShape_width() + x;
		int h = s.getShape_height() + y;
		switch (index) {
		case 0:
			lastNewShape = new TriangleUpShape(x, y, w, h, C, true);
			break;
		case 1:
			lastNewShape = new TriangleDownShape(x, y, w, h, C, true);
			break;
		case 2:
			lastNewShape = new RoundShape(x, y, w, h, C, true);
			break;
		case 3:
			lastNewShape = new RectangleShape(x, y, w, h, C, true);
			break;
		case 4:
			lastNewShape = new DiamondShape(x, y, w, h, C, true);
			break;
		}
		enlargeArray();
		shapes[shapes.length - 1] = lastNewShape;
		repaint();
	}

	public void delete(Shape shape, int i) {
		while (i != shapes.length - 1) {
			shapes[i] = shapes[i + 1];
			i++;
		}
		decreaseArray();
	}

	public void decreaseArray() {
		Shape[] temp = new Shape[shapes.length - 1];
		for (int i = 0; i < temp.length; i++)
			temp[i] = shapes[i];
		shapes = temp;

	}

	public void enlargeArray() {
		Shape[] temp = new Shape[shapes.length + 1];
		for (int i = 0; i < shapes.length; i++)
			temp[i] = shapes[i];
		shapes = temp;
	}

	private class MyMouse extends MouseAdapter implements ActionListener {
		public void mouseClicked(MouseEvent ev) {
			int x = ev.getX();
			int y = ev.getY();

			if (x > L)
				for (int i = 0; i < SHAPES; i++)
					shapes[i].contains(x, y);

			if (x < L && x > 600)
				x = 520;

			if (x < 600) {
				for (int i = 0; i < SHAPES; i++)
					if (shapes[i].isChosen)
						createNewShapeObject(x, y, i, shapes[i]);

				if (ev.getButton() == MouseEvent.BUTTON3) {
					clr = JColorChooser.showDialog(null, "Choose color", Color.WHITE);
					if (clr != null)
						for (int i = SHAPES; i < shapes.length; i++) 
							if (shapes[i].checkIfActive(x, y)) 
								shapes[i].setShapeColor(clr);
				}
			}
			repaint();
		}

		public void mouseMoved(MouseEvent e) {
			int mx = e.getX();
			int my = e.getY();

			for (int i = SHAPES; i < shapes.length; i++) {
				shapes[i].updateEyes(mx, my);
				if (shapes[i].checkIfActive(mx, my)) {
					add(jb);
					jb.setSize(43, 40);
					jb.setLocation(shapes[i].right, shapes[i].top);
					jb.setVisible(true);
				}
			}
			repaint();
		}

		public void actionPerformed(ActionEvent e) {
			int x = jb.getX();
			int y = jb.getY();
			for (int i = SHAPES; i < shapes.length; i++)
				if (shapes[i].checkJB(x, y)) {
					delete(shapes[i], i);
					jb.setVisible(false);// deletes JButtom x
					repaint(); // needed
				}
		}

	}

}