package com.example.redbackpack.partyon;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterEvento extends RecyclerView.Adapter<AdapterEvento.EventoViewHolder> {

    private List<Evento> items;


    public static class EventoViewHolder extends RecyclerView.ViewHolder{

        public ImageView imagenevento;
        public TextView nombreevento;
        public TextView fechaevento;
        public TextView lugarevento;

        public EventoViewHolder(View v){
            super(v);


            imagenevento = (ImageView)v.findViewById(R.id.imagenevento);
            nombreevento = (TextView)v.findViewById(R.id.nombre_evento);
            fechaevento = (TextView)v.findViewById(R.id.fecha_evento);
            lugarevento = (TextView)v.findViewById(R.id.lugarevento);
        }
    }

    public AdapterEvento(List<Evento> items){
        this.items = items;
    }

    @Override
    public int getItemCount(){

        return items.size();
    }

    @Override
    public EventoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view_eventos,viewGroup,false);
        return new EventoViewHolder(v);

    }
    @Override
    public void onBindViewHolder(EventoViewHolder viewHolder, int i){
        viewHolder.imagenevento.setImageResource(items.get(i).getImagenevento());;
        viewHolder.nombreevento.setText(items.get(i).getNombreevento());
        viewHolder.fechaevento.setText(items.get(i).getFecha());
        viewHolder.lugarevento.setText(items.get(i).getLugar());
    }


}
