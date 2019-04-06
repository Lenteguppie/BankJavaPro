package GUI;

public class ReceiptPrinter extends HardwareElement implements OutputDevice{

	public ReceiptPrinter(String naam) {
		super(naam);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void giveOutput(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}

}
