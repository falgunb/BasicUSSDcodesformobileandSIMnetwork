package com.aswdc.USSDcodes.design;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aswdc.USSDcodes.R;

public class Activity_Carrier extends AppCompatActivity {
    Button btnAircel;
    Button btnAirtel;
    Button btnBsnl;
//    Button btnIdea;
    Button btnReliance;
    Button btnTelenor;
    Button btnVideocon;
    Button btnVodafone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrier);

        btnAircel = findViewById(R.id.cc_tv_aircel);
        btnAirtel = findViewById(R.id.cc_tv_airtel);
        btnBsnl = findViewById(R.id.cc_tv_bsnl);
        btnReliance = findViewById(R.id.cc_tv_reliance);
        btnTelenor = findViewById(R.id.cc_tv_telenor);
        btnVideocon = findViewById(R.id.cc_tv_videocon);
        btnVodafone = findViewById(R.id.cc_tv_vodafone);


        btnAircel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity_Carrier_airtel.class);
                i.putExtra("carriername","aircel");
                startActivity(i);
            }
        });

        btnAirtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity_Carrier_airtel.class);
                i.putExtra("carriername","airtel");
                startActivity(i);

            }
        });

        btnBsnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity_Carrier_airtel.class);
                i.putExtra("carriername","bsnl");
                startActivity(i);
            }
        });


        btnReliance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity_Carrier_airtel.class);
                i.putExtra("carriername","reliance");
                startActivity(i);
            }
        });

        btnTelenor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity_Carrier_airtel.class);
                i.putExtra("carriername","telenor");
                startActivity(i);
            }
        });

        btnVideocon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity_Carrier_airtel.class);
                i.putExtra("carriername","videocon");
                startActivity(i);
            }
        });

        btnVodafone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity_Carrier_airtel.class);
                i.putExtra("carriername","vodafone");
                startActivity(i);
            }
        });


    }

}
