package com.unamjorge.practicas.persistenciapentangram.Fragment;

import com.unamjorge.practicas.persistenciapentangram.Adaptador.MascotaAdaptador;
import com.unamjorge.practicas.persistenciapentangram.Pojo.PojoMascota;

import java.util.ArrayList;

/**
 * Created by Jorge Urueta on 15/12/2017.
 */

public interface IFragmentMascota {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<PojoMascota> pojoMascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador contactoAdaptador);
}
