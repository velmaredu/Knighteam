package com.example.knighteam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.example.knighteam.R;
import com.example.knighteam.model.Material;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdaptadorTienda extends ArrayAdapter<Material> {

    private final ArrayList<Material> listaMateriales;
    private final String numSala;
    private final Material monedas;

    public AdaptadorTienda(Context context, int textViewResourceId, ArrayList<Material> objects,int numSala,Material monedas){
        super(context,textViewResourceId,objects);
        listaMateriales=objects;
        this.numSala= String.valueOf(numSala);
        this.monedas=monedas;
    }
    @Override
    public int getCount(){
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.gridview_tienda,null);

        ImageView imagenMaterial = (ImageView) v.findViewById(R.id.ImagenMaterialCompra);
        TextView textoNombre = (TextView) v.findViewById(R.id.NombreMaterialCompra);
        TextView textoCantidad = (TextView) v.findViewById(R.id.precioMaterial);
        AppCompatButton boton = (AppCompatButton) v.findViewById(R.id.botonComprarMaterial);
        imagenMaterial.setImageResource(listaMateriales.get(position).getIdDrawable());
        textoNombre.setText(listaMateriales.get(position).getName());
        textoCantidad.setText(String.valueOf(listaMateriales.get(position).getPrecio()));

        boton.setOnClickListener(v1 -> {
            if (monedas.getCantidad()>=listaMateriales.get(position).getPrecio()){
                    monedas.setCantidad(monedas.getCantidad()-listaMateriales.get(position).getPrecio());
                    listaMateriales.get(position).setCantidad(listaMateriales.get(position).getCantidad()+1);
                    boton.setText("+1");
                    for (Material m : listaMateriales) {
                        FirebaseDatabase.getInstance().getReference().child("Materiales").child(String.valueOf(numSala)).child(m.getName()).setValue(m);
                    }
                    FirebaseDatabase.getInstance().getReference().child("Materiales").child(String.valueOf(numSala)).child(monedas.getName()).setValue(monedas);
                }

        });


        return v;

    }

}
