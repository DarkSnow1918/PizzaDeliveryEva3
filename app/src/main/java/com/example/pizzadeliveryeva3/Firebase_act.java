package com.example.pizzadeliveryeva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.UUID;

import Clases.ClientFirebase;



public class Firebase_act extends AppCompatActivity {
    private EditText nombre, destino, promocion;
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);
        nombre = (EditText)findViewById(R.id.EtNombre);
        destino = (EditText)findViewById(R.id.EtDestino);
        promocion = (EditText)findViewById(R.id.EtPromo);
        iniciarFireBase();


    }
    public void listado(View view ){
        Intent i = new Intent(this, ListadoClientes_act.class);
        startActivity(i);
    }

    public void Guardar(View view ){
        if(!nombre.equals("")){
            ClientFirebase cli = new ClientFirebase();
            cli.setId(UUID.randomUUID().toString());
            cli.setNombre(nombre.getText().toString());
            cli.setDestino(destino.getText().toString());
            cli.setPromocion(promocion.getText().toString());

            databaseReference.child("ClientFirebase").child(cli.getId()).setValue(cli);




            Toast.makeText(getBaseContext(),"Se ha guardado",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getBaseContext(),"No se ha guardado",Toast.LENGTH_LONG).show();
        }

    }

    public void iniciarFireBase()
    {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }
}