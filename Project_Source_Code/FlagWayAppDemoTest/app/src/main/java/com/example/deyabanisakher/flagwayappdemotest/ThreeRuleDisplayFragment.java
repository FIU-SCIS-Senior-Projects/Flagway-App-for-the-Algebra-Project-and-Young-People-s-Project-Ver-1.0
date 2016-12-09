package com.example.deyabanisakher.flagwayappdemotest;

/**
 * Created by Deya Banisakher on 11/21/2016.
 */

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ThreeRuleDisplayFragment extends DialogFragment {



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View viewInflater = inflater.inflate(R.layout.fragment_three_rule_display, null);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(viewInflater)
                .setTitle("Mode A - Color Rules")
                // Add action buttons
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(getActivity(), Level1.class);
                        getActivity().startActivity(intent);
                    }
                });


        // Create the AlertDialog object and return it
        return builder.create();
    }


}