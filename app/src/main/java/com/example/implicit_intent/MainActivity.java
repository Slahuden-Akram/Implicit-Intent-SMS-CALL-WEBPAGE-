package com.example.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btnWeb);
        Button btn2 = (Button) findViewById(R.id.btnSms);
        Button btn3 = (Button) findViewById(R.id.btnChooser);
        Button btn4 = (Button) findViewById(R.id.btnCall);
        TextView txt = (TextView) findViewById(R.id.editPhone);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "WebPage Button", Toast.LENGTH_SHORT).show();
                Uri webpage = Uri.parse("https://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
                    startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = txt.getText().toString();
                Uri sms = Uri.parse("smsto:"+t);
                Intent intent = new Intent(Intent.ACTION_SENDTO,sms);
                intent.putExtra("sms_body","SMS Body!!!!!");
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri sms = Uri.parse("smsto:03036323423");
                Intent intent = new Intent(Intent.ACTION_SENDTO,sms);
                intent.putExtra("sms_body","SMS Body!!!!!");
                Intent a = Intent.createChooser(intent,"Choose one:");
                startActivity(a);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = txt.getText().toString();
                Uri sms = Uri.parse("tel:"+t);
                Intent intent = new Intent(Intent.ACTION_DIAL,sms);
//                intent.putExtra("sms_body","SMS Body!!!!!");
                startActivity(intent);
            }
        });
    }
}