package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
/**
 * A Squiggle, which is a group of Points
 * @author Yesung Cho, Aaron Merino, Justin Leung
 *
 */
public class Squiggle extends Shape{

	private ArrayList<Point> points=new ArrayList<Point>();
	
	public Squiggle(float thickness, Color colour) {
		super(false, thickness, colour);
	}
	
	/**
	 * Add a point to Squiggle
	 * @param p a point object
	 */
	public void addPoint(Point p){
		this.points.add(p);
	}
	
	/**
	 * Get a point from Squiggle
	 * @param i index of point in points
	 */
	public void getPoint(int i){
		this.points.get(i);
	}

	public ArrayList<Point> getPoints(){
		return this.points;
	}

	@Override
	public void draw(Graphics g) {
		for (int i = 0; i < this.points.size() - 1; i++){
			Point p1 = points.get(i);
			Point p2 = points.get(i + 1);
			g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
	}

	@Override
	public void transform(MouseEvent e) {
		// TODO Auto-generated method stub
		this.addPoint(new Point(e.getX(), e.getY()));
		this.setChanged();
		this.notifyObservers();
	}

}
