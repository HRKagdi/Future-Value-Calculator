
import java.lang.Exception;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.lang.Math;
public class App extends Application {
    private TextField AnnualInterestRateFX = new TextField();
    private TextField NumberOfYearsFX = new TextField();
    private TextField NameFX = new TextField();
    private TextField AddressFX = new TextField();
    private TextField InvestmentAmountFX = new TextField();
    private TextField FutureValueFX = new TextField();
    private Button CalculateFX = new Button("Compute Payment");
    private Button ResetFX=new Button("Reset");
    @Override
    public void start(Stage primaryStage) throws Exception {


        GridPane gridPane = new GridPane();
        gridPane.setHgap(6);
        gridPane.setVgap(6);
        gridPane.add(new Label("Name:"),0,0);
        gridPane.add(NameFX,1,0);
        gridPane.add(new Label("Address:"),0,1);
        gridPane.add(AddressFX,1,1);
        gridPane.add(new Label("Investment Amount:"),0,2);
        gridPane.add(InvestmentAmountFX, 1, 2);
        gridPane.add(new Label("Years:"), 0, 3);
        gridPane.add(NumberOfYearsFX, 1, 3);
        gridPane.add(new Label("Annual Interest Rate:"), 0, 4);
        gridPane.add(AnnualInterestRateFX, 1, 4);
        gridPane.add(new Label("Future Value"), 0, 5);
        gridPane.add(FutureValueFX, 1, 5);
        gridPane.add(CalculateFX, 1, 6);
        gridPane.add(ResetFX,1,7);

        gridPane.setAlignment(Pos.CENTER);
        NameFX.setAlignment(Pos.BOTTOM_RIGHT);
        AddressFX.setAlignment(Pos.BOTTOM_RIGHT);
        InvestmentAmountFX.setAlignment(Pos.BOTTOM_RIGHT);
        NumberOfYearsFX.setAlignment(Pos.BOTTOM_RIGHT);
        AnnualInterestRateFX.setAlignment(Pos.BOTTOM_RIGHT);
        FutureValueFX.setAlignment(Pos.BOTTOM_RIGHT);
        FutureValueFX.setEditable(false);
        GridPane.setHalignment(CalculateFX, HPos.RIGHT);

        CalculateFX.setOnAction(e -> {
            calculateFutureValuePayment();
        });

        ResetFX.setOnAction(e ->{
            NameFX.clear();
            AddressFX.clear();
            InvestmentAmountFX.clear();
            NumberOfYearsFX.clear();
            AnnualInterestRateFX.clear();
            FutureValueFX.clear();
        });

        Scene scene = new Scene(gridPane,400,200);
        primaryStage.setTitle("Future Value Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void calculateFutureValuePayment(){

        double interest = Double.parseDouble(AnnualInterestRateFX.getText());
        int year = Integer.parseInt(NumberOfYearsFX.getText());
        int investment= Integer.parseInt(InvestmentAmountFX.getText());
        String name=NameFX.getText();
        String address=AddressFX.getText();
        
        FutureValue FutureValue = new FutureValue(interest,year,investment);
        String message=name+"\n"+address+"\n"+FutureValue.getFutureValue();
        //System.out.print(message);
        CalculateFX.setOnMouseClicked(e->FutureValueMessage.display("Future Value of your Investment",
            message));

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Application.launch(args);
    }

}
class FutureValue {
    private double annualInterestRate;
    private int numberOfYears;
    private int investmentAmount;

    public FutureValue(){
        this(3.5,5,3500);
    }

    public FutureValue(double annualInterestRate,int numberOfYears,int investmentAmount){
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.investmentAmount = investmentAmount;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;

    }


    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears(){
        return numberOfYears;

    }

    public void setNumberOfyears(int numberOfyears){
        this.numberOfYears = numberOfyears;
    }


    public double getinvestmentAmount(){
        return investmentAmount;
    }


    public void setinvestmentAmount(int investmentAmount){
        this.investmentAmount = investmentAmount;
    }

    public double getFutureValue(){
        double futureValue=this.getinvestmentAmount()*Math.pow((1+(this.annualInterestRate/100)),(this.numberOfYears));
        return futureValue;
    }

}

