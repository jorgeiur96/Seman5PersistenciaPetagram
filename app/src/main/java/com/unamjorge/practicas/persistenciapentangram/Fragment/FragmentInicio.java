package com.unamjorge.practicas.persistenciapentangram.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unamjorge.practicas.persistenciapentangram.Adaptador.MascotaAdaptador;
import com.unamjorge.practicas.persistenciapentangram.Pojo.PojoMascota;
import com.unamjorge.practicas.persistenciapentangram.Presentador.IReciclerViewFragmentPresentador;
import com.unamjorge.practicas.persistenciapentangram.Presentador.ReciclerViewFragmentPresentador;
import com.unamjorge.practicas.persistenciapentangram.R;

import java.util.ArrayList;


public class FragmentInicio extends Fragment implements IFragmentMascota{


    public FragmentInicio() {

    }
    private RecyclerView listaMascotas;
    private IReciclerViewFragmentPresentador iReciclerViewFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        this.listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        iReciclerViewFragment = new ReciclerViewFragmentPresentador(this, getContext());
        iReciclerViewFragment.obtenerMascotaBaseDatos();



        return v;

    }

    public void irMascotasFavoritas(View view){

        Intent intent = new Intent(getActivity(), MascotasFavoritas.class);
        //intent.putExtra("arrayMascotas", pojoMascotas);

        startActivity(intent);

    }

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        this.listaMascotas.setLayoutManager(llm);


    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<PojoMascota> pojoMascotas) {

        MascotaAdaptador adaptador = new MascotaAdaptador(pojoMascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador) {

        listaMascotas.setAdapter(mascotaAdaptador);
    }

}
