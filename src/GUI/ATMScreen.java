package GUI;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;

public class ATMScreen extends java.awt.Container {
	ATMScreen as;
	public ATMScreen() {
		//super();
		super.setLayout(null);		
	}
	
	
	
	
	
	public void add(ScreenElement ScreenEl) {
		ScreenEl.setContainer(this);		
		
	}
	
	public void Clear() {
		removeAll();
	}
	
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
