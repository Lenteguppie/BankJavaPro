package GUI;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowAdapter extends WindowAdapter{
	private Frame f;
	public MyWindowAdapter(Frame f) {
		// TODO Auto-generated constructor stub
		this.f = f;
	}
	
	public void windowClosing(WindowEvent e) {
		f.dispose();
		System.exit(0);
	}
	

}
