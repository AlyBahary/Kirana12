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
        // Hawk.init(this).build();
        //   Hawk.put(Constants.Welcome_Flag, "1");
        Hawk.init(this).build();
        if (!Hawk.contains(Constants.Welcome_Flag)) {
            Intent i = new Intent(this, WelcomeSliderActivity.class);
            startActivity(i);
        }
        // AppIntro will do the rest.
        addSlide(SampleSlide.newInstance(R.layout.slider1));
        addSlide(SampleSlide.newInstance(R.layout.slider2));
        //addSlide(LastSlider.newInstance(R.layout.slider3));
        LastSlider l=new LastSlider();
        addSlide(l);
 /*       SliderPage sliderPage = new SliderPage();
        sliderPage.setTitle("");
        sliderPage.setDescription("");
        sliderPage.setImageDrawable(R.drawable.ic_remove_red_eye_black_24dp);

        sliderPage.setBgColor(Color.parseColor("#3F51B5"));

        addSlide(AppIntroFragment.newInstance(sliderPage));
        SliderPage sliderPage1 = new SliderPage();
        sliderPage1.setTitle("");
        sliderPage1.setDescription("");
        sliderPage1.setImageDrawable(R.drawable.ic_remove_red_eye_black_24dp);
        sliderPage1.setBgColor(Color.parseColor("#3F51B5"));
        addSlide(AppIntroFragment.newInstance(sliderPage1));

        // OPTIONAL METHODS
        // Override bar/separator color.
        // setBarColor(Color.parseColor("#3F51B5"));
        //setSeparatorColor(Color.parseColor("#2196F3"));
*/
        // Hide Skip/Done button.
        setSeparatorColor(Color.parseColor("#fff2ca"));
        showSkipButton(false);
        setProgressButtonEnabled(false);
        setIndicatorColor(Color.parseColor("#d12525"),Color.parseColor("#FFF79797"));



    }
}
