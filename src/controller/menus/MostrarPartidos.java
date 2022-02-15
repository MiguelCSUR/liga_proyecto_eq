package controller.menus;

import controller.Invocador;
import model.Liga;
import model.Partido;

import java.util.Scanner;

public class MostrarPartidos {

    public static Liga modificarPartidos(Liga liga){
        Scanner sc = new Scanner(System.in);
        int numeroPartidosPorRonda;
        int goles;
        int opcion;

        if (liga.getUltimaJornadaJugada() <1){
            System.out.println("No hay jornadas jugadas aún, por lo que tampoco hay partidos jugados.");
            return liga;
        }

        mostrarListaPartido(liga);
        System.out.println();
        System.out.println("Introduce el número del partido que quieres modificar:");
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

                mostrarPartido(partido);

                System.out.println("Introduce cuantos goles ha metido "+partido.getEquipoCasa().getNombre()+" (Casa):");

                goles = sc.nextInt();
                partido.setGolesEquipoCasa(goles);
                partido.getEquipoCasa().setGoles(partido.getEquipoCasa().getGoles()+goles);

                System.out.println("Introduce cuantos goles ha metido "+partido.getEquipoFuera().getNombre()+" (Fuera):");
                goles = sc.nextInt();
                partido.setGolesEquipoFuera(goles);
                partido.getEquipoFuera().setGoles(partido.getEquipoFuera().getGoles()+goles);

                Invocador.asignarPuntos(partido);

                mostrarPartido(partido);

                //metemos el partido modificado en su sitio para que se guarde
                liga.getCalendario().setListaPartidosConcreto(partido, partidoElegido-1);
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

    public static void mostrarUnPartido(Partido partido){

    }

    public static void mostrarPartido(Partido partido){

        System.out.println("Partido "+partido.getNumeroPartido()+":");
        System.out.println("------------------------------------------");
        System.out.println("Equipos Casa: "+partido.getEquipoCasa().getNombre()+"        "+partido.getEquipoCasa().getClub());
        System.out.println("Equipos Fuera: "+partido.getEquipoFuera().getNombre()+"        "+partido.getEquipoFuera().getClub());

        System.out.println("Goles Casa: "+partido.getGolesEquipoCasa()+"                "+
                "Goles Fuera: "+partido.getGolesEquipoFuera());

        System.out.println("Equipación de Casa: "+partido.getEquipoCasa().getEquipacionCasa());
        System.out.println("Equipación de Fuera: "+partido.getEquipoFuera().getEquipacionFuera());

        System.out.println("Árbitro: "+partido.getArbitro().getNombre()+ " " +partido.getArbitro().getApellidos());
        System.out.println("Empezó en "+partido.getFecha()+" a las "+partido.getHoraInicio());
        System.out.println();
        System.out.println();
    }

    public static void mostrarListaPartido(Liga liga){
        Partido [] listaPartidos = liga.getCalendario().getListaPartidos();
        int ultimoPartidoJugado = liga.getUltimaJornadaJugada()*liga.getCalendario().getListaJornadas()[0].getlistaPartidos().length;

        for(int i = 0 ; i < ultimoPartidoJugado ; i++){
            mostrarPartido(listaPartidos[i]);
        }
    }
}

