package com.example.guessnumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.guessnumber.databinding.ActivityEndplayBinding;

/**
 * Clase final en la que se dan los resultados obtenidos a lo largo de la ejecución del programa.
 * Permite volver a ejecutar la aplicación
 */
public class EndPlayActivity extends AppCompatActivity {
    ActivityEndplayBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEndplayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Jugador jugador = ((GuessNumberApplication) getApplication()).getJugador();

        binding.tvIntentosFinal.setText(jugador.getNombre() + " has " + jugador.getPartida() + " en " + jugador.getnIntentosActual() + " intentos.");
        binding.tvnumAdivinar.setText("El número secreto era " + jugador.getNumAdivinar());
    }

    /**
     * Reinicia el programa volviendo al primer activity, ConfigActivity.
     * @param view
     */
    public void repetir(View view) {
        Intent intent = new Intent(this, ConfigActivity.class);
        startActivity(intent);
        finish();
    }
}
