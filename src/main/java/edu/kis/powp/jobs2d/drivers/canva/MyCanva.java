package edu.kis.powp.jobs2d.drivers.canva;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDriverAdapter;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class MyCanva implements Job2dDriver {
    private final Job2dDriver innerDriver;
    private final int width;
    private final int height;

    private final Job2dDriver borderDriver;

    private int X, Y;

    public MyCanva(Job2dDriver innerDriver, int width, int height) {
        this.innerDriver = innerDriver;
        this.width = width;
        this.height = height;

        this.borderDriver = new LineDriverAdapter(DrawerFeature.getDrawerController(), LineFactory.getDottedLine(), "border");
    }

    @Override
    public void setPosition(int i, int j) {
        int[] clipped = clipPointToBounds(i, j);
        X = clipped[0];
        Y = clipped[1];
        innerDriver.setPosition(X, Y);
    }

    @Override
    public void operateTo(int i, int j) {
        int[] clipped = clipLineToBounds(X, Y, i, j);
        X = clipped[0];
        Y = clipped[1];
        innerDriver.operateTo(X, Y);
    }

    public void drawWorkspaceBoundary() {
        int halfWidth = width / 2;
        int halfHeight = height / 2;

        borderDriver.setPosition(-halfWidth, -halfHeight);
        borderDriver.operateTo(halfWidth, -halfHeight);
        borderDriver.operateTo(halfWidth, halfHeight);
        borderDriver.operateTo(-halfWidth, halfHeight);
        borderDriver.operateTo(-halfWidth, -halfHeight);
    }

    private boolean isInBounds(int x, int y) {
        int a = width / 2;
        int b = height / 2;
        return x >= (-a) && y >= -b && x <= a && y <= b;
    }

    private int[] clipPointToBounds(int x, int y) {
        int a = width / 2;
        int b = height / 2;
        int cx = Math.max(-a, Math.min(x, a));
        int cy = Math.max(-b, Math.min(y, b));
        return new int[]{cx, cy};
    }

    private int[] clipLineToBounds(int x0, int y0, int x1, int y1) {
        double t0 = 0.0;
        double t1 = 1.0;
        int dx = x1 - x0;
        int dy = y1 - y0;

        int[] bounds = {-width / 2, width / 2, -height / 2, height / 2};

        double[] p = {-dx, dx, -dy, dy};
        double[] q = {x0 - bounds[0], bounds[1] - x0, y0 - bounds[2], bounds[3] - y0};

        for (int i = 0; i < 4; i++) {
            if (p[i] == 0) {
                if (q[i] < 0) return new int[]{x0, y0}; // line is parallel and outside
            } else {
                double r = q[i] / p[i];
                if (p[i] < 0) {
                    t0 = Math.max(t0, r);
                } else {
                    t1 = Math.min(t1, r);
                }
            }
        }

        if (t0 > t1) return new int[]{x0, y0}; // line is outside

        int clippedX = (int) (x0 + t1 * dx);
        int clippedY = (int) (y0 + t1 * dy);
        return new int[]{clippedX, clippedY};
    }
}
