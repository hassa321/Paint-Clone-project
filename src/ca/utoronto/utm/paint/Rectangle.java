package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * A rectangle with a corner.
 * @author JustinRLeung
 */
public class Rectangle extends Shape {
	
	private Point corner;
	private int base, height; // >= 0
	private int current_x, current_y; // stores current (x, y) of mouse
	
	/**
	 * Creates a rectangle.
	 * @param corner	top-left corner
	 * @param base		base length
	 * @param height	height length
	 */
	public Rectangle(Point corner, int base, int height,
			boolean filled, float thickness, Color colour) {
		super(filled, thickness, colour);
		
		this.setCorner(corner);
		this.setBase(base);
		this.setHeight(height);
	}
	
	public Point getCorner() {
		return corner;
	}

	public void setCorner(Point corner) {
		this.corner = corner;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void draw(Graphics g) {
		int x = Math.min(this.corner.getX(), this.current_x);
		int y = Math.min(this.corner.getY(), this.current_y);
		if (this.isFilled())
			g.fillRect(x, y, this.base, this.height);
		else
			g.drawRect(x, y, this.base, this.height);
	}

	@Override
	public void transform(MouseEvent e) {
		this.current_x = e.getX();
		this.current_y = e.getY();
		int base = Math.abs(this.corner.getX() - this.current_x);
		int height = Math.abs(this.corner.getY() - this.current_y);
		this.setBase(base);
		this.setHeight(height);
		this.setChanged();
		this.notifyObservers();
	}

}

