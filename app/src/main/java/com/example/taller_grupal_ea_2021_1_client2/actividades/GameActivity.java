package com.example.taller_grupal_ea_2021_1_client2.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.taller_grupal_ea_2021_1_client2.comunicacion.Coordenada;
import com.example.taller_grupal_ea_2021_1_client2.comunicacion.OnListener;
import com.example.taller_grupal_ea_2021_1_client2.R;
import com.example.taller_grupal_ea_2021_1_client2.comunicacion.TCPConection;
import com.google.gson.Gson;

import java.io.BufferedWriter;

public class GameActivity extends AppCompatActivity implements View.OnTouchListener, OnListener {

    private Button upBtn;
    private Button downBtn;
    private Button leftBtn;
    private Button rightBtn;
    private BufferedWriter bwriter;
    private TCPConection tcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tcp= TCPConection.getInstance();
        tcp.setObserver(this);
        upBtn = findViewById(R.id.upBtn);
        downBtn = findViewById(R.id.downBtn);
        leftBtn = findViewById(R.id.leftBtn);
        rightBtn = findViewById(R.id.rightBtn);

        upBtn.setOnTouchListener(this);
        downBtn.setOnTouchListener(this);
        leftBtn.setOnTouchListener(this);
        rightBtn.setOnTouchListener(this);



    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Gson gson = new Gson();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                switch(v.getId()) {
                    case R.id.upBtn:
                        Coordenada coordenada = new Coordenada("UPSTART");
                        String json = gson.toJson(coordenada);
                        tcp.mandarMensaje(json);
                        break;
                    case R.id.downBtn:
                        Coordenada downStart = new Coordenada("DOWNSTART");
                        String downStartJson = gson.toJson(downStart);
                        tcp.mandarMensaje(downStartJson);
                        break;
                    case R.id.rightBtn:
                        Coordenada rightStart = new Coordenada("RIGHTSTART");
                        String rightStartJson = gson.toJson(rightStart);
                        tcp.mandarMensaje(rightStartJson);
                        break;
                    case R.id.leftBtn:
                        Coordenada leftStart = new Coordenada("LEFTSTART");
                        String leftStartJson = gson.toJson(leftStart);
                        tcp.mandarMensaje(leftStartJson);
                        break;

                }
                break;


            case MotionEvent.ACTION_UP:
                switch (v.getId()) {
                    case R.id.upBtn:
                        Coordenada upStop = new Coordenada("UPSTOP");
                        String upStopJson = gson.toJson(upStop);
                        tcp.mandarMensaje(upStopJson);
                        break;
                    case R.id.downBtn:
                        Coordenada downStop = new Coordenada("DOWNSTOP");
                        String downStopJson = gson.toJson(downStop);
                        tcp.mandarMensaje(downStopJson);
                        break;
                    case R.id.rightBtn:
                        Coordenada rightStop = new Coordenada("RIGHTSTOP");
                        String rightStopJson = gson.toJson(rightStop);
                        tcp.mandarMensaje(rightStopJson);
                        break;
                    case R.id.leftBtn:
                        Coordenada leftStop = new Coordenada("LEFTSTOP");
                        String leftStopJson = gson.toJson(leftStop);
                        tcp.mandarMensaje(leftStopJson);
                        break;
                }
                break;
        }



        return true;
    }

    @Override
    public void onMessage(String message) {

    }
}