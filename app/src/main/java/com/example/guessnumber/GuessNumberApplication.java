package com.example.guessnumber;

import android.app.Application;

/**
 * Clase que instancia la clase Jugador para permitir al resto de clases manipular los datos del jugador.
 */
public class GuessNumberApplication extends Application {
    Jugador jugador;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void setJugador(String jugador, int nIntentos) {
        this.jugador = new Jugador(jugador, nIntentos);
    }

    public Jugador getJugador() {
        return jugador;
    }
}
