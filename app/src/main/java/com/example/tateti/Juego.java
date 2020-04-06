package com.example.tateti;

public class Juego {

    private static Juego instancia;
    /*
    * Matriz cuadrada 3x3
    * 0 vacio
    * 1 circulo
    * 2 cruz
    * */

    int[][] matrizJuego = new int[3][3];

    private Juego() {

    }

    public static Juego getInstancia() {
        if(instancia == null) {
            instancia = new Juego();
        }
        return instancia;
    }
    public void inicializar() {
        for (int i=0; i<3; i++) {
            for (int j=0; i<3; j++) {
                matrizJuego[i][j] = 0;
            }
        }
    }


    public void agregarMovimiento(int i, int j, String usa) {
        if(usa.equalsIgnoreCase("circulo")){
            matrizJuego[i][j] = 1;
        } else {
            matrizJuego[i][j] = 4;
        }
    }

    public int[] generarMovimiento() {
        int[] resultado = new int[2];
        resultado[0]= (int) Math.floor(Math.random()*(3));
        resultado[1]= (int) Math.floor(Math.random()*(3));

//        System.out.println(resultado[0] + "; " + resultado [1]);
//        System.out.println(matrizJuego[resultado[0]][resultado[1]] == 0);

        return matrizJuego[resultado[0]][resultado[1]] == 0 ? resultado : generarMovimiento();
    }

    public boolean gano() {
        int[] wins = new int[8];
        /* Posiciones:
        *   0: vert 1
        *   1: vert 2
        *   2: vert 3
        *   3: hor 1
        *   4: hor 2
        *   5: hor 3
        *   6: diag 1
        *   7: diag 2*/
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                wins[0] = i==0 ? wins[0]+matrizJuego[i][j] : wins[0];
                wins[1] = i==1 ? wins[1]+matrizJuego[i][j] : wins[1];
                wins[2] = i==2 ? wins[2]+matrizJuego[i][j] : wins[2];
                wins[3] = j==0 ? wins[3]+matrizJuego[i][j] : wins[3];
                wins[4] = j==1 ? wins[4]+matrizJuego[i][j] : wins[4];
                wins[5] = j==2 ? wins[5]+matrizJuego[i][j] : wins[5];
                wins[6] = j==i ? wins[6]+matrizJuego[i][j] : wins[6];
                wins[7] = ((i==0&&j==2)|| (i==1&&j==1)) || (i==2 && j==0) ? wins[7]+matrizJuego[i][j] : wins[7];

            }
        }
        System.out.println("Chequeo");
        for (int i : wins) {
            System.out.println(i);
            if(i == 3 || i == 12)
                return true;
        }
        return false;
    }
}
