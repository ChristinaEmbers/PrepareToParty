package en.cembers.preparetoparty.logic;

import en.cembers.preparetoparty.model.Action;

import java.util.ArrayList;

/**
 * The purpose of this class is to create the Action objects, that will be used in this game.
 * It will return Arrays containing 3 Actions to the Game Controller. Each array being a group of food actions/deco actions or activity actions
 */
public class ActionBuilder {

    private static final ArrayList<Action> FOOD_ACTIONS = new ArrayList<Action>();
    private static final ArrayList<Action> DECO_ACTIONS = new ArrayList<Action>();
    private static final ArrayList<Action> ACTIVITY_ACTIONS = new ArrayList<Action>();

    static {
        // Food Actions
        FOOD_ACTIONS.add(new Action(
                "Simple Sandwiches",
                "You quickly prepare some simple sandwiches. It’s not fancy, but it works.",
                30, 20, 6, 5));

        FOOD_ACTIONS.add(new Action(
                "Catering Service",
                "You order professional catering. Convenient, but pricey.",
                20, 5, 9, 50));

        FOOD_ACTIONS.add(new Action(
                "Home Cooked Meal",
                "You decide to make a home cooked meal, delicious, but a lot of work.",
                120, 40, 13, 20));

        // Decoration Actions
        DECO_ACTIONS.add(new Action(
                "Minimal Decorations",
                "You put up a few decorations from last year.",
                15, 5, 5, 2));

        DECO_ACTIONS.add(new Action(
                "Colorful Banners",
                "You hang colorful banners and streamers across the room.",
                45, 15, 8, 8));

        DECO_ACTIONS.add(new Action(
                "Themed Setup",
                "You create a fully themed setup with lights, tablecloths and more.",
                90, 30, 20, 30));

        // Activity Actions
        ACTIVITY_ACTIONS.add(new Action(
                "Lounge Music",
                "You play some relaxed background music. Low effort, decent effect.",
                10, 5, 4, 0));

        ACTIVITY_ACTIONS.add(new Action(
                "Board Games",
                "You set up a variety of board games for guests to enjoy.",
                20, 20, 9, 20));

        ACTIVITY_ACTIONS.add(new Action(
                "Karaoke Night",
                "You organize a karaoke night. It’s loud, fun, and unforgettable.",
                120, 40, 14, 30));
    }

    public static ArrayList<Action> getFoodActions() {
        return FOOD_ACTIONS;
    }

    public static ArrayList<Action> getDecoActions() {
        return DECO_ACTIONS;
    }

    public static ArrayList<Action> getActivityActions() {
        return ACTIVITY_ACTIONS;
    }
}
