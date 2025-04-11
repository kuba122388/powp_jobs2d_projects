package edu.kis.powp.jobs2d.transformations;
import edu.kis.powp.jobs2d.Job2dDriver;

public abstract class TransformationDecorator implements Job2dDriver {
    protected final Job2dDriver driver;
    public TransformationDecorator(Job2dDriver driver) {
        this.driver = driver;
    }

    protected abstract int[] transformation(int x, int y);

    @Override
    public void setPosition(int x, int y) {
        int[] transformed = transformation(x, y);
        driver.setPosition(transformed[0], transformed[1]);
    }

    @Override
    public void operateTo(int x, int y) {
        int[] transformed = transformation(x, y);
        driver.operateTo(transformed[0], transformed[1]);
    }
}