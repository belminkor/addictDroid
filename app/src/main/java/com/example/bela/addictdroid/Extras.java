package com.example.bela.addictdroid;

import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Extras extends FragmentActivity {

    private String mAddiction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAddiction = PreferenceManager.getDefaultSharedPreferences(this).getString("addiction", "");

        if(mAddiction.equals("Alcohol"))setContentView(R.layout.fragment_aliterature);
        else if(mAddiction.equals("Drugs")) setContentView(R.layout.fragment_nliterature);
        else if(mAddiction.equals("Tobacco")) setContentView(R.layout.fragment_tliterature);
    }
}
