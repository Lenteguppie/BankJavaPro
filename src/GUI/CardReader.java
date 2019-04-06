package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CardReader extends HardwareElement implements InputDevice {
	String CardID = null;
	InputStream is = null;
	BufferedReader br = null;

	public CardReader(String naam) {
		super(naam);
		 br = new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated constructor stub
	}
	
	public String getInput() {
		String ID = "";
		System.out.println("To simulate inserting card, enter card number");
		try{
	        String cardNr = br.readLine();
	        return cardNr;
	        }
	        catch(IOException e){
	            return null;
	        }
	}
}
