package ru.spbu.arts.java.fractal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Fractal extends Application {

    public  int W = 600;
    public final static int H = 500;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Фигуры");

        Pane root = initInterface();
        stage.setScene(new Scene(root));

        stage.show();
    }

    private Pane initInterface(){
        WritableImage img = new WritableImage(W, H);
        Display display = new Display(-4, 5,8 / 600.0);
        FractalInterface f = new MandelbrotFractal();
        display.paint(img, f);

        ImageView imageView = new ImageView(img);
        return new Pane(imageView);
    }
}
