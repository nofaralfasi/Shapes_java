import java.awt.Color;
import java.awt.Graphics;

public class Eye {
	private int left, top, radius;
	private int pleft, ptop, p_rad; // pupil parameters
	private int mouse_x, mouse_y;

	public Eye() {
		this(-10, -10, 0, 0, 0);
	}

	public Eye(int l, int t, int r, int mx, int my) {
		left = l;
		top = t;
		radius = r;
		mouse_x = mx;
		mouse_y = my;
		p_rad = 7;
		setPupil(); // computes the pupil parameters
	}

	public void updateMouse(int mx, int my) {
		mouse_x = mx;
		mouse_y = my;
		setPupil();
	}

	public void setPupil() {
		int cx, cy; // center of eye
		int cpx, cpy; // center of pupil
		double dirx, diry, len, dist; // direction to mouse

		cx = left + radius;
		cy = top + radius;

		dirx = mouse_x - cx;
		diry = mouse_y - cy;
		len = Math.sqrt((double) dirx * dirx + diry * diry);
		dirx /= len; // getting normalized vector
		diry /= len;
		dist = radius - p_rad;
		cpx = (int) (cx + dirx * dist);
		cpy = (int) (cy + diry * dist);
		pleft = cpx - p_rad;
		ptop = cpy - p_rad;
	}

	public void drawMe(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(left, top, radius * 2, radius * 2);
		g.setColor(Color.BLACK);
		g.drawOval(left, top, radius * 2, radius * 2);
		g.fillOval(pleft, ptop, p_rad * 2, p_rad * 2);
	}
}
