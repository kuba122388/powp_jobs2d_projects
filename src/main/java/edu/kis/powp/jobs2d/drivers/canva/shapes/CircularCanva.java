package edu.kis.powp.jobs2d.drivers.canva.shapes;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CircularCanva implements CanvaShape {
    private final int radius;

    public CircularCanva(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean contains(int x, int y) {
        // Sprawdzenie czy punkt (x, y) znajduje się wewnątrz okręgu o promieniu radius
        return (x * x + y * y) <= (radius * radius);
    }

    @Override
    public int[] clipLine(int startX, int startY, int endX, int endY) {
        final int steps = 100;
        double dx = (endX - startX) / (double) steps;
        double dy = (endY - startY) / (double) steps;

        int clippedX = startX;
        int clippedY = startY;

        // Iteracyjnie poszukujemy punktu przecięcia odcinka z okręgiem
        for (int i = 1; i <= steps; i++) {
            int cx = (int) Math.round(startX + dx * i);
            int cy = (int) Math.round(startY + dy * i);
            if (!contains(cx, cy)) {
                break;
            }
            clippedX = cx;
            clippedY = cy;
        }

        return new int[]{clippedX, clippedY};
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
