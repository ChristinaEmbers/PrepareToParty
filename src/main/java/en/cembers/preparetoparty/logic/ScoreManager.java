package en.cembers.preparetoparty.logic;

/**
 * This class manages the final score and increases the points based on user Actions taken.
 */
public class ScoreManager {
    //region Variables
    private static int scoreForActions;
    private static int remainingEnergy;
    private static int remainingEuro;
    private static int remainingMinutes;
    private static double scoreTotal = 0;
    //endregion
//todo add starting message to the textarea
//todo singleton einfügen statt static
    //todo score auslagern in resource klasse



    public static void calculateScoreTotal() {
        scoreTotal =
                scoreForActions +
                        (remainingEnergy * 0.5) +
                        (remainingMinutes * 0.1) +
                        (remainingEuro * 0.2);

    }

    public static double getScoreTotal() {
        return scoreTotal;
    }

    public static void addScoreForActions(int score) {
        scoreForActions += score;
    }
 //region get and set methods
    public int getScoreForActions() {
        return scoreForActions;
    }

    public int getRemainingEnergy() {
        return remainingEnergy;
    }

    public void setRemainingEnergy(int remainingEnergy) {
        this.remainingEnergy = remainingEnergy;
    }

    public int getRemainingEuro() {
        return remainingEuro;
    }

    public void setRemainingEuro(int remainingEuro) {
        this.remainingEuro = remainingEuro;
    }

    public int getRemainingMinutes() {
        return remainingMinutes;
    }

    public void setRemainingMinutes(int remainingMinutes) {
        this.remainingMinutes = remainingMinutes;
    }
    //endregion
}
