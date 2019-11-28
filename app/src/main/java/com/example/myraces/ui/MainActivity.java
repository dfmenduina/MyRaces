package com.example.myraces.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.myraces.R;
import com.example.myraces.core.MyRaces;
import com.example.myraces.core.Races;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static int nueva_carrera = 10;
    private SimpleCursorAdapter adapter;
    private MyRaces myRaces;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Button btInserta = findViewById(R.id.idInserta);
        final ListView lvRaces = findViewById(R.id.lvRaces);
        
        btInserta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.inserta();
                adapter.notifyDataSetChanged();
            }
        });
        this.adapter = new SimpleCursorAdapter(this,R.layout.list_race,null,
                new String[]{myRaces.RACE_NAME,myRaces.RACE_DATE,myRaces.RACE_TIME,
                myRaces.RACE_DIST,myRaces.RACE_TYPE},new int[]{R.id.idName,R.id.idFecha,R.id.idHora,R.id.idDist,R.id.idSuper});

        lvRaces.setAdapter(adapter);

        this.registerForContextMenu(lvRaces);

        this.show();
    }

    public void onResume(){
        super.onResume();

        myRaces = new MyRaces(this.getApplicationContext());

        this.adapter.changeCursor(this.myRaces.getAllCursor());
        this.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == nueva_carrera && resultCode == Activity.RESULT_OK){
            Races races = new Races(data.getStringExtra("Nombre:"),data.getStringExtra("Fecha:"),
                    data.getStringExtra("Hora:"),
                    data.getExtras().getInt("Distancia:"),data.getExtras().getString("Superficie:"));

            this.myRaces.guardar(races);
        }
    }

    @SuppressLint("SetTextI18n")
    private void show() {
        final TextView lblRaces = findViewById(R.id.lblRaces);
        lblRaces.setText(this.adapter.getCount() + "carrera(s) inscritas");
    }

    private void inserta() {
        this.startActivityForResult(new Intent(this, NewRace.class),nueva_carrera);
    }
}
