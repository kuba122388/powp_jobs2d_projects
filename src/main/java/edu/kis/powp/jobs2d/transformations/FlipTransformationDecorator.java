package edu.kis.powp.jobs2d.transformations;
import edu.kis.powp.jobs2d.Job2dDriver;

public class FlipTransformationDecorator implements PointTransformation {
    private final boolean flipHorizontal;
    private final boolean flipVertical;

    public FlipTransformationDecorator(boolean flipHorizontal, boolean flipVertical) {
        this.flipHorizontal = flipHorizontal;
        this.flipVertical = flipVertical;
    }

    @Override
    public int[] transformation(int x, int y) {
        int newX = flipHorizontal ? -x : x;
        int newY = flipVertical ? -y : y;
        return new int[] { newX, newY };
    }
}