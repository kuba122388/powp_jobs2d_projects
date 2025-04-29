package edu.kis.powp.jobs2d.drivers.canva.shapes;

import edu.kis.powp.jobs2d.Job2dDriver;

public interface CanvaShape {
    boolean contains(int x, int y);
    int[] clipLine(int startX, int startY, int endX, int endY);
    void draw(Job2dDriver driver);
}