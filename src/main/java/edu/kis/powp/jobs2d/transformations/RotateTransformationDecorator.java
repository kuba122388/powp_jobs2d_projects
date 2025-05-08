package edu.kis.powp.jobs2d.transformations;
import edu.kis.powp.jobs2d.Job2dDriver;

public class RotateTransformationDecorator implements PointTransformation {
    private final double cos, sin;

    public RotateTransformationDecorator(double degrees) {
        double radians = Math.toRadians(degrees);
        this.cos = Math.cos(radians);
        this.sin = Math.sin(radians);
    }

    @Override
    public int[] transformation(int x, int y) {
        return new int[]{
                (int) Math.round(x * cos - y * sin),
                (int) Math.round(x * sin + y * cos)
        };
    }
}