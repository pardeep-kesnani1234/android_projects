package com.example.pardeep.rollnrock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] dices= {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six
    };
    public void rollTapped(View v)
    {
        ImageView MyDice=(ImageView)findViewById(R.id.dico);

        Random r = new Random();
        int n=r.nextInt(6);

          MyDice.animate().rotation(MyDice.getRotation()+360).start();
          MyDice.setImageResource(dices[n]);
        Toast.makeText(MainActivity.this,"YOU GOT:"+(n+1),Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
