package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView txtView;
    EditText nameTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= findViewById(R.id.btn);
        txtView= findViewById(R.id.txtView);
        nameTxt= findViewById(R.id.nameTxt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr_name= nameTxt.getText().toString();
                //Explicit Intent
                Intent i= new Intent(getApplicationContext(), LuckyNumberActivity.class);
                //passing data to another activity
                i.putExtra("name", usr_name);
                startActivity(i);

            }
        });
    }
}