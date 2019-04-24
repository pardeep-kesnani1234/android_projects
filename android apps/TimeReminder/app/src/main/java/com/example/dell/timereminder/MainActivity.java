package com.example.dell.timereminder;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView mnumber1= (TextView) findViewById(R.id.mnumber);
     final TextView done1= (TextView)findViewById(R.id.done);


        new CountDownTimer(10000,1000){
            public  void onTick(long millisecondsuntildone)
            {
                mnumber1.setText("TIME: "+String.valueOf(millisecondsuntildone/1000));
            }
            public void onFinish()
            {
              done1.setText("yupee! we did it!!!!");
            }
        }.start();
    }
}
