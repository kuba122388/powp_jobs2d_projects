package edu.kis.powp.jobs2d.canva.factories;

import edu.kis.powp.jobs2d.canva.shapes.RectangleCanva;

public class RectangleCanvaFactory {
    public static RectangleCanva getVerticalA5Canva() {
        return new RectangleCanva(148, 210);
    }

    public static RectangleCanva getHorizontalA5Canva() {
        return new RectangleCanva(210, 148);
    }

    public static RectangleCanva getVerticalA4Canva() {
        return new RectangleCanva(210, 297);
    }

    public static RectangleCanva getHorizontalA4Canva() {
        return new RectangleCanva(297, 210);
    }

    public static RectangleCanva getVerticalA3Canva() {
        return new RectangleCanva(297, 420);
    }

    public static RectangleCanva getHorizontalA3Canva() {
        return new RectangleCanva(420, 297);
    }

    public static RectangleCanva getLetterCanva() {
        return new RectangleCanva(216, 279);
    }
}
