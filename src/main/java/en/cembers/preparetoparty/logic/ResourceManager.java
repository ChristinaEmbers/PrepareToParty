package en.cembers.preparetoparty.logic;

import en.cembers.preparetoparty.model.Resource;

/**
 * This class manages the resources in the Resource class and makes changes to the values based on Actions taken by the user
 */
public class ResourceManager {

    private static Resource instance;

    //region getInstance
    public static synchronized Resource getInstance() {

        if (instance == null) {
            instance = new Resource();
        }

        return instance;

    }
    //endregion

    public static boolean areResourcesEnough(int time, int energy, int money)
    {
       return isTimeEnough(time)&&isEnergyEnough(energy)&&isMoneyEnough(money);
    }

    public static boolean isTimeEnough(int time)
    {
        return getInstance().getTime() >= time;
    }
    public static boolean isEnergyEnough(int energy)
    {
        return getInstance().getEnergy() >= energy;
    }

    public static boolean isMoneyEnough(int money)
    {
        return getInstance().getMoney() >= money;
    }
}
