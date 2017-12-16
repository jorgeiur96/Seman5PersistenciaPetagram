package com.unamjorge.practicas.persistenciapentangram.Fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.unamjorge.practicas.persistenciapentangram.Adaptador.MascotaAdaptador;
import com.unamjorge.practicas.persistenciapentangram.MainActivity;
import com.unamjorge.practicas.persistenciapentangram.Pojo.PojoMascota;
import com.unamjorge.practicas.persistenciapentangram.Presentador.IReciclerViewFragmentPresentador;
import com.unamjorge.practicas.persistenciapentangram.Presentador.ReciclerViewFragmentPresentador;
import com.unamjorge.practicas.persistenciapentangram.R;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity  implements IFragmentMascota{

    Toolbar tbBarraPrincipal;
    //ArrayList<PojoMascota> pojoMascotas = new ArrayList<PojoMascota>();;
    private RecyclerView listaMascotas;
    private IReciclerViewFragmentPresentador iReciclerViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        this.listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        this.tbBarraPrincipal = (Toolbar) findViewById(R.id.miActionBar);
        if (this.tbBarraPrincipal != null) {
            setSupportActionBar(this.tbBarraPrincipal);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        iReciclerViewFragment = new ReciclerViewFragmentPresentador(this, getBaseContext());
        iReciclerViewFragment.obtenerMascotaFavoritaBaseDatos();
    }

    @Override
    public boolean onSupportNavigateUp() {

        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("arrayMascotas", pojoMascotas);

        startActivity(intent);

        onBackPressed();
        return false;
    }

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        /*GridLayoutManager glm = new GridLayoutManager(this, 2);*/
        this.listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<PojoMascota> contactos) {
        MascotaAdaptador adaptador = new MascotaAdaptador(contactos, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador contactoAdaptador) {
        listaMascotas.setAdapter(contactoAdaptador);
    }
}
