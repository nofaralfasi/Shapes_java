import java.awt.Color;
import java.awt.Graphics;

public class DiamondShape extends Shape {
	private int[] x = new int[4];
	private int[] y = new int[4];

	public DiamondShape(int l, int t, int r, int b, Color c, Boolean isChosen) {
		super(l - 8, t - 8, r + 8, b + 8, c, isChosen);
		x[0] = left;
		y[0] = (top + bottom) / 2;
		x[1] = (left + right) / 2;
		y[1] = top;
		x[2] = right;
		y[2] = (top +bottom) / 2;
		x[3] = (left + right) / 2;
		y[3] = bottom;
	}

	public void drawMe(Graphics g) {
		g.setColor(shapeColor);
		g.fillPolygon(x, y, 4);
		super.drawMe(g);
	}



}
