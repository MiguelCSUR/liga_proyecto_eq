

import java.util.Scanner;

public class Main {

    //Inicializamos las probabilidades de Goles, una vez
    static int[] PROBABILIDADESGOLES = generadorProbabilidades();

    //TODO investigar porque static no funca
    public static void main(String[] args) {

        //Crear lista de Equipos
        Equipo[] listaEquipos= new Equipo[5];
        for(int i = 0;i<5;i++) {
            listaEquipos[i] = crearEquipo("Juvenil");
        }
        Arbitro[] listaArbitro = crearListaArbitro();

        crearJornadas(listaEquipos,listaArbitro);

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
    public static void comprobarGanador(Partido partido) {
        if (partido.getGolesEquipoCasa() == partido.getGolesEquipoFuera()) {
            System.out.printf("\n%s y %s han quedado en empate", partido.getEquipoCasa().getNombre(),
                    partido.getEquipoFuera().getNombre());
        } else if (partido.getGolesEquipoCasa() > partido.getGolesEquipoFuera()) {
            System.out.printf("\n%s han ganado a %s", partido.getEquipoCasa().getNombre(),
                    partido.getEquipoFuera().getNombre());
        } else {
            System.out.printf("\n%s han ganado a %s", partido.getEquipoFuera().getNombre(),
                    partido.getEquipoCasa().getNombre());
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
    public static Partido crearPartido(Equipo eq1,Equipo eq2,Arbitro arbitro) {
        Equipo equipoCasa = eq1;
        Equipo equipoFuera = eq2;
        Partido partido = new Partido(eq1, eq2, arbitro);

        partido.setGolesEquipoCasa(generadorGoles());
        partido.setGolesEquipoFuera(generadorGoles());

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

        Partido[][] jornadas;
        jornadas = new Partido[numeroRondas*2][numeroPartidosPorRonda];

        int x=0;
        int y=numeroEquipos-2;
        
        if(numeroEquipos%2==0) {//para los pares
        	for(int i = 0 ; i < numeroRondas ; i++) {
        		for(int j = 0 ; j < numeroPartidosPorRonda ; j++) {
        			if(j==0) {
        				if(i%2==0)  	jornadas[i][j] = crearPartido(listaEquipos[x],listaEquipos[(numeroEquipos-1)],listaArbitros[j]);
        				else 			jornadas[i][j] = crearPartido(listaEquipos[(numeroEquipos-1)],listaEquipos[x],listaArbitros[j]);
        				x++;
        			}else {
            			jornadas[i][j] = crearPartido(listaEquipos[x],listaEquipos[y],listaArbitros[j]);
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
        				if(i%2==0)  	jornadas[i+numeroRondas][j] = crearPartido(listaEquipos[(numeroEquipos-1)],listaEquipos[x],listaArbitros[j]);
        				else 			jornadas[i+numeroRondas][j] = crearPartido(listaEquipos[x],listaEquipos[(numeroEquipos-1)],listaArbitros[j]);
        				x++;
        			}else {
            			jornadas[i+numeroRondas][j] = crearPartido(listaEquipos[y],listaEquipos[x],listaArbitros[j]);
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
            			jornadas[i][j-1] = crearPartido(listaEquipos[x],listaEquipos[y],listaArbitros[j-1]);//la j-1 porque el 0 nos lo habiamos saltado
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
            			jornadas[i+numeroRondas][j-1] = crearPartido(listaEquipos[y],listaEquipos[x],listaArbitros[j-1]);
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
            for (int j = 0 ; j < numeroPartidosPorRonda ; j++){
                System.out.println("Partido "+(j+1));
                System.out.println(jornadas[i][j]);
            }
        }
        System.out.println("En total hay "+numeroPartidosEnTotal+" partidos");

        return jornadas;
    }


}
