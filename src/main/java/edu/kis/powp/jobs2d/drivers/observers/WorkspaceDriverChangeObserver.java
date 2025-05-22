package edu.kis.powp.jobs2d.drivers.observers;

import edu.kis.powp.jobs2d.canva.ClippingJobs2dDriverDecorator;
import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.features.WorkspaceFeature;
import edu.kis.powp.observer.Subscriber;

public class WorkspaceDriverChangeObserver implements Subscriber {
    @Override
    public void update() {
        ClippingJobs2dDriverDecorator clipper = WorkspaceFeature.getWorkspaceManager().getClipper();
        VisitableJob2dDriver currentDriver = DriverFeature.getDriverManager().getCurrentDriver();
        if (currentDriver == clipper)
            return;

        clipper.setInnerDriver(currentDriver);
        DriverFeature.getDriverManager().setCurrentDriver(clipper);
    }
}
