package com.example.towerka;

import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Rectangle tower1;
    public Rectangle tower2;
    public Rectangle tower3;

    public double lastX = -600;
    public double craneSpeed = 500;
    public double craneDownSpeed = 600;
    public boolean gameOver = false;
    public int gameCounter = 0;
    public AnchorPane anchorPane;
    public Label score;
    public Label gameover;

    public void clickedScreen(MouseEvent mouseEvent) {
        tower2.setOpacity(1);
        tower3.setOpacity(1);
        if (!gameOver || gameCounter == 0) {
            double lockX = tower1.translateXProperty().getValue();
            tower3.setX(lastX);
            tower2.setX(lockX);
            tower2.translateYProperty().setValue(0);
            TranslateTransition translate = new TranslateTransition();
            translate.setNode(tower2);
            translate.setDuration(Duration.millis(craneDownSpeed));
            if (gameCounter == 0) {
                translate.setByY(anchorPane.getHeight() - tower2.getHeight());
            } else {
                translate.setByY(anchorPane.getHeight() - tower2.getHeight() * 2);
            }
            translate.play();
            gameCounter++;
            score.setText("Score: " + gameCounter);
            System.out.println("Score: " + gameCounter);
            if (gameCounter != 1) {
                if (lockX + tower1.widthProperty().getValue() < lastX || lockX > lastX + tower1.widthProperty().getValue()) {
                    gameOver = true;
                    System.out.println("Game Over!");
                    gameover.setOpacity(1);
                }
            }
            lastX = lockX;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        URL imgSrc = getClass().getResource("tower.png");
        Image img = new Image(String.valueOf(imgSrc));
        tower1.setFill(new ImagePattern(img));
        tower2.setFill(new ImagePattern(img));
        tower3.setFill(new ImagePattern(img));
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(tower1);
        translate.setDuration(Duration.millis(craneSpeed));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(380 - tower1.getWidth());
        translate.setAutoReverse(true);
        translate.play();
        tower2.setOpacity(0);
        tower3.setOpacity(0);
        gameover.setOpacity(0);
    }
}