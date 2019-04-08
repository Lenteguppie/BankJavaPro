package GUI;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;

public class ScreenButton extends ScreenElement implements InputDevice, java.awt.event.ActionListener {
	Button button;
	boolean inputAvailable = false;

	public ScreenButton(String naam, Point locatie) {
		super(naam, locatie);
		button = new Button(naam);
		button.setBounds(pos.x, pos.y, 15 + 15 * naam.length(), 30);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputAvailable = true;
			}
		});
	}

	@Override
	void setContainer(Container container) {
		// TODO Auto-generated method stub
		container.add(button);
	}

	@Override
	public String getInput() {
		if (inputAvailable) {
			inputAvailable = false;
			//System.out.println(button.getLabel());
			return button.getLabel();
		} else {
			return null;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		inputAvailable = true;
	}

}
