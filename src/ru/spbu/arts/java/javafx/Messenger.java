package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Messenger extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Мессенджер");

        Parent parent = initInterface();
        stage.setScene(new Scene(parent));

        stage.show();
    }

    private HBox initInterface() {
        TextField tF = new TextField();
        Button b1 = new Button("отправить");

        TextArea  tA = new TextArea();
        HBox h1 = new HBox(tF, b1);

        Label l = new Label("  Контакты");
        ObservableList<String> list = FXCollections.observableArrayList("Have", "a", "good", "day!");
        ListView<String> lV = new ListView<>(list);

        VBox v1 = new VBox(tA, h1);
        VBox v2 = new VBox(l, lV);
        HBox h = new HBox(v1, v2);

        VBox.setVgrow(tA, Priority.ALWAYS);
        HBox.setHgrow(tF, Priority.ALWAYS);
        VBox.setVgrow(lV, Priority.ALWAYS);

        tF.setPrefHeight(70);
        b1.setPrefHeight(70);
        v2.setPrefWidth(250);
        l.setPrefHeight(30);

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tA.setText(tF.getText());
                tF.setText("");
            }
        });

        tA.setEditable(false);

        return h;
    }
}
