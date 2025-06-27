package en.cembers.preparetoparty.gui;

import en.cembers.preparetoparty.logic.ActionBuilder;
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
    private static final String CHOOSE_FOOD_CATEGORY = "Choose Food";
    private static final String CHOOSE_DECO_CATEGORY = "Choose Decoration";
    private static final String CHOOSE_ACTIVITY_CATEGORY = "Choose Activity";

    private static final String FOOD_CATEGORY_KEY = "Food";
    private static final String DECO_CATEGORY_KEY = "Deco";
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
        gameOptions.put("Deco", ActionBuilder.getDecoActions());
        gameOptions.put("Activity", ActionBuilder.getActivityActions());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillMap();
        loadUiValues(currentOptionSet);
    }

    private void loadUiValues(int currentOptionSet) {
        switch (currentOptionSet) {
            case 0:
                setOptionSet1();
                break;
            case 1:
                setOptionSet2();
                break;
            case 2:
                setOptionSet3();
                break;
            default: {
                ScoreManager.calculateScoreTotal();
                logbook.appendText("YOU WIN "+ ScoreManager.getScoreTotal() + " Points"); //todo add actual score
            }
        }
    }

    private void setOptionSet1() {
        if (currentOptionSet == 0) {
            lblChooseCategory.setText(CHOOSE_FOOD_CATEGORY);
            btnOption1.setText(gameOptions.get(FOOD_CATEGORY_KEY).get(0).getName());
            lblOption1.setText(createCostForOptionText(
                    gameOptions.get(FOOD_CATEGORY_KEY).get(0).getCostInMinutes(),
                    gameOptions.get(FOOD_CATEGORY_KEY).get(0).getChangeToEnergyLevel(),
                    gameOptions.get(FOOD_CATEGORY_KEY).get(0).getCostInEuro()
            ));
            btnOption2.setText(gameOptions.get(FOOD_CATEGORY_KEY).get(1).getName());
            lblOption2.setText(createCostForOptionText(
                    gameOptions.get(FOOD_CATEGORY_KEY).get(1).getCostInMinutes(),
                    gameOptions.get(FOOD_CATEGORY_KEY).get(1).getChangeToEnergyLevel(),
                    gameOptions.get(FOOD_CATEGORY_KEY).get(1).getCostInEuro()
            ));

            btnOption3.setText(gameOptions.get(FOOD_CATEGORY_KEY).get(2).getName());
            lblOption3.setText(createCostForOptionText(
                    gameOptions.get(FOOD_CATEGORY_KEY).get(2).getCostInMinutes(),
                    gameOptions.get(FOOD_CATEGORY_KEY).get(2).getChangeToEnergyLevel(),
                    gameOptions.get(FOOD_CATEGORY_KEY).get(2).getCostInEuro()
            ));

//todo hardcodierung flexibel gestalten, z.b. auslagerung als konstanten
        } else {
            //todo throw exception and write error into console
        }
    }

    private void setOptionSet2() {
        if (currentOptionSet == 1) {
            lblChooseCategory.setText(CHOOSE_DECO_CATEGORY);
            btnOption1.setText(gameOptions.get(DECO_CATEGORY_KEY).get(0).getName());
            lblOption1.setText(createCostForOptionText(
                    gameOptions.get(DECO_CATEGORY_KEY).get(0).getCostInMinutes(),
                    gameOptions.get(DECO_CATEGORY_KEY).get(0).getChangeToEnergyLevel(),
                    gameOptions.get(DECO_CATEGORY_KEY).get(0).getCostInEuro()
            ));
            btnOption2.setText(gameOptions.get(DECO_CATEGORY_KEY).get(1).getName());
            lblOption2.setText(createCostForOptionText(
                    gameOptions.get(DECO_CATEGORY_KEY).get(1).getCostInMinutes(),
                    gameOptions.get(DECO_CATEGORY_KEY).get(1).getChangeToEnergyLevel(),
                    gameOptions.get(DECO_CATEGORY_KEY).get(1).getCostInEuro()
            ));

            btnOption3.setText(gameOptions.get(DECO_CATEGORY_KEY).get(2).getName());
            lblOption3.setText(createCostForOptionText(
                    gameOptions.get(DECO_CATEGORY_KEY).get(2).getCostInMinutes(),
                    gameOptions.get(DECO_CATEGORY_KEY).get(2).getChangeToEnergyLevel(),
                    gameOptions.get(DECO_CATEGORY_KEY).get(2).getCostInEuro()
            ));
//todo hardcodierung flexibel gestalten, z.b. auslagerung als konstanten
        } else {
            //todo throw exception and write error into console
        }
    }

    private void setOptionSet3() {
        if (currentOptionSet == 2) {
            lblChooseCategory.setText(CHOOSE_ACTIVITY_CATEGORY);
            btnOption1.setText(gameOptions.get(ACTIVITY_CATEGORY_KEY).get(0).getName());
            lblOption1.setText(createCostForOptionText(
                    gameOptions.get(ACTIVITY_CATEGORY_KEY).get(0).getCostInMinutes(),
                    gameOptions.get(ACTIVITY_CATEGORY_KEY).get(0).getChangeToEnergyLevel(),
                    gameOptions.get(ACTIVITY_CATEGORY_KEY).get(0).getCostInEuro()
            ));
            btnOption2.setText(gameOptions.get(ACTIVITY_CATEGORY_KEY).get(1).getName());
            lblOption2.setText(createCostForOptionText(
                    gameOptions.get(ACTIVITY_CATEGORY_KEY).get(1).getCostInMinutes(),
                    gameOptions.get(ACTIVITY_CATEGORY_KEY).get(1).getChangeToEnergyLevel(),
                    gameOptions.get(ACTIVITY_CATEGORY_KEY).get(1).getCostInEuro()
            ));

            btnOption3.setText(gameOptions.get(ACTIVITY_CATEGORY_KEY).get(2).getName());
            lblOption3.setText(createCostForOptionText(
                    gameOptions.get(ACTIVITY_CATEGORY_KEY).get(2).getCostInMinutes(),
                    gameOptions.get(ACTIVITY_CATEGORY_KEY).get(2).getChangeToEnergyLevel(),
                    gameOptions.get(ACTIVITY_CATEGORY_KEY).get(2).getCostInEuro()
            ));
//todo hardcodierung flexibel gestalten, z.b. auslagerung als konstanten
        } else {
            //todo throw exception and write error into console
        }
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

    private void handleOptionSelection(String categoryKey, int index) {
        logbook.appendText(gameOptions.get(categoryKey).get(index).getDescriptionForTextLog()+"\n");
        ScoreManager.addScoreForActions(gameOptions.get(categoryKey).get(index).getPointValue());
    }

    private String createCostForOptionText(int time, int energy, int money) {
        return "Time cost: " + time + " Energy cost: " + energy + " Price : " + money + "€";
    }
}
