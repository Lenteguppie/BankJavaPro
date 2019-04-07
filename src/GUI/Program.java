package GUI;

public class Program {

	public static void main(String[] args) {
		Bank bank = new Bank();
		ATM atm = new ATM(bank);
		CardReader kaartlezer = new CardReader("kaartlezer");

		while(true) {
			atm.doTransaction(kaartlezer);
		}

	}
}
