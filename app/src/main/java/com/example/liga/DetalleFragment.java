package com.example.liga;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.liga.databinding.FragmentJugadoresBinding;


public class DetalleFragment extends Fragment {

    private FragmentJugadoresBinding binding;
    private NavController navController;

    Equipo equipo;

    public DetalleFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflamos el layout de este fragment
        binding =FragmentJugadoresBinding.inflate(inflater,container,false);


        return binding.getRoot();
    }



    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        navController = Navigation.findNavController(view);


        equipo = (Equipo) getArguments().getSerializable("equipoX");

        if(equipo == null){
            // No hay datos, manejar excepción
            
            return;
        }

        // Guardamos los datos pasadps por el Bundle, en variables del mismo tipo.

        int escudo = equipo.getEscudo();
        String nombre = equipo.getNombre();
        String estadio = equipo.getEstadio();
        double capacidad = equipo.getCapacidad();
        int fundacion = equipo.getFundacion();
        int foto = equipo.getFoto();

        // Mostramos los datos en los componentes de la interfaz.

        binding.imageView.setImageResource(escudo);
        binding.textNomEquipo.setText(nombre);
        binding.textNomEstadio.setText(estadio);
        binding.textCapacidad.setText(String.valueOf(capacidad));
        binding.textFundacion.setText(String.valueOf(fundacion));
        binding.fotoEstadio.setImageResource(foto);



    }

}