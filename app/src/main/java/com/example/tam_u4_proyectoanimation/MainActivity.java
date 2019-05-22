package com.example.tam_u4_proyectoanimation;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private MediaPlayer reproductor;
    private AnimationDrawable blackMen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reproductor=MediaPlayer.create(this,R.raw.sonido);
        reproductor.start();
        imageView = findViewById(R.id.imageView);

        if (imageView == null) throw new AssertionError();

        imageView.setBackgroundResource(R.drawable.animation_list);

        blackMen = (AnimationDrawable) imageView.getBackground();
        blackMen.setOneShot(true);

        if (blackMen.isRunning()) {
            blackMen.stop();
        }
        blackMen.start();

    }

    public void onStartBtnClick(View v) {
        Intent o = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(o);
        reproductor.stop();
    }
}
