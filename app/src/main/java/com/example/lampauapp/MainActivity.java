package com.example.lampauapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLihat = findViewById(R.id.btn_lihat);
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Buat Intent untuk berpindah ke ListUangActivity
                Intent intent = new Intent(MainActivity.this, ListUangActivity.class);
                startActivity(intent);
            }
        });
    }
}