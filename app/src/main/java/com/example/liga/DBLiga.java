package com.example.liga;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database (entities ={Equipo.class}, version = 4,exportSchema = false)

public abstract class DBLiga extends RoomDatabase {

    private static DBLiga INSTANCIA;


    public static DBLiga getINSTACIA (Application application){
        if (INSTANCIA == null) {
            synchronized (DBLiga.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(application,
                                    DBLiga.class, "liga25.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return INSTANCIA;

    }


    /**
     *  Interfaz para objetos DAO
      */

    @Dao
    public interface EquipoDao{

        @Query("SELECT * FROM EQUIPOS")
        LiveData<List<Equipo>> obtenerLista();

        @Query("SELECT * FROM EQUIPOS WHERE nombre = :nombre LIMIT 1")
        LiveData<Equipo> obtenerEquipoNombre(String nombre);

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insertar(Equipo equipo);

        @Delete
        void borrarEquipo(Equipo equipo);



    }


    public abstract EquipoDao getEquipoDao();

}
