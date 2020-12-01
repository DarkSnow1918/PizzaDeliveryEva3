package com.example.pizzadeliveryeva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nombre, contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre=(EditText)findViewById(R.id.EtName);
        contra=(EditText)findViewById(R.id.EtContra);

    }

    public void Login(View view){
        String userUno , userDos,contrasena;
        userUno = "Android";
        userDos = "ANDROID";
        contrasena= "123";


        if(nombre.getText().toString().equals(userUno)||nombre.getText().toString().equals(userDos)
                && contra.getText().toString().equals(contrasena)){
            Intent i = new Intent(this, Menu_act.class );
            startActivity(i);

        }


    }
}