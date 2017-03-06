package com.example.paul.paulheijen_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    Story story;
    EditText wordField;
    TextView nWordsLeft;
    int nPlaceholders;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int storyIndex = getIntent().getIntExtra("randomStory", 0);

        story = new Story(this.getResources().openRawResource(getStorySource(storyIndex)));

        nWordsLeft = (TextView) findViewById(R.id.nwords);
        nPlaceholders = story.getPlaceholderRemainingCount();
        nWordsLeft.setText("Number of words left to enter: " + Integer.toString(nPlaceholders));

        wordField = (EditText) findViewById(R.id.wordField);
        String currentPlaceholder = story.getNextPlaceholder();
        wordField.setHint(currentPlaceholder);
    }

    public void clickOk(View view){
        Toast noInputError = Toast.makeText(getApplicationContext(), "You did not enter anything, try again!",
                Toast.LENGTH_SHORT);


        String placeholderUserText = wordField.getText().toString();
        if(!placeholderUserText.equals("")) {
            story.fillInPlaceholder(placeholderUserText);
            wordField.setText("");

            nPlaceholders = story.getPlaceholderRemainingCount();
            nWordsLeft.setText("Words left: " + Integer.toString(nPlaceholders));

            String currentPlaceholder = story.getNextPlaceholder();
            wordField.setHint(currentPlaceholder);



            if(nPlaceholders == 0) {
                Intent i = new Intent(this, Main3Activity.class);
                i.putExtra("finalStory", story.toString());
                startActivity(i);
                story.clear();
            }
        } else {
            noInputError.setGravity(Gravity.CENTER_HORIZONTAL, 0, 200);
            noInputError.show();
        }
    }


    private int getStorySource(int storyIndex) {
        switch (storyIndex) {
            case 0: return R.raw.madlib0_simple;
            case 1: return R.raw.madlib1_tarzan;
            case 2: return R.raw.madlib2_university;
            case 3: return R.raw.madlib3_clothes;
            case 4: return R.raw.madlib4_dance;
            default: return R.raw.madlib0_simple;
        }
    }

}


