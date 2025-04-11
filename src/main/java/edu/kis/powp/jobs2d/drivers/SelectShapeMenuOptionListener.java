package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.canva.MyCanva;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectShapeMenuOptionListener  implements ActionListener {
    private DriverManager driverManager;
    private Job2dDriver driver = null;
    private MyCanva canvas = null;

    public SelectShapeMenuOptionListener(MyCanva canva, DriverManager driverManager) {
        this.driverManager = driverManager;
        this.driver = canva;
        this.canvas = canva;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        driverManager.setCurrentDriver(driver);
        this.canvas.drawWorkspaceBoundary();
    }
}
