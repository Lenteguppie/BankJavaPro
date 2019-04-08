package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keypad extends HardwareElement implements InputDevice{

	private BufferedReader br = null;
	public Keypad(String naam) {
		super(naam);
		this.br = new BufferedReader(new InputStreamReader(System.in)); //create a new buffered reader to get the input from commandline
	}

	/* Get the input of the console */
	@Override
	public String getInput() throws IOException{
		char c;
		try {			
		c = (char) br.read();
		System.out.println(c);
		}
		catch (IOException ioe)
		{
			System.out.println(ioe);
			return null;
		}
		finally {
			br.close();			
		}		
		return null;
	}

}
