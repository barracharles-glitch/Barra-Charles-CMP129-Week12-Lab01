import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class CalculatorApp extends Application 
{
    @Override
    public void start(Stage primaryStage)  
    {
        TextField num1Field = new TextField();
        num1Field.setPromptText("Enter first number");
        TextField num2Field = new TextField();
        num2Field.setPromptText("Enter second number");
        TextField operatorField = new TextField();
        operatorField.setPromptText("Enter operator (+ , - , * , /)");
        TextField resultField = new TextField();
        resultField.setEditable(false);
        Button calculate = new Button("Calculate");
        calculate.setOnAction(event ->
        {
            try
            {
                double result, num1, num2;
                String operator;
                num1 = Double.parseDouble(num1Field.getText());
                num2 = Double.parseDouble(num2Field.getText());
                operator = operatorField.getText();
                switch (operator)
                {
                    default:
                        resultField.setText("Invalid operator. Must be + , - , * , /");
                        return;
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if(num2==0)
                        {
                            resultField.setText("Error Undefined");
                            return;
                        }
                        result = num1/num2;
                        break;
                }
                resultField.setText(String.valueOf(result));
            }
            catch(NumberFormatException e)
            {
            resultField.setText("Error Invalid Number");
            }
        });
        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(12);
        buttonGrid.setVgap(12);
        buttonGrid.setAlignment(Pos.CENTER);
        String[][] buttonLabels = {
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"C", "0", "=", "+"}
        };
        for (int row = 0; row < buttonLabels.length; row++) 
        {
            for (int col = 0; col < buttonLabels[row].length; col++) 
            {
                Button btn = new Button(buttonLabels[row][col]);
                btn.setPrefSize(70, 70);
                buttonGrid.add(btn, col, row);
            }
        }
        VBox vbox = new VBox(10, num1Field, operatorField, num2Field, calculate, resultField, buttonGrid);
        Scene scene = new Scene(vbox, 400, 560);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}