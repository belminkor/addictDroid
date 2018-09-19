package com.example.bela.addictdroid;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class Relapse extends AppCompatActivity {

    EditText relapse1;
    EditText relapse2;
    TextView mDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relapse);

        relapse1 = (EditText) findViewById(R.id.reasons_why);
        relapse2 = (EditText) findViewById(R.id.reasons_why_not);

        mDate = (TextView) findViewById(R.id.current_date);
        String relapseText1 = PreferenceManager.getDefaultSharedPreferences(this).getString("relapse1", "");
        String relapseText2 = PreferenceManager.getDefaultSharedPreferences(this).getString("relapse2", "");
        if (relapseText1 != null) {
            relapse1.setText(relapseText1);
        }
        if (relapseText2 != null) {
            relapse2.setText(relapseText2);
        }
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy");
        String dateString = sdf.format(date);
        mDate.setText(dateString);


    }


    public void onClickSaveRelapse(View view) {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("relapse1", relapse1.getText().toString()).commit();
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("relapse2", relapse2.getText().toString()).commit();
        finish();
    }
}
