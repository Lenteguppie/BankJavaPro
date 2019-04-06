package GUI;
import java.awt.Container;
import java.awt.Point;

public abstract class ScreenElement extends ATMElement{
	Point pos;
	String name;
	
	
	public ScreenElement(String naam, Point locatie){
		super(naam);
		this.pos = locatie;
		this.name = naam;		
	}
	
	Container container = new Container();
	abstract void setContainer(Container container);
		
}