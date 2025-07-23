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

    private Map<GameState, ArrayList<Action>> gameActions = new HashMap<>();
    //endregion


    //region UI Elements
    @FXML
    private Label lblChooseCategory;

    @FXML
    private Button btnAction1;
    @FXML
    private Label lblAction1;

    @FXML
    public void executeAction1() {
        executeAction(ACTION_1_FROM_CURRENT_CATEGORY);
    }

    @FXML
    private Button btnAction2;
    @FXML
    private Label lblAction2;

    @FXML
    public void executeAction2() {
        executeAction(ACTION_2_FROM_CURRENT_CATEGORY);
    }

    @FXML
    private Button btnAction3;
    @FXML
    private Label lblAction3;

    @FXML
    public void executeAction3() {
        executeAction(ACTION_3_FROM_CURRENT_CATEGORY);
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
        gameActions.put(GameState.CHOOSE_FOOD, ActionBuilder.getFoodActions());
        gameActions.put(GameState.CHOOSE_DECORATION, ActionBuilder.getDecoActions());
        gameActions.put(GameState.CHOOSE_ACTIVITY, ActionBuilder.getActivityActions());
    }
    //endregion

    private void loadUiValues() {
        lblTime.setText(String.valueOf(resourceManager.getTime()));
        lblMoney.setText(String.valueOf(resourceManager.getMoney()));
        lblEnergy.setText(String.valueOf(resourceManager.getEnergy()));
        if ((currentState != GameState.GAME_WON)) {
            setActionSet();
        } else {
            lblChooseCategory.setText(currentState.name());

            scoreManager.calculateScoreTotal(resourceManager.getEnergy(), resourceManager.getMoney(), resourceManager.getTime());
            logbook.appendText("YOU WIN " + scoreManager.getScoreTotal() + " Points");
            disableAllButtons();
        }
    }

    private void disableAllButtons() {
        btnAction1.setDisable(true);
        btnAction2.setDisable(true);
        btnAction3.setDisable(true);
    }


    private void enableAllButtons() {
        btnAction1.setDisable(false);
        btnAction2.setDisable(false);
        btnAction3.setDisable(false);
    }

    private void setActionSet() {
        enableAllButtons();
        lblChooseCategory.setText(currentState.name());

        setButtonAction(btnAction1, lblAction1, ACTION_1_FROM_CURRENT_CATEGORY);
        setButtonAction(btnAction2, lblAction2, ACTION_2_FROM_CURRENT_CATEGORY);
        setButtonAction(btnAction3, lblAction3, ACTION_3_FROM_CURRENT_CATEGORY);
    }

    private void setButtonAction(Button buttonObject, Label labelObject, int actionFromCurrentCategory) {
        buttonObject.setText(gameActions.get(currentState).get(actionFromCurrentCategory).getName());
        labelObject.setText(createCostForActionText(
                gameActions.get(currentState).get(actionFromCurrentCategory).getCostInMinutes(),
                gameActions.get(currentState).get(actionFromCurrentCategory).getChangeToEnergyLevel(),
                gameActions.get(currentState).get(actionFromCurrentCategory).getCostInEuro()
        ));
        disableInvalidActions(actionFromCurrentCategory,
                gameActions.get(currentState).get(actionFromCurrentCategory).getCostInMinutes(),
                gameActions.get(currentState).get(actionFromCurrentCategory).getChangeToEnergyLevel(),
                gameActions.get(currentState).get(actionFromCurrentCategory).getCostInEuro());
    }

    private void executeAction(int chosenAction) {
        switch (currentState) {
            case GameState.CHOOSE_FOOD:
                handleActionSelection(chosenAction);
                currentState = GameState.CHOOSE_DECORATION;
                break;
            case GameState.CHOOSE_DECORATION:
                handleActionSelection(chosenAction);
                currentState = GameState.CHOOSE_ACTIVITY;
                break;
            case GameState.CHOOSE_ACTIVITY:
                handleActionSelection(chosenAction);
                currentState = GameState.GAME_WON;
                break;
            default: {

            }
        }
        loadUiValues();
    }

    private void handleActionSelection(int selectedAction) {
        logbook.appendText(gameActions.get(currentState).get(selectedAction).getDescriptionForTextLog() + "\n");
        scoreManager.addScoreForActions(gameActions.get(currentState).get(selectedAction).getPointValue());
        updateResources(
                gameActions.get(currentState).get(selectedAction).getCostInMinutes(),
                gameActions.get(currentState).get(selectedAction).getCostInEuro(),
                gameActions.get(currentState).get(selectedAction).getChangeToEnergyLevel());
    }

    private void updateResources(int time, int energy, int money) {
        resourceManager.setTime(resourceManager.getTime() - time);
        resourceManager.setMoney(resourceManager.getMoney() - money);
        resourceManager.setEnergy(resourceManager.getEnergy() - energy);

    }

    //region UI Helper methods
    private void disableInvalidActions(int actionFromCurrentCategory, int time, int energy, int money) {
        if (!resourceManager.areResourcesEnough(time, energy, money)) {
            switch (actionFromCurrentCategory) {
                case ACTION_1_FROM_CURRENT_CATEGORY:
                    btnAction1.setDisable(true);
                    break;

                case ACTION_2_FROM_CURRENT_CATEGORY:
                    btnAction2.setDisable(true);
                    break;

                case ACTION_3_FROM_CURRENT_CATEGORY:
                    btnAction3.setDisable(true);
                    break;
            }
        }
    }

    private String createCostForActionText(int time, int energy, int money) {
        return "Time cost: " + time + " Energy cost: " + energy + " Price : " + money + "€";
    }
    //endregion
}
