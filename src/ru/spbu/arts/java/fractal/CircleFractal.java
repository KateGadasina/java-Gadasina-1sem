package ru.spbu.arts.java.fractal;

import javafx.scene.paint.Color;

public class CircleFractal implements FractalInterface{
    @Override
    public Color paint(double x, double y){
        if (x * x + y * y <= 1)
            return Color.BLACK;
        else
            return Color.PINK;
    }
}
