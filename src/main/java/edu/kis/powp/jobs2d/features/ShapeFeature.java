package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;

import edu.kis.powp.jobs2d.drivers.SelectShapeMenuOptionListener;
import edu.kis.powp.jobs2d.drivers.canva.MyCanva;
import edu.kis.powp.jobs2d.drivers.observers.DriverLabelChangeObserver;

public class ShapeFeature {
    private static Application app;

    public static void setupShapePlugin(Application application) {
        app = application;
        app.addComponentMenu(ShapeFeature.class, "Shape Draw Panel");

        DriverLabelChangeObserver driverLabelChangeObserver = new DriverLabelChangeObserver(application);
        DriverFeature.getDriverManager().getChangePublisher().addSubscriber(driverLabelChangeObserver);
    }


    public static void addShape(String name, MyCanva canvas) {
        SelectShapeMenuOptionListener listener = new SelectShapeMenuOptionListener(canvas, DriverFeature.getDriverManager() );
        app.addComponentMenuElement(ShapeFeature.class, name, listener);
    }
}
