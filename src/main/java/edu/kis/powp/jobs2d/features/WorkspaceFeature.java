package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;

import edu.kis.powp.jobs2d.drivers.SelectWorkspaceMenuOptionListener;
import edu.kis.powp.jobs2d.drivers.WorkspaceManager;
import edu.kis.powp.jobs2d.drivers.canva.shapes.CanvaShape;

public class WorkspaceFeature {
    private static Application app;
    private static WorkspaceManager workspaceManager = new WorkspaceManager();

    public static void setupWorkspacePlugin(Application application) {
        app = application;
        app.addComponentMenu(WorkspaceFeature.class, "Workspaces");
    }

    public WorkspaceManager getWorkspaceManager() { return workspaceManager; }

    public static void addWorkspaceShape(String name, CanvaShape shape) {
        SelectWorkspaceMenuOptionListener listener = new SelectWorkspaceMenuOptionListener(shape, workspaceManager);
        app.addComponentMenuElement(WorkspaceFeature.class, name, listener);
    }
}
