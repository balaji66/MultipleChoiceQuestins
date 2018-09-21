package com.durga.balaji66.multiplechoicequestins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView mCorrect, mWrong, mPercentage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initializeViews();

        Intent intent =getIntent();
       mCorrect.setText(intent.getStringExtra("Correct"));
        mWrong.setText(intent.getStringExtra("Wrong"));
        mPercentage.setText(intent.getStringExtra("Percentage"));

    }
    public void initializeViews()
    {
        mCorrect =findViewById(R.id.textViewCorrect);
        mWrong =findViewById(R.id.textViewWrong);
        mPercentage =findViewById(R.id.textViewPercentage);
    }
}
