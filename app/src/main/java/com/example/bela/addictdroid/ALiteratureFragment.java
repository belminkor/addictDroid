package com.example.bela.addictdroid;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ALiteratureFragment extends Fragment {
    private TextView link0;
    private TextView link1;
    private TextView link2;
    private TextView link3;
    private TextView link4;
    private TextView link5;

    @Override
    public void onCreate(Bundle savedInstanceState)	{
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)	{
        View v=inflater.inflate(R.layout.fragment_aliterature,container,false);

        link0=(TextView)v.findViewById(R.id.link0);
        link1=(TextView)v.findViewById(R.id.link1);
        link2=(TextView)v.findViewById(R.id.link2);
        link3=(TextView)v.findViewById(R.id.link3);
        link4=(TextView)v.findViewById(R.id.link4);
        link5=(TextView)v.findViewById(R.id.link5);


        return	v;
    }
}
