package com.example.mascotas;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota>mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgMascota.setImageResource(mascota.getImagen());
        holder.tvNombre.setText(mascota.getNombre());


        // Icono Hueso Blanco
        holder.blanco.setImageResource(mascota.isFavorito() ? R.drawable.hueso_rojo : R.drawable.hueso_blanco);
        holder.blanco.setOnClickListener(v -> {
            mascota.setFavorito(!mascota.isFavorito());
            holder.blanco.setImageResource(
                    mascota.isFavorito() ? R.drawable.hueso_rojo : R.drawable.hueso_blanco);
        });

        // Raiting
        holder.naranja.setOnClickListener(v -> {
            int rating = mascota.getRating() + 1;
            mascota.setRating(rating);
            holder.ratingMascota.setText(String.valueOf(rating));

            holder.ratingMascota.setText(String.valueOf(mascota.getRating()));
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMascota, blanco, naranja;
        private TextView tvNombre, ratingMascota;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMascota = itemView.findViewById(R.id.imgMascota);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            blanco = itemView.findViewById(R.id.icBlanco);
            naranja = itemView.findViewById(R.id.icNaranja);
            ratingMascota = itemView.findViewById(R.id.ratingMascota);
        }
    }
}
