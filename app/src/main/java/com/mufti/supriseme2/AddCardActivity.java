package com.mufti.supriseme2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        String s1 = getIntent().getStringExtra("key1");
        String s2 = getIntent().getStringExtra("key2");

        ((TextView)(findViewById(R.id.question))).setText(s1);
        ((TextView)(findViewById(R.id.answer))).setText(s2);

        (findViewById(R.id.cancelQ)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCardActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });



        (findViewById(R.id.saveQ)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question,answer;
                question = ((EditText)findViewById(R.id.question)).getText().toString();
                answer = ((EditText)findViewById(R.id.answer)).getText().toString();

                if(question.equals("")|| answer.equals(""))
                    Toast.makeText(AddCardActivity.this, "Question or Answer cannnot be empty", Toast.LENGTH_SHORT).show();
                else{
                Intent data = new Intent();
                data.putExtra("qString",question);
                data.putExtra("aString",answer);
                setResult(RESULT_OK,data);
                finish();}
            }
        });
    }

}
