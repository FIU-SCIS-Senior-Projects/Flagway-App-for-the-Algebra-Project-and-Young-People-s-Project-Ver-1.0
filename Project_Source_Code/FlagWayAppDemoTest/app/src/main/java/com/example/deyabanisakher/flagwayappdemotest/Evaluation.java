package com.example.deyabanisakher.flagwayappdemotest;

/**
 * Created by msaza001 on 11/8/2016.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Evaluation {
    // private ArrayList<String> contents;
    //ac  private final String filename = "keywords.txt";

    public void read(Context context, String input1, String input2, String input3) {

        String [] keywords={
                "repeating",
                "distinct",
                "prime",
                "factors",
                "odd",
                "even",
                "mutually exclusive",
                "at least",
                "at most",
                "multiple",
                "divisible",
                "power",
                "exponent",
                "square",
                "cube",
                "add",
                "subtract",
                "square root",
                "cubic root",
                "number"
        };

        String [] phrase_red={
                "Divisible by four",
                "Multiple of four",
                "Perfect square",
                "Perfect square root"

        };

        String [] phrase_yellow={
                "Number is odd except for two",
                "Number is prime",
                "Number is the smallest",
                "The sum of"

        };

        String [] phrase_blue={

                "Divisible by three",
                "Divisible by six",
                "Neither red nor yellow",
                "Two factors"

        };




        boolean Finput1 = false;
        boolean Finput2 = false;
        boolean Finput3 = false;
        String oInput1 = "You are in the write way";
        String oInput2 = "You are Correct";

        int red = 0;int red1 = 0;int red2 = 0;
        int yellow = 0;int yellow1 = 0;
        int blue = 0; int blue1 = 0;

        for(int i=0;i<keywords.length;i++)
        {
            if(input1.contains(keywords[i])) //Finput1=true;
                red = 1;

        }

        for (int i=0;i<phrase_red.length;i++)
        {
            if(input1.contains(phrase_red[i]))
                red1 = 1;
        }

        for(int i=0;i<keywords.length;i++)
        {
            if(input2.contains(keywords[i])) //Finput2=true;
                yellow =1;
        }


        for (int i=0;i<phrase_yellow.length;i++)
        {
            if(input1.contains(phrase_yellow[i]))
                yellow1 = 1;
        }


        for(int i=0;i<keywords.length;i++)
        {
            if(input3.contains(keywords[i])) //Finput3=true;
                blue = 1;
        }


        for (int i=0;i<phrase_yellow.length;i++)
        {
            if(input1.contains(phrase_blue[i]))
                blue1 = 1;
        }



        // Toast.makeText(context, input1+" : "+Finput1+"\n"+input2+" : "+Finput2+"\n"+input3+" : "+Finput3, Toast.LENGTH_LONG).show();

        if (red==1){

            Toast.makeText(context, input1+":"+oInput1,Toast.LENGTH_LONG).show();

        }

        if (red1==1){

            Toast.makeText(context, input1+":"+oInput2,Toast.LENGTH_LONG).show();

        }

        if (yellow==1){

            Toast.makeText(context, input1+":"+oInput1,Toast.LENGTH_LONG).show();

        }

        if (yellow1==1){

            Toast.makeText(context, input1+":"+oInput2,Toast.LENGTH_LONG).show();

        }


        if (blue==1){

            Toast.makeText(context, input1+":"+oInput1,Toast.LENGTH_LONG).show();

        }

        if (blue1==1){

            Toast.makeText(context, input1+":"+oInput2,Toast.LENGTH_LONG).show();

        }



    }
}
