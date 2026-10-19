package com.example.contactoapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmacionActivity extends AppCompatActivity {
    private String nombre, fecha, telefono, email, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        nombre = getIntent().getStringExtra("nombre");
        fecha = getIntent().getStringExtra("fecha");
        telefono = getIntent().getStringExtra("telefono");
        email = getIntent().getStringExtra("email");
        descripcion = getIntent().getStringExtra("descripcion");

        ((TextView) findViewById(R.id.tvNombre)).setText(valor(nombre));
        ((TextView) findViewById(R.id.tvFecha)).setText(valor(fecha));
        ((TextView) findViewById(R.id.tvTelefono)).setText(valor(telefono));
        ((TextView) findViewById(R.id.tvEmail)).setText(valor(email));
        ((TextView) findViewById(R.id.tvDescripcion)).setText(valor(descripcion));

        Button btnEditar = findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(v -> {
            Intent intent = new Intent(this, FormularioActivity.class);
            intent.putExtra("editar", true);
            intent.putExtra("nombre", nombre);
            intent.putExtra("fecha", fecha);
            intent.putExtra("telefono", telefono);
            intent.putExtra("email", email);
            intent.putExtra("descripcion", descripcion);
            startActivity(intent);
            finish();
        });
    }

    private String valor(String texto) {
        return texto == null || texto.trim().isEmpty() ? "—" : texto;
    }
}
