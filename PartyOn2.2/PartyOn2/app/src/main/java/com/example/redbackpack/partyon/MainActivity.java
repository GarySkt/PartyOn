package com.example.redbackpack.partyon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewFlipper viewFlipper;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //banner
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipperevents);
        int images [] = {R.drawable.slider_1,R.drawable.slider_2,R.drawable.slider_3};

        viewFlipper = findViewById(R.id.viewflipperevents);

        //ciclo banner
        for (int i = 0; i < images.length; i++){
            flipperImagenes(images[i]);
        }


        //inicializar eventos

        List items = new ArrayList();

        items.add(new Evento("Dia del Skate","21/06/18","Discoteca TUSAN",R.drawable.slider_1));
        items.add(new Evento("Evento Surf Tour Sur","21/06/18","Playa los Hornos",R.drawable.slider_2));
        items.add(new Evento("Peru Mucho Gusto","21/06/18","Hotel Tacna",R.drawable.slider_3));
        items.add(new Evento("Dia del Skate","21/06/18","Discoteca TUSAN",R.drawable.slider_1));
        items.add(new Evento("Dia del Skate","21/06/18","Discoteca TUSAN",R.drawable.slider_2));
        items.add(new Evento("Dia del Skate","21/06/18","Discoteca TUSAN",R.drawable.slider_3));

        //obtener recycler
        recyclerView = (RecyclerView) findViewById(R.id.reciclador);
        recyclerView.setHasFixedSize(true);

        //usar administrador para linearlayout
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //crear nuevo adaptador
        adapter = new AdapterEvento(items);
        recyclerView.setAdapter(adapter);

    }

    public void flipperImagenes(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);;

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);//4 segundos
        viewFlipper.setAutoStart(true);

        //animacion
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_register) {

            Intent intent = new Intent(this,AactivityRegistro.class);
            startActivity(intent);

            //return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
