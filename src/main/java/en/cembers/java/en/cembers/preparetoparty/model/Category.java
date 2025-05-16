package en.cembers.preparetoparty.model;

import java.util.ArrayList;

/**
 * This class is the data model for the categories food, decoration and activities, which contain the corresponding actions
 */
public class Category {
    //todo implement checks in case the lists are empty or anything is wrong with the data
    //todo find the right place and add a method to fill the lists with the corresponding actions
    //namely all actions that have the corresponding category name
    //perhaps i need a list with all actions
    private ArrayList<Action> food;
    private ArrayList<Action> decoration;
    private ArrayList<Action> activities;


    public ArrayList<Action> getFood() {
        return food;
    }

    public void setFood(ArrayList<Action> food) {
        this.food = food;
    }

    public ArrayList<Action> getDecoration() {
        return decoration;
    }

    public void setDecoration(ArrayList<Action> decoration) {
        this.decoration = decoration;
    }

    public ArrayList<Action> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Action> activities) {
        this.activities = activities;
    }
}
