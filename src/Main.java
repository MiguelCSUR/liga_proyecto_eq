import model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    //Inicializamos las probabilidades de Goles, una vez
    static int[] PROBABILIDADESGOLES = generadorProbabilidades();

    //TODO investigar porque static no funca
    public static void main(String[] args) {
        //CALENDAR
        Calendar calendario = Calendar.getInstance();
        LocalDateTime localDateTime = LocalDateTime.now()/*.plusDays(1)*/;
        DateTimeFormatter formmatDate = DateTimeFormatter.ofPattern("dd-MM-yy", Locale.ENGLISH);
        String formatter = formmatDate.format(localDateTime);

        System.out.println("---------------------");
        System.out.println(formatter);
        System.out.println("---------------------");


        //Instaciar Equipo
        Equipo equipo1 = new Equipo();

        //Crear LISTA de Equipos
        Equipo[] listaEquipos= new Equipo[8];
        for(int i = 0;i<8;i++) {
            listaEquipos[i] = crearEquipo("Juvenil");
        }
        Arbitro[] listaArbitro = crearListaArbitro();

        crearJornadas(listaEquipos,listaArbitro);

        System.out.println("-------HASH!-------");

        //inicializa Equipos Puntos a 0.
        Map<Equipo, Integer> mapaEquiposPuntos = initMapaEquiposPuntos(listaEquipos);

        //printa el hashmapa
        for (Equipo i : mapaEquiposPuntos.keySet()) {
            System.out.println("Nombre Equipos: " + i.getNombre() + " Puntos: " + mapaEquiposPuntos.get(i));
        }



//        Equipo equipo1 = new Equipo();
//
//        //Asignar lista de jugadores al equipo
//        Jugador[] listaJugadores = crearJugadores("Juvenil");
//        equipo1.setJugadores(listaJugadores);
//
//        //PARTIDO
//        Partido partido = crearPartido("Juvenil");
//        System.out.println(
//                partido.toString()
//        );

        //Crear Jornada


        //Aquí comprobamos el ganador
//        comprobarGanador(partido);
    }

    public static Map<Equipo, Integer> initMapaEquiposPuntos(Equipo[] listaEquipos) {
        Map<Equipo, Integer> mapaEquiposPuntos = new HashMap<Equipo, Integer>();
        for (int i = 0; i < listaEquipos.length; i++) {
            mapaEquiposPuntos.put(listaEquipos[i], 0);
        }
        return mapaEquiposPuntos;
    }

    //Generador de probabilidades, lo llamamos 1 vez
    public static int[] generadorProbabilidades() {

        int[] probabilidad = new int[100];

        for (int i = 0; i < probabilidad.length; i++) {
            if (i <= 24) {
                probabilidad[i] = 1;
            }
            if (i > 24 && i <= 49) {
                probabilidad[i] = 2;
            }
            if (i > 49 && i <= 69) {
                probabilidad[i] = 3;
            }
            if (i > 69 && i <= 89) {
                probabilidad[i] = 0;
            }
            if (i > 89 && i <= 96) {
                probabilidad[i] = 4;
            }
            if (i > 96 && i <= 99) {
                probabilidad[i] = 5;
            }
        }
        return probabilidad;
    }

    public static int generadorGoles() {
        int numRamdon = (int) Math.floor(Math.random() * 100);
        return PROBABILIDADESGOLES[numRamdon];
    }

    //TODO: Borrar este método, cuando hagamos Clasificacion.java
    //PROVISIONAL Un método simple que comprueba el ganador, no devuelve nada solo imprime texto
    public static void asignarPuntos(Partido partido) {
            Equipo equipoCasa = partido.getEquipoCasa();
            Equipo equipoFuera = partido.getEquipoFuera();

        if (partido.getGolesEquipoCasa() == partido.getGolesEquipoFuera()) {
            //Empate
            equipoCasa.setPuntos(equipoCasa.getPuntos() + 1);
            equipoFuera.setPuntos(equipoFuera.getPuntos() + 1);
//            System.out.printf("\n%s y %s han quedado en empate", partido.getEquipoCasa().getNombre(),
//                    partido.getEquipoFuera().getNombre());
        } else if (partido.getGolesEquipoCasa() > partido.getGolesEquipoFuera()) {
            //Gana Equipo Casa
            equipoCasa.setPuntos(equipoCasa.getPuntos() + 3);
//            System.out.printf("\n%s han ganado a %s", partido.getEquipoCasa().getNombre(),
//                    partido.getEquipoFuera().getNombre());
        } else {
            //Gana Equipo Fuera
            equipoFuera.setPuntos(equipoFuera.getPuntos() + 3);
//            System.out.printf("\n%s han ganado a %s", partido.getEquipoFuera().getNombre(),
//                    partido.getEquipoCasa().getNombre());
        }
    }

    //Crea un array de jugadores, con un tam variable entre 11 y 20,
    //Este tamaño: numJugadores, sale de Equipo.java
    public static Jugador[] crearJugadores(String categoria) {
        int numJugadores = Equipo.asigNumJugadores();
        Jugador[] jugadores = new Jugador[numJugadores];
        Equipo equipo = new Equipo();

        //Se van creando los jugadores y asignando a un array
        for (int i = 0; i < numJugadores; i++) {
            Jugador jugador = new Jugador(categoria, i + 1);
            jugador.setEquipo(equipo);
            jugadores[i] = jugador;
        }
        return jugadores;
    }

    public static Equipo crearEquipo(String categoria) {
        Equipo equipo = new Equipo();
        equipo.setJugadores(crearJugadores(categoria));
        return equipo;
    }
    //TODO: Esto es un creacion de lista de arbitros provisional para provar el crear las jornadas
    public static Arbitro[] crearListaArbitro(){
        int numeroArbitros = 100;
        Arbitro[] listaArbitro = new Arbitro[100];
        for(int i = 0;i<100;i++){
            Arbitro arbitro = new Arbitro();
            listaArbitro[i]=arbitro;
        }

        return listaArbitro;
    }

    //Creamos el evento del partido, pero todavía no lo jugamos en este método
    public static Partido crearPartido(Equipo equipoCasa,Equipo equipoFuera,Arbitro arbitro) {
        Partido partido = new Partido(equipoCasa, equipoFuera, arbitro);

        //Generamos los golesEquipoCasa
        int golesEquipoCasa =  generadorGoles();
        //Seteamos los goles del Equipo casa, al partido en la propiedad partido.golesEquipoCasa
        partido.setGolesEquipoCasa(golesEquipoCasa);
        //Seteamos los goles del Equipo casa, al equipo en la propiedad equipo.goles
        //TODO: Este último paso es redundante eliminar en el futuro.
        equipoCasa.setGoles(equipoCasa.getGoles() + golesEquipoCasa);

        //Se repite el mismo proceso con golesEquipoFuera.
        int golesEquipoFuera =  generadorGoles();
        partido.setGolesEquipoFuera(golesEquipoFuera);
        equipoFuera.setGoles(equipoFuera.getGoles() + golesEquipoFuera);

        //Se asignan los puntos
        asignarPuntos(partido);

        return partido;
    }

    //TODO: método provisional.
    //Pide un número de numeroEquipos, solo lo acepta si es mayor de 1.
    public static int numeroEquipos() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número de equipos: ");
        int numeroEquipos = sc.nextInt();
        while (numeroEquipos < 2) {
            System.out.println("\nSe necesitan mas de un equipo para una liga.");
            System.out.print("Introduce de nuevo otro número de equipos: ");
            numeroEquipos = sc.nextInt();
        }
        return numeroEquipos;
    }

    public static Partido[][] crearJornadas(Equipo[] listaEquipos, Arbitro [] listaArbitros) {
        int numeroEquipos = listaEquipos.length;

        int numEncuentros = (numeroEquipos * (numeroEquipos - 1)) / 2;
        int numRondas;
        int numeroPartidosPorRonda;
        int equipoCasa = 0;
        int equipoFuera = 0;

        if (numeroEquipos % 2 == 0) {
            numRondas = numeroEquipos - 1;
            numeroPartidosPorRonda = numeroEquipos / 2;
        } else {
            numRondas = numeroEquipos;
            numeroPartidosPorRonda = (numeroEquipos - 1) / 2;
        }

        Partido[][] jornadas;
        jornadas = new Partido[numRondas*2][numeroPartidosPorRonda];

        if(numeroEquipos%2 == 0) {//para nº equipos par
            for(int i = 0 ; i < numRondas ; i++) {
                equipoCasa = i;
                equipoFuera = numeroEquipos-1+i;
                if (equipoFuera>numeroEquipos-1)	equipoFuera-=(numeroEquipos-1);
                for(int j = 0 ; j < numeroPartidosPorRonda ; j++) {
                    if (j==0)	jornadas[i][j] = crearPartido(listaEquipos[0], listaEquipos[equipoFuera], listaArbitros[j]);
                    else		jornadas[i][j] = crearPartido(listaEquipos[equipoCasa], listaEquipos[equipoFuera], listaArbitros[j]);

                    equipoCasa++;
                    equipoFuera--;
                    if (equipoCasa>numeroEquipos-1)	equipoCasa = 1;
                    if (equipoFuera<1)				equipoFuera = numeroEquipos-1;
                }
            }
            for(int i = 0 ; i < numRondas ; i++) {//esto es exactamente igual pero al reves, para que los que jugaron en casa lo hagan fuera y viceversa
                equipoCasa = i;
                equipoFuera = numeroEquipos-1+i;
                if (equipoFuera>numeroEquipos-1)	equipoFuera-=(numeroEquipos-1);
                for(int j = 0 ; j < numeroPartidosPorRonda ; j++) {
                    if (j==0){
                        jornadas[i+numRondas][j] = crearPartido(listaEquipos[equipoFuera], listaEquipos[0], listaArbitros[j]);
                    }
                    else		jornadas[i+numRondas][j] = crearPartido(listaEquipos[equipoFuera], listaEquipos[equipoCasa], listaArbitros[j]);

                    equipoCasa++;
                    equipoFuera--;
                    if (equipoCasa>numeroEquipos-1)	equipoCasa = 1;
                    if (equipoFuera<1)				equipoFuera = numeroEquipos-1;
                }
            }
        }else {//para nº equipos impar
            for(int i = 0 ; i < numRondas ; i++) {
                equipoCasa = i;
                equipoFuera = numeroEquipos-1-i;
                if (equipoCasa<0)	equipoCasa=numeroEquipos-1;
                if (equipoFuera<0)	equipoFuera=numeroEquipos-1;
                for(int j = 0 ; j < numeroPartidosPorRonda ; j++) {
                    jornadas[i][j] = crearPartido(listaEquipos[equipoCasa], listaEquipos[equipoFuera], listaArbitros[j]);
                }
            }
            for(int i = 0 ; i < numRondas ; i++) {//esto es exactamente igual pero al reves, para que los que jugaron en casa lo hagan fuera y viceversa
                equipoCasa = 0-i;
                equipoFuera = numeroEquipos-1-i;
                if (equipoCasa<0)	equipoCasa=numeroEquipos-1;
                if (equipoFuera<0)	equipoFuera=numeroEquipos-1;
                for(int j = 0 ; j < numeroPartidosPorRonda ; j++) {
                    jornadas[i+numRondas][j] = crearPartido(listaEquipos[equipoFuera], listaEquipos[equipoCasa], listaArbitros[j]);
                }
            }
        }
        for(int i = 0 ; i < numRondas*2 ; i++) {//Para imprimir
            System.out.println("Jornada "+ (i + 1));
            for (int j = 0 ; j < numeroPartidosPorRonda ; j++){
                System.out.println("Partido "+(j + 1));
                System.out.println(jornadas[i][j]);
            }
        }

        return jornadas;
    }

    public static void asignarPuntos() {

    }
}

