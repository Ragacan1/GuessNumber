package com.example.guessnumber;

import java.io.Serializable;
import java.util.Random;

/**
 * Clase que gestiona datos del jugador.
 * Se establecen campos necesarios para el desarrollo de la aplicación como nombre, intentos, numero a adivinar y estado actual de la partida
 */
public class Jugador implements Serializable {

    String nombre;
    int nIntentos;
    int nIntentosActual;
    int numAdivinar;
    String partida;


    public Jugador(String nombre, int nIntentos) {
        this.nombre = nombre;
        this.nIntentos = nIntentos;
        this.nIntentosActual = 0;
        this.numAdivinar = 1 + new Random().nextInt(100);
        this.partida = "En juego";

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getnIntentos() {
        return nIntentos;
    }

    public void setnIntentos(int nIntentos) {
        this.nIntentos = nIntentos;
    }

    public int getnIntentosActual() {
        return nIntentosActual;
    }

    public void setnIntentosActual(int nIntentosActual) {
        this.nIntentosActual = nIntentosActual;
    }

    public int getNumAdivinar() {
        return numAdivinar;
    }

    public void setNumAdivinar(int numAdivinar) {
        this.numAdivinar = numAdivinar;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }
}
