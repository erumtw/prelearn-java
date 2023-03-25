import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    protected TextField tfLoanAmount= new TextField();
    protected TextField tfYear = new TextField();
    protected TextArea tableArea = new TextArea("text will appear here");
    protected Button btShow = new Button("Show Table");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        tfLoanAmount.setAlignment(Pos.CENTER_RIGHT);
        tfYear.setAlignment(Pos.CENTER_RIGHT);
        tfLoanAmount.setPrefColumnCount(12);
        tfYear.setPrefColumnCount(3);

        HBox hPane = new HBox(10);
        hPane.getChildren().addAll(new Label("Loan Amount"), tfLoanAmount,  new Label("Number of years"), tfYear, btShow);
        hPane.setAlignment(Pos.CENTER);

        ScrollPane scrollPane = new ScrollPane(tableArea);
        scrollPane.autosize();
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(hPane, scrollPane);

        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Loan GUI");
        primaryStage.setScene(scene);
        primaryStage.show();

        btShow.setOnAction(e -> {
            System.out.println("Precessing...");
            showTable();
        });
    }

    protected void showTable() {
        Loan loan = new Loan();
        loan.setLoanAmount( Double.parseDouble(tfLoanAmount.getText()) );
        loan.setNumberOfYears( Double.parseDouble(tfYear.getText()) );
        String table = "";
        table += "Interest Rate\t\tMonthly Payment\t\tTotal Payment";

        for (double i = Double.parseDouble(tfYear.getText());  i <= 8; i += 0.25) {
            loan.setAnnualInterestRate(i);
            table += String.format("\n%.2f\t\t\t\t%.2f\t\t\t\t%5.2f", i, loan.getMonthlyPayment(), loan.getTotalPayment());
        }
    
        tableArea.setText(table);
    }
}
