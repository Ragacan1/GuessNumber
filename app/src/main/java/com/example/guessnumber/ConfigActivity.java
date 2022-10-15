package com.example.guessnumber;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.guessnumber.databinding.ActivityConfigBinding;

public class ConfigActivity extends AppCompatActivity {

    ActivityConfigBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void jugar(View view) {
        if (!checkCampos() || !checkIntentos())
            return;
        else {
            ((GuessNumberApplication) getApplication()).setJugador(binding.etJugador.getText().toString(), Integer.parseInt(binding.etNumIntentos.getText().toString()));
            Intent intent = new Intent(this, PlayActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public boolean checkCampos() {
        String etJugador = binding.etJugador.getText().toString();
        String etNumIntentos = String.valueOf(binding.etNumIntentos.getText());

        if (etJugador.equals("") || etNumIntentos.equals("")) {
            Toast.makeText(this, "Todos los campos deben estar rellenos", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }

    public boolean checkIntentos() {
        String etNumIntentos = String.valueOf(binding.etNumIntentos.getText());

        if (Integer.parseInt(binding.etNumIntentos.getText().toString()) > 100 || Integer.parseInt(binding.etNumIntentos.getText().toString()) < 1) {
            Toast.makeText(this, "Los intentos deben estar entre 1 y 100", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }
}