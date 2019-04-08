# BankJavaPro

In this project I create a bank GUI for my school assignment.
This will be a simulation of how a bank will work.

Run the project by clicking the run.bat Batch file.

Bank accounts:

		this.accounts = new HashMap<String, Client>();
		Client client1 = new Client("Piet", "0000", 100);
		this.accounts.put("NL01BANK0123456789", client1);

		Client client2 = new Client("Henk", "1234", 1000);
		this.accounts.put("NL01BANK9876543210", client2);

		Client client3 = new Client("Klaas", "4321", 1000000);
		this.accounts.put("NL01BANK0000000000", client3);

-------------------------------------------------------------
| Name  | PinCode  | Starting Balance | AccountNumber       |
|------------------------------------------------------------
| Piet  |   0000   |  100             | NL01BANK0123456789  |
| Henk  |   1234   |  1000            | NL01BANK9876543210  |
| Klaas |   4321   |  1000000         | NL01BANK0000000000  |
|------------------------------------------------------------
