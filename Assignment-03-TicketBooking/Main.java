import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] details = input.split(",");

        TicketBooking ticket = new TicketBooking(
                details[0],
                details[1],
                Integer.parseInt(details[2]));

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                double amount = sc.nextDouble();
                ticket.makePayment(amount);
                break;

            case 2:
                double amount2 = sc.nextDouble();
                sc.nextLine();
                String wallet = sc.nextLine();
                ticket.makePayment(wallet, amount2);
                break;

            case 3:
                String holder = sc.nextLine();
                double amount3 = sc.nextDouble();
                sc.nextLine();
                String card = sc.nextLine();
                String ccv = sc.nextLine();
                ticket.makePayment(card, ccv, holder, amount3);
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}