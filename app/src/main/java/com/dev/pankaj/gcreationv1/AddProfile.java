package com.dev.pankaj.gcreationv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddProfile extends AppCompatActivity {

    private EditText name;
    private EditText dob;
    private EditText dobTime;
    private EditText birthPlace;
    private EditText city;
    private EditText qualification;
    private EditText gotra;
    private EditText occupation;
    private EditText mobile_no;
    private Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);
        name = (EditText)findViewById(R.id.name);
        dob = (EditText)findViewById(R.id.dob);
        dobTime = (EditText)findViewById(R.id.dobTime);
        birthPlace = (EditText)findViewById(R.id.birthPlace);
        qualification = (EditText)findViewById(R.id.qualification);
        city = (EditText) findViewById(R.id.city);
        gotra = (EditText)findViewById(R.id.gotra);
        occupation = (EditText)findViewById(R.id.occupation);
        mobile_no = (EditText)findViewById(R.id.mobile_no);
        submitButton = (Button)findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
                saveForm();
            }
        });
    }
    protected void validate()
    {

    }
    protected void saveForm()
    {
        ProfileData profileData = new ProfileData(
                name.getText().toString(),
                dob.getText().toString(),
                dobTime.getText().toString(),
                birthPlace.getText().toString(),
                city.getText().toString(),
                qualification.getText().toString(),
                gotra.getText().toString(),
                occupation.getText().toString(),
                mobile_no.getText().toString()
        );
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("profile").child(profileData.getMobile_no()).setValue(profileData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("FirebaseData","Added");
                startActivity(new Intent(AddProfile.this,MainActivity.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("FirebaseData",e.getLocalizedMessage());
            }
        });
    }
}
