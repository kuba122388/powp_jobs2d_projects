package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import java.util.logging.Logger;

public class DriverMonitoringDecorator implements Job2dDriver {
    protected final Job2dDriver driver;
    private int headDistance = 0;
    private int opDistance = 0;
    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private int currentX = 0;
    private int currentY = 0;


    public DriverMonitoringDecorator(Job2dDriver driver) {
        this.driver = driver;
    }

    @Override
    public void setPosition(int x, int y) {
        int distance = calculateDistance(currentX, currentY, x, y);
        headDistance += distance;
        logger.info("Set position to (" + x + ", " + y + ")\n   head distance = " + headDistance + "\n   op. distance = " + opDistance);
        currentX = x;
        currentY = y;
        driver.setPosition(x, y);
    }

    @Override
    public void operateTo(int x, int y) {
        int distance = calculateDistance(currentX, currentY, x, y);
        headDistance += distance;
        opDistance += distance;
        logger.info("Operate to (" + x + ", " + y + ")\n   head distance = " + headDistance + "\n   op. distance = " + opDistance);
        currentX = x;
        currentY = y;
        driver.operateTo(x, y);
    }

    private int calculateDistance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

}
