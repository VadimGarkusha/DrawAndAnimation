package com.example.vadimgarkusha.vadymharkusha_comp304_lab3;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Task2Activity extends AppCompatActivity {
    AnimationDrawable mframeAnimation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        final Button onButton = (Button) findViewById(R.id.btnStart);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.btnStop);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }

    private void startAnimation()
    {

        ImageView img = (ImageView)findViewById(R.id.imageView_Drop);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim5);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim6);
        BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim7);
        BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim8);
        BitmapDrawable frame9 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim9);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = 150;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);
        mframeAnimation.addFrame(frame5, reasonableDuration);
        mframeAnimation.addFrame(frame6, reasonableDuration);
        mframeAnimation.addFrame(frame7, reasonableDuration);
        mframeAnimation.addFrame(frame8, reasonableDuration);
        mframeAnimation.addFrame(frame9, reasonableDuration);


        img.setBackgroundDrawable(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }
    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);

    }
}
