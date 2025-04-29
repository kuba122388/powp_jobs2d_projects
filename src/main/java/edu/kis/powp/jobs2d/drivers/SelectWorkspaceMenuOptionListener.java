package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.drivers.canva.WorkspaceDriver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectWorkspaceMenuOptionListener implements ActionListener {
    private final WorkspaceDriver canvas;
    private WorkspaceManager workspaceManager;

    public SelectWorkspaceMenuOptionListener(WorkspaceDriver canva, WorkspaceManager workspaceManager) {
        this.canvas = canva;
        this.workspaceManager = workspaceManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) { workspaceManager.setWorkspaceDriver(canvas); }
}
