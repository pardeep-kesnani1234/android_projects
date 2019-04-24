package com.example.pardeep.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int myactiveplayer=0;
    int[] mygamestate={2,2,2,2,2,2,2,2,2};
public void ImageTapped(View v)


{


    ImageView myTapped=(ImageView) v;

    int index =Integer.parseInt(myTapped.getTag().toString());


    if(mygamestate[index]==2) {

        if (myactiveplayer == 0) {
            myTapped.setImageResource(R.drawable.circle);
            myTapped.animate().rotation(360).setDuration(1000);
            myactiveplayer = 1;
        } else
            {
            myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(1000);
            myactiveplayer = 0;
        }
        mygamestate[index]--;
    }
}





    public void PlayAgainTapped(View v)

    {
        //toast msg that play again tapped
        Toast.makeText(getApplicationContext(),"LET'S PLAY AGAIN" ,Toast.LENGTH_SHORT).show();

       for (int i=0;i<mygamestate.length;i++)
       {

           //change game state back to 2
           mygamestate[i] = 2;
       }

        //make activeplayer 0 again
       myactiveplayer=0;

        //change all selection to emojis
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.lineone);
           for (int i=0;i<linearLayout1.getChildCount();i++)
           {
               ((ImageView) linearLayout1.getChildAt(i)).setImageResource(R.drawable.emoji);
           }

        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linetwo);
        for (int i=0;i<linearLayout2.getChildCount();i++)
        {
            ((ImageView) linearLayout2.getChildAt(i)).setImageResource(R.drawable.emoji);
        }
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.linethree);
        for (int i=0;i<linearLayout3.getChildCount();i++)
        {
            ((ImageView) linearLayout3.getChildAt(i)).setImageResource(R.drawable.emoji);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
