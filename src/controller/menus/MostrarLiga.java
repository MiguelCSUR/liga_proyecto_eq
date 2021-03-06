package controller.menus;
import java.util.Scanner;
import controller.Mostrador;
import model.Liga;

public class MostrarLiga {

    public static void iniciarMenu(Liga liga){
        imprimirMenu(liga);
    }

    public static void imprimirMenu(Liga liga) {
        System.out.println();
        System.out.println("Elige que hacer con la Liga "+liga.getNombre());
        System.out.println(" 1. Ver calendario");
        System.out.println(" 2. Ver clasificación");
        System.out.println(" 3. Añadir/Modificar datos de clasificación");
        System.out.println(" 4. Añadir/Modificar datos de un Equipo");
        System.out.println(" 5. Crear nueva liga desde cero");
        System.out.println(" 6. Crear nueva liga guardando los equipos");
        System.out.println(" 7. Salir");
        System.out.println();
        System.out.println("Elige una opción:");
        elegirOpcion(liga);
    }

    public static void elegirOpcion(Liga liga) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Introduce hasta que jornada quieres ver (Jornada max = "+liga.getCalendario().getListaJornadas().length+"): ");
                int jornadaMax = sc.nextInt();
                Mostrador.mostrarCalendario(liga, jornadaMax);
                imprimirMenu(liga);
                break;
            case 2:
                MostrarClasificacion.iniciarMenu(liga);
                break;
            case 3:
                MostrarPartidos.iniciarMenu(liga);
                break;
            case 4:
                MostrarEquipos.iniciarMenu(liga);
                break;
            case 5:
                System.out.println("No se podrá volver a esta liga. ¿Está seguro de que quiere crear una nueva liga?");
                System.out.println("1. Sí");
                System.out.println("2. No");
                opcion = sc.nextInt();
                switch(opcion){
                    case 1:
                        GenerarLiga.iniciarImprimirMenuLiga();
                        break;
                    case 2:
                        imprimirMenu(liga);
                        break;
                    default:
                        System.out.println("Número introducido erróneo");
                        imprimirMenu(liga);
                }
                break;
            case 6:
                System.out.println("No se podrá volver a esta liga. ¿Está seguro de que quiere crear una nueva liga guardando los equipos?");
                System.out.println("1. Sí");
                System.out.println("2. No");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        Liga ligaNueva = new Liga();
                        ligaNueva.setListaEquipos(liga.getListaEquipos());
                        ligaNueva.setCategoria(liga.getCategoria());
                        GenerarLiga.imprimirMenu(ligaNueva);
                        break;
                    case 2:
                        imprimirMenu(liga);
                        break;
                    default:
                        System.out.println("Número introducido erróneo");
                        imprimirMenu(liga);
                }
            case 7:
                System.out.println("Espero que la aplicación haya sido de su agrado. Adiós...");
                break;
            default:
                System.out.println("ERROR. Opción introducida incorrecta");
                imprimirMenu(liga);
        }
    }
}