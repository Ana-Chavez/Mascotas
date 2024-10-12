package com.example.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity {

    private RecyclerView favoritas;
    private MascotaAdaptador adaptador;
    private ArrayList<Mascota> mascotasFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        favoritas = findViewById(R.id.recyclerViewFavoritas);
        favoritas.setLayoutManager(new LinearLayoutManager(this));

        mascotasFavoritas = getIntent().getParcelableArrayListExtra("FAVORITAS");
        if (mascotasFavoritas != null) {
            adaptador = new MascotaAdaptador(mascotasFavoritas, this);
            favoritas.setAdapter(adaptador);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
