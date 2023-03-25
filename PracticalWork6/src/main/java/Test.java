/*package com.example.practicalwork6;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalTime;

public class Main extends Application {
    private double width = 400;
    private double height = 400;

    @Override
    public void start(Stage stage) {
        // create clock pane
        Pane pane = new Pane();

        // create clock face
        Circle face = new Circle(width / 2, height / 2, 0.9 * width / 2);
        face.setFill(Color.WHITE);
        face.setStroke(Color.BLACK);
        pane.getChildren().add(face);

        // create hour markers
        for (int i = 0; i < 12; i++) {
            double markerLength = 0.1 * width;
            double markerWidth = 2;
            Line marker = new Line(width / 2, height / 2 - face.getRadius() + markerWidth,
                    width / 2, height / 2 - face.getRadius() + markerLength + markerWidth);
            marker.getTransforms().add(new Rotate(i * 30, width / 2, height / 2));
            marker.setStroke(Color.BLACK);
            pane.getChildren().add(marker);
        }

        // create hour hand
        double hourHandLength = 0.5 * width;
        Line hourHand = new Line(width / 2, height / 2, width / 2, height / 2 - hourHandLength);
        hourHand.setStrokeWidth(6);
        hourHand.setStroke(Color.BLACK);
        pane.getChildren().add(hourHand);

        // create minute hand
        double minuteHandLength = 0.7 * width;
        Line minuteHand = new Line(width / 2, height / 2, width / 2, height / 2 - minuteHandLength);
        minuteHand.setStrokeWidth(4);
        minuteHand.setStroke(Color.BLACK);
        pane.getChildren().add(minuteHand);

        // create second hand
        double secondHandLength = 0.8 * width;
        Line secondHand = new Line(width / 2, height / 2, width / 2, height / 2 - secondHandLength);
        secondHand.setStrokeWidth(2);
        secondHand.setStroke(Color.RED);
        pane.getChildren().add(secondHand);

        // create animation for clock hands
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalTime now = LocalTime.now();
            double hourAngle = (now.getHour() % 12 + now.getMinute() / 60.0) * 30;
            double minuteAngle = now.getMinute() * 6;
            double secondAngle = now.getSecond() * 6;

            // update hour hand
            double hourHandX = width / 2 + hourHandLength * Math.sin(Math.toRadians(hourAngle));
            double hourHandY = height / 2 - hourHandLength * Math.cos(Math.toRadians(hourAngle));
            hourHand.setStartX(width / 2);
            hourHand.setStartY(height / 2);
            hourHand.setEndX(hourHandX);
            hourHand.setEndY(hourHandY);

            // update minute hand

            double minuteHandX = width / 2 + minuteHandLength * Math.sin(Math.toRadians(minuteAngle));
            double minuteHandY = height / 2 - minuteHandLength * Math.cos(Math.toRadians(minuteAngle));
            minuteHand.setStartX(width / 2);
            minuteHand.setStartY(height / 2);
            minuteHand.setEndX(minuteHandX);
            minuteHand.setEndY(minuteHandY);

            // update second hand
            double secondHandX = width / 2 + secondHandLength * Math.sin(Math.toRadians(secondAngle));
            double secondHandY = height / 2 - secondHandLength * Math.cos(Math.toRadians(secondAngle));
            secondHand.setStartX(width / 2);
            secondHand.setStartY(height / 2);
            secondHand.setEndX(secondHandX);
            secondHand.setEndY(secondHandY);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        // add pane to scene
        Scene scene = new Scene(new Group(pane), width, height);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

 */
