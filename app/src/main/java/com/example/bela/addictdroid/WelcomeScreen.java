package com.example.bela.addictdroid;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;

public class WelcomeScreen extends AppCompatActivity {

    String mUsername;
    EditText inputName;
    String mAddiction;
    Spinner selectAddiction;
    TextView mDate;
    Button startSession;

    // service connection
    private boolean mIsBound = false;
    private MusicService mServ;
    private ServiceConnection Scon =new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((MusicService.ServiceBinderbinder).getService());
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        // service start
        //doBindService();
        Intent music = new Intent();
        music.setClass(this,MusicService.class);
        startService(music);

        inputName = (EditText) findViewById(R.id.userName);
        selectAddiction = (Spinner) findViewById(R.id.addictionSelect);
        mDate = (TextView) findViewById(R.id.current_date);

        // current date
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy");
        String dateString = sdf.format(date);
        mDate.setText(dateString);


        // start session
        startSession = (Button) findViewById(R.id.submitButton);
        startSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUsername = inputName.getText().toString();
                mAddiction = selectAddiction.getSelectedItem().toString();

                // save user name and their addiction
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("username", mUsername).commit();
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("addiction", mAddiction).commit();


                // alert dialog
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                String label = getString(R.string.welcome_message) + " " + mUsername + "?\n";
                label += "Let's get it started!";

                TextView alertDialogMessage = new TextView(getContext());
                alertDialogMessage.setText(label);
                alertDialogMessage.setPadding(10, 10, 10, 10);
                alertDialogMessage.setBackgroundResource(R.drawable.background1);
                alertDialogMessage.setGravity(Gravity.CENTER);
                alertDialogMessage.setTextColor(Color.BLACK);
                alertDialogMessage.setTextSize(25);
                alertDialogBuilder.setView(alertDialogMessage);

                alertDialogBuilder.setPositiveButton("Ready", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        Intent intent = new Intent(WelcomeScreen.this, MainScreen.class);
                        startActivity(intent);
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.getWindow();
                alertDialog.show();
            }
        });
    }

    public Context getContext() {
        return this;
    }

    // music player functions
    void doBindService(){
        bindService(new Intent(this,MusicService.class),
                Scon,Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService() {
        if(mIsBound)
        {
            unbindService(Scon);
            mIsBound = false;
        }
    }
}
