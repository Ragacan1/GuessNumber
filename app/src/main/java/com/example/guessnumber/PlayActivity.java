package com.example.guessnumber;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.guessnumber.databinding.ActivityPlayBinding;

public class PlayActivity extends AppCompatActivity {
    ActivityPlayBinding binding;
    Jugador jugador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.jugador = ((GuessNumberApplication) getApplication()).getJugador();

        binding.tvBienvenida.setText("Bienvenido " + jugador.getNombre() + "!");
        binding.tvIntentosRestantes.setText("Te quedan " + String.valueOf(jugador.getnIntentos()) + " intentos");
    }

    /**
     * Comprueba si el número introducido es mayor, menor o igual que el número a adivinar.
     */
    public void adivinar(View view) {
        if (!checkCampos())
            return;
        else {
            int numIntroducido = Integer.parseInt(binding.etNumero.getText().toString());
            Intent intent = new Intent(this, EndPlayActivity.class);
            AlertDialog.Builder dialogo = new AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setTitle("Incorrecto")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            binding.etNumero.setText("");
                            jugador.setnIntentosActual(jugador.getnIntentosActual() + 1);
                            jugador.setnIntentos(jugador.getnIntentos() - 1);
                            binding.tvIntentosRestantes.setText("Te quedan " + String.valueOf(jugador.getnIntentos()) + " intentos");
                        }
                    });

            if (numIntroducido == jugador.getNumAdivinar()) {
                victoria(intent);
                return;
            }
            if (numIntroducido < jugador.getNumAdivinar()) {
                menorNum(intent, dialogo);
                return;
            }
            if (numIntroducido > jugador.getNumAdivinar()) {
                mayorNum(intent, dialogo);
                return;
            }

        }
    }

    /**
     * Gestiona el programa en caso de que el jugador inserte un número mayor al número a adivinar
     */
    public void mayorNum(Intent intent, AlertDialog.Builder dialogo) {
        if (jugador.getnIntentos() == 1) {
            jugador.setPartida("perdido");
            jugador.setnIntentosActual(jugador.getnIntentosActual() + 1);
            startActivity(intent);
            finish();
            return;
        }
        dialogo.setMessage("El número que ha introducido es MAYOR.");
        dialogo.show();
    }

    /**
     * Gestiona el programa en caso de que el jugador inserte un número menor al número a adivinar
     */
    public void menorNum(Intent intent, AlertDialog.Builder dialogo) {
        if (jugador.getnIntentos() == 1) {
            jugador.setPartida("perdido");
            jugador.setnIntentosActual(jugador.getnIntentosActual() + 1);
            startActivity(intent);
            finish();
            return;
        }
        dialogo.setMessage("El número que ha introducido es MENOR.");
        dialogo.show();
    }

    /**
     * Gestiona el programa en caso de que el jugador inserte un número igual al número a adivinar
     */
    public void victoria(Intent intent) {
        jugador.setPartida("ganado");
        jugador.setnIntentosActual(jugador.getnIntentosActual() + 1);
        startActivity(intent);
        finish();
    }

    /**
     * Verifica que ningún campo quede vacío
     */
    public boolean checkCampos() {
        String etNumero = binding.etNumero.getText().toString();

        if (etNumero.equals("")) {
            Toast.makeText(this, "Todos los campos deben estar rellenos", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }
}
