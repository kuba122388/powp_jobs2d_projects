package edu.kis.powp.jobs2d.transformations;

import edu.kis.powp.jobs2d.Job2dDriver;

public class TranslateTransformationDecorator extends TransformationDecorator {
    private final double translateX;
    private final double translateY;

    public TranslateTransformationDecorator(Job2dDriver driver, double translateX, double translateY) {
        super(driver);
        this.translateX = translateX;
        this.translateY = translateY;
    }

    @Override
    protected int[] transformation(int x, int y) {
        int newX = (int) Math.round(x + translateX);
        int newY = (int) Math.round(y + translateY);
        return new int[] { newX, newY };
    }
}
