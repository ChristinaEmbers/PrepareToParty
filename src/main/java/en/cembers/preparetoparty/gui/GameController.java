package en.cembers.preparetoparty.gui;

import en.cembers.preparetoparty.logic.ActionBuilder;
import en.cembers.preparetoparty.logic.ResourceManager;
import en.cembers.preparetoparty.logic.ScoreManager;
import en.cembers.preparetoparty.model.Action;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * This class is responsible for UI interactions
 */
public class GameController implements Initializable {
    //region Constants
    public static final int ACTION_1_FROM_CURRENT_CATEGORY = 0;
    public static final int ACTION_2_FROM_CURRENT_CATEGORY = 1;
    public static final int ACTION_3_FROM_CURRENT_CATEGORY = 2;
    //endregions

    //region Variables
    private static GameState currentState = GameState.CHOOSE_FOOD;
    private ResourceManager resourceManager;
    private ScoreManager scoreManager;

    public enum GameState {
        CHOOSE_FOOD, CHOOSE_DECORATION, CHOOSE_ACTIVITY, GAME_WON
    }

    private Map<GameState, ArrayList<Action>> gameOptions = new HashMap<>();
    //endregion


    //region UI Elements
    @FXML
    private Label lblChooseCategory;

    @FXML
    private Button btnOption1;
    @FXML
    private Label lblOption1;

    @FXML
    public void executeOption1() {
        executeOption(ACTION_1_FROM_CURRENT_CATEGORY);
    }

    @FXML
    private Button btnOption2;
    @FXML
    private Label lblOption2;

    @FXML
    public void executeOption2() {
        executeOption(ACTION_2_FROM_CURRENT_CATEGORY);
    }

    @FXML
    private Button btnOption3;
    @FXML
    private Label lblOption3;

    @FXML
    public void executeOption3() {
        executeOption(ACTION_3_FROM_CURRENT_CATEGORY);
    }

    @FXML
    private Label lblTime;
    @FXML
    private Label lblEnergy;
    @FXML
    private Label lblMoney;

    @FXML
    private TextArea logbook;
    //endregions


    //region initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resourceManager = ResourceManager.getInstance();
        scoreManager = ScoreManager.getInstance();
        fillMap();
        loadUiValues();

    }

    //endregion
    //region map initialisation
    private void fillMap() {
        gameOptions.put(GameState.CHOOSE_FOOD, ActionBuilder.getFoodActions());
        gameOptions.put(GameState.CHOOSE_DECORATION, ActionBuilder.getDecoActions());
        gameOptions.put(GameState.CHOOSE_ACTIVITY, ActionBuilder.getActivityActions());
    }
    //endregion

    private void loadUiValues() {
        lblTime.setText(String.valueOf(resourceManager.getTime()));
        lblMoney.setText(String.valueOf(resourceManager.getMoney()));
        lblEnergy.setText(String.valueOf(resourceManager.getEnergy()));
        if (!(currentState == GameState.GAME_WON)) {
            setOptionSet();
        } else {
            lblChooseCategory.setText(currentState.name());
            scoreManager.setRemainingEnergy(resourceManager.getEnergy());
            scoreManager.setRemainingMoney(resourceManager.getMoney());
            scoreManager.setRemainingTime(resourceManager.getTime());
            scoreManager.calculateScoreTotal();
            logbook.appendText("YOU WIN " + scoreManager.getScoreTotal() + " Points");
            disableAllButtons();
        }
    }

    private void disableAllButtons() {
        btnOption1.setDisable(true);
        btnOption2.setDisable(true);
        btnOption3.setDisable(true);
    }


    private void enableAllButtons() {
        btnOption1.setDisable(false);
        btnOption2.setDisable(false);
        btnOption3.setDisable(false);
    }

    private void setOptionSet() {
        enableAllButtons();
        lblChooseCategory.setText(currentState.name());

        setButtonOption(btnOption1, lblOption1, ACTION_1_FROM_CURRENT_CATEGORY);
        setButtonOption(btnOption2, lblOption2, ACTION_2_FROM_CURRENT_CATEGORY);
        setButtonOption(btnOption3, lblOption3, ACTION_3_FROM_CURRENT_CATEGORY);
    }

    private void setButtonOption(Button buttonObject, Label labelObject, int actionFromCurrentCategory) {
        buttonObject.setText(gameOptions.get(currentState).get(actionFromCurrentCategory).getName());
        labelObject.setText(createCostForOptionText(
                gameOptions.get(currentState).get(actionFromCurrentCategory).getCostInMinutes(),
                gameOptions.get(currentState).get(actionFromCurrentCategory).getChangeToEnergyLevel(),
                gameOptions.get(currentState).get(actionFromCurrentCategory).getCostInEuro()
        ));
        disableInvalidOptions(actionFromCurrentCategory,
                gameOptions.get(currentState).get(actionFromCurrentCategory).getCostInMinutes(),
                gameOptions.get(currentState).get(actionFromCurrentCategory).getChangeToEnergyLevel(),
                gameOptions.get(currentState).get(actionFromCurrentCategory).getCostInEuro());
    }

    private void executeOption(int chosenOption) {
        switch (currentState) {
            case GameState.CHOOSE_FOOD:
                handleOptionSelection(chosenOption);
                currentState = GameState.CHOOSE_DECORATION;
                break;
            case GameState.CHOOSE_DECORATION:
                handleOptionSelection(chosenOption);
                currentState = GameState.CHOOSE_ACTIVITY;
                break;
            case GameState.CHOOSE_ACTIVITY:
                handleOptionSelection(chosenOption);
                currentState = GameState.GAME_WON;
                break;
            default: {

            }
        }
        loadUiValues();
    }

    private void handleOptionSelection(int selectedOption) {
        logbook.appendText(gameOptions.get(currentState).get(selectedOption).getDescriptionForTextLog() + "\n");
        scoreManager.addScoreForActions(gameOptions.get(currentState).get(selectedOption).getPointValue());
        updateResources(
                gameOptions.get(currentState).get(selectedOption).getCostInMinutes(),
                gameOptions.get(currentState).get(selectedOption).getCostInEuro(),
                gameOptions.get(currentState).get(selectedOption).getChangeToEnergyLevel());
    }

    private void updateResources(int time, int energy, int money) {
        resourceManager.setTime(resourceManager.getTime() - time);
        resourceManager.setMoney(resourceManager.getMoney() - money);
        resourceManager.setEnergy(resourceManager.getEnergy() - energy);

    }

    //region UI Helper methods
    private void disableInvalidOptions(int actionFromCurrentCategory, int time, int energy, int money) {
        if (!resourceManager.areResourcesEnough(time, energy, money)) {
            switch (actionFromCurrentCategory) {
                case ACTION_1_FROM_CURRENT_CATEGORY:
                    btnOption1.setDisable(true);
                    break;

                case ACTION_2_FROM_CURRENT_CATEGORY:
                    btnOption2.setDisable(true);
                    break;

                case ACTION_3_FROM_CURRENT_CATEGORY:
                    btnOption3.setDisable(true);
                    break;
            }
        }
    }

    private String createCostForOptionText(int time, int energy, int money) {
        return "Time cost: " + time + " Energy cost: " + energy + " Price : " + money + "€";
    }
    //endregion
}
