import java.awt.Color;
import java.awt.Graphics;

public class RoundShape extends Shape {

	public RoundShape(int l, int t, int r, int b, Color c, Boolean isChosen) {
		super(l, t, r, b, c, isChosen);
	}

	public void drawMe(Graphics g) {
		g.setColor(shapeColor);
		g.fillOval(left, top, right - left, bottom - top);
		super.drawMe(g);
	}

	
	
}
