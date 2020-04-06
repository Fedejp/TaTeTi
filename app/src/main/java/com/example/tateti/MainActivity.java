package com.example.tateti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre;
    RadioButton btnCirculo, btnCruz;
    Button Empezar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        btnCirculo = (RadioButton) findViewById(R.id.btnCirculo);
        btnCruz = (RadioButton) findViewById(R.id.btnCruz);
        Empezar = (Button) findViewById(R.id.Empezar);

        Empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class );
                String nombre = txtNombre.getText().toString();
                if(nombre.isEmpty()) {
                    nombre = "Extraño";
                }
                intent.putExtra("nombre", nombre);
                if(btnCirculo.isChecked()) {
                    intent.putExtra("usa", "circulo");
                } else {
                    intent.putExtra("usa", "cruz");
                }
                startActivity(intent);
            }
        });
    }


}
