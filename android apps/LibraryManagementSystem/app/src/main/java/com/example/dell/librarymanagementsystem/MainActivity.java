package com.example.dell.librarymanagementsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView Textfield1 = (TextView) findViewById(R.id.TextField1);
        final TextView Textfield2 = (TextView) findViewById(R.id.TextField2);

        Button login = (Button) findViewById(R.id.Login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validate(Textfield1.getText().toString(), Textfield2.getText().toString());

            }
        });
    }



    public void validate(String text1, String text2) {

        String uname="w",upassword="w";
        TextView label3 = (TextView) findViewById(R.id.textView6);


        if (text1.equals(uname) && text2.equals(upassword)) {

            Toast.makeText(MainActivity.this, "LOGIN SUCCEESFULLY", Toast.LENGTH_SHORT).show();


            label3.setVisibility(View.INVISIBLE);

        } else {
            label3.setVisibility(View.VISIBLE);

            Toast.makeText(MainActivity.this, "LogIn Failed", Toast.LENGTH_SHORT).show();

        }
    }
    }
