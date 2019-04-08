package GUI;
import java.awt.Container;
import java.awt.Point;

public abstract class ScreenElement extends ATMElement{
	Point pos;
	String name;
	
	
	public ScreenElement(String naam, Point locatie){
		super(naam);
		this.pos = locatie; // set position of the screenelement
		this.name = naam;   // set the name of the screen element
	}
	
	Container container = new Container(); //create a new container
	abstract void setContainer(Container container);
		
}