package com.example.myraces.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myraces.R;

public class NewRace extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_race);

        final Button btInserta = findViewById(R.id.btInserta);
        final Button btCancela = findViewById(R.id.btCancela);

        btCancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewRace.this.finish();
            }
        });

        btInserta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewRace.this.guarda();
            }
        });
    }

    private void guarda() {
        final EditText edNombre = findViewById(R.id.etNombre);
        final EditText edFecha = findViewById(R.id.etFecha);
        final EditText edHora = findViewById(R.id.etHora);
        final EditText edDist = findViewById(R.id.etDist);
        final EditText edSuper = findViewById(R.id.etSuper);

        Intent data = new Intent();
        data.putExtra("Nombre:",edNombre.getText().toString());
        data.putExtra("Fecha:",edFecha.getText().toString());
        data.putExtra("Hora:",edHora.getText().toString());
        data.putExtra("Distancia:",edDist.getText().toString());
        data.putExtra("Superficie:",edSuper.getText().toString());

        setResult(Activity.RESULT_OK,data);
        finish();
    }
}
