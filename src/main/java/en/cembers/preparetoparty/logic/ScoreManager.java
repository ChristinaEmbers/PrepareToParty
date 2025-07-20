package en.cembers.preparetoparty.logic;

/**
 * This class manages the final score and increases the points based on user Actions taken.
 */
public class ScoreManager {
    //region Variables
    private static int scoreForActions;
    private static int remainingEnergy;
    private static int remainingMoney;
    private static int remainingTime;
    private static double scoreTotal = 0;
    //endregion

    private static ScoreManager scoreManager;

    public static ScoreManager getInstance() {
        if (scoreManager == null) {
            scoreManager = new ScoreManager();
        }
        return scoreManager;
    }

    //region score calculation
    public void calculateScoreTotal(int remainingEnergy, int remainingMoney, int remainingTime) {
        scoreTotal =
                scoreForActions +
                        (remainingEnergy * 0.5) +
                        (remainingMoney * 0.2) +
                        (remainingTime * 0.1);

    }

    public double getScoreTotal() {
        return scoreTotal;
    }

    public void addScoreForActions(int score) {
        scoreForActions += score;
    }
    //endregion

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

    public int getRemainingMoney() {
        return remainingMoney;
    }

    public void setRemainingMoney(int remainingEuro) {
        this.remainingMoney = remainingEuro;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
    //endregion
}
