package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import static java.lang.Math.min;

public class CircleManagement extends Application {
    private Circle c;
    private Slider sl;
    private Pane pane1;
    private ColorPicker cp1;
    private ColorPicker cp2;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Управление кругом");

        Parent parent = initInterface();
        stage.setScene(new Scene(parent));
        initInteraction();

        stage.show();
    }

    private Parent initInterface(){
        GridPane panelAll = new GridPane();

        GridPane panel0 = new GridPane();

        sl = new Slider(0.0, 100.0, 0.0);
        sl.setShowTickMarks(true);
        sl.setShowTickLabels(true);
        cp1 = new ColorPicker();
        cp2 = new ColorPicker();

        cp1.setValue(Color.valueOf("#ff9833"));
        cp2.setValue(Color.valueOf("#8a47b8"));

        Label l1 = new Label("Размер круга");
        Label l2 = new Label("Цвет круга");
        Label l3 = new Label("Цвет фона");

        panel0.setStyle("-fx-background-color: #fee5a2");

        pane1 = new Pane();
        pane1.setStyle("-fx-background-color: #8a47b8");

        c = new Circle();

        pane1.getChildren().addAll(c);

        c.setCenterX(100.0);
        c.setCenterY(100.0);
        c.setRadius(50.0);
        c.setFill(Color.valueOf("#ff9833"));

        panel0.add(l1, 0, 0);
        panel0.add(sl, 0, 1);
        panel0.add(l2, 0, 2);
        panel0.add(cp1, 0, 3);
        panel0.add(l3, 0, 4);
        panel0.add(cp2, 0, 5);
        panelAll.add(panel0, 0, 0);
        panelAll.add(pane1, 1, 0);

        ColumnConstraints c1 = new ColumnConstraints();
        c1.setPrefWidth(200);
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setHgrow(Priority.ALWAYS);

        panelAll.getColumnConstraints().addAll(c1, c2);

        RowConstraints r1 = new RowConstraints();
        r1.setVgrow(Priority.ALWAYS);

        panelAll.getRowConstraints().addAll(r1);

        r1.setPercentHeight(100);

        return panelAll;
    }

    private void initInteraction() {
        sl.valueProperty().addListener(o -> {
            double newValue = sl.getValue();
            c.setRadius(newValue);
        });

        pane1.widthProperty().addListener(e ->{
            double w = pane1.getWidth() / 2;
            c.setCenterX(w);
        });

        pane1.heightProperty().addListener(e ->{
            double w = pane1.getHeight() / 2;
            c.setCenterY(w);
        });

        cp1.valueProperty().addListener(o ->{
            Color newCol = cp1.getValue();
            c.setFill(newCol);
        });

        cp2.valueProperty().addListener(o ->{
            Color newColBack = cp2.getValue();
            String nc = newColBack.toString();
            String ncNew = nc.substring(2,8);
            //System.out.println(ncNew);
            pane1.setStyle("-fx-background-color: #" + ncNew);
        });

        pane1.heightProperty().addListener(w ->{
            double newRad1 = pane1.getWidth() / 2;
            double newRad2 = pane1.getHeight() / 2;
            sl.setMax(min(newRad1, newRad2));
        });
    }
}
