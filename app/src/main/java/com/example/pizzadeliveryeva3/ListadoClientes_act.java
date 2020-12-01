package com.example.pizzadeliveryeva3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Clases.ClientFirebase;


public class ListadoClientes_act extends AppCompatActivity {
    private ListView listado;
    private List<ClientFirebase> listClientes = new ArrayList<ClientFirebase>();
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;
    ClientFirebase ClientesSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_clientes_act);
        iniciarFireBase();
        listado=(ListView)findViewById(R.id.LvClientes);

        //mostrar los datos que están contenidos en firebase
        databaseReference.child("ClientFirebase").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot objSnapshot : snapshot.getChildren()){
                    ClientFirebase cli = objSnapshot.getValue(ClientFirebase.class);
                    listClientes.add(cli);

                    ArrayAdapter adpt = new ArrayAdapter(getBaseContext(),android.R.layout.simple_list_item_1,listClientes);
                    listado.setAdapter(adpt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //Obtiene el ITEM seleccionado del LISTVIEW por posición
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ClientesSelected = (ClientFirebase)parent.getItemAtPosition(position);

            }
        });


    }

    //Eliominar desde fireBase
    public void EliminarCampo(View view){
        ClientFirebase cli = new ClientFirebase();
        cli.setId(ClientesSelected.getId());
        databaseReference.child("ClientFirebase").child(cli.getId()).removeValue();

        Toast.makeText(this, "Has eliminado un campo",Toast.LENGTH_SHORT).show();

    }





    public void iniciarFireBase()
    {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }
}