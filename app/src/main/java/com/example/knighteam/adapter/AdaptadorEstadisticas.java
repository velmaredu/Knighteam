package com.example.knighteam.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.knighteam.R;
import com.example.knighteam.model.Estadistico;

import java.util.ArrayList;


public class AdaptadorEstadisticas extends ArrayAdapter<Estadistico> {
    private ArrayList<Estadistico> listaEstadisticas;

    public AdaptadorEstadisticas(Context context, int textViewResourceId, ArrayList<Estadistico> objects) {
        super(context, textViewResourceId, objects);
        listaEstadisticas = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.gridview_recursos_feudo, null);

        ImageView imageView = (ImageView) v.findViewById(R.id.imagenObjetoCreandose);
        TextView textoNombre = (TextView) v.findViewById(R.id.nombreObjetoCreandose);
        ProgressBar barraProgreso = (ProgressBar) v.findViewById(R.id.barraProgresoObjeto);
        TextView textoValor = (TextView) v.findViewById(R.id.porcentajeProgreso);

        imageView.setImageResource(listaEstadisticas.get(position).getIdDrawable());
        textoNombre.setText(listaEstadisticas.get(position).getNombre());
        textoNombre.setTextSize(15);
        textoValor.setText(listaEstadisticas.get(position).getValorActual() + "/" + listaEstadisticas.get(position).getValorMax());
        textoValor.setTextSize(15);

        if(textoNombre.getText().equals("Salud")){
            barraProgreso.setProgressTintList(ColorStateList.valueOf(Color.RED));
        }
        else if(textoNombre.getText().equals("Ataque")){
            barraProgreso.setProgressTintList(ColorStateList.valueOf(Color.MAGENTA));
        }
        else if(textoNombre.getText().equals("Velocidad de ataque")){
            barraProgreso.setProgressTintList(ColorStateList.valueOf(Color.CYAN));
        }
        else{
            barraProgreso.setProgressTintList(ColorStateList.valueOf(Color.BLUE));
        }

        int porcentaje= (int) (listaEstadisticas.get(position).getValorActual()*100/listaEstadisticas.get(position).getValorMax());
        barraProgreso.setProgress(porcentaje);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        barraProgreso.setLayoutParams(params);

        return v;

    }

    public void setListaEstadisticas(ArrayList<Estadistico> objects) {
        listaEstadisticas = objects;
    }
}