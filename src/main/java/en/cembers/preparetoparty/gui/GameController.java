package en.cembers.preparetoparty.gui;

import en.cembers.preparetoparty.logic.ActionBuilder;
import en.cembers.preparetoparty.logic.ResourceController;
import en.cembers.preparetoparty.logic.ScoreManager;
import en.cembers.preparetoparty.model.Action;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.ArrayList;

/**
 * This class is responsible for UI interactions
 */
public class GameController implements Initializable {
    //region Constants

    private static final String FOOD_CATEGORY_KEY = "Food";
    private static final String DECO_CATEGORY_KEY = "Decoration";
    private static final String ACTIVITY_CATEGORY_KEY = "Activity";
    //endregions


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


    private static int currentOptionSet = 0;
    private Map<String, ArrayList<Action>> gameOptions = new HashMap<>();

    private void fillMap() {
        gameOptions.put("Food", ActionBuilder.getFoodActions());
        gameOptions.put("Decoration", ActionBuilder.getDecoActions());
        gameOptions.put("Activity", ActionBuilder.getActivityActions());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillMap();
        loadUiValues(currentOptionSet);
    }

    private void loadUiValues(int currentOptionSet) {
     //todo   disableInvalidOptions(currentOptionSet);
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
                ScoreManager.calculateScoreTotal();
                logbook.appendText("YOU WIN " + ScoreManager.getScoreTotal() + " Points"); //todo add actual score
            }
        }
    }

    private void disableInvalidOptions(int optionNumber, int time, int energy, int money) {
        if (!ResourceController.areResourcesEnough(time, energy, money)) {
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
        ScoreManager.addScoreForActions(gameOptions.get(categoryKey).get(selectedOption).getPointValue());
    }

    private String createCostForOptionText(int time, int energy, int money) {
        return "Time cost: " + time + " Energy cost: " + energy + " Price : " + money + "€";
    }
}
