package edu.kis.powp.jobs2d.drivers;

import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDriverAdapter;
import edu.kis.powp.jobs2d.drivers.canva.WorkspaceDriver;
import edu.kis.powp.jobs2d.drivers.canva.shapes.CanvaShape;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class WorkspaceManager {
    private CanvaShape canvas;
    private final Job2dDriver borderDriver;

    public WorkspaceManager() {
        borderDriver = new LineDriverAdapter(DrawerFeature.getDrawerController(), LineFactory.getDottedLine(), "border");
    }

    public synchronized void setWorkspaceDriver(WorkspaceDriver workspaceDriver) {
        canvas = workspaceDriver.getBound();
        canvas.draw(borderDriver);
    }

    public CanvaShape getCanvas() { return canvas; }
}
