package GUI;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.Button;


public class ScreenButton extends ScreenElement implements InputDevice, java.awt.event.ActionListener{
	Button button;
	boolean inputAvailable = false;
	public ScreenButton(String naam, Point locatie) {
		super(naam, locatie);
		button = new Button(naam);
		button.setBounds(pos.x, pos.y, 15+15*naam.length(), 30);
		button.addActionListener(this);
	}

	@Override
	void setContainer(Container container) {
		// TODO Auto-generated method stub
		container.add(button);
	}

	@Override
	public String getInput() {
		// TODO Auto-generated method stub
		if (inputAvailable) {
			inputAvailable = false;
			return button.getLabel();			
		}else {	
		return null;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		inputAvailable = true;
	}

}
