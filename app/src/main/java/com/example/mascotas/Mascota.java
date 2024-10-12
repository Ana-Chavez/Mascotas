package com.example.mascotas;

import android.os.Parcel;
import android.os.Parcelable;

public class Mascota implements Parcelable {
    private String nombre;
    private int imagen;
    private boolean favorito;
    private int rating;


    public Mascota(int imagen, String nombre ) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.favorito = false;
        this.rating = 0;
    }

    protected Mascota(Parcel in) {
        nombre = in.readString();
        imagen = in.readInt();
        favorito = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeInt(imagen);
        dest.writeByte((byte) (favorito ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Mascota> CREATOR = new Creator<Mascota>() {
        @Override
        public Mascota createFromParcel(Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int image) {
        this.imagen = image;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
