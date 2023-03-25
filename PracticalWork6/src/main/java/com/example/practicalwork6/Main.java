package com.example.practicalwork6;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.time.LocalTime;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        double width = 500;
        double height = 500;
        double clockRadius = 200;

        Pane pane = new Pane();
        pane.setPrefSize(width, height);

        double numberRadius = clockRadius * 0.8;
        for (int i = 1; i <= 12; i++) {
            double angle = i * Math.PI / 6;
            double numberX = width / 2 + numberRadius * Math.sin(angle);
            double numberY = height / 2 - numberRadius * Math.cos(angle);
            Text number = new Text(String.valueOf(i));
            number.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            number.setX(numberX - number.getLayoutBounds().getWidth() / 2);
            number.setY(numberY + number.getLayoutBounds().getHeight() / 3);
            pane.getChildren().add(number);
        }

        Line hourHand = new Line();
        hourHand.setStroke(Color.BLACK);
        hourHand.setStrokeWidth(2);
        pane.getChildren().add(hourHand);

        Line minuteHand = new Line();
        minuteHand.setStroke(Color.BLACK);
        minuteHand.setStrokeWidth(2);
        pane.getChildren().add(minuteHand);

        Line secondHand = new Line();
        secondHand.setStroke(Color.BLACK);
        secondHand.setStrokeWidth(2);
        pane.getChildren().add(secondHand);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalTime time = LocalTime.now();
            double hour = time.getHour() % 12;
            double minute = time.getMinute();
            double second = time.getSecond();

            double hourAngle = (hour * 30) + (minute * 0.5);
            double minuteAngle = minute * 6;
            double secondAngle = second * 6;

            double hourHandLength = clockRadius * 0.4;
            double hourHandX = width / 2 + hourHandLength * Math.sin(Math.toRadians(hourAngle));
            double hourHandY = height / 2 - hourHandLength * Math.cos(Math.toRadians(hourAngle));
            hourHand.setStartX(width / 2);
            hourHand.setStartY(height / 2);
            hourHand.setEndX(hourHandX);
            hourHand.setEndY(hourHandY);

            double minuteHandLength = clockRadius * 0.5;
            double minuteHandX = width / 2 + minuteHandLength * Math.sin(Math.toRadians(minuteAngle));
            double minuteHandY = height / 2 - minuteHandLength * Math.cos(Math.toRadians(minuteAngle));
            minuteHand.setStartX(width / 2);
            minuteHand.setStartY(height / 2);
            minuteHand.setEndX(minuteHandX);
            minuteHand.setEndY(minuteHandY);

            double secondHandLength = clockRadius * 0.7;
            double secondHandX = width / 2 + secondHandLength * Math.sin(Math.toRadians(secondAngle));
            double secondHandY = height / 2 - secondHandLength * Math.cos(Math.toRadians(secondAngle));
            secondHand.setStartX(width / 2);
            secondHand.setStartY(height / 2);
            secondHand.setEndX(secondHandX);
            secondHand.setEndY(secondHandY);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        for (int i = 0; i < 12; i++) {
            double markerLength = 0.025 * width;
            double markerWidth = -3;
            Line marker = new Line(width / 2, height / 2 - 150 +markerLength,
                    width / 2, height / 2 - 150 + markerWidth);
            marker.getTransforms().add(new Rotate(i * 30, width / 2, height / 2));
            marker.setStroke(Color.BLACK);
            pane.getChildren().add(marker);
        }

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}