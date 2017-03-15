package com.example.benji.myratp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Rigva on 13/03/2017.
 */

public class ActLineSeven extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actrerb);

        Button next = (Button) findViewById(R.id.buttonrerbback);
        next.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        final TextView rerbtxt = (TextView) findViewById(R.id.rerbtxt);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api-ratp.pierre-grimaud.fr/v3/schedules/metros/7/Pierre_et_Marie_Curie/A";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() { @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    try {

                        JSONObject jsonObj = new JSONObject(response);
                        JSONObject res = jsonObj.getJSONObject("result");
                        JSONArray sch = res.getJSONArray("schedules");
                        String info = sch.getString(1);

                        String[] parts = info.split(",");

                        int i = 0;
                        while (parts[i] != null) {
                            if(parts[i].toLowerCase().contains("message".toLowerCase())) {
                                rerbtxt.setText(parts[i].substring(11, (parts[i].length()-1)));
                                break;
                            }
                            i++;
                        }

                    }
                    catch(JSONException e) {
                        System.out.print("No work");
                    }
                }
                }, new Response.ErrorListener() { @Override
        public void onErrorResponse(VolleyError error) {
            rerbtxt.setText("That didn't work!");
        }
        });
        queue.add(stringRequest);
    }
}