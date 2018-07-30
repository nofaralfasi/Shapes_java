import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	protected int shape_width = 150, shape_height = 150;
	protected int left, top, right, bottom;
	protected boolean isChosen;
	protected Color shapeColor;
	protected Eye left_eye= new Eye(), right_eye= new Eye();

	public Shape(int l, int t, int r, int b, Color c, Boolean a) {
		left = l;
		top = t;
		right = r;
		bottom = b;
		shapeColor = c;
		isChosen = a;
		if (isChosen) {
			int radx = (right - left) / 2;
			int rady = (bottom - top) / 2;
			left_eye = new Eye(left + radx - 5 - 2 * radx / 3, top + rady - rady / 3, radx / 3, 500, 500);
			right_eye = new Eye(left + radx + 5, top + rady - rady / 3, radx / 3, 500, 500);

		}
	}

	public void drawMe(Graphics g) {
		left_eye.drawMe(g);
		right_eye.drawMe(g);
	}

	public int getShape_width() {
		return shape_width;
	}

	public int getShape_height() {
		return shape_height;
	}

	public void updateEyes(int mx, int my) {
		left_eye.updateMouse(mx, my);
		right_eye.updateMouse(mx, my);
	}

	public void setShapeColor(Color shapeColor) {
		this.shapeColor = shapeColor;
	}

	public Color getShapeColor() {
		return this.shapeColor;
	}

	public void setIsChosen(boolean isChosen) {
		if (isChosen)
			setShapeColor(Color.YELLOW);
		else
			setShapeColor(new Color(210, 255, 255));
		this.isChosen = isChosen;
	}

	public void contains(int x, int y) {
		if (left <= x && right >= x && top <= y && bottom >= y)
			setIsChosen(true);
		else
			setIsChosen(false);
	}

	public boolean checkIfActive(int x, int y) {
		if (left <= x && right >= x && top <= y && bottom >= y)
			return true;
		else
			return false;
	}

	public boolean checkJB(int x, int y) {
		if (x == right && y == top)
			return true;
		else
			return false;
	}

}
