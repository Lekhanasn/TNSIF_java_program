import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(accNo, balance);

        try {

            System.out.print("Enter Deposit Amount: ");
            double deposit = sc.nextDouble();
            account.deposit(deposit);

            System.out.print("Enter Withdrawal Amount: ");
            double withdraw = sc.nextDouble();
            account.withdraw(withdraw);

        } catch (InvalidAmountException e) {

            System.out.println(e.getMessage());

        } catch (InsufficientFundsException e) {

            System.out.println(e.getMessage());

        } finally {

            account.displayBalance();
            System.out.println("Transaction Completed.");

        }

        sc.close();
    }
}