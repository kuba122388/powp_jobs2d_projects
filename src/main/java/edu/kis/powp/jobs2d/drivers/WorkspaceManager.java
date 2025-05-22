package edu.kis.powp.jobs2d.drivers;

import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDriverAdapter;
import edu.kis.powp.jobs2d.canva.shapes.CanvaShape;
import edu.kis.powp.jobs2d.features.DrawerFeature;
/**
 * Manages the current drawing workspace by handling the canvas shape and its visual representation.
 * <p>
 * This class allows setting a {@link CanvaShape} to represent the workspace area,
 * and automatically renders its border using a special {@link Job2dDriver}.
 */
public class WorkspaceManager implements Job2dDriver {
    private CanvaShape currentCanvaShape;
    private final Job2dDriver borderDriver;
    private boolean orClipeLine;
    private static Job2dDriver innerDriver;

    private int currentX,  currentY;

    /**
     * Constructs a new {@code WorkspaceManager} with a preconfigured border drawing driver.
     * <p>
     * The border driver uses a dotted line and is labeled "border".
     */
    public WorkspaceManager(Job2dDriver innerDriver) {
        borderDriver = new LineDriverAdapter(
                DrawerFeature.getDrawerController(),
                LineFactory.getDottedLine(),
                "border"
        );

        WorkspaceManager.innerDriver = innerDriver;
    }

    public static void updateDriver(Job2dDriver newDriver) {
        innerDriver = newDriver;
    }

    public void changeLineClipeed() {
        this.orClipeLine = !this.orClipeLine;
    }

    /**
     * Sets the current workspace canvas shape and draws its border.
     * <p>
     * This method is synchronized to prevent concurrent modifications to the workspace shape.
     *
     * @param canvaShape the {@link CanvaShape} to be used as the current workspace area
     */
    public synchronized void setWorkspaceCanvaShape(CanvaShape canvaShape) {
        this.currentCanvaShape = canvaShape;
        canvaShape.draw(borderDriver);
    }

    /**
     * Returns the current canvas shape set for the workspace.
     *
     * @return the currently active {@link CanvaShape}, or {@code null} if none is set
     */
    public CanvaShape getCurrentCanvaShape() {
        return currentCanvaShape;
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
        int[] clipped;
        if( orClipeLine ) {
            clipped = clipPointToBounds(x, y);
        }
        else {
            clipped = new int[] {x, y};
        }

        currentX = clipped[0];
        currentY = clipped[1];
        innerDriver.operateTo(currentX,  currentY);
    }

    private int[] clipPointToBounds(int x, int y) {
        if (currentCanvaShape.contains(x, y)) {
            return new int[]{x, y};
        } else {
            return currentCanvaShape.clipLine(currentX,  currentY, x, y);
        }
    }
}
