public class TicketBooking {

    private String stageEvent;
    private String customer;
    private int noOfSeats;

    // Default Constructor
    public TicketBooking() {
    }

    // Parameterized Constructor
    public TicketBooking(String stageEvent, String customer, int noOfSeats) {
        this.stageEvent = stageEvent;
        this.customer = customer;
        this.noOfSeats = noOfSeats;
    }

    // Getters
    public String getStageEvent() {
        return stageEvent;
    }

    public String getCustomer() {
        return customer;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    // Setters
    public void setStageEvent(String stageEvent) {
        this.stageEvent = stageEvent;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    // Cash Payment
    public void makePayment(double amount) {
        System.out.println("Stage event:" + stageEvent);
        System.out.println("Customer:" + customer);
        System.out.println("Number of seats:" + noOfSeats);
        System.out.printf("Amount %.1f paid in cash\n", amount);
    }

    // Wallet Payment
    public void makePayment(String walletNumber, double amount) {
        System.out.println("Stage event:" + stageEvent);
        System.out.println("Customer:" + customer);
        System.out.println("Number of seats:" + noOfSeats);
        System.out.printf("Amount %.1f paid using wallet\n", amount);
        System.out.println("Wallet Number:" + walletNumber);
    }

    // Credit Card Payment
    public void makePayment(String creditCard, String ccv, String name, double amount) {
        System.out.println("Stage event:" + stageEvent);
        System.out.println("Customer:" + customer);
        System.out.println("Number of seats:" + noOfSeats);
        System.out.println("Holder name:" + name);
        System.out.printf("Amount %.1f paid using %s card\n", amount, creditCard);
        System.out.println("CCV:" + ccv);
    }
}