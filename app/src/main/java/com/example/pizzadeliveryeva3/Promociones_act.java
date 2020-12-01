package com.example.pizzadeliveryeva3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Clases.Clientes;
import Clases.Promociones;

import static java.lang.Integer.parseInt;

public class Promociones_act extends AppCompatActivity {
    private Spinner spin;
    private EditText promocion, envio;
    private TextView msj, total;
    Clientes clientes = new Clientes();
    Promociones promociones = new Promociones();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);

        spin=(Spinner)findViewById(R.id.SpCliente);
        promocion = (EditText)findViewById(R.id.EtPromo);
        envio = (EditText)findViewById(R.id.EtEnvio);
        msj=(TextView)findViewById(R.id.TvMensaje);
        total=(TextView)findViewById(R.id.TvValor);


        ArrayList<String> listaCli = (ArrayList<String>)getIntent().getSerializableExtra("listaCliente");
        listaCli.add(clientes.getRamiro());
        listaCli.add(clientes.getRosa());
        listaCli.add(clientes.getRobert());

        ArrayAdapter<String> adpCli = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaCli);
        spin.setAdapter(adpCli);

    }
    public void Calcular(View view){
        String cliente = spin.getSelectedItem().toString();
        int totalUno = parseInt(envio.getText().toString()) + promociones.getPizzasPromo();
        int totalDos = parseInt(envio.getText().toString()) + promociones.getMasterPizza();
        int totalTres = parseInt(envio.getText().toString()) + promociones.getPizzaMax();


        if(cliente.equals(clientes.getRamiro())){
            if (promocion.getText().toString().equals(promociones.getPizzasPromoS())){
                msj.setText("Estimado "+clientes.getRamiro()+" el final según promoción y envío es:");
                total.setText("$"+totalUno);
            }

            else if (promocion.getText().toString().equals(promociones.getMasterPizzaS())){
                msj.setText("Estimado "+clientes.getRamiro()+" el final según promoción y envío es:");
                total.setText("$"+totalDos);

            }

            else if (promocion.getText().toString().equals(promociones.getPizzaMaxS())){
                msj.setText("Estimado "+clientes.getRamiro()+" el final según promoción y envío es:");
                total.setText("$"+totalTres);
            }
            else{
                Toast.makeText(this,"No existe esa promoción", Toast.LENGTH_LONG).show();
            }

        }


        if(cliente.equals(clientes.getRosa())) {
            if (promocion.getText().toString().equals(promociones.getPizzasPromoS())) {
                msj.setText("Estimado " + clientes.getRosa() + " el final según promoción y envío es:");
                total.setText("$" + totalUno);
            } else if (promocion.getText().toString().equals(promociones.getMasterPizzaS())) {
                msj.setText("Estimado " + clientes.getRosa() + " el final según promoción y envío es:");
                total.setText("$" + totalDos);

            } else if (promocion.getText().toString().equals(promociones.getPizzaMaxS())) {
                msj.setText("Estimado " + clientes.getRosa() + " el final según promoción y envío es:");
                total.setText("$" + totalTres);
            }
            else{
                Toast.makeText(this,"No existe esa promoción", Toast.LENGTH_LONG).show();
            }
        }

        if(cliente.equals(clientes.getRobert())){
            if (promocion.getText().toString().equals(promociones.getPizzasPromoS())){
                msj.setText("Estimado "+clientes.getRobert()+" el final según promoción y envío es:");
                total.setText("$"+totalUno);
            }

            else if (promocion.getText().toString().equals(promociones.getMasterPizzaS())){
                msj.setText("Estimado "+clientes.getRobert()+" el final según promoción y envío es:");
                total.setText("$"+totalDos);

            }

            else if (promocion.getText().toString().equals(promociones.getPizzaMaxS())){
                msj.setText("Estimado "+clientes.getRobert()+" el final según promoción y envío es:");
                total.setText("$"+totalTres);
            }
            else{
                Toast.makeText(this,"No existe esa promoción", Toast.LENGTH_LONG).show();
            }
        }
    }
}