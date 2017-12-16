package com.unamjorge.practicas.persistenciapentangram.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unamjorge.practicas.persistenciapentangram.Adaptador.MascotaAdaptadorPerfil;
import com.unamjorge.practicas.persistenciapentangram.Pojo.PojoMascota;
import com.unamjorge.practicas.persistenciapentangram.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPerfil extends Fragment {


    public FragmentPerfil() {
        // Required empty public constructor
    }
    ArrayList<PojoMascota> pojoMascotas;
    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);


        this.listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotasPerfil);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        this.listaMascotas.setLayoutManager(glm);

        this.inicializarListaMascotas();
        this.inicializarAdaptador();


        return v;
    }

    public void inicializarAdaptador(){

        MascotaAdaptadorPerfil adaptador = new MascotaAdaptadorPerfil(pojoMascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }


    public void inicializarListaMascotas(){

        pojoMascotas = new ArrayList<>();
        pojoMascotas.add(new PojoMascota("atila", R.drawable.img2, 2));
        pojoMascotas.add(new PojoMascota("atila", R.drawable.img2, 3));
        pojoMascotas.add(new PojoMascota("atila", R.drawable.img2, 4));
        pojoMascotas.add(new PojoMascota("atila", R.drawable.img2, 3));
        pojoMascotas.add(new PojoMascota("atila", R.drawable.img2, 2));
        pojoMascotas.add(new PojoMascota("atila", R.drawable.img2, 6));
        pojoMascotas.add(new PojoMascota("atila", R.drawable.img2, 2));
        pojoMascotas.add(new PojoMascota("atila", R.drawable.img2, 7));
        pojoMascotas.add(new PojoMascota("atila", R.drawable.img2, 10));
        pojoMascotas.add(new PojoMascota("atila", R.drawable.img2, 11));
    }

}
