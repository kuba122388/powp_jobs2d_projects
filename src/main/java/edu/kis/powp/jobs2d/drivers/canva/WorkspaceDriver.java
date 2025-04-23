package edu.kis.powp.jobs2d.drivers.canva;

import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDriverAdapter;
import edu.kis.powp.jobs2d.drivers.canva.shapes.CanvaShape;
import edu.kis.powp.jobs2d.features.DrawerFeature;


public class WorkspaceDriver implements Job2dDriver {
    private final Job2dDriver innerDriver;

    private final Job2dDriver borderDriver;

    private int currentX,  currentY;
    private CanvaShape bound;

    
    public WorkspaceDriver(Job2dDriver innerDriver, CanvaShape bound) {
        this.innerDriver = innerDriver;
        this.bound = bound;

        this.borderDriver = new LineDriverAdapter(DrawerFeature.getDrawerController(), LineFactory.getDottedLine(), "border");
    }

    @Override
    public void setPosition(int x, int y) {
        if ( innerDriver == null )
            return;
        int[] clipped = clipPointToBounds(x, y);
        currentX = clipped[0];
        currentY = clipped[1];
        innerDriver.setPosition(currentX,  currentY);
    }

    @Override
    public void operateTo(int x, int y) {
        if ( innerDriver == null )
            return;
        int[] clipped = bound.clipLine(currentX,  currentY, x, y);
        currentX = clipped[0];
        currentY = clipped[1];
        innerDriver.operateTo(currentX,  currentY);
    }

    public void drawWorkspaceBoundary() {
        bound.draw(borderDriver);
    }


    private int[] clipPointToBounds(int x, int y) {
        if (bound.contains(x, y)) {
            return new int[]{x, y};
        } else {
            return bound.clipLine(currentX,  currentY, x, y);
        }
    }

}
