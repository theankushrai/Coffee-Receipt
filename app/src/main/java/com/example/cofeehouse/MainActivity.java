package com.example.cofeehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int noOfCofee = 0;
    int totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        noOfCofee = noOfCofee + 1;
        totalPrice = totalPrice + 4;
        displayQuantity();
    }

    public void decrement(View view) {
        if (noOfCofee != 0) {
            noOfCofee = noOfCofee - 1;
            totalPrice = totalPrice - 4;
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


    public void orderButtonClick(View view) {

        EditText editName = findViewById(R.id.editName);
        String text = "Thank you " + editName.getText().toString() + "\nTotal price   : $ " + totalPrice;
        if (editName.getText().toString().length() != 0) {


            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ankushrai96@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Cofee Order");
            intent.putExtra(Intent.EXTRA_TEXT, text);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }


            Toast.makeText(this, "Ordered!!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Enter Your name please", Toast.LENGTH_SHORT).show();
        }
    }
}
//Todo:display price of checkboxes when checked
//Todo:click button only when editext filed has a name
//Todo:add an intent