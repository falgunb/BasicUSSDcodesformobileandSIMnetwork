package com.aswdc.USSDcodes.adapter;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aswdc.USSDcodes.R;



public class Adapter_Airtel extends RecyclerView.Adapter<Adapter_Airtel.ViewHolder> {


    private String[] splitCcode;
    private String[] splitCname;
    public Context context;

    public Adapter_Airtel(String[] splitCcode, String[] splitCname,Context context) {
        this.splitCcode = splitCcode;
        this.splitCname = splitCname;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_cc, viewGroup, false);
        return new Adapter_Airtel.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
    viewHolder.tvcc_tv_code.setText(splitCcode[i]);
    viewHolder.tvcc_tv_name.setText(splitCname[i]);

    viewHolder.tvcc_cv_dial.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String s = splitCcode[i].trim();
            s = s.replaceAll("[^0-9*#]", "");
            s = s.replace("#", "%23");

            Uri u = Uri.parse("tel:" +s);
            Intent i = new Intent(Intent.ACTION_DIAL, u);
            view.getContext().startActivity(i);
        }
    });
    }


    @Override
    public int getItemCount() {
        return splitCcode.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvcc_tv_name,tvcc_tv_code;
        public CardView tvcc_cv_dial;
        public ViewHolder(View view) {
            super(view);

            tvcc_tv_code = view.findViewById(R.id.tvcc_tv_code);
            tvcc_tv_name = view.findViewById(R.id.tvcc_tv_name);
            tvcc_cv_dial = view.findViewById(R.id.tvcc_cv_dial);

        }
    }
}
