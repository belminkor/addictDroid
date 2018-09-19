package com.example.bela.addictdroid;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EmergencyCalls extends AppCompatActivity {

    Button mChooseContact;
    Button mCall;
    ImageView mPoliceCall;
    ImageView mAmbulanceCall;
    TextView nekiTekst;
    private static final int REQUEST_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_calls);

        final String emergencyCall = PreferenceManager.getDefaultSharedPreferences(this).getString("call", "");
        nekiTekst = (TextView) findViewById(R.id.neki_tekst);

        mChooseContact = (Button) findViewById(R.id.choose_contact);
        mChooseContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent pickContact = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(pickContact, REQUEST_CONTACT);
            }
        });

        mCall = (Button) findViewById(R.id.button_call);
        mCall.setText(emergencyCall);
        mCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                callIntent.setData(Uri.parse("tel:124356789"));

                if (ActivityCompat.checkSelfPermission(EmergencyCalls.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });

        mAmbulanceCall = (ImageView) findViewById(R.id.ambulance_call);
        mAmbulanceCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                callIntent.setData(Uri.parse("tel:124"));

                if (ActivityCompat.checkSelfPermission(EmergencyCalls.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });

        mPoliceCall = (ImageView) findViewById(R.id.police_call);
        mPoliceCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                callIntent.setData(Uri.parse("tel:122"));

                if (ActivityCompat.checkSelfPermission(EmergencyCalls.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CONTACT) {
            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String[] projection = {  ContactsContract.Contacts.DISPLAY_NAME };

                Cursor cursor = getContentResolver().query(uri, projection,
                        null, null, null);
                cursor.moveToFirst();

                int nameColumnIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);

                String name = cursor.getString(nameColumnIndex);

                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("call", name).apply();
                mCall.setText(name);
            }
        }
    }

    public Context getContext() {
        return this;
    }

}
