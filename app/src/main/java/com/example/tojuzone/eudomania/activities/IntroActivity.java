package com.example.tojuzone.eudomania.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tojuzone.eudomania.R;
import com.example.tojuzone.eudomania.adapters.SliderAdapter;

public class IntroActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLinearLayout;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private Button mPrevBtn;
    private Button mNextBtn;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLinearLayout = findViewById(R.id.dotsLayout);

        mPrevBtn = findViewById(R.id.prev_btn);
        mNextBtn = findViewById(R.id.next_btn);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        // OnClickListener
        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage + 1);

                if (mCurrentPage == 2) {
                    Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(loginIntent);
                }
            }
        });

        mPrevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });
    }

    public void addDotsIndicator (int position) {
        mDots = new TextView[3];
        mDotLinearLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextColor(getResources().getColor(R.color.colorPrimary));
            mDots[i].setTextSize(40);

            mDotLinearLayout.addView(mDots[i]);
        }

        if(mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;

            if(i == 0) {
                mNextBtn.setEnabled(true);
                mPrevBtn.setEnabled(false);
                mPrevBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText("NEXT");
                mPrevBtn.setText("");
            } else if (i == mDots.length - 1) {
                mNextBtn.setEnabled(true);
                mPrevBtn.setEnabled(true);
                mPrevBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("FINISH");
                mPrevBtn.setText("BACK");
            } else {
                mNextBtn.setEnabled(true);
                mPrevBtn.setEnabled(true);
                mPrevBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("NEXT");
                mPrevBtn.setText("BACK");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
