package en.cembers.preparetoparty.logic;

/**
 * This class manages the final score and increases the points based on user Actions taken.
 */
public class ScoreManager {

//todo define how the endscreen and startscreen are supposed to look
// //todo write the ui for startscreen
    //todo write the ui for endscreen

    int scoreFood;
    int scoreDecoration;
    int scoreActivity;
    //todo decide if i just want to add remaining values to score total or use a formula
    int scoreEnergyLeft;
    int scoreMoneyLeft;
    int scoreTimeLeft; //todo decide if leftover time recharges energy

    static int scoreTotal = 0;


    public void increaseScoreTotal(int amountToIncreaseBy) {
        //todo add checks for errors
        scoreTotal += amountToIncreaseBy;

    }

    public int getScoreTotal()
    {
        return scoreTotal;
    }
}
