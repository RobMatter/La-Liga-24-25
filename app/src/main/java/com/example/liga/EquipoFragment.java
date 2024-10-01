package com.example.liga;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.liga.databinding.FragmentEquipoBinding;

import java.util.ArrayList;
import java.util.List;


public class EquipoFragment extends Fragment implements EquipoAdapter.OnItemSelectListener{

    private FragmentEquipoBinding binding;
    private NavController navController;
    private List<Equipo> equipos;
    private LigaViewModel ligaViewModel;



    public EquipoFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Solicitar modelo de vista y cargar datos.
        ligaViewModel = new ViewModelProvider(this).get(LigaViewModel.class);
        cargarEquipos();

        // Inflamos el layout de este fragment
        binding =FragmentEquipoBinding.inflate(inflater,container,false);
        binding.rcEqupos.setLayoutManager(new GridLayoutManager(getContext(),3));

        EquipoAdapter adapter = new EquipoAdapter(equipos, this);

        binding.rcEqupos.setAdapter(adapter);


        ligaViewModel.allEquipos().observe(getViewLifecycleOwner(), new Observer<List<Equipo>>() {

            @Override
            public void onChanged(List<Equipo> equipos) {
                adapter.setEquipos(equipos);

            }
        });


        return binding.getRoot();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

    }


    @Override
    public void onSelect(Equipo equipo) {
        Toast.makeText(getContext(), "Has Pulsado en " + equipo.getNombre(), Toast.LENGTH_SHORT).show();

        //Pasar datos del equipo elegido y mostrar siguiente pantalla
        Bundle args = new Bundle();
        args.putSerializable("equipoX", equipo);


        navController.navigate(R.id.action_equipoFragment_to_jugadoresFragment, args);

    }



    private void cargarEquipos() {

        Equipo equipo1 = new Equipo(R.drawable.athletic,"Athletic Club","San Mamés",53.289,1898, R.drawable.estadio_athletic);
        Equipo equipo2 = new Equipo(R.drawable.atletico,"Athletico Madrid","Metropolitano",70.460,1903, R.drawable.estadio_athletico);
        Equipo equipo3 = new Equipo(R.drawable.osasuna,"CA Osasuna","El Sadar",23.576,1920, R.drawable.estadio_osasuna);
        Equipo equipo4 = new Equipo(R.drawable.leganes,"CD Leganes","Butarque",12.454,1928, R.drawable.estadio_leganes);
        Equipo equipo5 = new Equipo(R.drawable.alaves,"Deportivo Alaves","Mendizorroza",19.840,1921, R.drawable.estadio_alaves);
        Equipo equipo6 = new Equipo(R.drawable.barcelona,"FC Barcelona","Lluis Companys",55.926,1899, R.drawable.estadio_barcelona);

        Equipo equipo7 = new Equipo(R.drawable.getafe,"Getafe CF","Coliseum",16.500,1983, R.drawable.estadio_getafe);
        Equipo equipo8 = new Equipo(R.drawable.girona,"Girona FC","Montilivi",14.624,1930, R.drawable.estadio_girona);
        Equipo equipo9 = new Equipo(R.drawable.rayo,"Rayo Vallecano","Vallecas",14.708,1924, R.drawable.estadio_rayo);
        Equipo equipo10 = new Equipo(R.drawable.celta,"RC Celta Vigo","Balaidos",24.870,1923, R.drawable.estadio_celta);
        Equipo equipo11 = new Equipo(R.drawable.espanyol,"RCD Espanyol","RCDE Stadium",40.000,1900, R.drawable.estadio_espanyol);
        Equipo equipo12 = new Equipo(R.drawable.mallorca,"RCD Mallorca","Son Moix",23.142,1916, R.drawable.estadio_mallorca);

        Equipo equipo13 = new Equipo(R.drawable.betis,"Real Betis","Benito Villamarín",60.721,1907, R.drawable.estadio_betis);
        Equipo equipo14 = new Equipo(R.drawable.realmadrid,"Real Madrid","Santiago Bernabéu",85.000,1902, R.drawable.estadio_madrid);
        Equipo equipo15 = new Equipo(R.drawable.realsociedad,"Real Sociedad","Reale Arena",40.000,1909, R.drawable.estadio_sociedad);
        Equipo equipo16 = new Equipo(R.drawable.valladolid,"Real Valladolid","José Zorrilla",27.618,1928, R.drawable.estadio_valladolid);
        Equipo equipo17 = new Equipo(R.drawable.sevilla,"Sevilla FC","Sanchez Pizjuán",43.883,1905, R.drawable.estadio_sevilla);
        Equipo equipo18 = new Equipo(R.drawable.laspalmas,"UD Las Palmas","Gran Canaria",32.400,1949, R.drawable.estadio_palmas);

        Equipo equipo19 = new Equipo(R.drawable.valencia,"Valencia CF","Mestalla",49.430,1919, R.drawable.estadio_valencia);
        Equipo equipo20 = new Equipo(R.drawable.villarreal,"Villareal CF","La Cerámica",23.500,1923, R.drawable.estadio_villareal);

        ligaViewModel.insertEquipo(equipo1);
        ligaViewModel.insertEquipo(equipo2);
        ligaViewModel.insertEquipo(equipo3);
        ligaViewModel.insertEquipo(equipo4);
        ligaViewModel.insertEquipo(equipo5);
        ligaViewModel.insertEquipo(equipo6);
        ligaViewModel.insertEquipo(equipo7);
        ligaViewModel.insertEquipo(equipo8);
        ligaViewModel.insertEquipo(equipo9);
        ligaViewModel.insertEquipo(equipo10);
        ligaViewModel.insertEquipo(equipo11);
        ligaViewModel.insertEquipo(equipo12);
        ligaViewModel.insertEquipo(equipo13);
        ligaViewModel.insertEquipo(equipo14);
        ligaViewModel.insertEquipo(equipo15);
        ligaViewModel.insertEquipo(equipo16);
        ligaViewModel.insertEquipo(equipo17);
        ligaViewModel.insertEquipo(equipo18);
        ligaViewModel.insertEquipo(equipo19);
        ligaViewModel.insertEquipo(equipo20);

    }


}