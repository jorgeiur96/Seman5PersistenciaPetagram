package com.unamjorge.practicas.persistenciapentangram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.unamjorge.practicas.persistenciapentangram.Adaptador.PageAdapter;
import com.unamjorge.practicas.persistenciapentangram.Fragment.FragmentInicio;
import com.unamjorge.practicas.persistenciapentangram.Fragment.FragmentPerfil;
import com.unamjorge.practicas.persistenciapentangram.Fragment.MascotasFavoritas;
import com.unamjorge.practicas.persistenciapentangram.Menu.Acercade;
import com.unamjorge.practicas.persistenciapentangram.Menu.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar tbBarraPrincipal;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tbBarraPrincipal = (Toolbar) findViewById(R.id.miActionBar);
        if (this.tbBarraPrincipal != null) {
            setSupportActionBar(this.tbBarraPrincipal);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        this.setSupportActionBar(miActionBar);

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

        setUpViewPager();
    }

    //Menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu_opciones);
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        Intent intent;

        switch(item.getItemId()){

            case R.id.mContacto:
                intent = new Intent(this, Contacto.class);
                startActivity(intent);
                break;

            case R.id.mAcercaDe:
                intent = new Intent(this, Acercade.class);
                startActivity(intent);
                break;

            //ActionViews
            case R.id.mFavorito:
                //Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, MascotasFavoritas.class);
                //intent.putExtra("arrayMascotas", mascotas);

                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentInicio());
        fragments.add(new FragmentPerfil());

        return fragments;
    }

    private void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.hueso);
        tabLayout.getTabAt(1).setIcon(R.drawable.hueso2);
    }


}
