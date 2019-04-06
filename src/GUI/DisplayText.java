package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;
import java.awt.Label;



public class DisplayText extends ScreenElement implements OutputDevice{
	Label label;
	public DisplayText(String naam, Point locatie) {
		super(naam, locatie);
		label = new Label();
		label.setForeground(Color.WHITE);
		label.setFont(new Font("SansSerif", Font.BOLD, 30));
		label.setBounds(pos.x, pos.y, 400, 35);
	}

	@Override
	void setContainer(Container container) {
		container.add(label);
		
	}

	@Override
	public void giveOutput(String string) {
		// TODO Auto-generated method stub
		label.setText(string);
		
	}
}
