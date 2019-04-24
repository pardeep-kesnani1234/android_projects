package com.example.pardeep.button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     public void GreenTapped(View v )
     {
         ImageView greeni=(ImageView) findViewById(R.id.green);
         ImageView yellowe=(ImageView)findViewById(R.id.yellow);
         greeni.animate().alpha(1).setDuration(1000);
         yellowe.animate().alpha(0).setDuration(1000);


     }
    public void YellowTapped(View v)
    {
        ImageView greeni=(ImageView) findViewById(R.id.green);
        ImageView yellowe=(ImageView)findViewById(R.id.yellow);
        greeni.animate().alpha(0).setDuration(1000);
        yellowe.animate().alpha(1).setDuration(1000);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
