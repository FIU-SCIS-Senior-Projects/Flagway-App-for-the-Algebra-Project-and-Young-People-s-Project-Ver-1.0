package com.example.deyabanisakher.flagwayappdemotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThreeRuleInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_rule_input);
        addListenerOnButton();
    }

    public void addListenerOnButton(){

        Button clickButton2 = (Button) findViewById(R.id.button2);
        clickButton2.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(ThreeRuleInput.this, Level1.class);
                ThreeRuleInput.this.startActivity(intent);
            }
        });

        Button clickButton4 = (Button) findViewById(R.id.button4);
        clickButton4.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(ThreeRuleInput.this, Level1.class);
                ThreeRuleInput.this.startActivity(intent);
            }
        });

        Button clickButton1 = (Button) findViewById(R.id.button1);
        clickButton1.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(ThreeRuleInput.this, Level1.class);
                ThreeRuleInput.this.startActivity(intent);
            }
        });
    }
}
