package com.example.cofeehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int noOfCofee = 0;

    public void increment(View view) {
        noOfCofee = noOfCofee + 1;
        displayQuantityPrice();
    }

    public void decrement(View view) {
        if (noOfCofee != 0) {
            noOfCofee = noOfCofee - 1;
        }
        displayQuantityPrice();
    }

    public void displayQuantityPrice() {
        TextView quantity = findViewById(R.id.quantity);
        TextView price = findViewById(R.id.price);
        quantity.setText(noOfCofee + "");
        price.setText("$ " + (noOfCofee * 4));
    }

    public void orderButtonClick(View view) {
        TextView orderSummary = findViewById(R.id.orderSummary);
        TextView orderSummaryHeading = findViewById(R.id.orderSummaryHeading);
        orderSummary.setVisibility(View.VISIBLE);
        orderSummaryHeading.setVisibility(View.VISIBLE);
        orderSummary.setText("Thank you!!!\nHere's your bill\nTotal price : $ " + (noOfCofee * 4) + "\nCome Again");
    }
}