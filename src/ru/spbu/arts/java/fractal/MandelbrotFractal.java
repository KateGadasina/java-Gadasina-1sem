package ru.spbu.arts.java.fractal;

import javafx.scene.paint.Color;

public class MandelbrotFractal implements FractalInterface{
    @Override
    public Color paint(double x, double y) {
        double zx = 0, zy = 0;
        double r = 0.2;
        int step = 1;
        while (step <= 1000){
            double zxNew = zx * zx - zy * zy + x;
            double zyNew = 2 * zx * zy + y;
            zx = zxNew;
            zy = zyNew;
            if (Math.sqrt(zx * zx + zy * zy) < r)
                return Color.gray(step / 1000);
            step++;
        }
        return Color.gray(1);
    }
}
