package ca.utoronto.utm.paint;

import java.awt.Color;

/**
 * A ShapeFactory to get a shape object.
 * 
 * 
 * @author Yesung Cho
 */

public class ShapeFactory {
	
	/**
	 * Constructs and returns a shape based on its type.
	 * @param type			shape type
	 * @param filled		true if fill, false if outline
	 * @param thickness		thickness of the drawing line
	 * @param colour		colour of the shape
	 * @param point			point associated with the shape
	 * @return				the constructed shape
	 */
	public static Shape makeShape(String type, boolean filled, float thickness, Color colour, Point point) {
		Shape shape = null;
		
		if (type == "Circle") {
			shape = new Circle(point, 0, filled, thickness, colour);
		}
//		else if (type == "Square") {
//			shape = new Square();
//		}
		
		else if (type == "Rectangle") {
			shape = new Rectangle(point, 0, 0, filled, thickness, colour);
		}
		
		else if (type == "Squiggle") {
			shape = new Squiggle(thickness, colour);
		}
		
//		else if (type == "Polyline") {
//			shape = new Polyline();
//		}
		return shape;
		
	}
}

