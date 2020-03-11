package com.mufti.supriseme2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    String TAG="TAG";
    private String mUser;


    //TextView question = (TextView)findViewById(R.id.suprise_question);
  // TextView answer = (TextView)findViewById(R.id.suprise_question);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String question,answer,answer2,answer3;

        ((TextView) findViewById(R.id.suprise_question)).setText("What's 2+2 ?");
        ((TextView) findViewById(R.id.suprise_answer1)).setText("4");
        ((TextView) findViewById(R.id.suprise_answer2)).setText("5");
        ((TextView) findViewById(R.id.suprise_answer3)).setText("8");
        //loop to check answers
       /* findViewById(R.id.suprise_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.suprise_question).setVisibility(View.INVISIBLE);
                (findViewById(R.id.suprise_answer1)).setVisibility(View.VISIBLE);
            }
        });*/

        findViewById(R.id.suprise_answer1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.suprise_answer1).setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.correct));
            }
        });

        findViewById(R.id.suprise_answer2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.suprise_answer1).setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.correct));
                findViewById(R.id.suprise_answer2).setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.wrong));
                findViewById(R.id.suprise_answer3).setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.wrong));

            }
        });

        findViewById(R.id.suprise_answer3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.suprise_answer1).setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.correct));
                findViewById(R.id.suprise_answer2).setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.wrong));
                findViewById(R.id.suprise_answer3).setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.wrong));

            }
        });


        findViewById(R.id.activityMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.suprise_answer1).setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.reset));
                findViewById(R.id.suprise_answer2).setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.reset));
                findViewById(R.id.suprise_answer3).setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.reset));

            }
        });



        (findViewById(R.id.addQ)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddCardActivity.class);
                startActivityForResult(intent,121);
            }
        });

        question = ((TextView)(findViewById(R.id.suprise_question))).getText().toString();
        answer = ((TextView)(findViewById(R.id.suprise_answer1))).getText().toString();
        answer2 = ((TextView)(findViewById(R.id.suprise_answer2))).getText().toString();
        answer3 = ((TextView)(findViewById(R.id.suprise_answer3))).getText().toString();

        (findViewById(R.id.editQ)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editClick = new Intent(MainActivity.this,AddCardActivity.class);
                editClick.putExtra("key1",question);
                editClick.putExtra("key2",answer);
                editClick.putExtra("key3",answer2);
                editClick.putExtra("key4",answer3);
                MainActivity.this.startActivityForResult(editClick,121);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==121)
        {
            String queUpdate = data.getExtras().getString("qString");
            String ansUpdate = data.getExtras().getString("aString");
            String ansUpdate1 = data.getExtras().getString("aString1");
            String ansUpdate2 = data.getExtras().getString("aString2");
            ((TextView)findViewById(R.id.suprise_question)).setText(queUpdate);
            ((TextView)findViewById(R.id.suprise_answer1)).setText(ansUpdate);
            ((TextView)findViewById(R.id.suprise_answer1)).setText(ansUpdate1);
            ((TextView)findViewById(R.id.suprise_answer1)).setText(ansUpdate2);

            Snackbar.make(findViewById(R.id.suprise_question),"Card updated!",
                    Snackbar.LENGTH_SHORT).show();
        }
    }

}
