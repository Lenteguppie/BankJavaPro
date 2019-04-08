package GUI;

public class Client {
	private String name;
	private String pin;
	private int balance;
	
	//constructor to set the clients name, pin and starting balance
	public Client(String name, String pin, int balance) {
		this.setName(name);
		this.pin = pin;
		this.setBalance(balance);
	}

	//method to set the name of a client
	private void setName(String name) {
		this.name = name;
		
	}

	//Method to get the name of a client
	public String getName() {
		return name;
	}
	
	// method to check the pincode
	public boolean checkPin(String PIN) {
		if (pin.equals(PIN)) {
			return true;
		}else {
			return false;
		}
	}

	//return the balance if the pincode is correct, else return a very low number for security purposes.
	public int getBalance(String x) {
		if (checkPin(x)) {
			return balance;
		}else {
			return Integer.MIN_VALUE;
		}
	}
	
	// set the balance
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	// method to deposit money
	public void deposit(int gestort) {
		this.balance += gestort;
	}
	
	
}
