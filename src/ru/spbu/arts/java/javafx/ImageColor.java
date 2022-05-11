package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static java.lang.Math.sqrt;

public class ImageColor extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Работа с изображениями и цветом");

        Parent parent = initInterface();
        stage.setScene(new Scene(parent));

        stage.show();
    }

    private Parent initInterface(){
        WritableImage myPainting1 = new WritableImage(100, 100);
        PixelWriter pixelWriter1 = myPainting1.getPixelWriter();
        for (int x = 0; x < 100; x++)
            for (int y = 0; y < 100; y++) {
                pixelWriter1.setColor(x, y, Color.rgb(150, 124, 200));
            }

        WritableImage myPainting2 = new WritableImage(256, 256);
        PixelWriter pixelWriter2 = myPainting2.getPixelWriter();

        for (int x = 0; x < 256; x++)
            for (int y = 0; y < 256; y++) {
                pixelWriter2.setColor(x, y, Color.rgb(x, y, 123));
            }

        WritableImage myPainting3 = new WritableImage(360, 100);
        PixelWriter pixelWriter3 = myPainting3.getPixelWriter();

        for (int x = 0; x < 360; x++)
            for (int y = 0; y < 100; y++) {
                pixelWriter3.setColor(x, y, Color.hsb(x, (double)y/100, 0.5));
            }

        WritableImage myPainting4 = new WritableImage(100, 100);
        PixelWriter pixelWriter4 = myPainting4.getPixelWriter();

        for (int x = 0; x < 100; x++)
            for (int y = 0; y < 100; y++) {
                if (x >= 24 && x < 75 && y >= 24 && y < 75)
                    pixelWriter4.setColor(x, y, Color.BLACK);
                else pixelWriter4.setColor(x, y, Color.WHITE);
            }

        WritableImage myPainting5 = new WritableImage(100, 100);
        PixelWriter pixelWriter5 = myPainting5.getPixelWriter();

        for (int x = 0; x < 100; x++)
            for (int y = 0; y < 100; y++) {
                if (sqrt((x - 50)*(x - 50) + (y - 50)*(y - 50)) < 50)
                    pixelWriter5.setColor(x, y, Color.BLACK);
                else pixelWriter5.setColor(x, y, Color.WHITE);
            }

        WritableImage myPainting6 = new WritableImage(360, 100);
        PixelWriter pixelWriter6 = myPainting6.getPixelWriter();

        for (int x = 0; x < 360; x++)
            for (int y = 0; y < 100; y++) {
                //XYZ -> sRGB
                double cieHradians = x * Math.PI / 180;
                double ciea = Math.cos(cieHradians) * y;
                double cieb = Math.sin(cieHradians) * y;

                // CIE-Lab -> XYZ
                double varY = 0.4;
                double varX = ciea / 500 + varY;
                double varZ = varY - cieb / 200;

                if (varY * varY * varY > 0.008856)
                    varY = varY * varY * varY;
                else
                    varY = (varY - 16. / 116) / 7.787;
                if (varX * varX * varX > 0.008856)
                    varX = varX * varX * varX;
                else
                    varX = (varX - 16. / 116) / 7.787;
                if (varZ * varZ * varZ > 0.008856)
                    varZ = varZ * varZ * varZ;
                else
                    varZ = (varZ - 16. / 116) / 7.787;

                double X = varX * 95.047;
                double Y = varY * 100;
                double Z = varZ * 108.883;

                //XYZ -> sRGB
                varX = X / 100;
                varY = Y / 100;
                varZ = Z / 100;

                double varR = varX * 3.2406 + varY * -1.5372 + varZ * -0.4986;
                double varG = varX * -0.9689 + varY * 1.8758 + varZ * 0.0415;
                double varB = varX * 0.0557 + varY * -0.2040 + varZ * 1.0570;

                if (varR > 0.0031308)
                    varR = 1.055 * Math.pow(varR, 1 / 2.4) - 0.055;
                else
                    varR = 12.92 * varR;
                if (varG > 0.0031308)
                    varG = 1.055 * Math.pow(varG, 1 / 2.4) - 0.055;
                else
                    varG = 12.92 * varG;
                if (varB > 0.0031308)
                    varB = 1.055 * Math.pow(varB, 1 / 2.4) - 0.055;
                else
                    varB = 12.92 * varB;

                if (varR < 0)
                    varR = 0;
                if (varR > 1)
                    varR = 1;
                if (varG < 0)
                    varG = 0;
                if (varG > 1)
                    varG = 1;
                if (varB < 0)
                    varB = 0;
                if (varB > 1)
                    varB = 1;
                pixelWriter6.setColor(x, y, Color.color(varR, varG, varB));
            }

        WritableImage myPainting7 = new WritableImage(371, 100);
        PixelWriter pixelWriter7 = myPainting7.getPixelWriter();

        double gamma = 0.8;
        double attenuation;
        double R;
        double G;
        double B;
        int xNew;
        for (int x = 0; x < 371; x++)
            for (int y = 0; y < 100; y++) {
                xNew = x + 380;
                if (xNew <= 440) {
                    attenuation = 0.3 + 0.7 * ((double) xNew - 380.) / (440.-380.);
                    R = Math.pow(((-((double) xNew - 440.) / (440.-380.)) * attenuation), gamma);
                    G = 0.0;
                    B = Math.pow((attenuation), gamma);
                }
                else if (xNew <= 490) {
                    R = 0.0;
                    G = Math.pow((((double) xNew - 440.) / (490. - 440.)), gamma);
                    B = 1.0;
                }
                else if (xNew <= 510) {
                    R = 0.0;
                    G = 1.0;
                    B = Math.pow((-((double) xNew - 510.) / (510. - 490.)), gamma);
                }
                else if (xNew <= 580) {
                    R = Math.pow((((double) xNew - 510.) / (580. - 510.)), gamma);
                    G = 1.0;
                    B = 0.0;
                }
                else if (xNew <= 645) {
                    R = 1.0;
                    G = Math.pow((-((double) xNew - 645.) / (645. - 580.)), gamma);
                    B = 0.0;
                }
                else{
                    attenuation = 0.3 + 0.7 * (750. - (double) xNew) / (750. - 645.);
                    R = Math.pow((attenuation), gamma);
                    G = 0.0;
                    B = 0.0;
                }
                R *= 255;
                G *= 255;
                B *= 255;
                pixelWriter7.setColor(x, y, Color.rgb((int)R, (int)G, (int)B));
            }

        ImageView viewer1 = new ImageView(myPainting1);
        ImageView viewer2 = new ImageView(myPainting2);
        ImageView viewer3 = new ImageView(myPainting3);
        ImageView viewer4 = new ImageView(myPainting4);
        ImageView viewer5 = new ImageView(myPainting5);
        ImageView viewer6 = new ImageView(myPainting6);
        ImageView viewer7 = new ImageView(myPainting7);

        return new FlowPane(
                viewer1,
                viewer2,
                viewer3,
                viewer4,
                viewer5,
                viewer6,
                viewer7
        );
    }
}
