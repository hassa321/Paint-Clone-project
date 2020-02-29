package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

public class PaintModel extends Observable {
	private ArrayList<Shape> shapes = new ArrayList<>();
	
	/**
	 * Adds a shape to the ArrayList and notifies observers.
	 * @param s	shape to be added to the model
	 */
	public void addShape(Shape s){
		this.shapes.add(s);
		this.setChanged();
		this.notifyObservers();
	}

	public ArrayList<Shape> getShapes(){
		return shapes;
	}
}
