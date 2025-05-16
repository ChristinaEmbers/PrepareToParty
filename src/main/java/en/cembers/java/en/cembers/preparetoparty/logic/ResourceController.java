package en.cembers.preparetoparty.logic;

import en.cembers.preparetoparty.model.Resource;

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
