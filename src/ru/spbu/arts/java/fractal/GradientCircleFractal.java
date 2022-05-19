package ru.spbu.arts.java.fractal;

import javafx.scene.paint.Color;

public class GradientCircleFractal implements FractalInterface{
    @Override
    public Color paint(double x, double y) {
        double r = x * x + y * y; //Math.sqrt(x * x + y * y)
        if (r > 1)
            r = 1;
        return Color.gray(r);
    }
}
