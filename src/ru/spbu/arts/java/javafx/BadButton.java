package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BadButton extends Application {

    private Button button1;
    int clicks = 0;
    private Image im;
    private ImageView jpg;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Не нажимайте эту кнопку");

        Parent rootElement = initInterface();
        initInteraction();

        primaryStage.setScene(new Scene(rootElement));
        primaryStage.show();
    }

    private Parent initInterface() {
        button1 = new Button("Не нажимайте эту кнопку");
        button1.setMaxWidth(100000);
        button1.setMaxHeight(Double.MAX_VALUE);
        button1.setPrefHeight(70);
        button1.setStyle("-fx-background-color: #f5827c");

        im = new Image("C:/Users/79218/.1Kate/Java/java 3 sem/src/ru/spbu/arts/java/javafx/Badcat.jpg");
        jpg = new ImageView();
        jpg.setFitWidth(500);
        jpg.setFitHeight(500);

        return new VBox(button1, jpg);
    }

    private void initInteraction() {
        String str1 = "Пожалуйста, не нажимайте больше эту кнопку!";
        String str2 = "Зачем вы опять нажали эту несчастную кнопку??";
        String str3 = "Это последнее предупреждение!!";
        String str4 = "Теперь вы внесены в черный список нажимателей кнопок";

        button1.addEventHandler(ActionEvent.ACTION, event -> {
            clicks++;
            if (clicks == 1)
                System.out.println(str1);
            else if (clicks == 2)
                System.out.println(str2);
            else if (clicks == 3)
                System.out.println(str3);
            else if (clicks == 4)
                System.out.println(str4);
            else{
                jpg.setImage(im);
                button1.setVisible(false);
            }
        });
    }
}
