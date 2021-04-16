package com.example.taller_grupal_ea_2021_1_client2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPConection extends Thread{


    private static TCPConection instance;
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String ip;
    private String puerto;

    private OnListener observer;

    private TCPConection(){ }

    public static TCPConection getInstance() {
        if(instance == null){
            instance = new TCPConection();
            return instance;
        }
        return instance;
    }

    public void setObserver(OnListener observer){
        this.observer = observer;
    }

    public void run() {
        try {
            this.socket = new Socket(this.ip, Integer.parseInt(this.puerto));

            //Reader
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            this.reader = new BufferedReader(isr);

            //Writer
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            this.writer = new BufferedWriter(osw);

            while(true) {
                recibirMensaje();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Solicitar conexion
    public void solicitarConexion(String ip,String puerto){
        this.ip = ip;
        this.puerto=puerto;
        this.start();
    }

    //Mandar un mensaje
    public void mandarMensaje(String mensaje){
        new Thread(
                ()->{
                    try {
                        writer.write(mensaje+"\n");
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }

    //Recibir mensaje
    public void recibirMensaje() throws IOException{
        String line = reader.readLine();
        observer.onMessage(line);
    }

    public void cerrarConexion(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
