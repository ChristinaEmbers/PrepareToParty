package en.cembers.preparetoparty.logic;

import en.cembers.preparetoparty.model.Resource;

/**
 * This class manages the resources in the Resource class and makes changes to the values based on Actions taken by the user
 */
public class ResourceController {

    private static Resource instance;

    //region getInstance
    public static synchronized Resource getInstance() {

        if (instance == null) {
            instance = new Resource();
        }

        return instance;

    }
    //endregion
}
