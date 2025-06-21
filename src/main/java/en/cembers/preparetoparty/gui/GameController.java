package en.cembers.preparetoparty.gui;

import en.cembers.preparetoparty.logic.ActionBuilder;
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


    public static final int CURRENT_OPTION_SET = 0;
    private Map<String, ArrayList<Action>> gameOptions = new HashMap<>();

    private void fillMap() {
        gameOptions.put("Food", ActionBuilder.getFoodActions());
        gameOptions.put("Deco", ActionBuilder.getDecoActions());
        gameOptions.put("Activity", ActionBuilder.getActivityActions());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillMap();
        setOptionSet1();
    }

    private void setOptionSet1() {
        if (CURRENT_OPTION_SET == 0) {
            lblChooseCategory.setText(CHOOSE_FOOD_CATEGORY);
            btnOption1.setText(gameOptions.get(FOOD_CATEGORY_KEY).get(0).getName());
            btnOption2.setText(gameOptions.get(FOOD_CATEGORY_KEY).get(1).getName());
            btnOption3.setText(gameOptions.get(FOOD_CATEGORY_KEY).get(2).getName());
           // lblOption1.setText(gameOptions.get(FOOD_CATEGORY_KEY).get(0).getDescriptionForTextLog());
            //lblOption2;
            //lblOption3;

        } else {
            //todo throw exception and write error into console
        }
    }

    private void setOptionSet2() {
    }

    private void setOptionSet3() {
    }
@FXML
    public void executeOption1(){}
    @FXML
    public void executeOption2(){}
    @FXML
    public void executeOption3(){}


}
