import model.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    //Inicializamos las probabilidades de Goles, una vez
    static int[] PROBABILIDADESGOLES = generadorProbabilidades();

    //TODO investigar porque static no funca
    public static void main(String[] args) {

        //TODO: Pasar a  una función. Posiblemente Liga
        //Crear lista de Equipos
        Equipo[] listaEquipos= new Equipo[5];
        for(int i = 0;i<5;i++) {
            listaEquipos[i] = crearEquipo("Juvenil");
        }

        //Testeo LIGA
        Liga liga1 = new  Liga();

        liga1.setArbitros();
        liga1.setNombre(Liga.generadorNombres());
        liga1.setEquipos(Liga.genararListaEquipos(Liga.numeroEquipos()));
        System.out.println (liga1.getNombre());
        System.out.println (Arrays.stream(liga1.getEquipos()).toList());

        System.out.println (Arrays.stream(liga1.getArbitros()).toList());

        Arbitro[] listaArbitro = crearListaArbitro();

        crearJornadas(listaEquipos, listaArbitro);


        //inicializa Equipos Puntos a 0.
        Map<Equipo, Integer> mapaEquiposPuntos = initMapaEquiposPuntos(listaEquipos);
        //printa el hashmapa
//        for (Equipo i : mapaEquiposPuntos.keySet()) {
//            System.out.println("Nombre Equipos: " + i.getNombre() + " Puntos: " + mapaEquiposPuntos.get(i));
//        }

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

    //TODO: Comprobar si luego se sigue usando.
    //Inicializa un Map<Equipo, Integer>, donde los Equipos vienen de una listaEquipos, y los Integer a 0.
    public static Map<Equipo, Integer> initMapaEquiposPuntos(Equipo[] listaEquipos) {
        Map<Equipo, Integer> mapaEquiposPuntos = new HashMap<Equipo, Integer>();
        for (int i = 0; i < listaEquipos.length; i++) {
            mapaEquiposPuntos.put(listaEquipos[i], 0);
        }
        return mapaEquiposPuntos;
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

    //TODO: Esto es un creacion de lista de arbitros provisional para probar el crear las jornadas
    public static Arbitro[] crearListaArbitro() {
        int numeroArbitros = 100;
        Arbitro[] listaArbitro = new Arbitro[100];
        for (int i = 0; i < 100; i++) {
            Arbitro arbitro = new Arbitro();
            listaArbitro[i] = arbitro;
        }

        return listaArbitro;
    }

    //Creamos el evento del partido, pero todavía no lo jugamos en este método
    public static Partido crearPartido(Equipo equipoCasa, Equipo equipoFuera, Arbitro arbitro) {
        Partido partido = new Partido(equipoCasa, equipoFuera, arbitro);

        //Generamos los golesEquipoCasa
        int golesEquipoCasa = generadorGoles();
        //Seteamos los goles del Equipo casa, al partido en la propiedad partido.golesEquipoCasa
        partido.setGolesEquipoCasa(golesEquipoCasa);
        //Seteamos los goles del Equipo casa, al equipo en la propiedad equipo.goles
        //TODO: Este último paso es redundante eliminar en el futuro.
        equipoCasa.setGoles(equipoCasa.getGoles() + golesEquipoCasa);

        //Se repite el mismo proceso con golesEquipoFuera.
        int golesEquipoFuera = generadorGoles();
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

    //TODO: Porque se crean 2 partidos por jornada? porque hay varios partidos 1, y 2.
    public static Partido[][] crearJornadas(Equipo[] listaEquipos, Arbitro[] listaArbitros) {
        int numeroEquipos = listaEquipos.length;

        int numeroPartidosEnTotal = (numeroEquipos * (numeroEquipos - 1)) / 2;
        int numeroRondas;
        int numeroPartidosPorRonda;
        int equipoCasa = 0;
        int equipoFuera = 0;

        if (numeroEquipos % 2 == 0) {
            numeroRondas = numeroEquipos - 1;
            numeroPartidosPorRonda = numeroEquipos / 2;
        } else {
            numeroRondas = numeroEquipos;
            numeroPartidosPorRonda = (numeroEquipos - 1) / 2;
        }

        Partido[][] listaJornadas;

        listaJornadas = new Partido[numeroRondas*2][numeroPartidosPorRonda];

        int x=0;
        int y=numeroEquipos-2;

        if(numeroEquipos%2==0) {//para los pares
        	for(int i = 0 ; i < numeroRondas ; i++) {
        		for(int j = 0 ; j < numeroPartidosPorRonda ; j++) {
        			if(j==0) {
        				if(i%2==0)  	listaJornadas[i][j] = crearPartido(listaEquipos[x],listaEquipos[(numeroEquipos-1)],listaArbitros[j]);
        				else 			listaJornadas[i][j] = crearPartido(listaEquipos[(numeroEquipos-1)],listaEquipos[x],listaArbitros[j]);
        				x++;
        			}else {
            			listaJornadas[i][j] = crearPartido(listaEquipos[x],listaEquipos[y],listaArbitros[j]);
        				x++;
            			y--;
        			}
        			if(x>(numeroEquipos-2))	x=0;
        			if(y<(0))				y=numeroEquipos-2;
        		}
        	}
        	for(int i = 0 ; i < numeroRondas ; i++) {//otra vez lo mismo pero con los datos cambiados para que los de casa sean fuera y viceversa
        		for(int j = 0 ; j < numeroPartidosPorRonda ; j++) {
        			if(j==0) {
        				if(i%2==0)  	listaJornadas[i+numeroRondas][j] = crearPartido(listaEquipos[(numeroEquipos-1)],listaEquipos[x],listaArbitros[j]);
        				else 			listaJornadas[i+numeroRondas][j] = crearPartido(listaEquipos[x],listaEquipos[(numeroEquipos-1)],listaArbitros[j]);
        				x++;
        			}else {
            			listaJornadas[i+numeroRondas][j] = crearPartido(listaEquipos[y],listaEquipos[x],listaArbitros[j]);
        				x++;
            			y--;
        			}
        			if(x>(numeroEquipos-2))	x=0;
        			if(y<(0))				y=numeroEquipos-2;
        		}
        	}

        }else {//para los impares
        	//para los impares hay que hacerlo como el numero par encima del impar, solo que saltandote la primera fila (j=0).
        	//asi que hay que todo lo que tenga que ver con numEquipos y numPartidosPorRonda se le suma uno.

        	y++;//esto es por lo que he puesto en la linea de arriba
        	for(int i = 0 ; i < numeroRondas ; i++) {
        		for(int j = 0 ; j < numeroPartidosPorRonda+1 ; j++) {
        			if(j==0)	 x++;//aunque nos lo saltemos la x hay que seguir sumandola en j = 0
        			else {
            			listaJornadas[i][j-1] = crearPartido(listaEquipos[x],listaEquipos[y],listaArbitros[j-1]);//la j-1 porque el 0 nos lo habiamos saltado
        				x++;
            			y--;
        			}
        			if(x>(numeroEquipos-1))	x=0;
        			if(y<(0))				y=numeroEquipos-1;
        		}
        	}
        	for(int i = 0 ; i < numeroRondas ; i++) {//otra vez lo mismo pero con los datos cambiados para que los de casa sean fuera y viceversa
        		for(int j = 0 ; j < numeroPartidosPorRonda+1 ; j++) {
        			if(j==0)	 x++;
        			else {
            			listaJornadas[i+numeroRondas][j-1] = crearPartido(listaEquipos[y],listaEquipos[x],listaArbitros[j-1]);
        				x++;
            			y--;
        			}
        			if(x>(numeroEquipos-1))	x=0;
        			if(y<(0))				y=numeroEquipos-1;
        		}
        	}
        }

        for(int i = 0 ; i < numeroRondas*2 ; i++) {//Para imprimir
            System.out.println("Jornada "+(i+1));
            for (int j = 0 ; j < numeroPartidosPorRonda ; j++) {
                System.out.println("Partido "+(j+1));
                System.out.println(listaJornadas[i][j]);
            }
        }
        System.out.println("En total hay "+numeroPartidosEnTotal+" partidos");

        //TODO: metodos provisionales toString()
        System.out.println("\n---CLASIFICACIÓN---");
        for (int i = 0; i < listaEquipos.length; i++) {
            System.out.println("Equipo: " + listaEquipos[i].getNombre());
            System.out.println("\tcon puntos: " + listaEquipos[i].getPuntos());
            System.out.println("\tcon número de goles: " + listaEquipos[i].getGoles() + "\n");
        }
        return listaJornadas;
    }
}
