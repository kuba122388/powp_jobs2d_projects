package edu.kis.powp.jobs2d.drivers.canva;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.canva.shapes.CanvaShape;


public class WorkspaceDriver {
    private final CanvaShape bound;

    
    public WorkspaceDriver(CanvaShape bound) {
        this.bound = bound;
    }

    public CanvaShape getBound() {
        return bound;
    }
}
