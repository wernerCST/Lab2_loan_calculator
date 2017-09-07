package com.example.a1511430.lab2;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNum1, etNum2, etNum3;
    TextView monthlyPayment, totalPayment, totalInterestPayment;
    double loanAmount, yearlyInterestRate;
    int numberOfYears;
    LoanCalculator cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText) findViewById(R.id.loanAmount);
        etNum2 = (EditText) findViewById(R.id.termsOfLoan);
        etNum3 = (EditText) findViewById(R.id.yearlyInterestRate);

        monthlyPayment = (TextView) findViewById(R.id.monthly_payments_result);
        totalPayment = (TextView) findViewById(R.id.total_payments_result);
        totalInterestPayment = (TextView) findViewById(R.id.total_interests_result);


    }
    public void calculate(View v){
        readingInput();
        monthlyPayment.setText(Double.toString(cal.getMonthlyPayment()));
        totalPayment.setText(Double.toString(cal.getTotalCostOfLoan ()));
        totalInterestPayment.setText(Double.toString(cal.getTotalInterest ()));

    }
    public void clear(View v){
        readingInput();
        monthlyPayment.setText("");
        totalPayment.setText("");
        totalInterestPayment.setText("");
        etNum1.setText("0.00");
        etNum2.setText("0.00");
        etNum3.setText("0.00");

    }

    public void readingInput(){
        loanAmount = Double.parseDouble(etNum1.getText().toString());
        numberOfYears = Integer.parseInt(etNum2.getText().toString());
        yearlyInterestRate = Double.parseDouble(etNum3.getText().toString());
        //Create the object with the data that was inputed
        cal = new LoanCalculator(loanAmount, numberOfYears, yearlyInterestRate);
    }
}
