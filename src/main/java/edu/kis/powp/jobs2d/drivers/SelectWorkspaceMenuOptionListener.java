package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.drivers.canva.shapes.CanvaShape;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectWorkspaceMenuOptionListener implements ActionListener {
    private final CanvaShape shape;
    private WorkspaceManager workspaceManager;

    public SelectWorkspaceMenuOptionListener(CanvaShape shape, WorkspaceManager workspaceManager) {
        this.shape = shape;
        this.workspaceManager = workspaceManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) { workspaceManager.setWorkspaceCanvaShape(shape); }
}
