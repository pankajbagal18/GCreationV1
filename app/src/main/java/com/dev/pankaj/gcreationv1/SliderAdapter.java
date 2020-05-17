package com.dev.pankaj.gcreationv1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.w3c.dom.Text;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.happy_face,
            R.drawable.email,
            R.drawable.wifi
    };

    public String[] slide_headings = {
            "Happy Face",
            "Email",
            "WIFI"
    };

    public String[] slide_description = {
            "lorem ipsum",
            "lorem ipsum",
            "lorem ipsum"
    };

    @Override
    public int getCount() {

        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImage = (ImageView)view.findViewById(R.id.introImage);
        TextView header = (TextView)view.findViewById(R.id.introHeader);
        TextView des= (TextView)view.findViewById(R.id.introDes);
        slideImage.setImageResource(slide_images[position]);
        header.setText(slide_headings[position]);
        des.setText(slide_description[position]);
        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
