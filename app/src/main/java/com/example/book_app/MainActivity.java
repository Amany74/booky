package com.example.book_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  static int  SPLASH_SCREEN = 4000;
    //add animation variables
    Animation bottom_anim,top_anim;
    TextView  slogan ;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //  Animation
        bottom_anim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        top_anim = AnimationUtils.loadAnimation(this,R.anim.top_anim);

        slogan = findViewById(R.id.slogan);
        image = findViewById(R.id.image);

        slogan.setAnimation(bottom_anim);
        image.setAnimation(top_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,screen_one.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}