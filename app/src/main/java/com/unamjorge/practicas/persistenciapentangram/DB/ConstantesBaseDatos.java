package com.unamjorge.practicas.persistenciapentangram.DB;

/**
 * Created by Jorge Urueta on 15/12/2017.
 */

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTA = "mascota";
    public static final String TABLE_MASCOTA_ID = "id";
    public static final String TABLE_MASCOTA_NOMBRE = "nombre";
    public static final String TABLE_MASCOTA_FOTO = "foto";


    public static final String TABLE_LIKE_MASCOTA = "mascota_like";
    public static final String TABLE_LIKE_MASCOTA_ID = "id";
    public static final String TABLE_LIKE_MASCOTA_ID_MASCOTA = "id_mascota";
    public static final String TABLE_LIKE_MASCOTA_NUMERO_LIKES = "numero_like";
}
