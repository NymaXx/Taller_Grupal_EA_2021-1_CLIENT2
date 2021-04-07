package com.example.taller_grupal_ea_2021_1_client2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Instructions_activity extends AppCompatActivity implements View.OnClickListener {

    private Button toStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_activity);

        toStart = findViewById(R.id.toStart);
        toStart.setOnClickListener(
                (v) -> {

                }
        );

    }

    @Override
    public void onClick(View v) {

    }
}