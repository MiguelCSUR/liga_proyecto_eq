package model;

import java.util.Scanner;

//TODO: parece que no se esta usando, plantear borrarlo
public class CalcularRondas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el número de equipos: ");
        int numEquipos=sc.nextInt();

        int numEncuentros=(numEquipos*(numEquipos-1))/2;
        int numRondas;
        int numPartidosSimultaneos;
        int equipo = 0;

        if(numEquipos>1) {
            if (numEquipos%2==0) {
                numRondas = numEquipos-1;
                numPartidosSimultaneos = numEquipos/2;
            }else {
                numRondas = numEquipos;
                numPartidosSimultaneos = (numEquipos-1)/2;
            }
            int [][][] rondas;
            rondas = new int [numRondas][numPartidosSimultaneos][2];
            if(numEquipos%2==0) {
                equipo = 2;
                for(int i = 0 ; i < numRondas ; i++) {
                    rondas[i][0][0]=1;
                    for(int j = 1 ; j < numPartidosSimultaneos ; j++) {
                        rondas[i][j][0]=equipo;
                        equipo++;
                        if (equipo>numEquipos)	equipo=2;
                    }
                    for(int j = numPartidosSimultaneos-1 ; j >= 0 ; j--) {
                        rondas[i][j][1]=equipo;
                        equipo++;
                        if (equipo>numEquipos)	equipo=2;
                    }
                    equipo++;
                    if (equipo>numEquipos)	equipo=2;
                }
            }else {
                equipo = 1;
                for(int i = 0 ; i < numRondas ; i++) {
                    for(int j = 0 ; j < numPartidosSimultaneos ; j++) {
                        rondas[i][j][0]=equipo;
                        equipo++;
                        if (equipo>numEquipos)	equipo=1;
                    }
                    for(int j = numPartidosSimultaneos-1 ; j >= 0 ; j--) {
                        rondas[i][j][1]=equipo;
                        equipo++;
                        if (equipo>numEquipos)	equipo=1;
                    }
                }
            }
            imprimirRondas(rondas, numRondas, numPartidosSimultaneos, numEncuentros);
        }else {
            System.out.println("Se necesitan mas de un equipo para una liga. No se puede hacer solo"+numEquipos);
        }
    }

    public static void imprimirRondas(int [][][] rondas, int numRondas, int numPartidosSimultaneos, int numEncuentros) {
        for(int i = 0 ; i < numRondas ; i++) {
            System.out.println("Ronda "+(i+1));
            for(int j = 0 ; j < numPartidosSimultaneos ; j++) {
                System.out.println("  Partido "+(j+1)+". Equipo "+rondas[i][j][0]+" vs Equipo "+rondas[i][j][1]);
            }
        }
        System.out.println("Número total de partidos: "+numEncuentros);
    }
}
