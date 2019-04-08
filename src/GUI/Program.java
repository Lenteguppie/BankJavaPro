package GUI;

public class Program {

	public static void main(String[] args) {
		Bank bank = new Bank(); //create a new bank
		ATM atm = new ATM(bank); // create new ATM
		CardReader kaartlezer = new CardReader("kaartlezer"); // create new cardreader

		while(true) { //Infinite loop to do transactions
			atm.doTransaction(kaartlezer);
		}

	}
}
