import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimelineTest extends Application {
    protected int time = 50;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) {
        Circle circle = new Circle();
        circle.setCenterX(300/2);
        circle.setCenterY(300/2);
        circle.setRadius(Math.min(200, 200) * 0.8 * 0.5);
        circle.setFill(Color.AQUA);
        circle.setStroke(Color.BLACK);
        Arc arc = new Arc();
        arc.setCenterX(300/2);
        arc.setCenterY(300/2);
        arc.setRadiusX(Math.min(200, 200) * 0.8 * 0.5);
        arc.setRadiusY(Math.min(200, 200) * 0.8 * 0.5);
        arc.setStartAngle(45);
        arc.setLength(35);
        arc.setType(ArcType.ROUND);
        arc.setFill(Color.DARKBLUE);

        Button speedUp = new Button("Speed Up");
        Button speedDown = new Button("Speed Down");
        Button reverse = new Button("Reverse");

        HBox but = new HBox(50);
        but.getChildren().addAll(speedUp, speedDown, reverse);
        but.setAlignment(Pos.CENTER);

        Pane pane = new Pane();
        pane.getChildren().addAll(circle, arc);

        Slider slider = new Slider();
        slider.setMax(4);
        

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(but);
        borderPane.setTop(slider);

        //animation
        EventHandler<ActionEvent> eventHandler = e -> {
            arc.setStartAngle(arc.getStartAngle() + 15);
        };

        Timeline timeline = new Timeline( new KeyFrame(Duration.millis(time), eventHandler));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.rateProperty().bind(slider.valueProperty());
        timeline.play();

        pane.setOnMousePressed(e -> {
            timeline.pause();
        });

        pane.setOnMouseReleased(e -> {
            timeline.play();
        });
        
        speedUp.setOnAction(e -> {
            timeline.rateProperty().setValue(2);
        });

        speedDown.setOnAction(e -> {
            timeline.rateProperty().setValue(1);
        });

        

        Scene scene = new Scene(borderPane, 300, 300);
        arg0.setTitle("arg0");
        arg0.setScene(scene);
        arg0.show();
    }
}
