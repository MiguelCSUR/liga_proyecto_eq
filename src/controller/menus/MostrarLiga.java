package controller.menus;
import java.util.Scanner;

import controller.Invocador;
import model.Liga;

public class MostrarLiga {

    public static void iniciarMenu(Liga liga){
        imprimirMenu(liga);
    }

    public static void imprimirMenu(Liga liga) {
        System.out.println(" 1. Ver calendario ");
        System.out.println(" 2. Ver clasificacion ");
        System.out.println(" 3. Añadir/Modificar datos ");
        System.out.println(" 4. Crear nueva liga ");
        System.out.println(" 5. Salir ");
        System.out.println();
        System.out.println("Elige una opción:");
        elegirOpcion(liga);
    }

    public static void elegirOpcion(Liga liga) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Introduce desde que Jornada quieres ver (Min: 1)");
                int desde = sc.nextInt();
                System.out.println("Introduce hasta que Jornada quieres ver (Max: "+liga.getCalendario().getListaJornadas().length+")");
                int hasta = sc.nextInt();
                //Invocador.mostrarCalendario(desde-1, hasta-1);
                break;
            case 2:
                //MostrarClasificacion.iniciarMenu(liga);
                break;
            case 3:
                //TODO Por definir que poner aqui
                break;
            case 4:
                System.out.println("No se podrá volver a esta liga. ¿Está seguro de que quiere crear una nueva liga?");
                System.out.println("1. Sí");
                System.out.println("2. No");
                opcion = sc.nextInt();
                switch(opcion){
                    case 1:
                        //TODO GenerarLiga.iniciarMenu();
                        break;
                    case 2:
                        imprimirMenu(liga);
                        break;
                    default:
                        System.out.println("Número introducido erróneo");
                        imprimirMenu(liga);
                }
                break;
            case 5:
                System.out.println("Espero que la aplicación haya sido de su agrado. Adiós...");
                break;
            default:
                System.out.println("ERROR. Opción introducida incorrecta");
                imprimirMenu(liga);
        }

    }
}