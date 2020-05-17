package com.dev.pankaj.gcreationv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser==null)
        {
            Toast.makeText(this,"Please signin",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,AuthenticateUser.class));
        }
        else
        {
            Toast.makeText(this,"Welcome",Toast.LENGTH_LONG).show();
        }
    }
}
