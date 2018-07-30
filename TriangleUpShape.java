import java.awt.Color;
import java.awt.Graphics;

public class TriangleUpShape extends Shape {
	private int[] x = new int[3];
	private int[] y = new int[3];

	public TriangleUpShape(int l, int t, int r, int b, Color c, Boolean isChosen) {
		super(l, t, r, b, c, isChosen);
		x[0] = left;
		y[0] = bottom;
		x[1] = (left + right) / 2;
		y[1] = top;
		x[2] = right;
		y[2] = bottom;
	}

	public void drawMe(Graphics g) {
		g.setColor(shapeColor);
		g.fillPolygon(x, y, 3);
		super.drawMe(g);
	}

}
