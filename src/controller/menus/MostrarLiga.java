package controller.menus;
import java.util.Scanner;

import controller.Invocador;
import model.Calendario;
import model.Clasificacion;
import model.Liga;

public class MostrarLiga {

    public static void imprimirMenu(){
        System.out.println(" 1. Ver calendario ");
        System.out.println(" 2. Ver clasificacion ");
        System.out.println(" 3. Añadir/Modificar datos ");
        System.out.println(" 4. Crear nueva liga ");
        System.out.println(" 5. Salir ");
        System.out.println();
        System.out.println("Elige una opción:");
    }

    public static void elegirOpcion(int opcion, Liga liga){
        switch(opcion){
            case 1:
                //Invocador.mostrarCalendario(liga);
                break;
            case 2:
                //MostrarLiga();
                break;
            case 3:
                break;
            case 4:
                System.out.println("No se podrá volver a esta liga");
                break;
            case 5:
                break;
            default:
                System.out.println("ERROR. Opción introducida incorrecta");
        }
    }