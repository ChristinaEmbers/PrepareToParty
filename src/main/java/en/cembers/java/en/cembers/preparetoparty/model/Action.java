package en.cembers.preparetoparty.model;

/**
 * Class to define the Action Object
 */
public class Action {
    //region Constants

    private static final String DEFAULT_NAME="Name has not been set";
    private static final String DEFAULT_CATEGORY="Category has not been set";
    private static final String DEFAULT_DESCRIPTION_FOR_TEXTLOG="Description has not been set";
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
        this.descriptionForTextLog = DEFAULT_DESCRIPTION_FOR_TEXTLOG;
        this.costInMinutes = DEFAULT_COST_IN_MINUTES;
        this.changeToStressLevel = DEFAULT_CHANGE_TO_STRESS_LEVEL;
        this.pointValue = DEFAULT_POINT_VALUE;
        this.costInEuro = DEFAULT_COST_IN_EURO;
    }

    //endregion
}
