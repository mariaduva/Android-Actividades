package com.dam.practica_uf2_adivinanum.utils;

import com.dam.practica_uf2_adivinanum.R;

public class ListaMsgAdivina {

    int [] msgAdivina = {R.string.adivina,
            R.string.num_adivinado,
            R.string.num_no_adivinado,
            R.string.num_invld,
            R.string.num_grnd,
            R.string.num_pqn,
            R.string.fin_juego
    };

    public int getMsg(int num) {
        return msgAdivina[num];
    }
}
