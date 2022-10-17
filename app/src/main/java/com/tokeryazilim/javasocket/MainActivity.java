package com.tokeryazilim.javasocket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new SocketToPc().execute("hello");
    }

    class SocketToPc extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            System.out.println("on pre execute");
        }


        @Override
        protected String doInBackground(String... strings) {
            try {
                Socket s = new Socket("192.168.1.101",5555);
                System.out.println("binded");

                PrintWriter pw = new PrintWriter(s.getOutputStream());
                pw.println("Hello mommy");
                pw.println("hello mommt2");
                pw.flush();

                System.out.println(s.isClosed());
                int i = 0;
                while(s.isConnected()){

                    PrintWriter pw2 = new PrintWriter(s.getOutputStream());
                    pw2.println(i);

                    pw2.flush();
                    i++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                return "gey";
            } catch (IOException e) {
                //e.printStackTrace();
                //System.out.println(e.getLocalizedMessage());
                return  null;
            }

        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            System.out.println("on post execute");
        }

    }
}