package com.example.alexchowdhury.clientsocket;


import android.os.AsyncTask;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;



public class ClientSocket extends AsyncTask<Float, Void, Void> {
    private MainActivity mainActivity;
    int port;

    ClientSocket(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public Void doInBackground(Float... string)   {
        try {
            port = Math.round(string[0]);
            Socket socket = new Socket("", port);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(Float.toString(string[1]));
            bufferedWriter.newLine();
            bufferedWriter.write(Float.toString(string[2]));
            bufferedWriter.newLine();
            bufferedWriter.write(Float.toString(string[3]));
            bufferedWriter.newLine();
            bufferedWriter.flush();
            socket.close();
        }
        catch(IOException e)   {
            e.printStackTrace();
        }
        return null;
    }



}
