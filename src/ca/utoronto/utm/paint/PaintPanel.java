package ca.utoronto.utm.paint;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener  {
	private int i=0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view

	private String mode; // modifies how we interpret input (could be better?)
	private Shape shape; // the shape we are building
	private boolean filled; // if the shape will be filled or outlined.Default is outline.
	private float thickness;
	private Color colour;
	
	public PaintPanel(PaintModel model, View view){
		this.setBackground(Color.blue);
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.mode=""; // bad code here?
		
		this.model = model;
		this.model.addObserver(this);
		
		this.view=view;
	}

	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!
		
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
		// setBackground (Color.blue); 
		// Origin is at the top left of the window 50 over, 75 down
		g2d.setColor(Color.white);
        g2d.drawString ("i="+i, 50, 75);
		i=i+1;
		
		// Draw shapes
		ArrayList<Shape> shapes = this.model.getShapes();
		for(Shape s: shapes){
			g2d.setColor(s.getColour());
			g2d.setStroke(new BasicStroke(s.getThickness()));
			s.draw(g2d);
		}
		
		g2d.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}
	
	/**
	 *  Controller aspect of this
	 */
	public void setMode(String mode){
		this.mode=mode;
	}
	
	public void setColour(Color c) {
		this.colour = c;
	}

	public void setFilled(boolean filled){
		this.filled = filled;
	}
	
	public boolean isFilled(){
		return this.filled;
	}
	
	public void setThickness(float thickness) {
		this.thickness = thickness;
	}
	
//===========================================================================================
//===========================================================================================
	
	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e) && this.shape != null)
			this.shape.transform(e);
	}

	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			Point point = new Point(e.getX(), e.getY());
			this.shape = ShapeFactory.makeShape(this.mode, this.filled, this.thickness, this.colour, point);
			if (this.shape != null) {
				this.shape.addObserver(this);
				this.model.addShape(this.shape);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.shape = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
