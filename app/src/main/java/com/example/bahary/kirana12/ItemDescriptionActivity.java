package com.example.bahary.kirana12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class ItemDescriptionActivity extends AppCompatActivity {
    SliderLayout sliderLayout;
    TextView DesTitle, SpeciTitle, UsageTitle, SourceTitle;
    TextView Des, Speci, Usage, Source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);
        //////////
        DesTitle = findViewById(R.id.itemdesDesTitle);
        SpeciTitle = findViewById(R.id.itemdesSpecialityTitle);
        UsageTitle = findViewById(R.id.itemdesUsageTitle);
        SourceTitle = findViewById(R.id.itemdesProductSourceTitle);
        //////
        Des = findViewById(R.id.itemdesDes);
        Speci = findViewById(R.id.itemdesSpeciality);
        Usage = findViewById(R.id.itemdesUsage);
        Source = findViewById(R.id.itemdesSource);
        ////
        sliderLayout = findViewById(R.id.imageSlider);
        //******************************
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(3); //set scroll delay in seconds :
        setSliderViews();
        ///
        DesTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Des.setVisibility(View.VISIBLE);
            }
        });
        SpeciTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Speci.setVisibility(View.VISIBLE);
            }
        });
        UsageTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usage.setVisibility(View.VISIBLE);
            }
        });
        SourceTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Source.setVisibility(View.VISIBLE);
            }
        });


    }

    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            SliderView sliderView = new SliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.img_slider1);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.img_slider1);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.img_slider1);

                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.img_slider1);
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
            sliderView.setDescription("setDescription " + (i + 1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(ItemDescriptionActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }
}
