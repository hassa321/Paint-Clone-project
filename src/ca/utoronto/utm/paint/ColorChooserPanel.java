package ca.utoronto.utm.paint;

import java.awt.Dimension;

import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * A panel that allows the user to select current drawing color for the
 * current shape selected.
 * @author aaron
 *
 */
public class ColorChooserPanel extends JColorChooser implements ChangeListener{
	private View view; // so we can talk to our parent and other components of the view
	
	/**
	 * Constructs a ColorChooserPanel
	 * 
	 * @param view  A View+Controller
	 */
	public ColorChooserPanel(View view) {
		this.view = view;
		
		this.setPreviewPanel(new JPanel());
		this.setPreferredSize(new Dimension(500,200));
		this.getSelectionModel().addChangeListener(this);
		
	}
	
	/**
	 * Invoked when a new color is selected
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		this.view.getPaintPanel().setColour(this.getColor());
	}

	
}
