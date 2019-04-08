package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class ATMScreen extends java.awt.Container {

	public ATMScreen() {
		//super();
		super.setLayout(null);		
	}
	
	/* add a screen element*/
	public void add(ScreenElement ScreenEl) {
		ScreenEl.setContainer(this);		
	}
	
	/* Clear everything on the screen */
	public void Clear() {
		removeAll();
	}
	
	/* Paint the HR bank logo in the buttom right of the screen */
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.fillRoundRect(347,230,35,35,10,10);
		g.fillRect(377, 260, 5, 5);
		g.setColor(Color.WHITE);
		g.setFont(new Font("SansSerif", Font.BOLD, 20));
		g.drawString("HR", 350, 250);
		g.setFont(new Font("SansSerif", Font.PLAIN, 12));
		g.drawString("Bank", 351, 260);
	}

}
