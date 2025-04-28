package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.canva.WorkspaceDriver;
import edu.kis.powp.jobs2d.drivers.canva.shapes.CanvaShape;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectWorkspaceMenuOptionListener implements ActionListener {
    private final WorkspaceDriver canvas;
    private final Job2dDriver borderDriver;

    public SelectWorkspaceMenuOptionListener(WorkspaceDriver canva, Job2dDriver borderDriver) {
        this.canvas = canva;
        this.borderDriver = borderDriver;
    }

    public CanvaShape getCanvaShape() {
        return canvas.getBound();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CanvaShape bound = canvas.getBound();
        bound.draw(borderDriver);
    }
}
