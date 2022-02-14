package controller.menus;
import java.util.Scanner;

import controller.Invocador;
import model.Liga;
import model.Partido;

public class MostrarLiga {

    public static void iniciarMenu(Liga liga){
        imprimirMenu(liga);
    }

    public static void imprimirMenu(Liga liga) {
        System.out.println();
        System.out.println("Elige que hacer con la Liga "+liga.getNombre());
        System.out.println(" 1. Ver calendario");
        System.out.println(" 2. Ver clasificación");
        System.out.println(" 3. Añadir/Modificar datos de un partido");
        System.out.println(" 4. Crear nueva liga");
        System.out.println(" 5. Salir");
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
        int opcion;

        if (liga.getUltimaJornadaJugada() <1){
            System.out.println("No hay jornadas jugadas aún");
            return liga;
        }

        mostrarListaPartido(liga);
        System.out.println();
        System.out.println("Introduce el número del partido que quieres modificar");
        int partidoElegido = sc.nextInt();

        if(liga.getListaEquipos().length%2==0)  numeroPartidosPorRonda = liga.getListaEquipos().length/2;
        else                                    numeroPartidosPorRonda = (liga.getListaEquipos().length-1)/2;

                                                    //este tocho es para saber si el partido que has puesto es uno que se ha jugado
        if (partidoElegido < 1 || partidoElegido > liga.getCalendario().getListaJornadas()[liga.getUltimaJornadaJugada()-1].getlistaPartidos()[numeroPartidosPorRonda-1].getNumeroPartido()){
            System.out.println("Número de partido incorrecto");
            return liga;
        }

        Partido partido = liga.getCalendario().getListaPartidos()[partidoElegido-1];

        System.out.println("Elige que modificar");
        System.out.println("1. Modificar resultado");
        System.out.println("2. Modificar árbitro");
        System.out.println("3. Salir");
        System.out.println("Escoge opción");
        opcion = sc.nextInt();

        switch(opcion){
            case 1:
                //Quita la puntuación y los goles de los equipos para luego poner la que le corresponde con los nuevos goles
                if (partido.getGolesEquipoCasa() == partido.getGolesEquipoFuera()) {
                    //Empate
                    partido.getEquipoCasa().setPuntos(partido.getEquipoCasa().getPuntos() - 1);
                    partido.getEquipoFuera().setPuntos(partido.getEquipoFuera().getPuntos() - 1);

                } else if (partido.getGolesEquipoCasa() > partido.getGolesEquipoFuera()) {
                    //Ganaba Equipo Casa
                    partido.getEquipoCasa().setPuntos(partido.getEquipoCasa().getPuntos() - 3);
                } else {
                    //Ganaba Equipo Fuera
                    partido.getEquipoFuera().setPuntos(partido.getEquipoFuera().getPuntos() - 3);
                }

                partido.getEquipoCasa().setGoles(partido.getEquipoCasa().getGoles()-partido.getGolesEquipoCasa());
                partido.getEquipoFuera().setGoles(partido.getEquipoFuera().getGoles()-partido.getGolesEquipoFuera());

                Invocador.mostrarPartido(partido);

                System.out.println("Introduce cuantos goles ha metido "+partido.getEquipoCasa().getNombre()+" (Casa):");

                goles = sc.nextInt();
                partido.setGolesEquipoCasa(goles);
                partido.getEquipoCasa().setGoles(partido.getEquipoCasa().getGoles()+goles);

                System.out.println("Introduce cuantos goles ha metido "+partido.getEquipoFuera().getNombre()+" (Fuera):");
                goles = sc.nextInt();
                partido.setGolesEquipoFuera(goles);
                partido.getEquipoFuera().setGoles(partido.getEquipoFuera().getGoles()+goles);

                Invocador.asignarPuntos(partido);

                Invocador.mostrarPartido(partido);
                System.out.println("Pulsa enter para continuar");
                opcion = sc.nextInt();
                //metemos el partido modificado en su sitio para que se guarde
                liga.getCalendario().getListaPartidos()[partidoElegido-1] = partido;
                break;
            case 2:

                System.out.println("Escribe el nombre del nuevo Árbitro");
                String arbitro = sc.nextLine();
                partido.getArbitro().setNombre(arbitro);

                System.out.println("Escribe los apellidos del nuevo Árbitro");
                arbitro = sc.nextLine();
                partido.getArbitro().setApellidos(arbitro);

                partido.getArbitro().setLicencia(Invocador.generarLicencia());
                break;
            case 3:
                break;
            default:
                System.out.println("Opción incorrecta");
        }
        return liga;
    }

    public static void mostrarListaPartido(Liga liga){
        Partido [] listaPartidos = liga.getCalendario().getListaPartidos();
        int ultimoPartidoJugado = liga.getUltimaJornadaJugada()*liga.getCalendario().getListaJornadas()[0].getlistaPartidos().length;

        for(int i = 0 ; i < ultimoPartidoJugado ; i++){
            Invocador.mostrarPartido(listaPartidos[i]);
        }
    }
}