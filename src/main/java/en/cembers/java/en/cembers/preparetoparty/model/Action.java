package en.cembers.preparetoparty.model;

/**
 * Class to define the Action Object
 */
public class Action {
    //region Constants

    private static final String DEFAULT_NAME="Name has not been set";
    private static final String DEFAULT_CATEGORY="Category has not been set";
    private static final String DEFAULT_DESCRIPTION_FOR_TEXT_LOG ="Description has not been set";
    private static final int DEFAULT_COST_IN_MINUTES=0;
    private static final int DEFAULT_CHANGE_TO_STRESS_LEVEL=0;
    private static final int DEFAULT_POINT_VALUE=0;
    private static final double DEFAULT_COST_IN_EURO=0.00;

    //endregion

    //region Variables
    private String name;
    private String category;
    private String descriptionForTextLog;
    private int costInMinutes;
    private int changeToStressLevel;
    private int pointValue;
    private double costInEuro;
    //endregion

    //region Constructor

    public Action()
    {
        this.name = DEFAULT_NAME;
        this.category = DEFAULT_CATEGORY;
        this.descriptionForTextLog = DEFAULT_DESCRIPTION_FOR_TEXT_LOG;
        this.costInMinutes = DEFAULT_COST_IN_MINUTES;
        this.changeToStressLevel = DEFAULT_CHANGE_TO_STRESS_LEVEL;
        this.pointValue = DEFAULT_POINT_VALUE;
        this.costInEuro = DEFAULT_COST_IN_EURO;
    }

    //endregion

    //region getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public int getChangeToStressLevel() {
        return changeToStressLevel;
    }

    public void setChangeToStressLevel(int changeToStressLevel) {
        this.changeToStressLevel = changeToStressLevel;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public double getCostInEuro() {
        return costInEuro;
    }

    public void setCostInEuro(double costInEuro) {
        this.costInEuro = costInEuro;
    }
    //endregion

    //region String methods
    @Override
    public String toString() {
        return "Action{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", descriptionForTextLog='" + descriptionForTextLog + '\'' +
                ", costInMinutes=" + costInMinutes +
                ", changeToStressLevel=" + changeToStressLevel +
                ", pointValue=" + pointValue +
                ", costInEuro=" + costInEuro +
                '}';
    }

    //endregion
}
