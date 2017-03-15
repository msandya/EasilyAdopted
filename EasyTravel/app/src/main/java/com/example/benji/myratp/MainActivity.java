package com.example.benji.myratp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easilytravel);

        Button next = (Button) findViewById(R.id.ligne6);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Actrerb.class);
                startActivityForResult(myIntent, 0);
            }
        });

        Button next1 = (Button) findViewById(R.id.ligne7);
        next1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), com.example.benji.myratp.ActLineSeven.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
