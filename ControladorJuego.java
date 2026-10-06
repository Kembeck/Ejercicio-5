import java.util.List;

public class ControladorJuego {
    private Tablero tablero;
    private VistaConsola vista;

    public ControladorJuego(Tablero tablero, VistaConsola vista) {
        this.tablero = tablero;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;

        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);
    }

    public void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                vista.mostrarPiezas(tablero.listarPiezas());
                break;

            case 2:
                int id = vista.leerEntero("ID de la pieza: ");
                vista.mostrarPieza(tablero.buscarPieza(id));
                break;

            case 3:
                String nombre = vista.leerTexto("Nombre de la pieza: ");
                List<Pieza> encontradas = tablero.buscarPieza(nombre);
                vista.mostrarPiezas(encontradas);
                break;

            case 4:
                vista.mostrarPiezas(tablero.ordenarPorEstabilidad());
                break;

            case 5:
                realizarInteraccion();
                break;

            case 0:
                vista.mostrarMensaje("Programa finalizado.");
                break;

            default:
                vista.mostrarMensaje("Opción no válida.");
        }
    }

    public void realizarInteraccion() {
        int idEstudiante = vista.leerEntero("ID del estudiante: ");
        int idDestino = vista.leerEntero("ID del lugar o catedrático: ");

        Pieza piezaEstudiante = tablero.buscarPieza(idEstudiante);
        Pieza destino = tablero.buscarPieza(idDestino);

        if (!(piezaEstudiante instanceof Estudiante)) {
            vista.mostrarMensaje(
                    "El primer ID no pertenece a un estudiante.");
            return;
        }

        Estudiante estudiante = (Estudiante) piezaEstudiante;

        if (estudiante.haPerdido()) {
            vista.mostrarMensaje(
                    "El estudiante ya perdió y no puede interactuar.");
            return;
        }

        try {
            if (destino instanceof LugarInteractivo) {
                LugarInteractivo lugar = (LugarInteractivo) destino;

                if (!lugar.estaDisponible()) {
                    vista.mostrarMensaje("El lugar está agotado.");
                    return;
                }

                lugar.interactuar(estudiante);

            } else if (destino instanceof Catedratico) {
                Catedratico catedratico = (Catedratico) destino;

                // Interacción por ID, sin comprobar distancia.
                catedratico.asignarProyecto(estudiante);

            } else {
                vista.mostrarMensaje(
                        "El segundo ID debe pertenecer a un lugar o catedrático.");
                return;
            }

            vista.mostrarPieza(estudiante);

            if (estudiante.haPerdido()) {
                vista.mostrarMensaje(
                        estudiante.getNombre() + " perdió.");
            }

        } catch (IllegalArgumentException | IllegalStateException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }
}