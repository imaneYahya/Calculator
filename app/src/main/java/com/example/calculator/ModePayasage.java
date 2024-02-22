package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

public class ModePayasage extends AppCompatActivity {



    private boolean isOp1=true;
    private int val1=0;
    private int val2=0;
    private String operation="";
    private TextView Ch_saisi;
    private TextView result;


    private static final int OPE_PLUS = R.id.ope_plus;

    private StringBuilder expression = new StringBuilder();
    String currentExpression = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_calculator);

        Ch_saisi=findViewById(R.id.textView);
        result = findViewById(R.id.textViewOperation);
        Button btnPlus = findViewById(R.id.ope_plus);
        Button btnMoins = findViewById(R.id.ope_moins);
        Button btnDiv = findViewById(R.id.ope_division);
        Button btnPourcentage = findViewById(R.id.pourcentage);
        Button btnMultip = findViewById(R.id.ope_multiplication);
        Button btnCalcule = findViewById(R.id.resultat);
        result = findViewById(R.id.textViewOperation);
        TextView btnDot = findViewById(R.id.dot);
        TextView parentgauche = findViewById(R.id.parenthetesesgauche);
        TextView parentdroite = findViewById(R.id.pr_dr);
        TextView cosinuss=findViewById(R.id.cos);
        TextView sept=findViewById(R.id.button_7);
        TextView sqrt=findViewById(R.id.sqrt);
        TextView power=findViewById(R.id.power);

        cosinuss.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                trigCosBTNPush(v);
            }
        });

        sept.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                updateText2(v);
            }
        });

        parentdroite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                updateText2(v);
            }
        });

        btnCalcule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer(v);
            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer(v);
            }
        });
    }

    public void trigCosBTNPush(View view) {
        currentExpression = "";
        updateText("cos(");
    }
    public void trigSinBTNPush(View view){
        currentExpression = "";
        updateText("sin(");
    }
    public void trigTanBTNPush(View view){
        currentExpression = "";
        updateText("tan(");
    }
    private void updateText(String textToAdd) {
        currentExpression += textToAdd;
        result.setText(currentExpression);
    }

    public void updateText2(View v) {
        String val = ((TextView)v).getText().toString();
        currentExpression += val;
        result.setText(currentExpression);
    }

    private void calculer(View view){

        Expression expression = new Expression(currentExpression);
        double resultat = expression.calculate();
        Ch_saisi.setText(String.valueOf(resultat));
        val1 = (int) Math.round(resultat);


        val2 = 0;
        isOp1 = true;
        operation = "";
        result.setText(""+resultat);

    }
    public void reset(View view){
        // val1=0;val2=0; isOp1=true;
        // operation="";
        currentExpression = "";
        Ch_saisi.setText("0");
        result.setText("0");
        //afficher();
    }

}
