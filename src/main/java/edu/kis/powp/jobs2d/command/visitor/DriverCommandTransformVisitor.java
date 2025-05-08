package edu.kis.powp.jobs2d.command.visitor;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.*;
import edu.kis.powp.jobs2d.drivers.CoordinateExtractingDriver;
import edu.kis.powp.jobs2d.transformations.FlipTransformationDecorator;
import edu.kis.powp.jobs2d.transformations.RotateTransformationDecorator;
import edu.kis.powp.jobs2d.transformations.ScaleTransformationDecorator;
import edu.kis.powp.jobs2d.transformations.TranslateTransformationDecorator;
import sun.tools.jstat.Scale;

import java.util.ArrayList;
import java.util.List;

public class DriverCommandTransformVisitor implements DriverCommandVisitor {
    private double scaleX = 1.0;
    private double scaleY = 1.0;
    private double translateX = 0.0;
    private double translateY = 0.0;
    private double rotation = 0.0;
    private boolean flipHorizontal = false;
    private boolean flipVertical = false;

    private final List<DriverCommand> transformedCommands = new ArrayList<>();

    public List<DriverCommand> getTransformedCommands() {
        return transformedCommands;
    }

    private int[] apply(int x, int y) {
        CoordinateExtractingDriver coordDriver = new CoordinateExtractingDriver();
        Job2dDriver driver = coordDriver;

        driver = new ScaleTransformationDecorator(driver, scaleX, scaleY);
        driver = new TranslateTransformationDecorator(driver, translateX, translateY);
        driver = new RotateTransformationDecorator(driver, rotation);
        driver = new FlipTransformationDecorator(driver, flipHorizontal, flipVertical);

        driver.setPosition(x, y);
        return coordDriver.getLastPosition();
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

    public void setFlipHorizontal(boolean flipHorizontal) {
        this.flipHorizontal = flipHorizontal;
    }

    public void setFlipVertical(boolean flipVertical) {
        this.flipVertical = flipVertical;
    }
}
