package com.example.liga;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "equipos")
public class Equipo implements Serializable {
    @PrimaryKey (autoGenerate = true)
    int id;
    int escudo;
    String nombre;
    String estadio;
    double capacidad;
    int fundacion;
    int foto;

    public Equipo(int escudo, String nombre, String estadio, double capacidad, int fundacion, int foto) {
        this.escudo = escudo;
        this.nombre = nombre;
        this.estadio = estadio;
        this.capacidad = capacidad;
        this.fundacion = fundacion;
        this.foto = foto;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getFundacion() {
        return fundacion;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


}
