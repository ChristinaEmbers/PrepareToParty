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
    private static final String FOOD_CATEGORY_KEY = "Food";
    private static final String DECO_CATEGORY_KEY = "Decoration";
    private static final String ACTIVITY_CATEGORY_KEY = "Activity";
    public static final int ACTION_1_FROM_CURRENT_CATEGORY = 0;
    public static final int ACTION_2_FROM_CURRENT_CATEGORY = 1;
    public static final int ACTION_3_FROM_CURRENT_CATEGORY = 2;
    //endregions

    //region Variables
    private static GameState currentState = GameState.CHOOSE_FOOD;

    public enum GameState {
        CHOOSE_FOOD, CHOOSE_DECORATION, CHOOSE_ACTIVITY, GAME_WON
    }

    private Map<String, ArrayList<Action>> gameOptions = new HashMap<>();
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


    //region Singletons
    private static ResourceManager resourceManager;

    public static synchronized ResourceManager getResourceManagerInstance() {
        if (resourceManager == null) {
            resourceManager = new ResourceManager();
        }
        return resourceManager;
    }

    private static ScoreManager scoreManager;

    public static synchronized ScoreManager getScoreManagerInstance() {
        if (scoreManager == null) {
            scoreManager = new ScoreManager();
        }
        return scoreManager;
    }


    //endregion

    //region initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillMap();
        loadUiValues(currentState);
    }

    //endregion
    //region map initialisation
    private void fillMap() {
        gameOptions.put(FOOD_CATEGORY_KEY, ActionBuilder.getFoodActions());
        gameOptions.put(DECO_CATEGORY_KEY, ActionBuilder.getDecoActions());
        gameOptions.put(ACTIVITY_CATEGORY_KEY, ActionBuilder.getActivityActions());
    }
    //endregion

    private void loadUiValues(GameState currentOptionSet) {
        lblTime.setText(String.valueOf(getResourceManagerInstance().getTime()));
        lblMoney.setText(String.valueOf(getResourceManagerInstance().getMoney()));
        lblEnergy.setText(String.valueOf(getResourceManagerInstance().getEnergy()));
        switch (currentOptionSet) {
            case GameState.CHOOSE_FOOD:
                setOptionSet(FOOD_CATEGORY_KEY);
                break;
            case GameState.CHOOSE_DECORATION:
                setOptionSet(DECO_CATEGORY_KEY);
                break;
            case GameState.CHOOSE_ACTIVITY:
                setOptionSet(ACTIVITY_CATEGORY_KEY);
                break;
            case GameState.GAME_WON:
                getScoreManagerInstance().setRemainingEnergy(getResourceManagerInstance().getEnergy());
                getScoreManagerInstance().setRemainingMoney(getResourceManagerInstance().getMoney());
                getScoreManagerInstance().setRemainingTime(getResourceManagerInstance().getTime());
                getScoreManagerInstance().calculateScoreTotal();
                logbook.appendText("YOU WIN " + getScoreManagerInstance().getScoreTotal() + " Points");
                break;
        }
    }


    private void enableAllButtons() {
        btnOption1.setDisable(false);
        btnOption2.setDisable(false);
        btnOption3.setDisable(false);
    }

    private void setOptionSet(String categoryKey) {
        enableAllButtons();
        lblChooseCategory.setText("Choose " + categoryKey);

        setButtonOption(btnOption1, lblOption1, ACTION_1_FROM_CURRENT_CATEGORY, categoryKey);
        setButtonOption(btnOption2, lblOption2, ACTION_2_FROM_CURRENT_CATEGORY, categoryKey);
        setButtonOption(btnOption3, lblOption3, ACTION_3_FROM_CURRENT_CATEGORY, categoryKey);
    }

    private void setButtonOption(Button buttonObject, Label labelObject, int actionFromCurrentCategory, String categoryKey) {
        buttonObject.setText(gameOptions.get(categoryKey).get(actionFromCurrentCategory).getName());
        labelObject.setText(createCostForOptionText(
                gameOptions.get(categoryKey).get(actionFromCurrentCategory).getCostInMinutes(),
                gameOptions.get(categoryKey).get(actionFromCurrentCategory).getChangeToEnergyLevel(),
                gameOptions.get(categoryKey).get(actionFromCurrentCategory).getCostInEuro()
        ));
        disableInvalidOptions(actionFromCurrentCategory,
                gameOptions.get(categoryKey).get(actionFromCurrentCategory).getCostInMinutes(),
                gameOptions.get(categoryKey).get(actionFromCurrentCategory).getChangeToEnergyLevel(),
                gameOptions.get(categoryKey).get(actionFromCurrentCategory).getCostInEuro());
    }

    private void executeOption(int index) {
        switch (currentState) {
            case GameState.CHOOSE_FOOD:
                handleOptionSelection(FOOD_CATEGORY_KEY, index);
                currentState = GameState.CHOOSE_DECORATION;
                break;
            case GameState.CHOOSE_DECORATION:
                handleOptionSelection(DECO_CATEGORY_KEY, index);
                currentState = GameState.CHOOSE_ACTIVITY;
                break;
            case GameState.CHOOSE_ACTIVITY:
                handleOptionSelection(ACTIVITY_CATEGORY_KEY, index);
                currentState = GameState.GAME_WON;
                break;
            default: {

            }
        }
        loadUiValues(currentState);
    }

    private void handleOptionSelection(String categoryKey, int selectedOption) {
        logbook.appendText(gameOptions.get(categoryKey).get(selectedOption).getDescriptionForTextLog() + "\n");
        getScoreManagerInstance().addScoreForActions(gameOptions.get(categoryKey).get(selectedOption).getPointValue());
        updateResources(
                gameOptions.get(categoryKey).get(selectedOption).getCostInMinutes(),
                gameOptions.get(categoryKey).get(selectedOption).getCostInEuro(),
                gameOptions.get(categoryKey).get(selectedOption).getChangeToEnergyLevel());
    }

    private void updateResources(int time, int energy, int money) {
        getResourceManagerInstance().setTime(getResourceManagerInstance().getTime() - time);
        getResourceManagerInstance().setMoney(getResourceManagerInstance().getMoney() - money);
        getResourceManagerInstance().setEnergy(getResourceManagerInstance().getEnergy() - energy);

    }

    //region UI Helper methods
    private void disableInvalidOptions(int actionFromCurrentCategory, int time, int energy, int money) {
        if (!ResourceManager.areResourcesEnough(time, energy, money)) {
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
