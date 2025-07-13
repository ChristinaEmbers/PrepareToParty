package en.cembers.preparetoparty.model;

/**
 * Class to define the Action Object
 */
public class Action {
    //region Constants
    private static final String DEFAULT_NAME = "Name has not been set";
    private static final String DEFAULT_DESCRIPTION_FOR_TEXT_LOG = "Description has not been set";
    private static final int DEFAULT_COST_IN_MINUTES = 0;
    private static final int DEFAULT_CHANGE_TO_ENERGY_LEVEL = 0;
    private static final int DEFAULT_COST_IN_EURO = 0;
    private static final int DEFAULT_POINT_VALUE = 0;
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

    public Action() {
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
                  int pointValue) {
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
        return descriptionForTextLog; }

    public void setDescriptionForTextLog(String descriptionForTextLog) {
        this.descriptionForTextLog = descriptionForTextLog; }

    public int getCostInMinutes() { return costInMinutes; }

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
