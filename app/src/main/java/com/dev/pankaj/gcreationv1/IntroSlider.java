package com.dev.pankaj.gcreationv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class IntroSlider extends AppCompatActivity {

    private ViewPager viewPager;
    private Button doneIntro;
    private SliderAdapter sliderAdapter;
    public static String COMPLETED_INTRO="completed";
    private int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_slider);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        doneIntro = (Button) findViewById(R.id.done);
        sliderAdapter = new SliderAdapter(this);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state==ViewPager.SCROLL_STATE_IDLE)
                {
                    int curr = viewPager.getCurrentItem();
                    int lastReal = viewPager.getAdapter().getCount()-1;
                    if(curr<lastReal)
                    {
                        counter=0;
                    }
                    else if(curr==lastReal)
                    {
                        counter++;
                        doneIntro.setText("Done");
                        if(counter==2)
                        {
                            viewPager.setOffscreenPageLimit(0);
                            viewPager.setCurrentItem(0,false);
                            counter=0;
                        }
                    }
                }
            }
        });
        viewPager.setAdapter(sliderAdapter);
        doneIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroSlider.this,MainActivity.class));
                finish();
            }
        });
    }

}
