import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random generador = new Random();

        final String jugador = "A";
        final String enemigo = "X";
        final String casillaVacia = "L";
        final String salida = "S";
        final String vidaExtra = "V";

        int jugador1x, jugador1y;
        int jugador2x, jugador2y;
        int vidasJugador1 = 3;
        int vidasJugador2 = 3;

        //Tablero1
        String[][] tablero1 = new String[6][6];
        String[][] tablero2 = new String[6][6];

        // COMIENZO RELLENADO TABLERO 1
        // Rellenamos con casillas libres "L"
        for (String[] fila : tablero1) {
            Arrays.fill(fila, casillaVacia);
        }

        // Posicionamos jugador1 de forma aleatoria y guardamos en tablero
        jugador1x = generador.nextInt(6);
        jugador1y = generador.nextInt(6);
        tablero1[jugador1x][jugador1y] = jugador;

        //Guardaremos la opcion del usuario
        int opcion;
        System.out.println("Hola, escribe el número del nivel que quieras jugar");
        System.out.println("1. Nivel fácil");
        System.out.println("2. Nivel medio");
        System.out.println("3. Nivel difícil");

        opcion = Integer.parseInt(teclado.nextLine());
        int enemigosSeleccionados;

        switch (opcion) {
            case 1:
                enemigosSeleccionados = 5;
                break;
            case 2:
                enemigosSeleccionados = 7;
                break;
            case 3:
                enemigosSeleccionados = 9;
                break;
            default:
                enemigosSeleccionados = 5;
                break;
        }

        for (int i = 0; i <= enemigosSeleccionados; i++) {
            boolean enemigos = false;
            do {
                int fila = generador.nextInt(6);
                int columna = generador.nextInt(6);
                if (tablero1[fila][columna].equals(casillaVacia)) {
                    tablero1[fila][columna] = enemigo;
                    enemigos = true;
                }
            } while (!enemigos);
        }

        //Posicionamos la casilla salida de forma aleatoria
        boolean casillaLibre = false;
        do {
            int fila = generador.nextInt(6);
            int columna = generador.nextInt(6);
            if (tablero1[fila][columna].equals(casillaVacia)) {
                tablero1[fila][columna] = salida;
                casillaLibre = true;
            }
        } while (!casillaLibre);

        //Posicionamiento casillas vidas extras
        for (int i = 0; i <= 1; i++) {
            boolean vidasExtras = false;
            do {
                int fila = generador.nextInt(6);
                int columna = generador.nextInt(6);
                if (tablero1[fila][columna].equals(casillaVacia)) {
                    tablero1[fila][columna] = vidaExtra;
                    vidasExtras = true;
                }
            } while (!vidasExtras);
        }
        ///////////// FIN RELLENADO TABLERO 1 /////////////////


        // COMIENZO RELLENADO TABLERO 2
        // Rellenamos con casillas libres "L"
        for (String[] fila : tablero2) {
            Arrays.fill(fila, casillaVacia);
        }

        // Posicionamos jugador1 de forma aleatoria y guardamos en tablero
        jugador2x = generador.nextInt(6);
        jugador2y = generador.nextInt(6);
        tablero2[jugador2x][jugador2y] = jugador;

        for (int i = 0; i <= enemigosSeleccionados; i++) {
            boolean enemigos = false;
            do {
                int fila = generador.nextInt(6);
                int columna = generador.nextInt(6);
                if (tablero2[fila][columna].equals(casillaVacia)) {
                    tablero2[fila][columna] = enemigo;
                    enemigos = true;
                }
            } while (!enemigos);
        }

        //Posicionamos la casilla salida de forma aleatoria
        boolean casillaLibreJ2 = false;
        do {
            int fila = generador.nextInt(6);
            int columna = generador.nextInt(6);
            if (tablero2[fila][columna].equals(casillaVacia)) {
                tablero2[fila][columna] = salida;
                casillaLibreJ2 = true;
            }
        } while (!casillaLibreJ2);

        //Posicionamiento casillas vidas extras
        for (int i = 0; i <= 1; i++) {
            boolean vidasExtras = false;
            do {
                int fila = generador.nextInt(6);
                int columna = generador.nextInt(6);
                if (tablero2[fila][columna].equals(casillaVacia)) {
                    tablero2[fila][columna] = vidaExtra;
                    vidasExtras = true;
                }
            } while (!vidasExtras);
        }
        ///////////// FIN RELLENADO TABLERO 2 //////////////


        // TABLERO1

        do {
            System.out.println("TABLERO 1");
            //Pintar tablero con enemigos ocultos
           for (int i = 0; i < tablero1.length; i++) {
               for (int j = 0; j < tablero1[0].length; j++) {
                   if (tablero1[i][j].equals(enemigo)) {
                        System.out.print(casillaVacia + " ");
                    } else {
                   System.out.print(tablero1[i][j] + " ");
               }
           }
                System.out.println();
            }

            // EMPIEZA MOVIMIENTO JUGADOR 1
            // 1º - Reseteamos casilla de usuario actual a Libre
            tablero1[jugador1x][jugador1y] = casillaVacia;

            // Pido movimiento al usuario
            System.out.println("Turno del jugador 1 - Mueve tu personaje con (W/S/A/D):");
            String direccion = teclado.nextLine();
            System.out.println("Número de casillas 1,2 o 3:");
            int casillas = Integer.parseInt(teclado.nextLine());

            // 2º Si es correcto, seguimos, si no repetimos
            boolean movimientoCorrecto;
            do {
                movimientoCorrecto = true;

                // Guardamos posición original
                int casillas1x = jugador1x;
                int casillas1y = jugador1y;
                if (direccion.equals("W") || direccion.equals("w")) {
                    jugador1x -= casillas;
                } else if (direccion.equals("S") || direccion.equals("s")) {
                    jugador1x += casillas;
                } else if (direccion.equals("A") || direccion.equals("a")) {
                    jugador1y -= casillas;
                } else if (direccion.equals("D") || direccion.equals("d")) {
                    jugador1y += casillas;
                } else {
                    movimientoCorrecto = false;
                }
                // Si la dirección no es correcta o las casillas se salen del tablero
                if (!movimientoCorrecto || (jugador1x < 0 || jugador1x > 5) || (jugador1y < 0 || jugador1y > 5)) {
                    System.out.println("Vuelve a introducir dirección y casillas, movimiento incorrecto.");
                    System.out.println("Turno del jugador 1 - Mueve tu personaje con (W/S/A/D):");
                    direccion = teclado.nextLine();
                    System.out.println("Número de casillas 1,2 o 3:");
                    casillas = Integer.parseInt(teclado.nextLine());
                    movimientoCorrecto = false;
                    jugador1x = casillas1x;
                    jugador1y = casillas1y;
                }
            } while (!movimientoCorrecto);

            // COMPROBAMOS ESTADO JUGADOR
            if (tablero1[jugador1x][jugador1y].matches(salida)) {
                System.out.println("¡¡JUGADOR 1 HA GANADO!!");
                System.out.println("¡FIN DE JUEGO!");
                System.out.println(" ");
                break;
            } else {

                if (tablero1[jugador1x][jugador1y].matches(vidaExtra)) {
                    vidasJugador1++;
                    System.out.println("JUGADOR 1 HA GANADO UNA VIDA EXTRA: " + vidasJugador1);
                    System.out.println(" ");
                }

                if (tablero1[jugador1x][jugador1y].matches(enemigo)) {
                    vidasJugador1--;
                    System.out.println("¡¡JUGADOR 1 HA PERDIDO UNA VIDA!! Le quedan: " + vidasJugador1);
                    System.out.println(" ");
                }
                if (vidasJugador1 == 0) {
                    System.out.println("¡¡JUGADOR 1 HA PERDIDO TODAS LAS VIDAS!!");
                    System.out.println(" ");
                    break;
                }

                // Guardamos
                tablero1[jugador1x][jugador1y] = jugador;

                //Pinta el tablero con los enemigos ocultos

                System.out.println("TABLERO 1");
                for (int i = 0; i < tablero1.length; i++) {
                    for (int j = 0; j < tablero1[0].length; j++) {
                        /*if (tablero1[i][j].equals(enemigo)) {
                            System.out.print(casillaVacia + " ");
                        } else*/ {
                            System.out.print(tablero1[i][j] + " ");
                        }
                    }
                    System.out.println();
                }
                System.out.println("======================================");
                System.out.println("======================================");

                //Pinta el tablero con los enemigos ocultos
                System.out.println("TABLERO 2");
                for (int i = 0; i < tablero2.length; i++) {
                    for (int j = 0; j < tablero2[0].length; j++) {
                        if (tablero2[i][j].equals(enemigo)) {
                            System.out.print(casillaVacia + " ");
                        } else {
                            System.out.print(tablero2[i][j] + " ");
                        }
                    }
                    System.out.println();
                }
                // Espacio entre tableros
                System.out.println(" ");

                // EMPIEZA MOVIMIENTO JUGADOR 2
                // 1º - Reseteamos casilla de usuario actual a Libre
                tablero2[jugador2x][jugador2y] = casillaVacia;

                // Pido movimiento al usuario
                System.out.println("Turno del jugador 2 - Mueve tu personaje con (W/S/A/D):");
                direccion = teclado.nextLine();
                System.out.println("Número de casillas 1,2 o 3:");
                casillas = Integer.parseInt(teclado.nextLine());

                // 2º Si es correcto, seguimos, si no repetimos
                do {
                    movimientoCorrecto = true;

                    // Guardamos posicion original
                    int casillas2x = jugador2x;
                    int casillas2y = jugador2y;
                    if (direccion.equals("W") || direccion.equals("w")) {
                        jugador2x -= casillas;
                    } else if (direccion.equals("S") || direccion.equals("s")) {
                        jugador2x += casillas;
                    } else if (direccion.equals("A") || direccion.equals("a")) {
                        jugador2y -= casillas;
                    } else if (direccion.equals("D") || direccion.equals("d")) {
                        jugador2y += casillas;
                    } else {
                        movimientoCorrecto = false;
                    }
                    // Si la dirección no es correcta o las casillas se salen del tablero
                    if (!movimientoCorrecto || (jugador2x < 0 || jugador2x > 5) || (jugador2y < 0 || jugador2y > 5)) {
                        System.out.println("Vuelve a introducir dirección y casillas, movimiento incorrecto.");
                        System.out.println("Turno del jugador 2 - Mueve tu personaje con (W/S/A/D):");
                        direccion = teclado.nextLine();
                        System.out.println("Número de casillas 1,2 o 3:");
                        casillas = Integer.parseInt(teclado.nextLine());
                        movimientoCorrecto = false;
                        jugador2x = casillas2x;
                        jugador2y = casillas2y;
                    }
                } while (!movimientoCorrecto);

                System.out.println(" ");

                // COMPROBAMOS ESTADO JUGADOR
                if (tablero2[jugador2x][jugador2y].matches(salida)) {
                    System.out.println("¡¡JUGADOR 2 HA GANADO!!");
                    System.out.println("¡FIN DE JUEGO!");
                    System.out.println(" ");
                    break;

                } else {
                    if (tablero2[jugador2x][jugador2y].matches(vidaExtra)) {
                        vidasJugador2++;
                        System.out.println("JUGADOR 2 HA GANADO UNA VIDA EXTRA: " + vidasJugador2);
                        System.out.println(" ");
                    }

                    if (tablero2[jugador2x][jugador2y].matches(enemigo)) {
                        vidasJugador2--;
                        System.out.println("¡¡JUGADOR 2 HA PERDIDO UNA VIDA!! Le quedan: " + vidasJugador2);
                        System.out.println(" ");
                    }
                    if (vidasJugador2 == 0) {
                        System.out.println("¡¡JUGADOR 2 HA PERDIDO TODAS LAS VIDAS!!");
                        System.out.println(" ");
                        break;
                    }
                }
                // Guardar jugador después de mover
                tablero2[jugador2x][jugador2y] = jugador;

                //Pinta el tablero con los enemigos ocultos
                System.out.println("TABLERO 2");
                for (int i = 0; i < tablero2.length; i++) {
                    for (int j = 0; j < tablero2[0].length; j++) {
                        if (tablero2[i][j].equals(enemigo)) {
                            System.out.print(casillaVacia + " ");
                        } else {
                            System.out.print(tablero2[i][j] + " ");
                        }
                    }
                    System.out.println();
                }
                System.out.println("======================================");
                System.out.println("======================================");
            }
        } while (true);
    }
}


