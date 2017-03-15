package com.example.benji.myratp;

import android.content.Intent;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class main extends AppCompatActivity {

    private TextView scoreLabel;
    private ImageView player;
    private ImageView bullet1;
    private ImageView bullet2;
    private ImageView bullet3;
    private ImageView bullet4;
    private ImageView bullet5;
    private ImageView bullet6;
    private ImageView bullet7;


    private int frameHeight;
    private int boxSize;
    private int ScreenWidth;
    private int ScreenHeight;

    private int b1X = 0;
    private int b1Y = 0;
    private int b2X = 0;
    private int b2Y = 0;
    private int b3X = 0;
    private int b3Y = 0;
    private int b4X = 0;
    private int b4Y = 0;
    private int b5X = 0;
    private int b5Y = 0;
    private int b6X = 0;
    private int b6Y = 0;
    private int b7X = 0;
    private int b7Y = 0;
    private int boxY = 600;

    private int score = 0;
    private int frame = 0;
    private int clicked = 0;

    private Handler handler = new Handler();
    private Timer timer = new Timer();

    private boolean start_flg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_twho);

        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);

        ScreenWidth = size.x;
        ScreenHeight = size.y;

        scoreLabel = (TextView) findViewById(R.id.score);
        player = (ImageView) findViewById(R.id.player);
        player.setX(50);
        player.setY(boxY);

        bullet1 = (ImageView) findViewById(R.id.bullet1);
        b1X = ScreenWidth + 2000;
        b1Y = (int)Math.floor(Math.random() * (ScreenHeight - bullet1.getHeight()));
        bullet1.setX(b1X);
        bullet1.setY(b1Y);

        bullet2 = (ImageView) findViewById(R.id.bullet2);
        b2X = ScreenWidth + 2500;
        b2Y = (int)Math.floor(Math.random() * (ScreenHeight - bullet2.getHeight()));
        bullet2.setX(b2X);
        bullet2.setY(b2Y);

        bullet3 = (ImageView) findViewById(R.id.bullet3);
        b3X = ScreenWidth + 1800;
        b3Y = (int)Math.floor(Math.random() * (ScreenHeight - bullet3.getHeight()));
        bullet3.setX(b3X);
        bullet3.setY(b3Y);

        bullet4 = (ImageView) findViewById(R.id.bullet4);
        b4X = ScreenWidth + 2700;
        b4Y = (int)Math.floor(Math.random() * (ScreenHeight - bullet4.getHeight()));
        bullet4.setX(b4X);
        bullet4.setY(b4Y);

        bullet5 = (ImageView) findViewById(R.id.bullet5);
        b5X = ScreenWidth + 1500;
        b5Y = (int)Math.floor(Math.random() * (ScreenHeight - bullet5.getHeight()));
        bullet5.setX(b5X);
        bullet5.setY(b5Y);

        bullet6 = (ImageView) findViewById(R.id.bullet6);
        b6X = ScreenWidth + 2000;
        b6Y = (int)Math.floor(Math.random() * (ScreenHeight - bullet6.getHeight()));
        bullet6.setX(b6X);
        bullet6.setY(b6Y);

        bullet7 = (ImageView) findViewById(R.id.bullet7);
        b7X = ScreenWidth + 3000;
        b7Y = (int)Math.floor(Math.random() * (ScreenHeight - bullet7.getHeight()));
        bullet7.setX(b7X);
        bullet7.setY(b7Y);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        }, 0, 20);
    }

    public void changePos() {

        if(start_flg == true) {

            HitCheck();

            if(frame % 30 == 0) {
                score += 50;
            }
            b1X -= 20;
            if(b1X < 0) {
                b1X = ScreenWidth + 20;
                b1Y = (int)Math.floor(Math.random() * (ScreenHeight - bullet1.getHeight()));
            }
            bullet1.setX(b1X);
            bullet1.setY(b1Y);

            b2X -= 30;
            if(b2X < 0) {
                b2X = ScreenWidth + 30;
                b2Y = (int)Math.floor(Math.random() * (ScreenHeight - bullet2.getHeight()));
            }
            bullet2.setX(b2X);
            bullet2.setY(b2Y);

            b3X -= 10;
            if(b3X < 0) {
                b3X = ScreenWidth + 10;
                b3Y = (int)Math.floor(Math.random() * (ScreenHeight - bullet3.getHeight()));
            }
            bullet3.setX(b3X);
            bullet3.setY(b3Y);

            b4X -= 25;
            if(b4X < 0) {
                b4X = ScreenWidth + 25;
                b4Y = (int)Math.floor(Math.random() * (ScreenHeight - bullet4.getHeight()));
            }
            bullet4.setX(b4X);
            bullet4.setY(b4Y);

            b5X -= 20;
            if(b5X < 0) {
                b5X = ScreenWidth + 20;
                b5Y = (int)Math.floor(Math.random() * (ScreenHeight - bullet5.getHeight()));
            }
            bullet5.setX(b5X);
            bullet5.setY(b5Y);

            b6X -= 15;
            if(b6X < 0) {
                b6X = ScreenWidth + 10;
                b6Y = (int)Math.floor(Math.random() * (ScreenHeight - bullet6.getHeight()));
            }
            bullet6.setX(b6X);
            bullet6.setY(b6Y);

            b7X -= 30;
            if(b7X < 0) {
                b7X = ScreenWidth + 40;
                b7Y = (int)Math.floor(Math.random() * (ScreenHeight - bullet7.getHeight()));
            }
            bullet7.setX(b7X);
            bullet7.setY(b7Y);

            if(clicked != 0 && clicked <= frame && clicked + 10 >= frame) {
                boxY -= 20;
            }
            else {
                boxY += 20;
            }

            if(boxY < 0) boxY = 0;
            player.setY(boxY);
            frame++;
            scoreLabel.setText("Score : " + score);
        }
    }

    public void HitCheck() {
        int b1CenterX = b1X + bullet1.getWidth() / 2;
        int b1CenterY = b1Y + bullet1.getHeight() / 2;
        int b2CenterX = b2X + bullet2.getWidth() / 2;
        int b2CenterY = b2Y + bullet2.getHeight() / 2;
        int b3CenterX = b3X + bullet3.getWidth() / 2;
        int b3CenterY = b3Y + bullet3.getHeight() / 2;
        int b4CenterX = b4X + bullet4.getWidth() / 2;
        int b4CenterY = b4Y + bullet4.getHeight() / 2;
        int b5CenterX = b5X + bullet5.getWidth() / 2;
        int b5CenterY = b5Y + bullet5.getHeight() / 2;
        int b6CenterX = b6X + bullet6.getWidth() / 2;
        int b6CenterY = b6Y + bullet6.getHeight() / 2;
        int b7CenterX = b7X + bullet7.getWidth() / 2;
        int b7CenterY = b7Y + bullet7.getHeight() / 2;

        if(player.getX() <= b1CenterX && b1CenterX <= player.getX() + player.getWidth()
                && player.getY() <= b1CenterY && b1CenterY <= player.getY() + player.getHeight() ||
                player.getX() <= b2CenterX && b2CenterX <= player.getX() + player.getWidth()
                        && player.getY() <= b2CenterY && b2CenterY <= player.getY() + player.getHeight() ||
                player.getX() <= b3CenterX && b3CenterX <= player.getX() + player.getWidth()
                        && player.getY() <= b3CenterY && b3CenterY <= player.getY() + player.getHeight() ||
                player.getX() <= b4CenterX && b4CenterX <= player.getX() + player.getWidth()
                        && player.getY() <= b4CenterY && b4CenterY <= player.getY() + player.getHeight() ||
                player.getX() <= b5CenterX && b5CenterX <= player.getX() + player.getWidth()
                        && player.getY() <= b5CenterY && b5CenterY <= player.getY() + player.getHeight() ||
                player.getX() <= b6CenterX && b6CenterX <= player.getX() + player.getWidth()
                        && player.getY() <= b6CenterY && b6CenterY <= player.getY() + player.getHeight() ||
                player.getX() <= b7CenterX && b7CenterX <= player.getX() + player.getWidth()
                        && player.getY() <= b7CenterY && b7CenterY <= player.getY() + player.getHeight() ||
                boxY > frameHeight - boxSize) {
            timer.cancel();
            timer = null;

            Intent intent = new Intent(getApplicationContext(), result.class);
            intent.putExtra("SCORE", score);
            startActivity(intent);
        }
    }

    public boolean onTouchEvent(MotionEvent me) {
        if(start_flg == false) {
            start_flg = true;

            FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
            frameHeight = frame.getHeight();
            boxSize = player.getHeight();


        } else {
            if(me.getAction() == MotionEvent.ACTION_DOWN) {
                clicked = frame;
            }
        }

        return true;
    }
}
