package com.example.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        listaMascotas = findViewById(R.id.rvLista);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializaAdaptador();

        //Floating Action Button
        FloatingActionButton fabSubir = findViewById(R.id.fabSubir);
        fabSubir.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Agregar.class);
            startActivity(intent);
        });

    }

    public void inicializaAdaptador(){
        MascotaAdaptador adaptador;
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perro, "Catty"));
        mascotas.add(new Mascota(R.drawable.perro2, "Ronny"));
        mascotas.add(new Mascota(R.drawable.perro3, "Frida"));
        mascotas.add(new Mascota(R.drawable.perro4, "Rocky"));
        mascotas.add(new Mascota(R.drawable.perro5, "Coco"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_favoritos) {
            Intent intent = new Intent(this, Favoritas.class);

            ArrayList<Mascota> favoritas = new ArrayList<>();
            for (Mascota mascota : mascotas) {
                if (mascota.isFavorito()) {
                    favoritas.add(mascota);
                }
            }
            intent.putParcelableArrayListExtra("FAVORITAS", favoritas);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}