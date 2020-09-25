package com.example.cofeehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int noOfCofee = 0;
    int totalPrice = 0;
    boolean hasWhippedCream = false;
    boolean hasChocolate = false;

    public void increment(View view) {
        noOfCofee = noOfCofee + 1;
        displayQuantity();
    }

    public void decrement(View view) {
        if (noOfCofee != 0) {
            noOfCofee = noOfCofee - 1;
        }
        displayQuantity();
    }

    public void displayQuantity() {
        TextView quantity = findViewById(R.id.quantity);
        quantity.setText(noOfCofee + "");
    }

    public void expandCheckBoxes(View view) {
        CheckBox whippedCream = findViewById(R.id.whippedCream);
        CheckBox chocolate = findViewById(R.id.chocolate);
        whippedCream.setVisibility(View.VISIBLE);
        chocolate.setVisibility(View.VISIBLE);
    }

    public void addedExtraWhippedCream(View view) {
        hasWhippedCream = true;
    }

    public void addedExtraChocolate(View view) {
        hasChocolate = true;
    }


    public void orderButtonClick(View view) {
        TextView orderSummary = findViewById(R.id.orderSummary);
        TextView orderSummaryHeading = findViewById(R.id.orderSummaryHeading);
        EditText editName = findViewById(R.id.editName);
        orderSummary.setVisibility(View.VISIBLE);
        orderSummaryHeading.setVisibility(View.VISIBLE);
        totalPrice = noOfCofee * 4;
        orderSummary.setText("Thank you" + editName.getText().toString() + "\nTotal : $" + totalPrice);
        Toast.makeText(this, "Ordered!!", Toast.LENGTH_SHORT).show();
    }
}