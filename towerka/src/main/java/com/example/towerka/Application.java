package com.example.towerka;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        URL stylesheetURL = getClass().getResource("style.css");
        scene.getStylesheets().add(stylesheetURL.toExternalForm());
        System.out.println(scene.getStylesheets());
        stage.setResizable(false);
        stage.setTitle("Towerka");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}