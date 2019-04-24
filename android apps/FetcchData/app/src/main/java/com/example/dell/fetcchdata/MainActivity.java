package com.example.dell.fetcchdata;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         final String myUrl=  "https://www.facebook.com";
            Button mybutton = (Button)findViewById(R.id.button);

mybutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);

        StringRequest stringRequest= new StringRequest(Request.Method.POST, myUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
Log.i("PAGE","WEB"+response);
                        Toast.makeText(getApplicationContext(),"WEBPAGE BY TOAST"+response,Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override

                    public void onErrorResponse(VolleyError error)
                    {
                        Log.i("Error","Error is "+ error);
                        Toast.makeText(getApplicationContext(),"error"+error,Toast.LENGTH_SHORT).show();

                    }
                }
        );
requestQueue.add(stringRequest);
    }
});
    }
}
