package com.unamjorge.practicas.persistenciapentangram.Presentador;

import android.content.Context;

import com.unamjorge.practicas.persistenciapentangram.DB.ConstructorMascotas;
import com.unamjorge.practicas.persistenciapentangram.Fragment.IFragmentMascota;
import com.unamjorge.practicas.persistenciapentangram.Pojo.PojoMascota;

import java.util.ArrayList;

/**
 * Created by Jorge Urueta on 15/12/2017.
 */

public class ReciclerViewFragmentPresentador implements IReciclerViewFragmentPresentador {
    private IFragmentMascota iFragmentHome;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    ArrayList<PojoMascota> pojoMascotas;

    public ReciclerViewFragmentPresentador(IFragmentMascota iFragmentHome, Context context) {

        this.iFragmentHome = iFragmentHome;
        this.context = context;

        //this.obtenerMascotaBaseDatos();
    }

    @Override
    public void obtenerMascotaBaseDatos() {

        constructorMascotas = new ConstructorMascotas(context);
        pojoMascotas = constructorMascotas.obtenerDatos();

        this.mostrarMascotaRV();
    }

    @Override
    public void mostrarMascotaRV() {

        iFragmentHome.inicializarAdaptadorRV(iFragmentHome.crearAdaptador(pojoMascotas));
        iFragmentHome.generarLinearLayoutVertical();

    }

    @Override
    public void obtenerMascotaFavoritaBaseDatos() {

        constructorMascotas = new ConstructorMascotas(context);
        pojoMascotas = constructorMascotas.obtenerConsulta();

        this.mostrarMascotaRV();
    }
}
