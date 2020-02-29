package ca.utoronto.utm.paint;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * A panel for customizing the thickness of the line using a slider.
 * @author JustinRLeung
 *
 */
public class ThicknessPanel extends JPanel implements ChangeListener {
	
	private View view;
	private JSlider slider;
	private JSpinner spinner;
	
	/**
	 * Creates the thickness panel with a slider.
	 * @param view	top level View+Controller
	 */
	public ThicknessPanel(View view) {
		this.view = view;
		
		JLabel label = new JLabel("Line Thickness");
		
		this.slider = new JSlider(0, 25, 1);
		this.slider.addChangeListener(this);
		
		this.spinner = new JSpinner(new SpinnerNumberModel(1, 0, 25, 1));
		this.spinner.addChangeListener(this);
		
		this.add(label);
		this.add(this.slider);
		this.add(this.spinner);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		boolean isSlider = e.getSource() == this.slider;
		int value = isSlider ? this.slider.getValue() : (int) this.spinner.getValue();
		this.slider.setValue(value);
		this.spinner.setValue(value);
		this.view.getPaintPanel().setThickness(value);
	}

}
