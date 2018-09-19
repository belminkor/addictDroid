package com.example.bela.addictdroid;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainScreen extends AppCompatActivity {

    Button mDailyMotivation;
    //Button mDailyChallenges;
    Button mRelapse;
    Button mMyGoals;
    TextView dayCounter;
    //boolean dailyChallengesPressed;
    ImageView mPhoneCalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        final String userName = PreferenceManager.getDefaultSharedPreferences(this).getString("username", "");
        final String addiction = PreferenceManager.getDefaultSharedPreferences(this).getString("addiction", "");

        // personal informations
        dayCounter = (TextView) findViewById(R.id.day_count);

        //on regular click
        dayCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainScreen.this, Extras.class);
                startActivity(i);
            }
        });
        // on long click
        dayCounter.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(getContext());

                String newText = "User informations:\n\nUsername: " + userName + "\n\nAddiction: " + addiction +"\n";

                TextView alertDialogMessage = new TextView(getContext());
                alertDialogMessage.setText(newText);
                alertDialogMessage.setPadding(10, 10, 10, 10);
                alertDialogMessage.setBackgroundResource(R.drawable.background1);
                alertDialogMessage.setGravity(Gravity.CENTER);
                alertDialogMessage.setTextColor(Color.BLACK);
                alertDialogMessage.setTextSize(25);
                alertDialogBuilder.setView(alertDialogMessage);

                alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // do nothing
                    }
                });

                android.support.v7.app.AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.getWindow();
                alertDialog.show();
                return true;
            }
        });

        // daily motivation
        mDailyMotivation = (Button) findViewById(R.id.daily_motivation_button);
        mDailyMotivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainScreen.this, DailyMotivation.class);
                startActivity(i);
            }
        });

        // daily challenges
//        mDailyChallenges = (Button) findViewById(R.id.daily_challenges_button);
//        if(savedInstanceState != null) {
//            dailyChallengesPressed = savedInstanceState.getBoolean("dailyChallengesPressed", false);
//            mDailyChallenges.clearAnimation();
//        }
//        else {
//            Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
//            mDailyChallenges.startAnimation(shake);
//        }

//        mDailyChallenges.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putBoolean("dailyChallengesPressed", true).commit();
//                mDailyChallenges.clearAnimation();
//                Intent intent = new Intent(MainScreen.this, DailyChallenges.class);
//                startActivity(intent);
//            }
//        });

        // relapse
        mRelapse = (Button) findViewById(R.id.relapse_button);
        mRelapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, Relapse.class);
                startActivity(intent);
            }
        });

        // my goals
        mMyGoals = (Button) findViewById(R.id.my_goals_button);
        mMyGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, GoalListActivity.class);
                startActivity(intent);
            }
        });

        // phone calls
        mPhoneCalls = (ImageView) findViewById(R.id.phone_calls);
        mPhoneCalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainScreen.this, EmergencyCalls.class);
                startActivity(intent);
            }
        });

        // animation change colors for day counter
        TextView ourLayout = (TextView) findViewById(R.id.day_count);
        AnimationDrawable animationDrawable = (AnimationDrawable) ourLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

    }

    public Context getContext() {
        return this;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("dailyChallengesPressed", true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putBoolean("dailyChallengesPressed",false).apply();
    }
}
