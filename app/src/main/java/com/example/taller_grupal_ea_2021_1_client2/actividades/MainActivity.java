package com.example.taller_grupal_ea_2021_1_client2.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.taller_grupal_ea_2021_1_client2.R;
import com.example.taller_grupal_ea_2021_1_client2.actividades.ConectionScreen;
import com.example.taller_grupal_ea_2021_1_client2.actividades.Instructions_activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button toStart;
    private Button toControlsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toStart = findViewById(R.id.toStart);
        toControlsBtn = findViewById(R.id.toControlsBtn);

        toStart.setOnClickListener(this);
        toControlsBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch ((v.getId())){
            case R.id.toStart:
                Intent iG = new Intent(this, ConectionScreen.class);
                startActivity(iG);
                break;

            case R.id.toControlsBtn:
                Intent intent = new Intent(this, Instructions_activity.class);
                startActivity(intent);
                break;
        }
    }
}