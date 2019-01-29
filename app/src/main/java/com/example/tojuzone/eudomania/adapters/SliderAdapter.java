package com.example.tojuzone.eudomania.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tojuzone.eudomania.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    // Arrays
    public int[] slide_images = {
        R.drawable.ic_intro_person_1,
        R.drawable.ic_intro_person_2,
        R.drawable.ic_intro_person_3
    };

    public String[] slide_headings = {
            "Create an account",
            "Log into an account",
            "Log into an account"
    };

    public String[] slide_subheadings = {
            "Connect with counselours around the world",
            "Let’s help you with any challenge you are facing",
            "Sign Up and get counselled you Today"
    };

    public String[] slide_descriptions = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideSubHeading = (TextView) view.findViewById(R.id.slide_subheading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideSubHeading.setText(slide_subheadings[position]);
        slideDescription.setText(slide_descriptions[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
