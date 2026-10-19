package com.example.contactoapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import java.util.Locale;

public class FormularioActivity extends AppCompatActivity {
    private TextInputEditText etNombre, etFecha, etTelefono, etEmail, etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNombre = findViewById(R.id.etNombre);
        etFecha = findViewById(R.id.etFecha);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDescripcion = findViewById(R.id.etDescripcion);

        etFecha.setOnClickListener(v -> mostrarSelectorFecha());
        etFecha.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) mostrarSelectorFecha();
        });

        // Cuando se vuelve desde la pantalla de confirmación, precarga los datos.
        if (savedInstanceState == null && getIntent().getBooleanExtra("editar", false)) {
            etNombre.setText(getIntent().getStringExtra("nombre"));
            etFecha.setText(getIntent().getStringExtra("fecha"));
            etTelefono.setText(getIntent().getStringExtra("telefono"));
            etEmail.setText(getIntent().getStringExtra("email"));
            etDescripcion.setText(getIntent().getStringExtra("descripcion"));
        }

        Button btnSiguiente = findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(v -> continuar());
    }

    private void mostrarSelectorFecha() {
        Calendar c = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(this, (view, year, month, day) -> {
            etFecha.setText(String.format(Locale.getDefault(), "%02d/%02d/%04d", day, month + 1, year));
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        dialog.show();
    }

    private void continuar() {
        String nombre = texto(etNombre);
        String fecha = texto(etFecha);
        String telefono = texto(etTelefono);
        String email = texto(etEmail);
        String descripcion = texto(etDescripcion);

        if (nombre.isEmpty() || fecha.isEmpty() || telefono.isEmpty() || email.isEmpty() || descripcion.isEmpty()) {
            Toast.makeText(this, "Completa todos los campos.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Ingresa un correo electrónico válido.");
            etEmail.requestFocus();
            return;
        }

        Intent intent = new Intent(this, ConfirmacionActivity.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("fecha", fecha);
        intent.putExtra("telefono", telefono);
        intent.putExtra("email", email);
        intent.putExtra("descripcion", descripcion);
        startActivity(intent);
    }

    private String texto(TextInputEditText campo) {
        return campo.getText() == null ? "" : campo.getText().toString().trim();
    }
}
