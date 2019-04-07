package GUI;

public class Program {

	public static void main(String[] args) {
		Bank bank = new Bank();
		ATM atm = new ATM(bank);
		CardReader kaartlezer = new CardReader("kaartlezer");

		for (int i = 0; i < 99999; i++) {
			atm.doTransaction(kaartlezer);
		}

	}
}
