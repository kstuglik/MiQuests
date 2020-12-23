package com.example.miquests;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        btnStart = findViewById(R.id.btnStart);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void runGame(View view) {
        if(view == btnStart) btnStart.setBackgroundResource(R.drawable.bg_btn_click);
        Intent i = new Intent(this,MainActivity2.class);
        startActivity(i);
    }
}