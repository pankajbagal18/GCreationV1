package com.dev.pankaj.gcreationv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.Preferences;

public class SplashScreen extends AppCompatActivity {

    public static int SPLASH_SCREEN_TIME_OUT=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SplashScreen.this);
                boolean state = sharedPreferences.getBoolean(IntroSlider.COMPLETED_INTRO,false);
                if(!state)
                {
                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(SplashScreen.this).edit();
                    editor.putBoolean(IntroSlider.COMPLETED_INTRO,true);
                    editor.apply();
                    startActivity(new Intent(SplashScreen.this,IntroSlider.class));
                }
                else
                {
                    startActivity(new Intent(SplashScreen.this,MainActivity.class));
                }
                finish();
            }
        },SPLASH_SCREEN_TIME_OUT);
    }
}
