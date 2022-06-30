package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Exam extends Application {

    private Button button;
    private Label lable;
    private ListView<String> listview = new ListView();;
    private DirectoryChooser dirC;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Exam");

        Parent parent = initInterface();
        stage.setScene(new Scene(parent));

        button.setOnAction(actionEvent -> {
            File dir = dirC.showDialog(stage);
            if (dir != null){
                lable.setText(dir.getName());
                listview.getItems().clear();
                listview.getItems().addAll(getAllFiles(dir.getAbsoluteFile()));
            }
        });

        stage.show();
    }


    private Parent initInterface() {

        button = new Button("выберите папку");
        dirC = new DirectoryChooser();
        lable = new Label("выбранный файл");

        return new VBox(button, lable, listview);
    }

    public List<String> getAllFiles(File dir) {
        List<String> list = new ArrayList<>();
        File[] filelist = dir.listFiles();
        String[] files = new String[filelist.length];
        for (int i = 0; i < files.length; i++) {
            files[i] = filelist[i].getName();
        }
        for (String fileName : files) {
            list.add(fileName);
        }
        return list;
    }
}
