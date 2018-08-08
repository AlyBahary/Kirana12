package com.example.bahary.kirana12;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bahary.kirana12.Utils.Constants;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;
import com.orhanobut.hawk.Hawk;

public class WelcomeSliderActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // AppIntro will do the rest.

        SliderPage sliderPage=new SliderPage();
        //addSlide(LastSlider.newInstance(R.layout.slider3));
        LastSlider l=new LastSlider();
        FirstSliderFragment f=new FirstSliderFragment();
        SecondSliderFragment s = new SecondSliderFragment();
        //addSlide(SampleSlide.newInstance(R.layout.slider1));
        //addSlide(SampleSlide.newInstance(R.layout.slider2));
        addSlide(f);
        addSlide(s);
        addSlide(l);
        // Hide Skip/Done button.
        setSeparatorColor(Color.parseColor("#fff2ca"));
        showSkipButton(false);
        setProgressButtonEnabled(false);
        setIndicatorColor(Color.parseColor("#d12525"),Color.parseColor("#FFF79797"));



    }
}
