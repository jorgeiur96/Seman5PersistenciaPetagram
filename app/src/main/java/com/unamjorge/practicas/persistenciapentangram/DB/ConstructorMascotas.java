package com.unamjorge.practicas.persistenciapentangram.DB;

import android.content.ContentValues;
import android.content.Context;

import com.unamjorge.practicas.persistenciapentangram.Pojo.PojoMascota;
import com.unamjorge.practicas.persistenciapentangram.R;

import java.util.ArrayList;

/**
 * Created by Jorge Urueta on 15/12/2017.
 */

public class ConstructorMascotas {

    private static boolean INSERTO_REGISTROS = false;
    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }


    public ArrayList<PojoMascota> obtenerDatos() {

        BaseDatos baseDatos = new BaseDatos(context);
        insertarMascotas(baseDatos);

        return baseDatos.obtenerAllMascotas();

    }

    public ArrayList<PojoMascota> obtenerConsulta() {

        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerAllMascotas();

    }



    public void insertarMascotas(BaseDatos baseDatos){

        if(!INSERTO_REGISTROS) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Tobie");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.img1 );
            baseDatos.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "kyra");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.img2);
            baseDatos.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "blade");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.img3);
            baseDatos.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "neron");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.img4);
            baseDatos.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "atila");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.img4);
            baseDatos.insertarMascota(contentValues);

            INSERTO_REGISTROS = true;
        }

    }

    public void darLikeMascotas(PojoMascota pojoMascota){

        BaseDatos baseDatos = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA, pojoMascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES, LIKE);

        baseDatos.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(PojoMascota pojoMascota){

        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerLikesContacto(pojoMascota);
    }


}
