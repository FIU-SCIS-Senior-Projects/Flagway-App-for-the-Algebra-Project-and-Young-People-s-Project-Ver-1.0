package com.example.deyabanisakher.flagwayappdemotest;

import java.util.ArrayList;

/**
 * Created by Deya Banisakher on 10/25/2016.
 */

public class BackBone {

    public static boolean gameModeA = true; // true if mode A, false if mode B is selected.

    public static String rule1 = "Enter Your Rule Here";
    public static String rule2 = "Enter Your Rule Here";
    public static String rule3 = "Enter Your Rule Here";

    public static ArrayList<Integer> redBag = new ArrayList<>();
    public static ArrayList<Integer> blueBag = new ArrayList<>();
    public static ArrayList<Integer> yellowBag = new ArrayList<>();

    private static final char[] correctColorsBag = {'R',
            'R',
            'Y',
            'R',
            'B',
            'R',
            'Y',
            'Y',
            'B',
            'R',
            'Y',
            'R',
            'B',
            'B',
            'Y',
            'R',
            'Y',
            'R',
            'Y',
            'B',
            'B',
            'R',
            'Y',
            'Y',
            'B',
            'Y',
            'Y',
            'B',
            'R',
            'R',
            'Y',
            'B',
            'B',
            'B',
            'Y',
            'R',
            'B',
            'B',
            'Y',
            'R',
            'R',
            'R',
            'Y',
            'Y',
            'B',
            'R',
            'Y',
            'Y',
            'Y',
            'B',
            'Y',
            'R',
            'Y',
            'B',
            'Y',
            'B',
            'B',
            'R',
            'Y',
            'R',
            'B',
            'Y',
            'Y',
            'B',
            'R',
            'R',
            'Y',
            'B',
            'R',
            'R',
            'Y',
            'R',
            'B',
            'Y',
            'Y',
            'B',
            'R',
            'R',
            'Y',
            'Y',
            'B',
            'R',
            'Y',
            'B',
            'B',
            'B',
            'Y',
            'R',
            'Y',
            'B',
            'Y',
            'B',
            'B',
            'B',
            'Y',
            'R',
            'Y',
            'Y',
            'Y',
            'R',
            'R',
            'R',
            'Y',
            'R',
            'B',
            'R',
            'Y',
            'R',
            'R',
            'B',
            'Y',
            'R',
            'R',
            'B',
            'Y',
            'Y',
            'B',
            'R',
            'Y',
            'Y',
            'B',
            'B',
            'Y',
            'Y',
            'Y',
            'R',
            'Y',
            'B',
            'R',
            'R',
            'Y',
            'B',
            'B',
            'Y',
            'Y',
            'R',
            'R',
            'R',
            'Y',
            'B',
            'B',
            'B',
            'Y',
            'B',
            'B',
            'Y',
            'Y',
            'R',
            'Y'};

    public BackBone(){
        rule1 =  "Enter Your Rule Here";
        rule2 =  "Enter Your Rule Here";
        rule3 =  "Enter Your Rule Here";
        redBag.add(2);
        blueBag.add(6);
        yellowBag.add(4);

    }

    public void setRule1(String r1){
        rule1 = r1;
    }

    public void setRule2(String r2){
        rule2 = r2;
    }

    public void setRule3(String r3){
        rule3 = r3;
    }

    public String getRule1(){
        return rule1;
    }

    public String getRule2(){
        return rule2;
    }

    public String getRule3(){
        return rule3;
    }

    public static boolean  verifyAnswer(int number, char color){

        if(correctColorsBag[number-2] == color){
            assignNumber(number, correctColorsBag[number-2]);
            return true;
        }

        return false;
    }

    public static void assignNumber(int number, char color){

        if(color == 'R'){
            redBag.add(number);
        }else if (color == 'B'){
            blueBag.add(number);
        }else if (color == 'Y'){
            yellowBag.add(number);
        }
    }
}

