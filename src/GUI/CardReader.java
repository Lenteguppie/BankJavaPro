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
		 br = new BufferedReader(new InputStreamReader(System.in)); //setup to get input from console
		// TODO Auto-generated constructor stub
	}
	
	public String getInput() {
		System.out.println("To simulate inserting card, enter card number");
		try{
	        String cardNr = br.readLine(); //read line and return it
	        return cardNr;
	        }
	        catch(IOException e){
	            return null;
	        }
	}
}
