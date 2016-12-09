package com.example.deyabanisakher.flagwayappdemotest;

/**
 * Created by Deya Banisakher on 10/25/2016.
 */

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class YellowRuleDialogFragment extends DialogFragment {



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View viewInflater = inflater.inflate(R.layout.yellow_rule_input, null);

        TextView yellowNumbers = (TextView) viewInflater.findViewById(R.id.yellow_numbers);
        String yellowNums = "";

        for (int i = 0; i < BackBone.yellowBag.size(); i++){
            if(yellowNums.equals("")){
                yellowNums += BackBone.yellowBag.get(i);
            }else{
                yellowNums += " ," + BackBone.yellowBag.get(i);
            }

        }

        CharSequence numbers = yellowNums;
        yellowNumbers.setText(numbers);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(viewInflater)
                .setTitle(R.string.single_rule_input_title)
                // Add action buttons
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });


        // Create the AlertDialog object and return it
        return builder.create();
    }


}