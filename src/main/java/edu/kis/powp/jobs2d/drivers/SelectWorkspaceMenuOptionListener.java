package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.canva.WorkspaceDriver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectWorkspaceMenuOptionListener implements ActionListener {
    private DriverManager driverManager;
    private Job2dDriver driver = null;
    private WorkspaceDriver canvas = null;

    public SelectWorkspaceMenuOptionListener(WorkspaceDriver canva, DriverManager driverManager) {
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
