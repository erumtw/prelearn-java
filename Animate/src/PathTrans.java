// import javafx.animation.PathTransition;
// import javafx.animation.Timeline;
// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.layout.Pane;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.Arc;
// import javafx.scene.shape.ArcType;
// import javafx.scene.shape.Circle;
// import javafx.stage.Stage;
// import javafx.util.Duration;

// public class PathTrans extends Application {

//     public static void main(String[] args) {
//         launch(args);
//     }

//     @Override
//     public void start(Stage arg0) {
//         Circle circle = new Circle();
//         circle.setCenterX(200/2);
//         circle.setCenterY(200/2);
//         circle.setRadius(Math.min(200, 200) * 0.8 * 0.5);
//         circle.setFill(Color.AQUA);
//         circle.setStroke(Color.BLACK);

//         Arc arc = new Arc();
//         arc.setCenterX(200/2);
//         arc.setCenterY(200/2);
//         arc.setRadiusX(Math.min(200, 200) * 0.8 * 0.5);
//         arc.setRadiusY(Math.min(200, 200) * 0.8 * 0.5);
//         arc.setStartAngle(45);
//         arc.setLength(35);
//         arc.setType(ArcType.ROUND);
//         arc.setFill(Color.DARKBLUE);

//         Pane pane = new Pane();
//         pane.getChildren().addAll(circle, arc);

//         //animation
//         PathTransition pathTransition = new PathTransition();
//         pathTransition.setDuration(Duration.millis(1000));
//         pathTransition.setPath(circle);
//         pathTransition.setNode(arc);
//         pathTransition.setCycleCount(Timeline.INDEFINITE);
//         pathTransition.play();

//         circle.setOnMousePressed(e -> {
//             pathTransition.pause();
//         });

//         circle.setOnMouseReleased(e -> {
//             pathTransition.play();
//         });

//         circle.setOnMouseClicked(e -> {
//             pathTransition.setAutoReverse(true);
//         });

//         Scene scene = new Scene(pane, 200, 200);
//         arg0.setTitle("arg0");
//         arg0.setScene(scene);
//         arg0.show();
//     }
// }
