package controller.menus;
import java.util.Scanner;

import controller.Invocador;
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
        System.out.println(" 4. Crear nueva liga");
        System.out.println(" 5. Salir");
        System.out.println();
        System.out.println("Elige una opción:");
        elegirOpcion(liga);
        imprimirMenu(liga);
    }

    public static void elegirOpcion(Liga liga) {
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:

                System.out.println("Introduce hasta que jornada quieres ver (Jornada max = "+liga.getCalendario().getListaJornadas().length+"): ");
                int jornadaMax = sc.nextInt();
                Invocador.mostrarCalendario(liga, jornadaMax);
                imprimirMenu(liga);
                break;
            case 2:
                MostrarClasificacion.iniciarMenu(liga);
                imprimirMenu(liga);
                break;
            case 3:
                liga = modificarDatos(liga);
                imprimirMenu(liga);
                break;
            case 4:
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
            case 5:
                System.out.println("Espero que la aplicación haya sido de su agrado. Adiós...");
                break;
            default:
                System.out.println("ERROR. Opción introducida incorrecta");
                imprimirMenu(liga);
        }

    }

    public static Liga modificarDatos(Liga liga){
        Scanner sc = new Scanner(System.in);
        int numeroPartidosPorRonda;
        int goles;

        if (liga.getUltimaJornadaJugada() <1)   System.out.println("No hay jornadas jugadas aún");
        else{
            Invocador.mostrarClasificacion(liga);

            System.out.println();
            System.out.println("Actualmente estamos en la jornada "+liga.getUltimaJornadaJugada());
            


                    System.out.println("Introduce el número del partido");
                    int opcion = sc.nextInt();
                    
                    liga.getCalendario().getListaJornadas();
                if(liga.getListaEquipos().length%2==0)  numeroPartidosPorRonda = liga.getListaEquipos().length/2;
                else                                    numeroPartidosPorRonda = (liga.getListaEquipos().length-1)/2;
                //todo este tocho es para saber si el partido que has puesto es uno que se ha jugado
                if (opcion < 1 || opcion > liga.getCalendario().getListaJornadas()[liga.getUltimaJornadaJugada()-1].getlistaPartidos()[numeroPartidosPorRonda-1].getNumeroPartido()){
                    
                    System.out.println("Número de partido incorrecto");

                }else{
                    

                    if (liga.getCalendario().getListaPartidos()[opcion-1].getGolesEquipoCasa() == liga.getCalendario().getListaPartidos()[opcion-1].getGolesEquipoFuera()) {
                        //Empate
                        liga.getCalendario().getListaPartidos()[opcion-1].getEquipoCasa().setPuntos(liga.getCalendario().getListaPartidos()[opcion-1].getEquipoCasa().getPuntos() - 1);
                        liga.getCalendario().getListaPartidos()[opcion-1].getEquipoFuera().setPuntos(liga.getCalendario().getListaPartidos()[opcion-1].getEquipoFuera().getPuntos() - 1);

                    } else if (liga.getCalendario().getListaPartidos()[opcion-1].getGolesEquipoCasa() > liga.getCalendario().getListaPartidos()[opcion-1].getGolesEquipoFuera()) {
                        //Ganaba Equipo Casa
                        liga.getCalendario().getListaPartidos()[opcion-1].getEquipoCasa().setPuntos(liga.getCalendario().getListaPartidos()[opcion-1].getEquipoCasa().getPuntos() - 3);
                    } else {
                        //Ganaba Equipo Fuera
                        liga.getCalendario().getListaPartidos()[opcion-1].getEquipoFuera().setPuntos(liga.getCalendario().getListaPartidos()[opcion-1].getEquipoFuera().getPuntos() - 3);
                    }
                    System.out.println("Equipo Casa                  Equipo Fuera");
                    System.out.println(liga.getCalendario().getListaPartidos()[opcion-1].getEquipoCasa()+"     "+liga.getCalendario().getListaPartidos()[opcion-1].getEquipoFuera());
                    System.out.println("Goles casa: "+liga.getCalendario().getListaPartidos()[opcion-1].getGolesEquipoCasa()+"    Goles Fuera: "+liga.getCalendario().getListaPartidos()[opcion-1].getGolesEquipoFuera());

                    liga.getCalendario().getListaPartidos()[opcion-1].toString();
                    System.out.println("Escribe cuantos goles ha metido Casa:");
                    goles = sc.nextInt();
                    liga.getCalendario().getListaPartidos()[opcion-1].setGolesEquipoCasa(goles);
                    System.out.println("Escribe cuantos goles ha metido Fuera:");
                    goles = sc.nextInt();
                    liga.getCalendario().getListaPartidos()[opcion-1].setGolesEquipoFuera(goles);
                    
                    System.out.println("Equipo Casa                  Equipo Fuera");
                    System.out.println(liga.getCalendario().getListaPartidos()[opcion-1].getEquipoCasa()+"     "+liga.getCalendario().getListaPartidos()[opcion-1].getEquipoFuera());
                    System.out.println("Goles casa: "+liga.getCalendario().getListaPartidos()[opcion-1].getGolesEquipoCasa()+"    Goles Fuera: "+liga.getCalendario().getListaPartidos()[opcion-1].getGolesEquipoFuera());


                    Invocador.asignarPuntos(liga.getCalendario().getListaPartidos()[opcion-1]);
                }
        }
     return liga;
    }
}