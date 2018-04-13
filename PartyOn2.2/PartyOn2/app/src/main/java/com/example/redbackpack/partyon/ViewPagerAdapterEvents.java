package com.example.redbackpack.partyon;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewPagerAdapterEvents extends PagerAdapter {


    private Context context;
    private LayoutInflater layoutInflater;


    public ViewPagerAdapterEvents(Context context){
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.arroba,
            R.drawable.arroba,
            R.drawable.registrate
    };

    public String [] slide_headings = {
            "Bienvenido",
            "Hola",
            "Registrate"
    };

    public String[] slide_descripcion = {
            "bienvenido a plur donde encontraras",
            "hola que tal?",
            "Se premium y disfruta de todos sus beneficios"
    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view,Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_1_bienvenido,container,false);

        ImageView slideimagen = (ImageView)view.findViewById(R.id.slide_image);
        TextView slideheading = (TextView)view.findViewById(R.id.slide_heading);
        TextView slidedescripcion = (TextView)view.findViewById(R.id.slide_descripcion);

        slideimagen.setImageResource(slide_images[position]);
        slideheading.setText(slide_descripcion[position]);
        slidedescripcion.setText(slide_descripcion[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((RelativeLayout)object);
    }
}
