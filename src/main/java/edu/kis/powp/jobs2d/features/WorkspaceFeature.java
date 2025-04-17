package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;

import edu.kis.powp.jobs2d.drivers.SelectWorkspaceMenuOptionListener;
import edu.kis.powp.jobs2d.drivers.canva.WorkspaceCanva;
import edu.kis.powp.jobs2d.drivers.observers.DriverLabelChangeObserver;

public class WorkspaceFeature {
    private static Application app;

    public static void setupWorkspacePlugin(Application application) {
        app = application;
        app.addComponentMenu(WorkspaceFeature.class, "Workspaces");

        DriverLabelChangeObserver driverLabelChangeObserver = new DriverLabelChangeObserver(application);
        DriverFeature.getDriverManager().getChangePublisher().addSubscriber(driverLabelChangeObserver);
    }


    public static void addWorkspaceShape(String name, WorkspaceCanva canvas) {
        SelectWorkspaceMenuOptionListener listener = new SelectWorkspaceMenuOptionListener(canvas, DriverFeature.getDriverManager() );
        app.addComponentMenuElement(WorkspaceFeature.class, name, listener);
    }
}
