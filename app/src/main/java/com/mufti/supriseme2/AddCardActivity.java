package com.mufti.supriseme2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

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
               // question = ((EditText)findViewById(R.id.question)).getText().toString();
                //answer = ((EditText)findViewById(R.id.answer)).getText().toString();
                Intent data = new Intent();
                data.putExtra("qString",((EditText)findViewById(R.id.question)).getText().toString());
                data.putExtra("aString",((EditText)findViewById(R.id.answer)).getText().toString());
                setResult(RESULT_OK,data);
                finish();
            }
        });
    }
}
