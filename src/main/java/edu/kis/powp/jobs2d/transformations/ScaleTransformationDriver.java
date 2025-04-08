package edu.kis.powp.jobs2d.transformations;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.jobs2d.drivers.TransformationDriver;

public class ScaleTransformationDriver extends TransformationDriver {
    private final double scaleX;
    private final double scaleY;

    public ScaleTransformationDriver(DrawPanelController drawPanelController, double scaleX, double scaleY) {
        super(drawPanelController);
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    @Override
    protected int[] applyTransformations(int x, int y) {
        int newX = (int) Math.round(scaleX * x);
        int newY = (int) Math.round(scaleY * y);
        return new int[] { newX, newY };
    }
}