package com.dev.vivec.bookastudent.Code.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dev.vivec.bookastudent.R;

/**
 * Created by Teperics Márton on 2015.11.08..
 */
public class SplashScreen extends Activity{
    private static int timer = 1500;
    Animation animFadein;
    ImageView logo;
    RelativeLayout rl;

    public class Anim implements Animation.AnimationListener{
        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        logo = (ImageView)findViewById(R.id.splash_logo);
        rl = (RelativeLayout)findViewById(R.id.splash_lay);
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.move_fade);

        animFadein.setAnimationListener(new Anim());
        //Fadein anim
        animFadein.setFillAfter(true);
        logo.startAnimation(animFadein);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, LogReg.class);
                startActivity(i);
                finish();
            }
        }, timer);
    }

    public void onDestroy(){
        super.onDestroy();
    }

    public void onPause(){
        super.onPause();
    }
}
