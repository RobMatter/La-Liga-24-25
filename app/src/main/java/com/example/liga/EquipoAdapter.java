package com.example.liga;


import android.location.GnssAntennaInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.liga.databinding.TarjetaBinding;

import java.util.List;

public class EquipoAdapter extends RecyclerView.Adapter<EquipoAdapter.ViewHolder> {

    private List<Equipo> equipos;
    private OnItemSelectListener listener;


    public EquipoAdapter(List<Equipo> equipos, OnItemSelectListener listener) {
        this.equipos = equipos;
        this.listener = listener;
    }

    public interface OnItemSelectListener{
        void onSelect(Equipo equipo);
    }


    @Override
    public EquipoAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        return new EquipoAdapter.ViewHolder(
                TarjetaBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));

    }

    @Override
    public void onBindViewHolder( EquipoAdapter.ViewHolder holder, int position) {
        Equipo equipo = equipos.get(position);

        holder.binding.imgEscudo.setImageResource(equipo.getEscudo());
        holder.binding.txtNombreEquipo.setText(equipo.getNombre());
    }

    @Override
    public int getItemCount() {
        if(equipos != null){
            return equipos.size();
        }else{
            return 0;
        }
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TarjetaBinding binding;
        public ViewHolder(TarjetaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.tarjetaEscudos.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int posicion = getAdapterPosition();
            listener.onSelect(equipos.get(posicion));

        }
    }
}
