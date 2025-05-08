package edu.kis.powp.jobs2d.drivers;
import edu.kis.powp.jobs2d.Job2dDriver;

public class CoordinateExtractingDriver implements Job2dDriver {
    private int x, y;

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void operateTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getLastPosition() {
        return new int[] { x, y };
    }
}
