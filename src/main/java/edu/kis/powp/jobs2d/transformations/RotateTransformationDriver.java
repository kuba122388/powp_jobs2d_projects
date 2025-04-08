package edu.kis.powp.jobs2d.transformations;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.jobs2d.drivers.TransformationDriver;

public class RotateTransformationDriver extends TransformationDriver {
    private final double cos, sin;

    public RotateTransformationDriver(DrawPanelController drawPanelController, double degrees) {
        super(drawPanelController);
        double radians = Math.toRadians(degrees);
        this.cos = Math.cos(radians);
        this.sin = Math.sin(radians);
    }

    @Override
    protected int[] applyTransformations(int x, int y) {
        return new int[]{
                (int) Math.round(x * cos - y * sin),
                (int) Math.round(x * sin + y * cos)
        };
    }
}