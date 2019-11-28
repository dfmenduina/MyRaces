package com.example.myraces.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myraces.R;
import com.example.myraces.core.Races;

import java.util.ArrayList;


public class MyRacesArrayAdapter extends ArrayAdapter<Races> {


    public MyRacesArrayAdapter(Context context, int resource, ArrayList<Races> racesArrayList) {
        super(context, 0, racesArrayList);
    }

    public View getView(int position, View convertView, View parentView){
        final LayoutInflater inflater = LayoutInflater.from(this.getContext());
        final Races race = this.getItem(position);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_race,null);
        }

        final TextView idNombre = convertView.findViewById(R.id.idName);
        final TextView idFecha = convertView.findViewById(R.id.idFecha);
        final TextView idHora = convertView.findViewById(R.id.idHora);
        final TextView idDist = convertView.findViewById(R.id.idDist);
        final TextView idSuper = convertView.findViewById(R.id.idSuper);

        idNombre.setText(race.getNombre());
        idFecha.setText(race.getFecha());
        idHora.setText(race.getHora());
        idDist.setText(race.getDistancia());
        idSuper.setText(race.getSuperficie());

        return convertView;
    }
}
