package com.example.deyabanisakher.flagwayappdemotest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Deya Banisakher on 10/26/2016.
 */

public class ModeALauncher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_amode);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        Button clickButton2 = (Button) findViewById(R.id.ModeAOk);
        clickButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(ModeALauncher.this, Level1.class);
                ModeALauncher.this.startActivity(intent);
            }
        });
    }
}
