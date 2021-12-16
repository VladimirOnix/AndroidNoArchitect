package com.sample.arch.forbidden;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class AnimationActivity extends AppCompatActivity {

    private Button mButtonAnimated;
    private ImageButton mButtonValueAnimator;
    private ImageButton mButtonObjectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        mButtonAnimated = findViewById(R.id.buttonMoved);
        mButtonValueAnimator = findViewById(R.id.imageButtonRight);
        mButtonObjectAnimator= findViewById(R.id.imageButtonLeft);

        mButtonValueAnimator.setOnClickListener((view)->{
            ValueAnimator animation = ValueAnimator.ofFloat(0f, 100f);
            animation.setDuration(1000);
            animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float animatedValue = (float)animation.getAnimatedValue();
                    mButtonAnimated.setTranslationX(animatedValue);
                }
            });
            animation.start();
        });

        mButtonObjectAnimator.setOnClickListener((view)->{
            ObjectAnimator animation = ObjectAnimator.ofFloat(mButtonAnimated, "translationY", 100f);
            animation.setDuration(1000);
            animation.start();
        });

    }
}