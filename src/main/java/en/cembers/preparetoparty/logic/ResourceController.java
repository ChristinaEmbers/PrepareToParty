package en.cembers.preparetoparty.logic;

import en.cembers.preparetoparty.model.Resource;

/**
 * This class manages the resources in the Resource class and makes changes to the values based on Actions taken by the user
 */
public class ResourceController {

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

    //todo methode die prüft ob ich genug energie habe und knopf deaktiviert, wenn nicht genug energie da ist
    //1. verhindern das knopf gedrückt wird wenn ressourcen fehlen(checkmethode in resource controller) und aufruf vor laden neuer buttonwerte
    //noch testen
    // todo 2. ui aktuelle energie etc aus resource klasse anzeigen
    //todo 3. methoden schreiben die energie zeit etc reduzieren
    //todo 4. werte an score manager klasse geben
    //todo 5. überlegen score in resource auszulagern


    public void reduceEnergy(int Energy)
    {

    }
}
