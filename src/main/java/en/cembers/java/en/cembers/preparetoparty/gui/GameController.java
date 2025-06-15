package en.cembers.preparetoparty.gui;

import en.cembers.preparetoparty.logic.ActionBuilder;
import en.cembers.preparetoparty.model.Action;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.ArrayList;

/**
 * This class is responsible for UI interactions
 */
public class GameController implements Initializable {
    public static final int CURRENT_OPTION_SET=0;
    private Map<String, ArrayList<Action>> gameOptions = new HashMap<>();

    private void fillMap()
    {
gameOptions.put("Food", ActionBuilder.getFoodActions());
gameOptions.put("Deco", ActionBuilder.getDecoActions());
gameOptions.put("Activity", ActionBuilder.getActivityActions());

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //todo initialisiere die map
        //array befüllen mit action
        //this map=new map mit string und array
        //todo factory/builder klasse, die 9 actions erstellt und mir 3 arrays zurückliefert
        //hat 1methode die anhand der option1 das jeweilige set zurückgibt
        //in builder klasse sind hardcodiert die aufrufe new Action(String diesistdername, String diesistdiebeschreibung etc)

        //schön wäre factory klasse die daten aus json datei bekommt und damit die actions erstellt
        //json controller startet factory klasse und gibt das zeug an game controller



//todo add option id
        //map im game controller. die map enthält 3 paare mit string und array paar
        //der array enthlt 3 actions
        //somit können daraus die daten geladen werden für die buttons
    }
}
