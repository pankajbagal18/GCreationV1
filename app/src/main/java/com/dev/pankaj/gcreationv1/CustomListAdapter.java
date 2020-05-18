package com.dev.pankaj.gcreationv1;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter {
    Activity context;
    List<ProfileData> data;
    TextView name;
    TextView mobile_no;
    public CustomListAdapter(@NonNull Activity context, @NonNull List<ProfileData> profileData) {
        super(context, R.layout.profile_row_layout,profileData);
        this.context = context;
        this.data = profileData;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        row = inflater.inflate(R.layout.profile_row_layout,null,true);
        name = row.findViewById(R.id.row_name);
        mobile_no = row.findViewById(R.id.row_mobile_no);
        ImageView imageView = row.findViewById(R.id.row_image);
        Log.d("Ada",data.get(position).getName());
        name.setText(data.get(position).getName());
        mobile_no.setText(data.get(position).getMobile_no());
        return row;
    }
}
