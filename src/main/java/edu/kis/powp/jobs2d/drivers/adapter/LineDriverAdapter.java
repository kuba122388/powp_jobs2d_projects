package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.visitors.DriverVisitor;

/**
 * Line adapter - Job2dDriver with DrawPanelController object.
 */
public class LineDriverAdapter implements VisitableJob2dDriver {
    private ILine line;
    private int startX = 0, startY = 0;
    private String name;

    private DrawPanelController drawController;

    public LineDriverAdapter(DrawPanelController drawController, ILine line, String name) {
        super();
        this.drawController = drawController;
        this.line = line;
        this.name = name;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        line.setStartCoordinates(this.startX, this.startY);
        this.setPosition(x, y);
        line.setEndCoordinates(x, y);

        drawController.drawLine(line);
    }

    @Override
    public String toString() {
        return "2d device simulator - " + name;
    }

    @Override
    public void accept(DriverVisitor visitor) {
        visitor.visit(this);
    }
}
