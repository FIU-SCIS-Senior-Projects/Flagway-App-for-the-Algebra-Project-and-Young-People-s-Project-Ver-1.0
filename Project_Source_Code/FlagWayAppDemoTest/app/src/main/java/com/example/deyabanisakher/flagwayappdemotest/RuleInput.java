package com.example.deyabanisakher.flagwayappdemotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class RuleInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_input);
        addListenerOnButton();
    }

    public void addListenerOnButton(){

        Button clickButton = (Button) findViewById(R.id.button5);
        clickButton.setOnClickListener( new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(RuleInput.this, Level1.class);
               startActivity(intent);
            }
        });
    }
}
