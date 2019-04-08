package GUI;

/*Doing the needed imports*/
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;

public class ScreenButton extends ScreenElement implements InputDevice {
	Button button;
	boolean inputAvailable = false; //boolean to register da input

	public ScreenButton(String naam, Point locatie) {
		super(naam, locatie);
		button = new Button(naam); // create a new button with a new label
		button.setBounds(pos.x, pos.y, 15 + 15 * naam.length(), 30); // define the length, width and position of the buttons
		
		/* Create a new actionlistener and evenhandler for the buttons */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputAvailable = true; //button is pressed
			}
		});
	}

	@Override
	void setContainer(Container container) {
		// TODO Auto-generated method stub
		container.add(button);
	}

	/* Return the label of the button if the button is pressed else return null*/
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
}
