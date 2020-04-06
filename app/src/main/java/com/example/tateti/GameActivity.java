package com.example.tateti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.VectorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Vector;

public class GameActivity extends AppCompatActivity {

    TextView txtJugador, txtGanador;
    ImageView btnBack, btnClose;
    Button x1y1, x2y1, x3y1, x1y2, x2y2, x3y2, x1y3, x2y3, x3y3;
    String nombre, usa;
    public static Juego Juego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        vincular();
        nombre = getIntent().getStringExtra("nombre");
        usa = getIntent().getStringExtra("usa");
        txtJugador.setText(nombre + " juega con " + usa);
        asignarEventos();
    }

    private void asignarEventos() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        x1y1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(usa.equalsIgnoreCase("circulo")) {
                    x1y1.setText("O");
                }
                else {
                    x1y1.setText("X");
                }
                Juego.getInstancia().agregarMovimiento(0,0,usa);
                x1y1.setEnabled(false);
                actualizarTablero();
            }
        });
        x1y2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(usa.equalsIgnoreCase("circulo")) {
                    x1y2.setText("O");
                }
                else {
                    x1y2.setText("X");
                }
                Juego.getInstancia().agregarMovimiento(0,1,usa);
                x1y2.setEnabled(false);
                actualizarTablero();
            }
        });
        x1y3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(usa.equalsIgnoreCase("circulo")) {
                    x1y3.setText("O");
                }
                else {
                    x1y3.setText("X");
                }
                Juego.getInstancia().agregarMovimiento(1,2,usa);
                x1y3.setEnabled(false);
                actualizarTablero();
            }
        });
        x2y1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(usa.equalsIgnoreCase("circulo")) {
                    x2y1.setText("O");
                }
                else {
                    x2y1.setText("X");
                }
                Juego.getInstancia().agregarMovimiento(1,0,usa);
                x2y1.setEnabled(false);
                actualizarTablero();
            }
        });
        x2y2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(usa.equalsIgnoreCase("circulo")) {
                    x2y2.setText("O");
                }
                else {
                    x2y2.setText("X");
                }
                Juego.getInstancia().agregarMovimiento(1,1,usa);
                x2y2.setEnabled(false);
                actualizarTablero();
            }
        });
        x2y3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(usa.equalsIgnoreCase("circulo")) {
                    x2y3.setText("O");
                }
                else {
                    x2y3.setText("X");
                }
                Juego.getInstancia().agregarMovimiento(1,2,usa);
                x2y3.setEnabled(false);
                actualizarTablero();
            }
        });
        x3y1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(usa.equalsIgnoreCase("circulo")) {
                    x3y1.setText("O");
                }
                else {
                    x3y1.setText("X");
                }
                Juego.getInstancia().agregarMovimiento(2,0,usa);
                x3y1.setEnabled(false);
                actualizarTablero();
            }
        });
        x3y2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(usa.equalsIgnoreCase("circulo")) {
                    x3y2.setText("O");
                }
                else {
                    x3y2.setText("X");
                }
                Juego.getInstancia().agregarMovimiento(2,1,usa);
                x3y2.setEnabled(false);
                actualizarTablero();
            }
        });
        x3y3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(usa.equalsIgnoreCase("circulo")) {
                    x3y3.setText("O");
                }
                else {
                    x3y3.setText("X");
                }
                Juego.getInstancia().agregarMovimiento(2,2,usa);
                x3y3.setEnabled(false);
                actualizarTablero();
            }
        });

    }

    private void actualizarTablero() {
        if(!Juego.getInstancia().gano()) {
            int[] posicion = Juego.getInstancia().generarMovimiento();
            Button aux = buscarBoton(posicion);
            if (usa.equalsIgnoreCase("circulo")){
                aux.setText("X");
                Juego.getInstancia().agregarMovimiento(posicion[0],posicion[1],"cruz");
            }
            else {
                aux.setText("O");
                Juego.getInstancia().agregarMovimiento(posicion[0],posicion[1],"circulo");
            }
            aux.setEnabled(false);
            if(Juego.getInstancia().gano()) {
                txtGanador.setText("El ganador es la computadora :C");
                deshabilitar();
            }
        } else {
            txtGanador.setText("El ganador es " + nombre + " :3");
            deshabilitar();
        }

    }

    private Button buscarBoton(int[] resultado) {
        if(resultado[0] == 0 && resultado [1] == 0)
            return x1y1;
        else if(resultado[0] == 0 && resultado [1] == 1)
            return x1y2;
        else if(resultado[0] == 0 && resultado [1] == 2)
            return x1y3;
        else if(resultado[0] == 1 && resultado [1] == 0)
            return x2y1;
        else if(resultado[0] == 1 && resultado [1] == 1)
            return x2y2;
        else if(resultado[0] == 1 && resultado [1] == 2)
            return x2y3;
        else if(resultado[0] == 2 && resultado [1] == 0)
            return x3y1;
        else if(resultado[0] == 2 && resultado [1] == 1)
            return x3y2;
        else
            return x3y3;
    }

    private void vincular() {
        txtJugador = (TextView) findViewById(R.id.txtJugador);
        txtGanador = (TextView) findViewById(R.id.txtGanador);
        btnClose = (ImageView) findViewById(R.id.btnClose);
        btnBack = (ImageView) findViewById(R.id.btnBack);
        x1y1 = (Button) findViewById(R.id.x1y1);
        x2y1 = (Button) findViewById(R.id.x2y1);
        x3y1 = (Button) findViewById(R.id.x3y1);
        x1y2 = (Button) findViewById(R.id.x1y2);
        x2y2 = (Button) findViewById(R.id.x2y2);
        x3y2 = (Button) findViewById(R.id.x3y2);
        x1y3 = (Button) findViewById(R.id.x1y3);
        x2y3 = (Button) findViewById(R.id.x2y3);
        x3y3 = (Button) findViewById(R.id.x3y3);

    }

    private void deshabilitar() {
        x1y1.setEnabled(false);
        x1y2.setEnabled(false);
        x1y3.setEnabled(false);
        x2y1.setEnabled(false);
        x2y2.setEnabled(false);
        x2y3.setEnabled(false);
        x3y1.setEnabled(false);
        x3y2.setEnabled(false);
        x3y3.setEnabled(false);


    }
}
