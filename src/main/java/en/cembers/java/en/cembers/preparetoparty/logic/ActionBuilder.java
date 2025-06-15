package en.cembers.preparetoparty.logic;

import en.cembers.preparetoparty.model.Action;

import java.util.ArrayList;

/**
 * The purpose of this class is to create the Action objects, that will be used in this game.
 * It will return Arrays containing 3 Actions to the Game Controller. Each array being a group of food actions/deco actions or activity actions
 */
public class ActionBuilder {

public static ArrayList<Action> foodActions= new ArrayList<Action>();
public static ArrayList<Action> decoActions= new ArrayList<Action>();
public static ArrayList<Action> activityActions= new ArrayList<Action>();


    //region Food Actions
   private Action food1 = new Action(
            "Simple Sandwiches",
            "You quickly prepare some simple sandwiches. It’s not fancy, but it works.",
            30,
            20,
            6,
            5);

    private Action food2 = new Action(
            "Catering Service",
            "You order professional catering. Convenient, but pricey.",
            20,
            5,
            9,
            50);

    private Action food3 = new Action(
            "Home Cooked Meal",
            "You decide to make a home cooked meal, delicious, but a lot of work.",
            120,
            40,
            13,
            20);
    //endregion

    //region Decoration
    private Action decor1 = new Action(
            "Minimal Decorations",
            "You put up a few decorations from last year.",
            15,
            5,
            5,
            2);

    private Action decor2 = new Action(
            "Colorful Banners",
            "You hang colorful banners and streamers across the room.",
            45,
            15,
            8,
            8);

    private Action decor3 = new Action(
            "Themed Setup",
            "You create a fully themed setup with lights, tablecloths and more.",
            90,
            30,
            20,
            30);

    //endregion

    //region Activities
    private Action activity1 = new Action(
            "Lounge Music",
            "You play some relaxed background music. Low effort, decent effect.",
            10,
            5,
            4,
            0);

    private Action activity2 = new Action(
            "Board Games",
            "You set up a variety of board games for guests to enjoy.",
            20,
            20,
            9,
            20);

    private Action activity3 = new Action(
            "Karaoke Night",
            "You organize a karaoke night. It’s loud, fun, and unforgettable.",
            120,
            40,
            14,
            30);

    //endregion


    private void fillArrayLists()
    {
        foodActions.add(food1);
        foodActions.add(food2);
        foodActions.add(food3);

        decoActions.add(decor1);
        decoActions.add(decor2);
        decoActions.add(decor3);

        activityActions.add(activity1);
        activityActions.add(activity2);
        activityActions.add(activity3);
    }

    public ArrayList<Action> getFoodActions()
    {
        //todo refactoring nötig, wenn dies mehr als einmal aufgerufen wird, z.b. durch replay button
        //oder wenn food nicht als erstes aufgerufen wird
        fillArrayLists();
        return foodActions;}

    public ArrayList<Action> getDecoActions() {
        return decoActions;
    }

    public  ArrayList<Action> getActivityActions() {
        return activityActions;
    }
}
