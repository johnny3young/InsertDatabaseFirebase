package com.ejemplo.app.insertdatabasefirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText usuario, correo, edad;
    Button guardar;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        usuario = findViewById(R.id.usuario);
        correo = findViewById(R.id.correo);
        edad = findViewById(R.id.edad);
        guardar = findViewById(R.id.guardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usuario.getText().toString();
                String email = correo.getText().toString();
                String age = edad.getText().toString();

                User user1 = new User(user, Integer.valueOf(age), email);

                databaseReference.child("usuarios").child(user).setValue(user1);
            }
        });
    }
}
