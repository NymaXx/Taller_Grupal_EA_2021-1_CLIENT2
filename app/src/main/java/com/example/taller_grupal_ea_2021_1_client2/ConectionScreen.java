package com.example.taller_grupal_ea_2021_1_client2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConectionScreen extends AppCompatActivity {


    private EditText ip,puerto;
    private Button btnConectar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conection_screen);

        ip=findViewById(R.id.txtIp);
        puerto=findViewById(R.id.txtPuerto);
        btnConectar=findViewById(R.id.btnConectar);
        btnConectar.setOnClickListener(v ->{

            if(ip.getText().toString().isEmpty()||puerto.getText().toString().isEmpty()){

                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
            }

            else{

                String ipS=  ip.getText().toString();
                String puertoS = puerto.getText().toString();


            }
        } );
    }
}