package com.example.myrecipe.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myrecipe.R;

public class SplashScreen extends AppCompatActivity {

    private static int Splash_screen  = 3000;

    Animation topAnim, bottomAnim;
    ImageView logo;
    TextView name, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        logo = findViewById(R.id.logo);
        name = findViewById(R.id.textView);
        slogan = findViewById(R.id.slogan);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        logo.setAnimation(topAnim);
        name.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, DashBoard.class);
                Pair[] pairs = new Pair[2];
                pairs[0] =new Pair<View, String>(logo,"logo_image");
                pairs[1] =new Pair<View, String>(logo,"logo_text");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this, pairs);
                    startActivity(intent, options.toBundle());
                    finish();
                }
            }
        },Splash_screen);
    }
}