package com.example.sflashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
    }
}