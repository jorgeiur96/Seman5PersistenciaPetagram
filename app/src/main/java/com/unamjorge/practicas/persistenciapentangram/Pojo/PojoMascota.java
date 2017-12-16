package com.unamjorge.practicas.persistenciapentangram.Pojo;

import java.io.Serializable;

/**
 * Created by Jorge Urueta on 15/12/2017.
 */

public class PojoMascota implements Serializable {

    private int id;
    private String nombre;
    private int foto;
    private int numLike;

    public PojoMascota(String nombre, int foto, int numLike) {
        this.nombre = nombre;
        this.foto = foto;
        this.numLike = numLike;
    }

    public PojoMascota() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getNumLike() {
        return numLike;
    }

    public void setNumLike(int numLike) {
        this.numLike = numLike;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
