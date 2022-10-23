package com.dam.practica_uf2_adivinanum.utils;


import com.dam.practica_uf2_adivinanum.R;

public class ListaColoresFondo {

    int [] coloresFondo = {R.color.inicio, R.color.adivinado, R.color.no_adivinado};

    public int getColorFondo(int num) {
        return coloresFondo[num];
    }
}
