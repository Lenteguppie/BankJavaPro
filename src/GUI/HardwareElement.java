package GUI;

public abstract class HardwareElement extends ATMElement{

	protected boolean power = false;
	public HardwareElement(String naam) {
		super(naam);
		// TODO Auto-generated constructor stub
	}
	
	protected void powerOn() {
		power = true;
		
	}
	
	protected void powerOff() {
		power = false;
	}

}
