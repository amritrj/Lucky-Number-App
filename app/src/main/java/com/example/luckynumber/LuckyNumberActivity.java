package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActivity<userName, randomNum> extends AppCompatActivity {
    TextView lucky_activity_txt, lucky_no_txt;
    Button shareBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);
        lucky_activity_txt= findViewById(R.id.lucky_activity_txt);
        lucky_no_txt= findViewById(R.id.lucky_no_txt);
        shareBtn= findViewById(R.id.shareBtn);
        //Username
        Intent i= getIntent();
        String userName=i.getStringExtra("name");
        Toast.makeText(this,"UserName:"+userName,Toast.LENGTH_LONG).show();

        //Random Number Generator
        int randomNum=getLuckyNumber();
        lucky_no_txt.setText(" "+randomNum);

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName, randomNum);
            }
        });
    }

    private void shareData(String userName, int randomNum) {
        //Implicit Intent
        Intent i= new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        //Convert int to String
        String number= String.valueOf(randomNum);

        i.putExtra(Intent.EXTRA_SUBJECT, userName + " Got Lucky Today");
        i.putExtra(Intent.EXTRA_TEXT, "Your Lucky Number is: "+randomNum);
        startActivity(Intent.createChooser(i, "Choose a platform to Share"));



    }

    public int getLuckyNumber(){
        Random random=new Random();
        return random.nextInt(1000);
    }

}