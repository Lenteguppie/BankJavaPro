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

	private static String getPin(ATM atm) {

		atm.pinScreenNotification("Doorwerken");
		return "";
		

	}
// 
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		ATM atm = new ATM(bank);
		CardReader kaartlezer = new CardReader("kaartlezer");

		String cardNumber = "";
		String PinCode = "";

		Client c = getClient(atm, bank, kaartlezer);
		
		atm.setupPinscreen();
		String sukkel = getPin(atm);

	}
}
