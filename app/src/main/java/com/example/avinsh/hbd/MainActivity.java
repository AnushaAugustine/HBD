package com.example.avinsh.hbd;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;


    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton image = (ImageButton) findViewById(R.id.imageButton2);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation1 =
                        AnimationUtils.loadAnimation(getApplicationContext(),
                                R.anim.rotate);
                image.startAnimation(animation1);



                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.hb);

                mediaPlayer.start();


            }
        });



        final int[] drawablearray=new int[]{
                R.drawable.p1,R.drawable.p2,R.drawable.p4,R.drawable.p5,R.drawable.p3,R.drawable.p6,
                R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10};
        gettingBackground(drawablearray);



    }

    private void gettingBackground(final int[] drawablearray) {

        new Handler().postDelayed(new Runnable() {
            public void run() {

                if(count<drawablearray.length){
                    MainActivity.this.getWindow().
                            setBackgroundDrawableResource(drawablearray[count]);
                    count++;
                    gettingBackground(drawablearray);
                }
                else{
                    count=0;
                }
            }
        }, 4500);
    }


    @Override
    protected void onStart() {
        final ImageButton image = (ImageButton) findViewById(R.id.imageButton2);
        super.onStart();

        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.myanimation);
        image.startAnimation(animation);

        MainActivity.this.getWindow().
                setBackgroundDrawableResource(R.drawable.p1);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}