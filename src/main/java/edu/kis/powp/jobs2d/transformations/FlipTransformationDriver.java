package edu.kis.powp.jobs2d.transformations;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.jobs2d.drivers.TransformationDriver;

public class FlipTransformationDriver extends TransformationDriver {
    private final boolean flipHorizontal;
    private final boolean flipVertical;

    public FlipTransformationDriver(DrawPanelController drawPanelController, boolean flipHorizontal, boolean flipVertical) {
        super(drawPanelController);
        this.flipHorizontal = flipHorizontal;
        this.flipVertical = flipVertical;
    }

    @Override
    protected int[] applyTransformations(int x, int y) {
        int newX = flipHorizontal ? -x : x;
        int newY = flipVertical ? -y : y;
        return new int[] { newX, newY };
    }
}