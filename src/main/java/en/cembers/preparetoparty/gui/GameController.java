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
    //todo remove magic numbers in the code and replace with constants
    //endregions

    //region Variables
    private static int currentOptionSet = 0; //todo replace numbers with enum
    private Map<String, ArrayList<Action>> gameOptions = new HashMap<>();
    //endregion


    //region UI Elements
    @FXML
    private Label lblChooseCategory;
    @FXML
    private Button btnOption1;
    @FXML
    private Button btnOption2;
    @FXML
    private Button btnOption3;
    @FXML
    private Label lblOption1;
    @FXML
    private Label lblOption2;
    @FXML
    private Label lblOption3;
    @FXML
    private Label lblTime;
    @FXML
    private Label lblEnergy;
    @FXML
    private Label lblMoney;
    @FXML
    private TextArea logbook;
    //endregions

    //region Button Methods
    @FXML
    public void executeOption1() {
        executeOption(0);
    }

    @FXML
    public void executeOption2() {
        executeOption(1);
    }

    @FXML
    public void executeOption3() {
        executeOption(2);
    }
    //endregion

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
        loadUiValues(currentOptionSet);
    }

    //endregion
    //region map initialisation
    private void fillMap() {
        gameOptions.put("Food", ActionBuilder.getFoodActions());
        gameOptions.put("Decoration", ActionBuilder.getDecoActions());
        gameOptions.put("Activity", ActionBuilder.getActivityActions());
    }
    //endregion

    private void loadUiValues(int currentOptionSet) {
        lblTime.setText(String.valueOf(getResourceManagerInstance().getTime()));
        lblMoney.setText(String.valueOf(getResourceManagerInstance().getMoney()));
        lblEnergy.setText(String.valueOf(getResourceManagerInstance().getEnergy()));
        switch (currentOptionSet) {
            case 0:
                setOptionSet(FOOD_CATEGORY_KEY);
                break;
            case 1:
                setOptionSet(DECO_CATEGORY_KEY);
                break;
            case 2:
                setOptionSet(ACTIVITY_CATEGORY_KEY);
                break;
            default: {
                getScoreManagerInstance().setRemainingEnergy(getResourceManagerInstance().getEnergy());
                getScoreManagerInstance().setRemainingMoney(getResourceManagerInstance().getMoney());
                getScoreManagerInstance().setRemainingTime(getResourceManagerInstance().getTime());
                getScoreManagerInstance().calculateScoreTotal();
                logbook.appendText("YOU WIN " + getScoreManagerInstance().getScoreTotal() + " Points");
            }
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

        //button 1
        btnOption1.setText(gameOptions.get(categoryKey).get(0).getName());
        lblOption1.setText(createCostForOptionText(
                gameOptions.get(categoryKey).get(0).getCostInMinutes(),
                gameOptions.get(categoryKey).get(0).getChangeToEnergyLevel(),
                gameOptions.get(categoryKey).get(0).getCostInEuro()
        ));
        disableInvalidOptions(1,
                gameOptions.get(categoryKey).get(0).getCostInMinutes(),
                gameOptions.get(categoryKey).get(0).getChangeToEnergyLevel(),
                gameOptions.get(categoryKey).get(0).getCostInEuro());

        //button 2
        btnOption2.setText(gameOptions.get(categoryKey).get(1).getName());
        lblOption2.setText(createCostForOptionText(
                gameOptions.get(categoryKey).get(1).getCostInMinutes(),
                gameOptions.get(categoryKey).get(1).getChangeToEnergyLevel(),
                gameOptions.get(categoryKey).get(1).getCostInEuro()
        ));
        disableInvalidOptions(2,
                gameOptions.get(categoryKey).get(1).getCostInMinutes(),
                gameOptions.get(categoryKey).get(1).getChangeToEnergyLevel(),
                gameOptions.get(categoryKey).get(1).getCostInEuro());

        //button 3
        btnOption3.setText(gameOptions.get(categoryKey).get(2).getName());
        lblOption3.setText(createCostForOptionText(
                gameOptions.get(categoryKey).get(2).getCostInMinutes(),
                gameOptions.get(categoryKey).get(2).getChangeToEnergyLevel(),
                gameOptions.get(categoryKey).get(2).getCostInEuro()
        ));
        disableInvalidOptions(3,
                gameOptions.get(categoryKey).get(2).getCostInMinutes(),
                gameOptions.get(categoryKey).get(2).getChangeToEnergyLevel(),
                gameOptions.get(categoryKey).get(2).getCostInEuro());
    }

    private void executeOption(int index) {
        switch (currentOptionSet) {
            case 0:
                handleOptionSelection(FOOD_CATEGORY_KEY, index);
                break;
            case 1:
                handleOptionSelection(DECO_CATEGORY_KEY, index);
                break;
            case 2:
                handleOptionSelection(ACTIVITY_CATEGORY_KEY, index);
                break;
            default: {

            }
        }
        currentOptionSet++;
        loadUiValues(currentOptionSet);
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
    private void disableInvalidOptions(int optionNumber, int time, int energy, int money) {
        if (!ResourceManager.areResourcesEnough(time, energy, money)) {
            switch (optionNumber) {
                case 1:
                    btnOption1.setDisable(true);
                    break;

                case 2:
                    btnOption2.setDisable(true);
                    break;

                case 3:
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
