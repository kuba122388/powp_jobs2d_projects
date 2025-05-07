package edu.kis.powp.jobs2d.command.visitor;

import edu.kis.powp.jobs2d.command.*;

import java.util.ArrayList;
import java.util.List;

public class DriverCommandTransformVisitor implements DriverCommandVisitor {
    private double scaleX = 1.0;
    private double scaleY = 1.0;
    private double translateX = 0.0;
    private double translateY = 0.0;
    private double rotation = 0.0;

    private final List<DriverCommand> transformedCommands = new ArrayList<>();

    public List<DriverCommand> getTransformedCommands() {
        return transformedCommands;
    }

    private int[] apply(int x, int y) {
        double newX = x * scaleX;
        double newY = y * scaleY;

        double radians = Math.toRadians(rotation);
        double rotatedX = newX * Math.cos(radians) - newY * Math.sin(radians);
        double rotatedY = newX * Math.sin(radians) + newY * Math.cos(radians);

        rotatedX += translateX;
        rotatedY += translateY;

        return new int[] {(int) Math.round(rotatedX), (int) Math.round(rotatedY)};
    }

    @Override
    public void visit(SetPositionCommand command) {
        int[] coords = apply(command.getX(), command.getY());
        transformedCommands.add(new SetPositionCommand(coords[0], coords[1]));
    }

    @Override
    public void visit(OperateToCommand command) {
        int[] coords = apply(command.getX(), command.getY());
        transformedCommands.add(new OperateToCommand(coords[0], coords[1]));
    }

    @Override
    public void visit(ICompoundCommand command) {
        for (DriverCommand c : command) {
            c.accept(this);
        }
    }

    public void setScaleX(double scaleX) {
        this.scaleX = scaleX;
    }

    public void setScaleY(double scaleY) {
        this.scaleY = scaleY;
    }

    public void setTranslateX(double translateX) {
        this.translateX = translateX;
    }

    public void setTranslateY(double translateY) {
        this.translateY = translateY;
    }
    
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
}
