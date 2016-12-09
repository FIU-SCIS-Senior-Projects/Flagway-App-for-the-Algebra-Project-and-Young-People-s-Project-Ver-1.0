package com.example.deyabanisakher.flagwayappdemotest;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.logging.Level;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final RadioGroup radioRangeGroup = (RadioGroup) findViewById(R.id.radioGroup2);
        Button clickButton2 = (Button) findViewById(R.id.modeA);
        clickButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                BackBone bb = new BackBone();
                BackBone.gameModeA = true;

                if (radioRangeGroup.getCheckedRadioButtonId() != -1) {
                    int selectedId = radioRangeGroup.getCheckedRadioButtonId();
                    View radioButton = radioRangeGroup.findViewById(selectedId);
                    int radioID = radioRangeGroup.indexOfChild(radioButton);
                    RadioButton btn = (RadioButton) radioRangeGroup.getChildAt(radioID);
                    String rangeSelected = (String) btn.getText();

                    if(rangeSelected.equalsIgnoreCase("range 1")){
                        Level1.range = 10;
                    }else if (rangeSelected.equalsIgnoreCase("range 2")){
                        Level1.range = 20;
                    }else if (rangeSelected.equalsIgnoreCase("range 3")){
                        Level1.range = 40;
                    }else if (rangeSelected.equalsIgnoreCase("range 4")){
                        Level1.range = 144;
                    }
                    ThreeRuleDisplayFragment threeRuleDisplay = new ThreeRuleDisplayFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    threeRuleDisplay.show(fragmentManager, "dialog");
                }else{
                    Toast.makeText(getApplicationContext(), "Range Not Selected", Toast.LENGTH_LONG).show();
                }

            }
        });

        Button clickButton4 = (Button) findViewById(R.id.modeB);
        clickButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                BackBone bb = new BackBone();
                BackBone.gameModeA = false;

                if (radioRangeGroup.getCheckedRadioButtonId() != -1) {
                    int selectedId = radioRangeGroup.getCheckedRadioButtonId();
                    View radioButton = radioRangeGroup.findViewById(selectedId);
                    int radioID = radioRangeGroup.indexOfChild(radioButton);
                    RadioButton btn = (RadioButton) radioRangeGroup.getChildAt(radioID);
                    String rangeSelected = (String) btn.getText();

                    if(rangeSelected.equalsIgnoreCase("range 1")){
                        Level1.range = 10;
                    }else if (rangeSelected.equalsIgnoreCase("range 2")){
                        Level1.range = 20;
                    }else if (rangeSelected.equalsIgnoreCase("range 3")){
                        Level1.range = 40;
                    }else if (rangeSelected.equalsIgnoreCase("range 4")){
                        Level1.range = 144;
                    }
                    Intent intent = new Intent(Main.this, Level1.class);
                    Main.this.startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Range Not Selected", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
