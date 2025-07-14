package en.cembers.preparetoparty.logic;

import en.cembers.preparetoparty.model.Resource;

/**
 * This class manages the resources in the Resource class and makes changes to the values based on Actions taken by the user
 */
public class ResourceManager {

    private static Resource resource;

    //region getInstance
    public static synchronized Resource getResource() {

        if (resource == null) {
            resource = new Resource();
        }

        return resource;

    }
    //endregion

    public static boolean areResourcesEnough(int time, int energy, int money) {
        return isTimeEnough(time) && isEnergyEnough(energy) && isMoneyEnough(money);
    }

    public static boolean isTimeEnough(int time) {
        return getResource().getTime() >= time;
    }

    public static boolean isEnergyEnough(int energy) {
        return getResource().getEnergy() >= energy;
    }

    public static boolean isMoneyEnough(int money) {
        return getResource().getMoney() >= money;
    }

    public int getEnergy() {
        return getResource().getEnergy();
    }

    public int getTime() {
        return getResource().getTime();
    }

    public int getMoney() {
        return getResource().getMoney();
    }

    public void setTime(int time) {
        getResource().setTime(time);
    }

    public void setMoney(int money) {
        getResource().setMoney(money);
    }

    public void setEnergy(int energy) {
        getResource().setEnergy(energy);
    }
}
