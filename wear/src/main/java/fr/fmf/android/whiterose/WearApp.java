package fr.fmf.android.whiterose;

import android.app.Application;

/**
 * Created by fredericfalliere on 01/08/2017.
 */

public class WearApp extends Application {

    private ServiceFacade serviceFacade;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public ServiceFacade serviceFacade() {
        if (serviceFacade == null) {
            serviceFacade = new ServiceFacade();
        }
        return serviceFacade;
    }
}
