package en.cembers.preparetoparty.logic;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is responsible for UI interactions
 */
public class GameController implements Initializable {
    public static final int CURRENT_OPTION_SET=0;

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
