package com.example.paul.paulheijen_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSecondMain(View view) {
        Random r = new Random();
        int storyInt = r.nextInt(5);

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("randomStory", storyInt);
        startActivity(intent);
    }
}
