package com.example.redbackpack.plur;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new Usuario()).commit();
        }

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            Fragment selectedFragment = null;


            switch (item.getItemId()) {
                case R.id.navigation_home:

                    selectedFragment = new Usuario();

                    break;
                case R.id.navigation_dashboard:
                    selectedFragment = new Eventos();
                    break;
                case R.id.navigation_notifications:

                    selectedFragment = new Mapa();

                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,selectedFragment).commit();

            return true;
        }
    };



}
