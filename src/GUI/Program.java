package GUI;

public class Program {

	static Client getClient(ATM atm, Bank bank, CardReader kaartlezer) {
		// String cardNumber = "";
		Client accountHolder = null;
		String name = "";
		atm.cardScreen();
		while (accountHolder == null) {
			String cardNumber = "";
			
			if (cardNumber == "" || cardNumber == null)
				cardNumber = kaartlezer.getInput();
			else
				cardNumber = "";

			if (cardNumber != null || cardNumber != "") {
				accountHolder = bank.get(cardNumber);
				if (accountHolder == null) {
					System.out.println(cardNumber);
					cardNumber = "";
					System.out.println("This account does not exist, please try again");
				} else {
					name = accountHolder.getName();
					System.out.println("Welcome " + name);
				}

			}
		}
		return accountHolder;

	}
	
	String getPin(ATM atm) {
		
		return null;
		
	}

	public static void main(String[] args) {
		Bank bank = new Bank();
		ATM atm = new ATM(bank);
		CardReader kaartlezer = new CardReader("kaartlezer");

		String cardNumber = "";
		String PinCode = "";

		Client c = getClient(atm, bank, kaartlezer);

		atm.clearScreen();
		atm.pinScreen("Enter your Pin!");
		while (PinCode.length() < 4) {
			switch (PinCode.length()) {
			case 1:
				atm.pinScreen("X");
				break;
			case 2:
				atm.pinScreen("XX");
				break;
			case 3:
				atm.pinScreen("XXX");
				break;
			case 4:
				atm.pinScreen("XXXX");
				break;
			default:
				atm.pinScreen("Enter your Pin!");

			}

		}
	}
}
