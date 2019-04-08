package GUI;

import java.util.*;

public class Bank {
	private Map<String, Client> accounts;

	public Bank() {
		this.accounts = new HashMap<String, Client>();
		Client client1 = new Client("Piet", "0000", 100);
		this.accounts.put("NL01BANK0123456789", client1);

		Client client2 = new Client("Henk", "1234", 1000);
		this.accounts.put("NL01BANK9876543210", client2);

		Client client3 = new Client("Klaas", "4321", 1000000);
		this.accounts.put("NL01BANK0000000000", client3);

	}

	
	public Client get(String rekeningnummer) {
		if (accounts.containsKey(rekeningnummer)) {
			return accounts.get(rekeningnummer);
		} else {
			return null;
		}
	}
}
