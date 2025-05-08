package edu.kis.powp.jobs2d.transformations;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ScaleTransformationDecorator implements PointTransformation {
    private final double scaleX;
    private final double scaleY;

    public ScaleTransformationDecorator(double scaleX, double scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    @Override
    public int[] transformation(int x, int y) {
        int newX = (int) Math.round(scaleX * x);
        int newY = (int) Math.round(scaleY * y);
        return new int[] { newX, newY };
    }
}