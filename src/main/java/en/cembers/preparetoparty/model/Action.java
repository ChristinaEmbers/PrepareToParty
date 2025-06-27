package en.cembers.preparetoparty.model;

/**
 * Class to define the Action Object
 */
public class Action {
    //region Constants
    private static final String DEFAULT_NAME="Name has not been set";
    private static final String DEFAULT_DESCRIPTION_FOR_TEXT_LOG ="Description has not been set";
    private static final int DEFAULT_COST_IN_MINUTES=0;
    private static final int DEFAULT_CHANGE_TO_ENERGY_LEVEL=0;
    private static final int DEFAULT_COST_IN_EURO=0;
    private static final int DEFAULT_POINT_VALUE=0;

//get optionset methode die alle werte liefert um btn 1,2 und 3 zu befüllen mit den jeweiligen werten
    //dafür notwendig optionset definieren
    //option set füllen mit den jeweiligen werten, dafür 3 verschiede sets anlegen
    //ich habe actions, die die jeweiligen eigenschaften einer option haben sollten und ein optionset sind 3 zusammengehörige actions
    //und zwar die mit derselben optionset id

    //schritt 1 ist also die 9 actions zu definieren. alle hardcodiert als konstanten(weit mehr als 9, da x werte je action)
    //schritt 2 ist methoden zu schreiben um die jeweiligen actions auszugeben. vllt kann ich die konstanten generisch benennen mit hochzählender nr
    //schritt 3 ist eine methode zu schreiben, die die 3 zusammengehörigen options zurückgibt
    //schritt 4 ist diese auf der ui anzuzeigen; hierbei sollte schon getestet sein, dass ich von hier überhaupt daten an die ui geben kann und diese anzeigen kann
    //endregion

    //region Variables
    private String name;
    private String descriptionForTextLog;
    private int costInMinutes;
    private int changeToEnergyLevel;
    private int pointValue;
    private int costInEuro;
    //endregion

    //region Constructor

    public Action()
    {
        this.name = DEFAULT_NAME;
        this.descriptionForTextLog = DEFAULT_DESCRIPTION_FOR_TEXT_LOG;
        this.costInMinutes = DEFAULT_COST_IN_MINUTES;
        this.changeToEnergyLevel = DEFAULT_CHANGE_TO_ENERGY_LEVEL;
        this.pointValue = DEFAULT_POINT_VALUE;
        this.costInEuro = DEFAULT_COST_IN_EURO;
    }

    public Action(String name,
                  String descriptionForTextLog,
                  int costInMinutes,
                  int changeToEnergyLevel,
                  int costInEuro,
                  int pointValue)
    {
        this.name = name;
        this.descriptionForTextLog = descriptionForTextLog;
        this.costInMinutes = costInMinutes;
        this.changeToEnergyLevel = changeToEnergyLevel;
        this.costInEuro = costInEuro;
        this.pointValue = pointValue;
    }

    //endregion

    //region getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptionForTextLog() {
        return descriptionForTextLog;
    }

    public void setDescriptionForTextLog(String descriptionForTextLog) {
        this.descriptionForTextLog = descriptionForTextLog;
    }

    public int getCostInMinutes() {
        return costInMinutes;
    }

    public void setCostInMinutes(int costInMinutes) {
        this.costInMinutes = costInMinutes;
    }

    public int getChangeToEnergyLevel() {
        return changeToEnergyLevel;
    }

    public void setChangeToEnergyLevel(int changeToEnergyLevel) {
        this.changeToEnergyLevel = changeToEnergyLevel;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public int getCostInEuro() {
        return costInEuro;
    }

    public void setCostInEuro(int costInEuro) {
        this.costInEuro = costInEuro;
    }
    //endregion

    //region String methods
    @Override
    public String toString() {
        return "Action{" +
                "name='" + name + '\'' +
                ", descriptionForTextLog='" + descriptionForTextLog + '\'' +
                ", costInMinutes=" + costInMinutes +
                ", changeToEnergyLevel=" + changeToEnergyLevel +
                ", pointValue=" + pointValue +
                ", costInEuro=" + costInEuro +
                '}';
    }

    //endregion
}
