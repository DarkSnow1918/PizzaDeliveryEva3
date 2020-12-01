package com.example.pizzadeliveryeva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);
        video = (VideoView)findViewById(R.id.VvVideo);
        String ruta = "android.resource://"+getPackageName()+"/"+R.raw.video;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);

        //Controles del video

        MediaController media = new MediaController(this);
        video.setMediaController(media);
    }

    public void clientes(View view){
        Intent i = new Intent(this, Firebase_act.class);
        startActivity(i);
    }

    public void promociones (View view){
        ArrayList<String> clientes = new ArrayList<String>();
        Intent i = new Intent(this, Promociones_act.class);
        i.putExtra("listaCliente", clientes);
        startActivity(i);

    }
}