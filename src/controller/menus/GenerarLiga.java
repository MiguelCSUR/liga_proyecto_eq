package controller.menus;

import controller.Invocador;
import model.*;

import java.util.Scanner;

public class GenerarLiga {
    public static void iniciarImprimirMenuLiga() {
        Menu.limpiarPantalla();
        Liga liga = new Liga();
        imprimirMenu(liga);
    }

    public static void imprimirMenu(Liga liga) {
        Scanner sc = new Scanner(System.in);
        if (liga.getNombre() == null) {
            System.out.println(" 1. Nombre ");
        } else {
            System.out.println(" 1. Nombre - " +"\033[0;1m" +liga.getNombre()+"\033[0;0m");
        }
        if (liga.getCategoria() == null) {
            System.out.println(" 2. Categoría ");
        } else {
            System.out.println(" 2. Categoría - " +"\033[0;1m"+ liga.getCategoria()+"\033[0;0m");
        }
        if (liga.getListaEquipos() == null) {
            System.out.println(" 3. Numero de Equipos ");
        } else {
            //Todo Necesitas un numero de equipos y categoria para crear los equipos
            System.out.println(" 3. Numero de Equipos - " +"\033[0;1m"+ liga.getListaEquipos().length+"\033[0;0m");
        }
        if (liga.getFechaInicio() == null) {
            System.out.println(" 4. Fecha Inicio ");
        } else {
            System.out.println(" 4. Fecha Inicio - " +"\033[0;1m"+ Invocador.dateToString(liga.getFechaInicio())+"\033[0;0m");
        }
        System.out.println(" 5. Crear Liga ");
        System.out.println(" Si falta por rellenar algun campo este se generara de modo aleatorio");
        System.out.println();
        System.out.println("Elige una opción:");
        elegirOpcion(sc.nextInt(), liga);
        Invocador.generarEspacio();
        imprimirMenu(liga);
    }

    public static void elegirOpcion(int opcion, Liga liga) {
        Scanner sc = new Scanner(System.in);
        switch (opcion) {
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
                if (liga.getListaEquipos() == null) {
                    liga.setListaEquipos(Invocador.crearListaEquipos(Invocador.generarNumeroEquipos(), liga.getCategoria()));
                } else
                    liga.setListaEquipos(Invocador.crearListaEquipos(liga.getListaEquipos().length, liga.getCategoria()));
                break;
            case 3:

                if (liga.getCategoria() == null) {
                    System.out.println("Hay que elegir una categoria primero");
                    elegirOpcion(2, liga);
                }

                System.out.println("Cuantos equipos deseas tener: ");
                liga.setListaEquipos(Invocador.crearListaEquipos(sc.nextInt(), liga.getCategoria()));
                break;
            case 4:
                //fecha inic
                System.out.println("Que dia quieres que comience: ");
                int dia = sc.nextInt();
                String diaString;
                while (dia < 1 || dia > 31) {
                    System.out.println("Introduzca una fecha correcta");
                    dia = sc.nextInt();
                }
                if (dia > 0 && dia < 10) {
                    diaString = "0" + dia;
                } else diaString = "" + dia;
                System.out.println("Que mes quieres que comience: ");
                int mes = sc.nextInt();
                String mesString;
                while (mes < 1 || mes > 12) {
                    System.out.println("Introduzca un mes correcto");
                    mes = sc.nextInt();
                }
                if (mes > 0 && mes < 10) {
                    mesString = "0" + mes;
                } else mesString = "" + mes;
                System.out.println("Que dia quieres que comience: ");
                int ano = sc.nextInt();
                String anoString;
                while (ano <= 0 || ano > 10000) {
                    System.out.println("Introduzca un año correcto");
                    ano = sc.nextInt();
                }
                if (ano > 0 && ano < 10) anoString = "000" + ano;
                else if (ano >= 10 && ano < 100) anoString = "00" + ano;
                else if (ano >= 100 && ano < 1000) anoString = "0" + ano;
                else anoString = "" + ano;
                String fechaJunta = diaString + "-" + mesString + "-" + anoString;
                liga.setFechaInicio(Invocador.stringToDate(fechaJunta));
                break;
            case 5:
                //crear liga
                if(liga.getNombre()==null){
                    liga.setNombre(Invocador.generarNombresLiga());
                }
                if(liga.getListaEquipos()==null){
                    if(liga.getCategoria()==null){
                        int numero = (int) Math.floor(Math.random()*7)+1;
                        liga.setCategoria(elegirCategoria(numero));
                    }
                    liga.setListaEquipos(Invocador.crearListaEquipos(Invocador.generarNumeroEquipos(),liga.getCategoria()));
                }
                if(liga.getFechaInicio()==null){
                    liga.setFechaInicio(Invocador.generarFechaInicio());
                }
                liga.setListaArbitros(Invocador.crearListaArbitros(liga.getListaEquipos().length));
                liga.setCalendario(Invocador.crearCalendario(liga));
                MostrarLiga.iniciarMenu(liga);
                break;
            default:
                System.out.println("ERROR. Opción introducida incorrecta");
                break;
        }
    }

    public static String elegirCategoria(int opcion) {
        switch (opcion) {
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
