package com.aswdc.USSDcodes.design;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aswdc.USSDcodes.R;

public class MainActivity extends AppCompatActivity {
    Button btnCu;
    Button btnMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCu =  findViewById(R.id.main_btn_cu);
        btnMobile = findViewById(R.id.main_btn_mb);

        btnCu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity_Carrier.class);
                startActivity(i);
            }
        });
        btnMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity_Mobile_Codes.class);
                startActivity(i);
            }
        });


    }
}
