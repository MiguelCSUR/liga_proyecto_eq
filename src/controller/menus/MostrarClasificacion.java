package controller.menus;
import controller.Invocador;
import model.Liga;

import java.util.Scanner;

public class MostrarClasificacion {
    private Liga liga;

    public static void iniciarMenu(Liga liga) {
        imprimirMenu(liga);
    }

    public static void imprimirMenu(Liga liga) {
        System.out.println("CLASIFICACIÓN:");
        System.out.println("1. Mostrar todas las jornadas");
        System.out.println("2. Mostrar selección de jornadas");
        System.out.println("3. Volver");
        seleccionClasificacion(liga);
    }

    public static void seleccionClasificacion(Liga liga) {
        Scanner input = new Scanner(System.in);
        int seleccion = input.nextInt();
        switch (seleccion) {
            case 1:
                Invocador.mostrarClasificacion(liga);
                imprimirMenu(liga);
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Esta opción no es correcta");
                imprimirMenu(liga);
                break;
        }
    }
}
