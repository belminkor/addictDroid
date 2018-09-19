package com.example.bela.addictdroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;


public class DailyChallenges extends AppCompatActivity {

    CheckBox mChallenge1;
    CheckBox mChallenge2;
    CheckBox mChallenge3;
    CheckBox mChallenge4;
    CheckBox mChallenge5;
    CheckBox mChallenge6;
    CheckBox mChallenge7;
    CheckBox mChallenge8;
    CheckBox mChallenge9;
    CheckBox mChallenge10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_challenges);

        mChallenge1 = (CheckBox) findViewById(R.id.checkbox_challenge1);
        mChallenge2 = (CheckBox) findViewById(R.id.checkbox_challenge2);
        mChallenge3 = (CheckBox) findViewById(R.id.checkbox_challenge3);
        mChallenge4 = (CheckBox) findViewById(R.id.checkbox_challenge4);
        mChallenge5 = (CheckBox) findViewById(R.id.checkbox_challenge5);
        mChallenge6 = (CheckBox) findViewById(R.id.checkbox_challenge6);
        mChallenge7 = (CheckBox) findViewById(R.id.checkbox_challenge7);
        mChallenge8 = (CheckBox) findViewById(R.id.checkbox_challenge8);
        mChallenge9 = (CheckBox) findViewById(R.id.checkbox_challenge9);
        mChallenge10 = (CheckBox) findViewById(R.id.checkbox_challenge10);

        boolean checked1 = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("check1", false);
        boolean checked2 = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("check2", false);
        boolean checked3 = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("check3", false);
        boolean checked4 = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("check4", false);
        boolean checked5 = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("check5", false);
        boolean checked6 = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("check6", false);
        boolean checked7 = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("check7", false);
        boolean checked8 = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("check8", false);
        boolean checked9 = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("check9", false);
        boolean checked10 = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("check10", false);

        mChallenge1.setChecked(checked1);
        mChallenge2.setChecked(checked2);
        mChallenge3.setChecked(checked3);
        mChallenge4.setChecked(checked4);
        mChallenge5.setChecked(checked5);
        mChallenge6.setChecked(checked6);
        mChallenge7.setChecked(checked7);
        mChallenge8.setChecked(checked8);
        mChallenge9.setChecked(checked9);
        mChallenge10.setChecked(checked10);
    }

    public void onCheckboxClicked(View view) {
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_challenge1:
                if (mChallenge1.isChecked()) {
                    mChallenge1.setActivated(true);
                    mChallenge1.setTextColor(Color.BLUE);
                }
                else {
                    mChallenge1.setActivated(false);
                    mChallenge1.setTextColor(Color.BLACK);
                }

                PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("check1", mChallenge1.isChecked()).commit();
                break;
            case R.id.checkbox_challenge2:
                if (mChallenge2.isChecked()) {
                    mChallenge2.setActivated(true);
                    mChallenge2.setTextColor(Color.BLUE);
                }
                else {
                    mChallenge2.setActivated(false);
                    mChallenge2.setTextColor(Color.BLACK);
                }

                PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("check2", mChallenge2.isChecked()).commit();

                break;
            case R.id.checkbox_challenge3:
                if (mChallenge3.isChecked()) {
                    mChallenge3.setActivated(true);
                    mChallenge3.setTextColor(Color.BLUE);
                }
                else {
                    mChallenge3.setActivated(false);
                    mChallenge3.setTextColor(Color.BLACK);
                }

                PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("check3", mChallenge3.isChecked()).commit();

                break;
            case R.id.checkbox_challenge4:
                if (mChallenge4.isChecked()) {
                    mChallenge4.setActivated(true);
                    mChallenge4.setTextColor(Color.BLUE);
                }
                else {
                    mChallenge4.setActivated(false);
                    mChallenge4.setTextColor(Color.BLACK);
                }

                PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("check4", mChallenge4.isChecked()).commit();
                break;
            case R.id.checkbox_challenge5:
                if (mChallenge5.isChecked()) {
                    mChallenge5.setActivated(true);
                    mChallenge5.setTextColor(Color.BLUE);
                }
                else {
                    mChallenge5.setActivated(false);
                    mChallenge5.setTextColor(Color.BLACK);
                }

                PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("check5", mChallenge5.isChecked()).commit();
                break;
            case R.id.checkbox_challenge6:
                if (mChallenge6.isChecked()) {
                    mChallenge6.setActivated(true);
                    mChallenge6.setTextColor(Color.BLUE);
                }
                else {
                    mChallenge6.setActivated(false);
                    mChallenge6.setTextColor(Color.BLACK);
                }

                PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("check6", mChallenge6.isChecked()).commit();
                break;
            case R.id.checkbox_challenge7:
                if (mChallenge7.isChecked()) {
                    mChallenge7.setActivated(true);
                    mChallenge7.setTextColor(Color.BLUE);
                }
                else {
                    mChallenge7.setActivated(false);
                    mChallenge7.setTextColor(Color.BLACK);
                }

                PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("check7", mChallenge7.isChecked()).commit();
                break;
            case R.id.checkbox_challenge8:
                if (mChallenge8.isChecked()) {
                    mChallenge8.setActivated(true);
                    mChallenge8.setTextColor(Color.BLUE);
                }
                else {
                    mChallenge8.setActivated(false);
                    mChallenge8.setTextColor(Color.BLACK);
                }

                PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("check8", mChallenge8.isChecked()).commit();
                break;
            case R.id.checkbox_challenge9:
                if (mChallenge9.isChecked()) {
                    mChallenge9.setActivated(true);
                    mChallenge9.setTextColor(Color.BLUE);
                }
                else {
                    mChallenge9.setActivated(false);
                    mChallenge9.setTextColor(Color.BLACK);
                }

                PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("check9", mChallenge9.isChecked()).commit();
                break;
            case R.id.checkbox_challenge10:
                if (mChallenge10.isChecked()) {
                    mChallenge10.setActivated(true);
                    mChallenge10.setTextColor(Color.BLUE);
                }
                else {
                    mChallenge10.setActivated(false);
                    mChallenge10.setTextColor(Color.BLACK);
                }

                PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("check10", mChallenge10.isChecked()).commit();
                break;
        }


    }

    public void onClickSave(View view) {
        //super.onBackPressed();
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("dailyChallengesPressed", true).commit();
        finish();
    }
}