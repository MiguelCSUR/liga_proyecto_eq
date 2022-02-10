package controller.menus;
import java.util.Scanner;

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
    public static void elegirOpcion(int opcion){
        switch(opcion){
            case 1:
//                System.out.println(Calendario.toString());
                break;
            case 2:
//                System.out.println(Clasificacion.toString());
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("ERROR. Opción introducida incorrecta");
        }
    }
}
