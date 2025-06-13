package en.cembers.preparetoparty.model;

/**
This Model class contains the values of the start and current values for the game relevant resources
 */

public class Resource {

    private static final int MIN_TIME_LEFT_IN_MINUTES=0;
    private static final int START_TIME_LEFT_IN_MINUTES=300;
    private static final int MIN_ENERGY=0;
    private static final int MAX_ENERGY=100;
    private static final double MIN_MONEY=0.00;
    private static final double START_MONEY=100;

 //todo singleton for each kind of resource
    private int timeLeftInMinutes;
    private int energy;
    private double moneyInEuro;

    public Resource() {
        this.timeLeftInMinutes = START_TIME_LEFT_IN_MINUTES;
        this.energy = MAX_ENERGY;
        this.moneyInEuro = START_MONEY;
    }

    public int getTimeLeftInMinutes() {
        return timeLeftInMinutes;
    }

    public void setTimeLeftInMinutes(int timeLeftInMinutes) {
        this.timeLeftInMinutes = timeLeftInMinutes;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public double getMoneyInEuro() {
        return moneyInEuro;
    }

    public void setMoneyInEuro(double moneyInEuro) {
        this.moneyInEuro = moneyInEuro;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "timeLeftInMinutes=" + timeLeftInMinutes +
                ", energy=" + energy +
                ", moneyInEuro=" + moneyInEuro +
                '}';
    }
}
