package com.example.benji.myratp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Rigva on 15/03/2017.
 */

public class MainAppli extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_appli);
    }

    public void startRatp(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public void startTwoh(View view) {
        startActivity(new Intent(getApplicationContext(), main.class));
    }

    public void startgame(View view) {
        startActivity(new Intent(getApplicationContext(), MainGame.class));
    }

    public void startContact(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivityContact.class));
    }
}
