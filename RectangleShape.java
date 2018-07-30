import java.awt.Color;
import java.awt.Graphics;

public class RectangleShape extends Shape {

	public RectangleShape(int l, int t, int r, int b, Color c, Boolean isChosen) {
		super(l, t, r, b, c, isChosen);
	}

	public void drawMe(Graphics g) {
		g.setColor(shapeColor);
		g.fillRect(left, top, right - left, bottom - top);
		super.drawMe(g);
	}


}
