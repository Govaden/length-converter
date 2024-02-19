package com.govaden.length_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.FormatException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inchesEditText;
    private Button calculateButton;
    private TextView resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        setupButtonClickListener();
    }


    // method, which stores Views as Fields
    private void findViews() {
        inchesEditText = findViewById(R.id.edit_text_inches);
        calculateButton = findViewById(R.id.button_calculate);
        resultText = findViewById(R.id.text_view_meters);

    }

    // method, which is being called when button is clicked
    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String inchesText = inchesEditText.getText().toString();

                if (inchesText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Input a value into 'Inches' field", Toast.LENGTH_SHORT).show();
                } else {
                    double calculationResult = convertToMeters(inchesText);
                    displayResult(calculationResult);
                }


            }
        });
    }

    // method for converting inches to meters
    protected double convertToMeters(String inchesText) {

        double inches = Double.parseDouble(inchesText);

        return inches * 0.0254;
    }


    // method, which formats meters value as a string to x decimal places and displays it
    private void displayResult(double meters) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String metersTextResult = myDecimalFormatter.format(meters);

        String fullTextResult = metersTextResult + " meters";

        resultText.setText(fullTextResult);
    }

}