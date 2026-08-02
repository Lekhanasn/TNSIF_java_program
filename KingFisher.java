public class KingFisher implements Airfare {

    private int hours;
    private double costPerHour;

    // Default Constructor
    public KingFisher() {
    }

    // Parameterized Constructor
    public KingFisher(int hours, double costPerHour) {
        this.hours = hours;
        this.costPerHour = costPerHour;
    }

    // Getter and Setter
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    // Override Method
    @Override
    public double calculateAmount() {
        return hours * costPerHour * 4;
    }
}