package ca.utoronto.utm.paint;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d

class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	private JButton currentShapeBtn; //current
	
	public ShapeChooserPanel(View view) {	
		this.view=view;
		
		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline", "Outline"};		
		this.setLayout(new GridLayout(buttonLabels.length, 1));
		for (int i = 0; i<buttonLabels.length; i++) {
			ImageIcon icons = new ImageIcon("src/Shapes_Images/"+buttonLabels[i]+".png");
			JButton button = new JButton(buttonLabels[i], icons);
			this.add(button);
			button.addActionListener(this);
		}
	}
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if((e.getActionCommand()=="Fill" || e.getActionCommand()=="Outline")) {
			JButton fillButton= ((JButton) e.getSource());
			boolean filled = this.view.getPaintPanel().isFilled();
			String nameFill = filled ? "Outline" : "Fill";
			ImageIcon fillUp = new ImageIcon("src/Shapes_Images/"+nameFill+".png");
			fillButton.setText(nameFill);
			fillButton.setIcon(fillUp);
			this.view.getPaintPanel().setFilled(!filled);
		}else{
			if (e.getSource() instanceof JButton){
				if (currentShapeBtn != null) {
					currentShapeBtn.setEnabled(true);
				}
				JButton newBtn = (JButton) e.getSource();
				currentShapeBtn = newBtn;
				currentShapeBtn.setEnabled(false);
			}
			this.view.getPaintPanel().setMode(e.getActionCommand());
			System.out.println(e.getActionCommand());
		}
	}

	
}
