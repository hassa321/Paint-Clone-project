package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * A circle with a centre and a radius.
 * @author JustinRLeung
 *
 */
public class Circle extends Shape {
	private Point centre;
	private int radius; // >= 0
	
	/**
	 * Constructs a circle with a centre and a radius.
	 * @param centre		centre point
	 * @param radius		radius
	 * @param filled		true if fill, false if outline
	 * @param thickness		thickness of drawing line
	 * @param colour		colour of the circle
	 */
	public Circle(Point centre, int radius,
			boolean filled, float thickness, Color colour) {
		super(filled, thickness, colour);
		this.centre = centre;
		this.radius = radius;
	}

	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw(Graphics g) {		
		int x = this.centre.getX() - this.radius;
		int y = this.centre.getY() - this.radius;
		int d = this.radius * 2;
		
		if (super.isFilled())
			g.fillOval(x, y, d, d);
		else
			g.drawOval(x, y, d, d);
	}

	@Override
	public void transform(MouseEvent e) {
		int x = e.getX() - this.centre.getX();
		int y = e.getY() - this.centre.getY();
		int radius = (int) Math.sqrt(x * x + y * y);
		this.setRadius(radius);
		this.setChanged();
		this.notifyObservers();
	}

}
