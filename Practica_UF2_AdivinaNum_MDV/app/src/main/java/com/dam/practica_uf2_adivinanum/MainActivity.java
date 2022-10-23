package com.dam.practica_uf2_adivinanum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dam.practica_uf2_adivinanum.utils.ListaColoresFondo;
import com.dam.practica_uf2_adivinanum.utils.ListaMsgAdivina;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl;
    TextView txtInt;
    TextView txtPista;
    EditText etAdivina;
    Button btnComp;

    ListaColoresFondo colores;
    ListaMsgAdivina pistas;

    private int numUsr;
    private int numIntentos;
    private int numAlea;
    private boolean numAcertado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = findViewById(R.id.rlFondo);
        txtInt = findViewById(R.id.txtIntentos);
        txtPista = findViewById(R.id.txtPista);
        etAdivina = findViewById(R.id.etNum);
        btnComp = findViewById(R.id.btnComparacion);

        colores = new ListaColoresFondo();
        pistas = new ListaMsgAdivina();

        numIntentos = 5;
        numAlea = (int) ((Math.random() * 100) + 1);
        numAcertado = false;
        //System.out.println(numAlea);

        rl.setBackgroundColor(getColor(colores.getColorFondo(0)));
        txtInt.setText(String.format(getString(R.string.intentos_rest), numIntentos));
        txtPista.setText(String.format(getString(pistas.getMsg(0)), numAlea));

        btnComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numUsr = Integer.parseInt(etAdivina.getText().toString());
                if(numUsr < 0 || numUsr >100){
                    Toast.makeText(MainActivity.this, pistas.getMsg(3) , Toast.LENGTH_LONG).show();
                }
                if(numUsr == numAlea){
                    numAcertado = true;
                    finJuego(numAcertado,1);
                } else if (numUsr != numAlea) {
                    --numIntentos;
                    if (numIntentos == 0) {
                        finJuego(numAcertado,2);
                    } else {
                        if (numUsr > numAlea) {
                            txtPista.setText(pistas.getMsg(5));
                        } else {
                            txtPista.setText(pistas.getMsg(4));
                        }
                        txtInt.setText(String.format(getString(R.string.intentos_rest), numIntentos));
                        etAdivina.setText("");
                    }
                    txtInt.setText(String.format(getString(R.string.intentos_rest), numIntentos));
                }
            }

            private void finJuego(boolean esCorrecto, int num) {
                if (esCorrecto){
                    txtPista.setText(pistas.getMsg(num));
                }else {
                    txtPista.setText(String.format(getString(pistas.getMsg(num)), numAlea));
                }
                rl.setBackgroundColor(getColor(colores.getColorFondo(num)));
                btnComp.setText(pistas.getMsg(6));
                btnComp.setEnabled(false);
                etAdivina.setEnabled(false);
            }
        });
    }
}