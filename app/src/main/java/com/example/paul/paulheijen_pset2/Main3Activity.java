package com.example.paul.paulheijen_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView storyText;
    String finalStory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        finalStory = getIntent().getStringExtra("finalStory");

        storyText = (TextView) findViewById(R.id.finalStory);
        storyText.setText(finalStory);
    }

    public void clickRetry(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }

}