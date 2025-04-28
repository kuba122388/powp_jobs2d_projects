package edu.kis.powp.jobs2d.drivers.canva.shapes;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CircularCanva implements CanvaShape {
    private final int radius;

    public CircularCanva(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw(Job2dDriver driver) {
        int steps = 17; // liczba punktów wykorzystywanych do przybliżenia okręgu
        double angleStep = 2 * Math.PI / steps;

        // Ustalenie początkowego położenia na okręgu (punkt na osi x)
        driver.setPosition(radius, 0);
        for (int i = 1; i <= steps; i++) {
            double angle = angleStep * i;
            int x = (int) Math.round(Math.cos(angle) * radius);
            int y = (int) Math.round(Math.sin(angle) * radius);
            driver.operateTo(x, y);
        }
    }
}
