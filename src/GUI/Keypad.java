package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keypad extends HardwareElement implements InputDevice{

	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public Keypad(String naam) {
		super(naam);
		// TODO Auto-generated constructor stub
	}

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
