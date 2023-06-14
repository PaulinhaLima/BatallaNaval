package batalla;
import java.util.Scanner;

public class Batalla {
    private static final int ancho_altoTablero = 5;
    private static final int barcos = 3;

    private char[][] tablero;
    private int barcosRestantes;

    public batalla() {
        tablero = new char[ancho_altoTablero][ancho_altoTablero];
        barcosRestantes = barcos;

        // Inicializar el tablero 
        for (int i = 0; i < ancho_altoTablero; i++) {
            for (int j = 0; j < ancho_altoTablero; j++) {
                tablero[i][j] = ' ';
            }
        }

        // barcos en posiciones aleatorias
        for (int i = 0; i < barcos; i++) {
            int fila = (int) (Math.random() * ancho_altoTablero);
            int columna = (int) (Math.random() * ancho_altoTablero);

            if (tablero[fila][columna] != 'O') {
                tablero[fila][columna] = 'O';
            } else {
                i--;
            }
        }
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);

        while (barcosRestantes > 0) {
            System.out.println("******** Batalla Naval *******");
            mostrarTablero();
            System.out.print(" fila: ");
            int fila = scanner.nextInt();
            System.out.print(" columna: ");
            int columna = scanner.nextInt();

            if (fila < 0 || fila >= ancho_altoTablero || columna < 0 || columna >= ancho_altoTablero) {
                System.out.println("Posición inválida. Intente nuevamente.");
                continue;
            }

            if (tablero[fila][columna] == 'O') {
                System.out.println("¡Asertaste!");
                tablero[fila][columna] = 'X';
                barcosRestantes--;
            } else if (tablero[fila][columna] == 'X') {
                System.out.println("Ya has golpeado esa posición. Intente nuevamente.");
            } else {
                System.out.println("Agua. Intente nuevamente.");
                tablero[fila][columna] = '-';
            }
        }

        System.out.println("¡Ganaste!");
        mostrarTablero();
    }

    public void mostrarTablero() {
        System.out.println();

        for (int i = 0; i < ancho_altoTablero; i++) {
            for (int j = 0; j < ancho_altoTablero; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}

