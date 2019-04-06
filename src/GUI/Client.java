package GUI;

public class Client {
	private String name;
	private String pin;
	private int balance;
	
	public Client(String name, String pin, int balance) {
		this.setName(name);
		this.pin = pin;
		this.setBalance(balance);
	}

	private void setName(String name) {
		this.name = name;
		
	}

	public String getName() {
		return name;
	}
	
	public boolean checkPin(String PIN) {
		if (pin.equals(PIN)) {
			return true;
		}else {
			return false;
		}
	}

	public int getBalance(String x) {
		if (checkPin(x)) {
			return balance;
		}else {
			return Integer.MIN_VALUE;
		}
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void deposit(int gestort) {
		this.balance += gestort;
	}
	
	
}
