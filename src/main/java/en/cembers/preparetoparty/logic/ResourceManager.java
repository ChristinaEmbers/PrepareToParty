package en.cembers.preparetoparty.logic;

import en.cembers.preparetoparty.model.Resource;

/**
 * This class manages the resources in the Resource class and makes changes to the values based on Actions taken by the user
 */
public class ResourceManager {
    private Resource resource = Resource.getInstance();

    private static ResourceManager resourceManager;

    public static ResourceManager getInstance() {
        if (resourceManager == null) {
            resourceManager = new ResourceManager();
        }
        return resourceManager;
    }

    public boolean areResourcesEnough(int time, int energy, int money) {
        return isTimeEnough(time) && isEnergyEnough(energy) && isMoneyEnough(money);
    }

    public boolean isTimeEnough(int time) {
        return resource.getTime() >= time;
    }

    public boolean isEnergyEnough(int energy) {
        return resource.getEnergy() >= energy;
    }

    public boolean isMoneyEnough(int money) {
        return resource.getMoney() >= money;
    }

    public int getEnergy() {
        return resource.getEnergy();
    }

    public int getTime() {
        return resource.getTime();
    }

    public int getMoney() {
        return resource.getMoney();
    }

    public void setTime(int time) {
        resource.setTime(time);
    }

    public void setMoney(int money) {
        resource.setMoney(money);
    }

    public void setEnergy(int energy) {
        resource.setEnergy(energy);
    }
}
