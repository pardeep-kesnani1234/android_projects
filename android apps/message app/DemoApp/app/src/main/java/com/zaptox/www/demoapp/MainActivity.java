package com.zaptox.www.demoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 Button b;
 EditText etNum,etMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.btn);
        etNum=(EditText)findViewById(R.id.editTextNumber);
        etMsg=(EditText)findViewById(R.id.editTextMsg);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String Msg=etMsg.getText().toString();
               String num=etNum.getText().toString();
                SmsManager sms= SmsManager.getDefault();
                sms.sendTextMessage(num,null,Msg,null,null);
                Toast.makeText(MainActivity.this,""+Msg+" to "+num,Toast.LENGTH_SHORT).show();
                etNum.setText("");
                etMsg.setText("");

                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);

            }
        }
        );
    }
}
