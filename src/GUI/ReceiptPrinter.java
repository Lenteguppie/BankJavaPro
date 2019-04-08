package GUI;

public class ReceiptPrinter extends HardwareElement implements OutputDevice{

	public ReceiptPrinter(String naam) {
		super(naam);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void giveOutput(String string) {
		// Print the given String
		System.out.println(string);
	}

}
