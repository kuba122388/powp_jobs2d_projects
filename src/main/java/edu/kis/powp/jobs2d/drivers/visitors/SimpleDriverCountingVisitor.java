package edu.kis.powp.jobs2d.drivers.visitors;

import edu.kis.powp.jobs2d.canva.ClippingJobs2dDriverDecorator;
import edu.kis.powp.jobs2d.drivers.ComplexDriver;
import edu.kis.powp.jobs2d.drivers.InformativeLoggerDriver;
import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDriverAdapter;
import edu.kis.powp.jobs2d.drivers.monitoring.DriverMonitorDecorator;
import edu.kis.powp.jobs2d.transformations.FlipTransformationDecorator;
import edu.kis.powp.jobs2d.transformations.RotateTransformationDecorator;
import edu.kis.powp.jobs2d.transformations.ScaleTransformationDecorator;

public class SimpleDriverCountingVisitor implements DriverVisitor {
    private int total;

    @Override
    public void visit(ComplexDriver driver) {
        for (VisitableJob2dDriver children : driver.getChildren()) {
            children.accept(this);
        }
        total++;
    }

    @Override
    public void visit(InformativeLoggerDriver driver) {
        total++;
    }

    @Override
    public void visit(LineDriverAdapter driver) {
        total++;
    }

    @Override
    public void visit(RotateTransformationDecorator decorator) {
        decorator.getDriver().accept(this);
        total++;
    }

    @Override
    public void visit(ScaleTransformationDecorator decorator) {
        decorator.getDriver().accept(this);
        total++;
    }

    @Override
    public void visit(FlipTransformationDecorator decorator){
        decorator.getDriver().accept(this);
        total++;
    }

    @Override
    public void visit(ClippingJobs2dDriverDecorator decorator) {
        decorator.getInnerDriver().accept(this);
        total++;
    }

    @Override
    public void visit(DriverMonitorDecorator decorator) {
        decorator.accept(this);
        total++;
    }

    public int getTotal() {
        return total;
    }
}
