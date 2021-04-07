package com.example.taller_grupal_ea_2021_1_client2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class GameActivity extends AppCompatActivity implements View.OnTouchListener {

    private Button upBtn;
    private Button downBtn;
    private Button leftBtn;
    private Button rightBtn;
    private BufferedWriter bwriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        upBtn = findViewById(R.id.upBtn);
        downBtn = findViewById(R.id.downBtn);
        leftBtn = findViewById(R.id.leftBtn);
        rightBtn = findViewById(R.id.rightBtn);

        upBtn.setOnTouchListener(this);
        downBtn.setOnTouchListener(this);
        leftBtn.setOnTouchListener(this);
        rightBtn.setOnTouchListener(this);


        new Thread(

                () -> {

                    try {
                        //Direccion del computador

                        //Server -> 255.255.255.0
                        Socket socket = new Socket("255.255.255.0", 6000);

                        OutputStream os = socket.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        bwriter = new BufferedWriter(osw);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

        ).start();


    }

    public void enviar(String msg){
        new Thread(() -> {
            try {
                bwriter.write(msg + "\n");
                bwriter.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
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
                        enviar(json);
                        break;
                    case R.id.downBtn:
                        Coordenada downStart = new Coordenada("DOWNSTART");
                        String downStartJson = gson.toJson(downStart);
                        enviar(downStartJson);
                        break;
                    case R.id.rightBtn:
                        Coordenada rightStart = new Coordenada("RIGHTSTART");
                        String rightStartJson = gson.toJson(rightStart);
                        enviar(rightStartJson);
                        break;
                    case R.id.leftBtn:
                        Coordenada leftStart = new Coordenada("LEFTSTART");
                        String leftStartJson = gson.toJson(leftStart);
                        enviar(leftStartJson);
                        break;

                }
                break;


            case MotionEvent.ACTION_UP:
                switch (v.getId()) {
                    case R.id.upBtn:
                        Coordenada upStop = new Coordenada("UPSTOP");
                        String upStopJson = gson.toJson(upStop);
                        enviar(upStopJson);
                        break;
                    case R.id.downBtn:
                        Coordenada downStop = new Coordenada("DOWNSTOP");
                        String downStopJson = gson.toJson(downStop);
                        enviar(downStopJson);
                        break;
                    case R.id.rightBtn:
                        Coordenada rightStop = new Coordenada("RIGHTSTOP");
                        String rightStopJson = gson.toJson(rightStop);
                        enviar(rightStopJson);
                        break;
                    case R.id.leftBtn:
                        Coordenada leftStop = new Coordenada("LEFTSTOP");
                        String leftStopJson = gson.toJson(leftStop);
                        enviar(leftStopJson);
                        break;

                }
                break;
        }



        return true;
    }
}