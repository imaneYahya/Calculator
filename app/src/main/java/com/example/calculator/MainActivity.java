package com.example.calculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private boolean isOp1 = true;
    private int val1 = 0;
    private int val2 = 0;
    private String operation = "";
    private TextView Ch_saisi;
    private TextView result;


    private static final int OPE_PLUS = R.id.ope_plus;

    private StringBuilder expression = new StringBuilder();
    String currentExpression = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_calculator);


        boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        Intent intent;
        if (isLandscape) {
            intent = new Intent(this, ModePayasage.class);
        } else {
            intent = new Intent(this, ModePortrait.class);
        }

        startActivity(intent);
        finish();


    }

}