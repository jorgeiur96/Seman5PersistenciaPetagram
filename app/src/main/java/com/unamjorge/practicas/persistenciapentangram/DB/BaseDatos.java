package com.unamjorge.practicas.persistenciapentangram.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.unamjorge.practicas.persistenciapentangram.Pojo.PojoMascota;

import java.util.ArrayList;

/**
 * Created by Jorge Urueta on 15/12/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {

        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;

    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA
                + "(" + ConstantesBaseDatos.TABLE_MASCOTA_ID   + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE       + " TEXT," +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO         + " INTEGER" +
                ")";

        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA
                + "(" + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID      + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA     + " INTEGER," +
                ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES    + " INTEGER," +
                " FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID + ") " +
                " REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTA + "(" + ConstantesBaseDatos.TABLE_MASCOTA_ID +")" +
                ")";

        sqLiteDatabase.execSQL(queryCrearTablaContacto);
        sqLiteDatabase.execSQL(queryCrearTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA);

        this.onCreate(sqLiteDatabase);
    }

    public ArrayList<PojoMascota> obtenerAllMascotas() {
        ArrayList<PojoMascota> contactos = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registros = sqLiteDatabase.rawQuery(query, null);
        PojoMascota pojoMascota;
        String queryLikes;
        Cursor registroLikes;

        while(registros.moveToNext()){

            pojoMascota = new PojoMascota();
            pojoMascota.setId(registros.getInt(0));
            pojoMascota.setNombre(registros.getString(1));
            pojoMascota.setFoto(registros.getInt(2));

            queryLikes = "SELECT COUNT ( " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES + ")" +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + " = " + pojoMascota.getId();

            registroLikes = sqLiteDatabase.rawQuery(queryLikes, null);
            if(registroLikes.moveToNext()){
                pojoMascota.setNumLike(registroLikes.getInt(0));

            }else{

                pojoMascota.setNumLike(0);
            }


            contactos.add(pojoMascota);
        }

        sqLiteDatabase.close();
        return contactos;
    }

    public void insertarMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKE_MASCOTA, null, contentValues);
        db.close();
    }


    public int obtenerLikesContacto(PojoMascota pojoMascota){

        int likes = 0;

        String query = "SELECT COUNT ( " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + " = " + pojoMascota.getId();

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor registros = database.rawQuery(query, null);



        while(registros.moveToNext()){
            likes = registros.getInt(0);
        }

        database.close();

        return likes;
    }

}
