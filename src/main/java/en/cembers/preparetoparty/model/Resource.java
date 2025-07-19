package en.cembers.preparetoparty.model;

/**
 * This Model class contains the values of the start and current values for the game relevant resources
 */

public class Resource {
    private static Resource resource;

    public static Resource getInstance() {

        if (resource == null) {
            resource = new Resource();
        }

        return resource;

    }

    private static final int START_TIME = 300;
    private static final int MAX_ENERGY = 100;
    private static final int START_MONEY = 100;

    private static int time;
    private static int energy;
    private static int money;

    public Resource() {
        this.time = START_TIME;
        this.energy = MAX_ENERGY;
        this.money = START_MONEY;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "time=" + time +
                ", energy=" + energy +
                ", moneyInEuro=" + money +
                '}';
    }
}
