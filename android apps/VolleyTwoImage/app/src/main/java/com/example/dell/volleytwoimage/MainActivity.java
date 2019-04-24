package com.example.dell.volleytwoimage;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {

    //https://upload.wikimedia.org/wikipedia/commons/e/ee/Android_green_figure%2C_next_to_its_original_packaging.jpg

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

final String myUrl="https://upload.wikimedia.org/wikipedia/commons/e/ee/Android_green_figure%2C_next_to_its_original_packaging.jpg";
        final ImageView imageView = (ImageView)findViewById(R.id.imageView);
        Button button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageRequest imageRequest = new ImageRequest(myUrl,
                        new Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap response) {
                                imageView.setImageBitmap(response);
                            }
                        }, 0, 0, null,
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(),"error is "+error,Toast.LENGTH_SHORT).show();

                            }
                        }
                );

                MySingleton.getMinstance(MainActivity.this).addToRequestQue(imageRequest);
            }
        });
    }
}
