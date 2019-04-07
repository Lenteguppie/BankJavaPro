package GUI;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class ATM {
	private Bank bank;
	private Frame f;
	private String PinCode = "";
	private String PinCodeSecure = "";
	// private int Amount;

	private ATMScreen as;
	private DisplayText NotificationText;

	private ArrayList<ScreenButton> KeyPadButtons = new ArrayList<ScreenButton>();
	private ArrayList<ScreenButton> AmountButtons = new ArrayList<ScreenButton>();
	private ArrayList<ScreenButton> YesNoButtons = new ArrayList<ScreenButton>();
	private ArrayList<ScreenButton> MenuButtons = new ArrayList<ScreenButton>();

	public ATM(Bank bank) {
		this.bank = bank;

		as = new ATMScreen();
		Frame f = new Frame("My ATM");

		addButtonsToListKeyPad();
		addButtonsToListAmount();
		addButtonsToListYesNo();
		addButtonsToListMenu();

		f.setBounds(200, 200, 400, 350);
		f.setBackground(Color.BLUE);
		f.addWindowListener(new MyWindowAdapter(f));
		f.add(as);
		f.setVisible(true);
		NotificationText = new DisplayText("NotificationText", new Point(100, 25));
	}

	private void addButtonsToListKeyPad() {

		ScreenButton button1 = new ScreenButton("1", new Point(100, 100));
		ScreenButton button2 = new ScreenButton("2", new Point(150, 100));
		ScreenButton button3 = new ScreenButton("3", new Point(200, 100));
		ScreenButton button4 = new ScreenButton("4", new Point(100, 150));
		ScreenButton button5 = new ScreenButton("5", new Point(150, 150));
		ScreenButton button6 = new ScreenButton("6", new Point(200, 150));
		ScreenButton button7 = new ScreenButton("7", new Point(100, 200));
		ScreenButton button8 = new ScreenButton("8", new Point(150, 200));
		ScreenButton button9 = new ScreenButton("9", new Point(200, 200));
		ScreenButton button0 = new ScreenButton("0", new Point(150, 250));
		KeyPadButtons.add(button1);
		KeyPadButtons.add(button2);
		KeyPadButtons.add(button3);
		KeyPadButtons.add(button4);
		KeyPadButtons.add(button5);
		KeyPadButtons.add(button6);
		KeyPadButtons.add(button7);
		KeyPadButtons.add(button8);
		KeyPadButtons.add(button9);
		KeyPadButtons.add(button0);
	}

	private void addButtonsToListYesNo() {

		ScreenButton buttonYes = new ScreenButton("Yes", new Point(100, 50));
		ScreenButton buttonNo = new ScreenButton("No", new Point(50, 150));

		YesNoButtons.add(buttonYes);
		YesNoButtons.add(buttonNo);

	}

	private void addButtonsToListAmount() {

		ScreenButton button1 = new ScreenButton("\u20ac 20", new Point(100, 100));
		ScreenButton button2 = new ScreenButton("\u20ac 50", new Point(150, 100));
		ScreenButton button3 = new ScreenButton("\u20ac 100", new Point(200, 100));
		ScreenButton button4 = new ScreenButton("\u20ac 200", new Point(100, 150));
		AmountButtons.add(button1);
		AmountButtons.add(button2);
		AmountButtons.add(button3);
		AmountButtons.add(button4);

	}

	private void addButtonsToListMenu() {

		ScreenButton button1 = new ScreenButton("Balance", new Point(150, 100));
		ScreenButton button2 = new ScreenButton("Withdraw", new Point(150, 200));

		MenuButtons.add(button1);
		MenuButtons.add(button2);

	}

	private int getAmount() {
		int amount = 0;
		while (amount <= 0) {
			Thread.yield();
			for (int i = 0; i < AmountButtons.size(); i++) {
				String input = AmountButtons.get(i).getInput();

				if (input != null) {
					switch (input) {
					case "\u20ac 20":
						amount = 20;
						break;
					case "\u20ac 50":
						amount = 50;
						break;
					case "\u20ac 100":
						amount = 100;
						break;
					case "\u20ac 200":
						amount = 200;
						break;
					default:

						break;
					}

				}
			}
		}
		System.out.println("Amount: " + amount);
		return amount;
	}

	private void clearScreen() {
		as.Clear();
	}

	private void cardScreen() {
		as.add(NotificationText);
		pinScreenNotification("Enter your Card!");
	}

	private void setupPinscreen() {
		clearScreen();
		as.add(NotificationText);
		pinScreenNotification("Enter your PIN");

		Iterator<ScreenButton> it = KeyPadButtons.iterator();
		while (it.hasNext()) {
			as.add(it.next());
		}
	}

	private void setupReceiptScreen() {
		clearScreen();
		as.add(NotificationText);
		pinScreenNotification("Do you want a receipt?");

		Iterator<ScreenButton> it = YesNoButtons.iterator();
		while (it.hasNext()) {
			as.add(it.next());
		}
	}

	private void setupAmountScreen() {
		clearScreen();
		as.add(NotificationText);
		pinScreenNotification("Choose amount");

		Iterator<ScreenButton> it = AmountButtons.iterator();
		while (it.hasNext()) {
			as.add(it.next());
		}
	}

	private void setupMenuScreen() {
		clearScreen();
		as.add(NotificationText);
		pinScreenNotification("Menu, Choose option here!");

		Iterator<ScreenButton> it = MenuButtons.iterator();
		while (it.hasNext()) {
			as.add(it.next());
		}
	}

	private void setupSaldoScreen(int bal) {
		clearScreen();
		as.add(NotificationText);
		pinScreenNotification("Balance: \u20ac" + Integer.toString(bal));

		as.add((MenuButtons.get(1)));
	}

	private void clearPinCode() {
		PinCode = "";
		PinCodeSecure = "";
	}

	private String KeypadInput() {
		while (PinCode.length() < 4) {
			Thread.yield();
			for (int i = 0; i < KeyPadButtons.size(); i++) {
				String input = KeyPadButtons.get(i).getInput();
				if (PinCode.length() == 0) {
					if (input != null) {
						PinCode = input;
						PinCodeSecure += "X";
						pinScreenNotification(PinCodeSecure);
						input = "";
					}
				} else {
					if (input != null) {
						PinCode += input;
						PinCodeSecure += "X";
						pinScreenNotification(PinCodeSecure);
						input = "";
					}
				}
			}
			System.out.println(PinCode);

		}
		return PinCode;
	}

	private void pinScreenNotification(String tekst) {
		NotificationText.giveOutput(tekst);
	}

	private Client getClient(Bank bank, CardReader kaartlezer) {
		// String cardNumber = "";
		Client accountHolder = null;
		String name = "";
		cardScreen();
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

	private String getPin(ATM atm) {

		pinScreenNotification("Enter your Pin!");

		clearPinCode();
		String code = KeypadInput();
		return code;

	}

	private void delay(long l) {
		try {
			Thread.sleep(l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getYesNo() {
		String YesNo = "";
		while (YesNo == "") {
			Thread.yield();
			for (int i = 0; i < YesNoButtons.size(); i++) {
				String input = YesNoButtons.get(i).getInput();

				if (input != null) {
					YesNo = input;
				}

			}
		}

		System.out.println("Keuze: " + YesNo);
		return YesNo;
	}

	private String getOption() {
		String option = "";
		while (option == "") {
			Thread.yield();
			for (int i = 0; i < MenuButtons.size(); i++) {
				String input = MenuButtons.get(i).getInput();

				if (input != null) {
					option = input;
				}

			}
		}

		System.out.println("Keuze: " + option);
		return option;
	}

	public void doTransaction(CardReader kaartlezer) {

		Client c = getClient(bank, kaartlezer);

		setupPinscreen();

		for (int i = 0; i < 3; i++) {
			delay(1000);
			String PinCode = getPin(this);
			System.out.println("PinCode: " + PinCode);
			if (c.checkPin(PinCode)) {
				System.out.println("Correct PinCode");
				break;
			} else {
				System.out.println("Incorrect PinCode");
			}
		}

		delay(1500);

		setupMenuScreen();

		int bal = c.getBalance(PinCode);

		String optie = getOption();
		if (optie == "Balance") {
			setupSaldoScreen(bal);
			while (true) {
				if (((MenuButtons.get(1).getInput()) == "Withdraw")) {
					clearScreen();
					withdraw(c, bal);
					break;
				}
			}

		} else {
			if (optie == "Withdraw") {
				withdraw(c, bal);

			}
		}
		//delay(1500);
	}

	private void withdraw(Client c, int bal) {
		setupAmountScreen();

		int amount = getAmount();

		if (bal > amount) {
			delay(1500);
			setupReceiptScreen();

			if (getYesNo() == "Yes") {
				printReceipt();
			}
			clearScreen();
			c.setBalance(bal - amount);
			as.add(NotificationText);
			pinScreenNotification("Now dispensing: \u20ac" + Integer.toString(amount));
			delay(2000);
		} else {
			clearScreen();
			as.add(NotificationText);
			pinScreenNotification("Insufficient money!");
			delay(1000);
			
		}
		//clearScreen();
	}

	private void printReceipt() {
		// TODO Auto-generated method stub

	}
}