package controller.menus;
import controller.Invocador;
import model.*;
import java.util.Scanner;

public class GenerarLiga {
    public static void inicarImprimirMenuLiga(){
        Liga liga = new Liga();
        imprimirMenu(liga);
    }

    public static void imprimirMenu(Liga liga) {
        Scanner sc = new Scanner(System.in);
        if(liga.getNombre()==null) {
            System.out.println(" 1. Nombre ");
        }
        else{
            System.out.println(" 1. Nombre - "+liga.getNombre());
        }
        if(liga.getCategoria()==null) {
            System.out.println(" 2. Categoría ");
        }
        else{
            System.out.println(" 2. Categoría - "+liga.getCategoria());
        }
        if(liga.getListaEquipos()==null) {
            System.out.println(" 3. Numero de Equipos ");
        }
        else{
            //Todo Necesitas un numero de equipos y categoria para crear los equipos
            System.out.println(" 3. Numero de Equipos - "+liga.getListaEquipos().length);
        }
        if(liga.getFechaInicio()==null) {
            System.out.println(" 4. Fecha Inicio ");
        }
        else{
            System.out.println(" 4. Fecha Inicio - "+liga.getFechaInicio());
        }
        System.out.println(" 5. Crear Liga ");
        System.out.println(" Si falta por rellenar algun campo este se generara de modo aleatorio");
        System.out.println();
        System.out.println("Elige una opción:");
        elegirOpcion(sc.nextInt(),liga);
        imprimirMenu(liga);
    }

    public static void elegirOpcion(int opcion,Liga liga){
        Scanner sc = new Scanner(System.in);
        switch(opcion){
            case 1:
                System.out.println("Escriba el nombre de la liga: ");
                liga.setNombre(sc.nextLine());
                break;
            case 2:
                System.out.println("Elija una de las siguientes categorías: ");
                System.out.println(" 1. Chupetín");
                System.out.println(" 2. Prebenjamín");
                System.out.println(" 3. Benjamín");
                System.out.println(" 4. Alevín");
                System.out.println(" 5. Infantil");
                System.out.println(" 6. Cadete");
                System.out.println(" 7. Juvenil");
                liga.setCategoria(elegirCategoria(sc.nextInt()));
                liga.setListaEquipos(Invocador.crearListaEquipos(liga.getListaEquipos().length,liga.getCategoria()));
                break;
            case 3:
//                if (){
//
//                }
                System.out.println("Cuantos equipos deseas tener: ");
                liga.setListaEquipos(Invocador.crearListaEquipos(sc.nextInt(),liga.getCategoria()));
                break;
            case 4:
                //fecha inico
                break;
            case 5:
                //fecha inicio
                break;
            default:
                System.out.println("ERROR. Opción introducida incorrecta");
        }
    }
    public static String elegirCategoria(int opcion){
        switch(opcion){
            case 1:
                return "Chupetín";
            case 2:
                return "Prebenjamín";
            case 3:
                return "Benjamín";
            case 4:
                return "Alevín";
            case 5:
                return "Infantil";
            case 6:
                return "Cadete";
            case 7:
                return "Juvenil";
            default:
                return "ERROR. Opción introducida incorrecta";
        }
    }

}
