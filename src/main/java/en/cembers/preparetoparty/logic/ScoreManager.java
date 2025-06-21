package en.cembers.preparetoparty.logic;

/**
 * This class manages the final score and increases the points based on user Actions taken.
 */
public class ScoreManager {

//todo define how the endscreen and startscreen are supposed to look
// //todo write the ui for startscreen
    //todo write the ui for endscreen

    public int getScoreForActions() {
        return scoreForActions;
    }

    public void setScoreForActions(int scoreForActions) {
        this.scoreForActions = scoreForActions;
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

    int scoreForActions;
    int remainingEnergy;
    int remainingEuro;
    int remainingMinutes;

    static int scoreTotal = 0;


    public void calculateScoreTotal() {
        double totalPoints =
                scoreForActions +
                        (remainingEnergy * 0.5) +
                        (remainingMinutes * 0.1) +
                        (remainingEuro * 0.2);

    }

    public double getScoreTotal()
    {
        return scoreTotal;
    }
}
