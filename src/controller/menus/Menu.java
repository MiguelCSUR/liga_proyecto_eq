package controller.menus;

public class Menu {
    public static void comprobarResolución() {
        System.out.println("───────────────────────────────────────────────────────");
        System.out.println("Por favor, estire la ventana hasta que se vea la linea");
        System.out.println("completa en una sola linea para que se vea el programa");
        System.out.println("correctamente. Gracias");
    }
    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
