package com.aswdc.USSDcodes.design;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.aswdc.USSDcodes.R;
import com.aswdc.USSDcodes.adapter.Adapter_Airtel;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class Activity_Carrier_airtel extends AppCompatActivity {

    RecyclerView rvCairtel;
    RecyclerView.LayoutManager mLayoutManagerairtel;
    Adapter_Airtel mAdapterairtel;
    TextView tvcc_tv_name,tvcc_tv_code;
    CardView tvcc_cv_dial;

    String cname, ccode;
    String[] splitCname;
    String[] splitCcode;
    String carrierAllname;
    public Context context;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrier_airtel);

        rvCairtel = findViewById(R.id.ca_rv_ca);
        tvcc_tv_code = findViewById(R.id.tvcc_tv_code);
        tvcc_tv_name = findViewById(R.id.tvcc_tv_name);
        tvcc_cv_dial = findViewById(R.id.tvcc_cv_dial);

        carrierAllname = Objects.requireNonNull(getIntent().getExtras()).getString("carriername");
        Resources res = getResources();
        InputStream is;

        switch (carrierAllname) {
            case "aircel":
                is = res.openRawResource(R.raw.aircel);
                break;
            case "airtel":
                is = res.openRawResource(R.raw.airtel);
                break;
            case "bsnl":
                is = res.openRawResource(R.raw.bsnl);
                break;
            case "reliance":
                is = res.openRawResource(R.raw.reliance);
                break;
            case "telenor":
                is = res.openRawResource(R.raw.telenor);
                break;
            case "videocon":
                is = res.openRawResource(R.raw.videocon);
                break;
            default:
                is = res.openRawResource(R.raw.vodafone);
                break;
        }


        Scanner scanner = new Scanner(is);
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        parseJson(builder.toString());

        mLayoutManagerairtel = new LinearLayoutManager(this);
        mAdapterairtel = new Adapter_Airtel(splitCcode,splitCname,context );
        rvCairtel.setLayoutManager(mLayoutManagerairtel);
        rvCairtel.setAdapter(mAdapterairtel);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void parseJson(String s) {

        StringBuilder builder = new StringBuilder();
        StringBuilder bf = new StringBuilder();


        try {
            JSONObject root = new JSONObject(s);
            JSONArray carriercode;
            switch (carrierAllname) {
                case "aircel":
                    carriercode = root.getJSONArray("Aircel");
                    break;
                case "airtel":
                    carriercode = root.getJSONArray("Airtel");
                    break;
                case "bsnl":
                    carriercode = root.getJSONArray("BSNL");
                    break;
                case "reliance":
                    carriercode = root.getJSONArray("Reliance");
                    break;
                case "telenor":
                    carriercode = root.getJSONArray("Telenor");
                    break;
                case "videocon":
                    carriercode = root.getJSONArray("Videocon");
                    break;
                default:
                    carriercode = root.getJSONArray("Vodafone");
                    break;
            }

            for (int i = 0; i < carriercode.length(); i++) {
                JSONObject aircelJSONObject = carriercode.getJSONObject(i);

                builder.append(aircelJSONObject.getString("name")).append("falgun");
                bf.append(aircelJSONObject.getString("code")).append("falgun");

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        cname = builder.toString();
        ccode = bf.toString();


        splitCname = cname.split("falgun");
        splitCcode = ccode.split("falgun");


    }
}
