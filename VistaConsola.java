import java.util.List;
import java.util.Scanner;

public class VistaConsola {
    private Scanner scanner;

    public VistaConsola() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n=== SEMANA DE PARCIALES ===");
        System.out.println("1. Listar piezas");
        System.out.println("2. Buscar pieza por ID");
        System.out.println("3. Buscar pieza por nombre");
        System.out.println("4. Ordenar por estabilidad");
        System.out.println("5. Interactuar con un lugar");
        System.out.println("0. Salir");
    }

    public int leerOpcion() {
        return leerEntero("Seleccione una opción: ");
    }

    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException error) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarPiezas(List<Pieza> piezas) {
        if (piezas.isEmpty()) {
            mostrarMensaje("No se encontraron piezas.");
            return;
        }

        for (Pieza pieza : piezas) {
            System.out.println(pieza);
        }
    }

    public void mostrarPieza(Pieza pieza) {
        if (pieza == null) {
            mostrarMensaje("No se encontró la pieza.");
        } else {
            System.out.println(pieza);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
