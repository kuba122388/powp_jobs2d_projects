package edu.kis.powp.jobs2d.drivers.canva.shapes;

import edu.kis.powp.jobs2d.Job2dDriver;

public class RectangleCanva implements CanvaShape {
    private final int width, height;

    public RectangleCanva(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean contains(int x, int y) {
        int a = width / 2;
        int b = height / 2;
        return x >= -a && x <= a && y >= -b && y <= b;
    }

    @Override
    public int[] clipLine(int startX, int startY, int endX, int endY) {
        // Liang-Barsky algorytm, jak wcześniej
        double t0 = 0.0, t1 = 1.0;
        int dx = endX - startX, dy = endY - startY;
        int[] bounds = {-width / 2, width / 2, -height / 2, height / 2};
        double[] p = {-dx, dx, -dy, dy};
        double[] q = {startX - bounds[0], bounds[1] - startX, startY - bounds[2], bounds[3] - startY};

        for (int i = 0; i < 4; i++) {
            if (p[i] == 0 && q[i] < 0) return new int[]{startX, startY};
            double r = p[i] != 0 ? q[i] / p[i] : 0;
            if (p[i] < 0) t0 = Math.max(t0, r);
            if (p[i] > 0) t1 = Math.min(t1, r);
        }

        if (t0 > t1) return new int[]{startX, startY};
        return new int[]{
                (int)(startX + t1 * dx),
                (int)(startY + t1 * dy)
        };
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
