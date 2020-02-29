package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Observable;

/**
 * A shape that can be drawn.
 * @author JustinRLeung
 *
 */
public abstract class Shape extends Observable{
	private boolean filled;
	private float thickness;
	private Color colour;
	
	/**
	 * Constructs a shape.
	 * @param filled		true if fill, false if outline
	 * @param thickness		thickness of the drawing line
	 * @param colour		colour of the shape
	 */
	public Shape(boolean filled, float thickness, Color colour) {
		this.filled = filled;
		this.thickness = thickness;
		this.colour = colour;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public float getThickness() {
		return this.thickness;
	}
	
	public void setThickness(float thickness) {
		this.thickness = thickness;
	}

	public Color getColour() {
		return colour;
	}

	public void setColour(Color colour) {
		this.colour = colour;
	}
	
	
	/**
	 * Draws the shape on the PaintPanel.
	 * @param g Graphics
	 */
	public abstract void draw(Graphics g);
	
	/**
	 * Changes the shape to the current state based on the mouse and notify observers.
	 * @param e	MouseEvent
	 */
	public abstract void transform(MouseEvent e);
}
