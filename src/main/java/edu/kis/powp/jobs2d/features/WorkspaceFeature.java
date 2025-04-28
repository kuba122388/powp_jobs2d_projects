package edu.kis.powp.jobs2d.features;

import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.appbase.Application;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.SelectWorkspaceMenuOptionListener;
import edu.kis.powp.jobs2d.drivers.adapter.LineDriverAdapter;
import edu.kis.powp.jobs2d.drivers.canva.WorkspaceDriver;

public class WorkspaceFeature {
    private static Application app;
    private static Job2dDriver borderDriver;

    public static void setupWorkspacePlugin(Application application) {
        app = application;
        app.addComponentMenu(WorkspaceFeature.class, "Workspaces");
        borderDriver = new LineDriverAdapter(DrawerFeature.getDrawerController(), LineFactory.getDottedLine(), "border");
    }


    public static void addWorkspaceShape(String name, WorkspaceDriver canvas) {
        SelectWorkspaceMenuOptionListener listener = new SelectWorkspaceMenuOptionListener(canvas, borderDriver);
        app.addComponentMenuElement(WorkspaceFeature.class, name, listener);
    }
}
