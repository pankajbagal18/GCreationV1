package com.dev.pankaj.gcreationv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

public class ShowSelectedProfile extends AppCompatActivity {

    TextView showProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_selected_profile);
        ProfileData profileData = (ProfileData) getIntent().getParcelableExtra("PROFILE_DATA");
        showProfile = (TextView)findViewById(R.id.showProfile);
        showProfile.setText(profileData.toString());
    }
}
