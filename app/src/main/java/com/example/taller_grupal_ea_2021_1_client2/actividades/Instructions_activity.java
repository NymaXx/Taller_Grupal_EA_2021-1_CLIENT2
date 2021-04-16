package com.example.taller_grupal_ea_2021_1_client2.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.taller_grupal_ea_2021_1_client2.R;
import com.example.taller_grupal_ea_2021_1_client2.actividades.GameActivity;

public class Instructions_activity extends AppCompatActivity implements View.OnClickListener {

    private Button startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_activity);

        startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(
                (v) -> {
                    Intent i =  new Intent(this, GameActivity.class);
                    startActivity(i);

                }
        );

    }

    @Override
    public void onClick(View v) {

    }
}