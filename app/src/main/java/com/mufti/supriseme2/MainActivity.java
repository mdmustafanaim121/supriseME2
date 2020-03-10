package com.mufti.supriseme2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

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


    //TextView question = (TextView)findViewById(R.id.suprise_question);
  // TextView answer = (TextView)findViewById(R.id.suprise_question);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String question,answer;


        //loop to check answers
        findViewById(R.id.suprise_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.suprise_question).setVisibility(View.INVISIBLE);
                (findViewById(R.id.suprise_answer1)).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.suprise_answer1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.suprise_answer1).setVisibility(View.INVISIBLE);
                (findViewById(R.id.suprise_question)).setVisibility(View.VISIBLE);
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
        (findViewById(R.id.editQ)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editClick = new Intent(MainActivity.this,AddCardActivity.class);
                editClick.putExtra("key1",question);
                editClick.putExtra("key2",answer);
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
            ((TextView)findViewById(R.id.suprise_question)).setText(queUpdate);
            ((TextView)findViewById(R.id.suprise_answer1)).setText(ansUpdate);

            Snackbar.make(findViewById(R.id.suprise_question),"Card updated!",
                    Snackbar.LENGTH_SHORT).show();
        }
    }

}
