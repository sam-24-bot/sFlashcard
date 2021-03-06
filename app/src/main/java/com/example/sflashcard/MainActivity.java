package com.example.sflashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView FlashcardQuestion = findViewById(R.id.flashcard_question);
        TextView FlashcardAnswer = findViewById(R.id.flashcard_answer);


        FlashcardQuestion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FlashcardQuestion.setVisibility(View.INVISIBLE);
                FlashcardAnswer.setVisibility(View.VISIBLE);
            }

        });

//new
        FlashcardAnswer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FlashcardQuestion.setVisibility(View.VISIBLE);
                FlashcardAnswer.setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.plus_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivity(intent);
            }

        });

        Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
        intent.putExtra("question", " ");
        intent.putExtra("answer", " ");
        MainActivity.this.startActivityForResult(intent, 100);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            String question = data.getExtras().getString("question"); // 'string1' needs to match the key we used when we put the string in the Intent
            String answer = data.getExtras().getString("answer");

            ((TextView) findViewById(R.id.flashcard_question)).setText(question);
            ((TextView) findViewById(R.id.flashcard_answer)).setText(answer);
        }
    }
}