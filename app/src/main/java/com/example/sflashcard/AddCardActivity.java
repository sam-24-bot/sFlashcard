package com.example.sflashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        findViewById(R.id.cancel_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String card_question = ((EditText) findViewById(R.id.user_question)).getText().toString();
                String card_answer = ((EditText) findViewById(R.id.user_answer)).getText().toString();

                if (card_question.equals("") || card_answer.equals("")){
                    Toast.makeText(getApplicationContext(), "Add text", Toast.LENGTH_SHORT).show();

                }
                else{
                    Intent data = new Intent(); // create a new Intent, this is where we will put our data
                    data.putExtra("question", card_question); // puts one string into the Intent, with the key as 'string1'
                    data.putExtra("answer", card_answer); // puts another string into the Intent, with the key as 'string2
                    setResult(RESULT_OK, data); // set result code and bundle data for response
                    finish(); // closes this activity and pass data to the original activity that launched this activity

                }

            }

        });

        String s1 = getIntent().getStringExtra("question");
        String s2 = getIntent().getStringExtra("answer");



    }
}

