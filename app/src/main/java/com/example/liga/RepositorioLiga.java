package com.example.liga;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RepositorioLiga {
    private DBLiga.EquipoDao equipoDao;
    private Executor executor;

    public RepositorioLiga(Application application) {
        equipoDao = DBLiga.getINSTACIA(application).getEquipoDao();
        executor = Executors.newSingleThreadExecutor();

    }

    public LiveData<List<Equipo>> getAllEquipos() {
        return equipoDao.obtenerLista();
    }

    public LiveData<Equipo> getEquipo(String nommbre) {
        return equipoDao.obtenerEquipoNombre(nommbre);
    }

    public void insertarEquipo(Equipo equipo){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                equipoDao.insertar(equipo);
            }
        });

    }

    public void borrarEquipo(Equipo equipo){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                equipoDao.borrarEquipo(equipo);
            }
        });

    }
}
