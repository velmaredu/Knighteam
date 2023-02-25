package com.example.knighteam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.knighteam.R;
import com.example.knighteam.model.Material;

import java.util.ArrayList;


public class AdaptadorMateriales extends ArrayAdapter {
    private ArrayList<Material> listaMateriales;

    public AdaptadorMateriales(Context context, int textViewResourceId, ArrayList<Material> objects){
        super(context,textViewResourceId,objects);
        listaMateriales=objects;
    }
    @Override
    public int getCount(){
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.activity_gridview_materiales, null);
        TextView textoNombre = (TextView) v.findViewById(R.id.nombreMaterial);
        ImageView imageView = (ImageView) v.findViewById(R.id.imagenMaterial);
        TextView textoCantidad = (TextView) v.findViewById(R.id.cantidadMateriales);
        imageView.setImageResource(listaMateriales.get(position).getIdDrawable());
        textoNombre.setText(listaMateriales.get(position).getName());
        textoCantidad.setText(String.valueOf(listaMateriales.get(position).getCantidad()));


        return v;

    }
    public void setListaMateriales(ArrayList<Material> objects){
        listaMateriales=objects;
    }






}
