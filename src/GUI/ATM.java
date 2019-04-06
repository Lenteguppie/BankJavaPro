package GUI;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class ATM {
	private Bank bank;
	private Frame f;
	ATMScreen as;
	
	ArrayList<ScreenButton> buttons = new ArrayList<ScreenButton>();
	
	public ATM(Bank bank) {
		 this.bank = bank;
		 
		as = new ATMScreen();
		Frame f = new Frame("My ATM");
		
		addButtonsToList();
		
		f.setBounds(200, 200, 400, 350);
		f.setBackground(Color.BLUE);
		f.addWindowListener(new MyWindowAdapter(f));
		f.add(as);
		f.setVisible(true);
	}
	
	
	void addButtonsToList() {
		
		ScreenButton button1 = new ScreenButton("1", new Point(100,100));
		ScreenButton button2 = new ScreenButton("2", new Point(150,100));
		ScreenButton button3 = new ScreenButton("3", new Point(200,100));
		ScreenButton button4 = new ScreenButton("4", new Point(100,150));
		ScreenButton button5 = new ScreenButton("5", new Point(150,150));
		ScreenButton button6 = new ScreenButton("6", new Point(200,150));
		ScreenButton button7 = new ScreenButton("7", new Point(100,200));
		ScreenButton button8 = new ScreenButton("8", new Point(150,200));
		ScreenButton button9 = new ScreenButton("9", new Point(200,200));
		ScreenButton button0 = new ScreenButton("0", new Point(150,250));
		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);
		buttons.add(button4);
		buttons.add(button5);
		buttons.add(button6);
		buttons.add(button7);
		buttons.add(button8);
		buttons.add(button9);
		buttons.add(button0);
	}
	
	public void clearScreen() {
		as.Clear();
	}
	
	public void cardScreen() {
		DisplayText cardLabel = new DisplayText("cardLabel", new Point(100, 25));
		as.add(cardLabel);
		cardLabel.giveOutput("Enter your Card!");
	}
	
	public void pinScreen(String l) {
		
		DisplayText label = new DisplayText("Enter your pin!", new Point(100, 25));
		as.add(label);
		label.giveOutput(l);
		//as.add(button1);
		
		Iterator<ScreenButton> it = buttons.iterator();
		while(it.hasNext()){
			as.add(it.next());
		}
	}
	
	
	
	void doTransaction() {
		
	}
	
	
	
}
