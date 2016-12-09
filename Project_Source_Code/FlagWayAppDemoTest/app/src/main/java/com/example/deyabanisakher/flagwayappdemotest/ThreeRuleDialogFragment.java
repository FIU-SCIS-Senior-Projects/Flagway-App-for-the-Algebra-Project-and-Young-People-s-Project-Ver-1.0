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

public class ThreeRuleDialogFragment extends DialogFragment {



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View viewInflater = inflater.inflate(R.layout.three_rule_input, null);

        final EditText input1= (EditText) viewInflater.findViewById(R.id.rule1);
        input1.setHint(BackBone.rule1);
        final EditText input2 = (EditText) viewInflater.findViewById(R.id.rule2);
        input2.setHint(BackBone.rule2);
        final EditText input3 = (EditText) viewInflater.findViewById(R.id.rule3);
        input3.setHint(BackBone.rule3);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(viewInflater)
                .setTitle(R.string.single_rule_input_title)
                // Add action buttons
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        BackBone.rule1 = input1.getText().toString();
                        BackBone.rule2 = input2.getText().toString();
                        BackBone.rule3 = input3.getText().toString();

                        Evaluation ev = new Evaluation();
                        ev.read(getActivity().getApplicationContext(), BackBone.rule1, BackBone.rule2, BackBone.rule3);
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