package edu.kis.powp.jobs2d.drivers.canva.shapes;

import edu.kis.powp.jobs2d.Job2dDriver;

public class RectangleCanva implements CanvaShape {
    private final int width, height;

    public RectangleCanva(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Job2dDriver driver) {
        int halfWidth = width / 2;
        int halfHeight = height / 2;

        driver.setPosition(-halfWidth, -halfHeight);
        driver.operateTo(halfWidth, -halfHeight);
        driver.operateTo(halfWidth, halfHeight);
        driver.operateTo(-halfWidth, halfHeight);
        driver.operateTo(-halfWidth, -halfHeight);
    }
}
