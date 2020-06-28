package com.example.B10602137_HW1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txt;
    private Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txt = findViewById(R.id.textView);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        txt.setText("你剛剛選了"+MainActivity.num+"個項目");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondActivity.this.finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setClass(SecondActivity.this,MainActivity.class);
                MainActivity.num = 0;
                startActivity(intent);
            }
        });
    }
}
