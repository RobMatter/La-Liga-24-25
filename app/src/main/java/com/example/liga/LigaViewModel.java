package com.example.liga;

import android.app.Application;
import android.os.AsyncTask;


import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.ArrayList;
import java.util.List;

public class LigaViewModel extends AndroidViewModel {


    private RepositorioLiga repositorio;

    public LigaViewModel(Application application) {
        super(application);
        repositorio = new RepositorioLiga(application);
    }

    public LiveData<List<Equipo>> allEquipos(){
        return repositorio.getAllEquipos();
    }

    public void insertEquipo(Equipo equipo){
        repositorio.insertarEquipo(equipo);
    }

    public LiveData<Equipo> oneEquipo(String nombre){
        return repositorio.getEquipo(nombre);
    }

    public void deleteEquipo(Equipo equipo){
        repositorio.borrarEquipo(equipo);
    }

}
