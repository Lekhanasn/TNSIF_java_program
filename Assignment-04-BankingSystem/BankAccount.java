public class BankAccount {

    private int accountNumber;
    private double balance;

    // Parameterized Constructor
    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit Method
    public void deposit(double amount) throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException("Invalid deposit amount.");
        }

        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Withdraw Method
    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientFundsException {

        if (amount <= 0) {
            throw new InvalidAmountException("Invalid withdrawal amount.");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance.");
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    // Display Balance
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}