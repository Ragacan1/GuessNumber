package com.example.guessnumber;

import android.app.Application;

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
