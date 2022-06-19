package com.example.raindrop;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.raindrop.ui.Create;

import butterknife.BindView;
import butterknife.ButterKnife;

public  class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.button)
    Button mClickButton;
    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.animationView)
    View lottie;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // Custom animation speed or duration.
        ValueAnimator animator
                = ValueAnimator.ofFloat(0f, 1f);
        animator
                .addUpdateListener(animation -> {
                    lottie.setScaleX((float) animation.getAnimatedValue());
                    lottie.setScaleY((float) animation.getAnimatedValue());
                });
        animator.start();


        mClickButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == mClickButton) {
            Intent intent = new Intent(MainActivity.this, Create.class);
            startActivity(intent);
        }

        LottieAnimationView animationView
                = findViewById(R.id.animationView);
        animationView
                .addAnimatorUpdateListener(
                        (animation) -> {
                            // Do something.
                        });
        animationView
                .playAnimation();

        if (animationView.isAnimating()) {
            // Do something.
        }


        YoYo.with(Techniques.SlideInDown)
                .duration(500)
                .repeat(5)
                .playOn(findViewById(R.id.textView));

    }

}