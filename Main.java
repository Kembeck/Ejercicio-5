public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();

        tablero.agregarPieza(new Estudiante(1, "Kembeck", 1, 1, 75, 60));
        tablero.agregarPieza(new Estudiante(2, "Angel", 2, 1, 50, 40));
        tablero.agregarPieza(new Estudiante(3, "María", 3, 2, 90, 80));
        tablero.agregarPieza(new Estudiante(4, "Lulu", 4, 3, 35, 20));

        tablero.agregarPieza(new Catedratico(5, "Lic. López", 5, 5, 85, 2));
        tablero.agregarPieza(new Catedratico(6, "Ing. Nájera", 7, 3, 70, 3));

        tablero.agregarPieza(new LugarInteractivo(7, "Cafetera central", 2, 4,
                80, 5, 5, TipoLugar.MAQUINA_CAFE));
        tablero.agregarPieza(new LugarInteractivo(8, "Switch de la biblioteca", 6, 2,
                60, 5, 5, TipoLugar.SWITCH));
        tablero.agregarPieza(new LugarInteractivo(9, "Puesto de comida", 3, 6,
                95, 5, 5, TipoLugar.PUESTO_COMIDA));
        tablero.agregarPieza(new LugarInteractivo(10, "Mesa de biblioteca", 8, 4,
                55, 5, 5, TipoLugar.MESA_TRABAJO));

        VistaConsola vista = new VistaConsola();
        ControladorJuego controlador = new ControladorJuego(tablero, vista);
        controlador.iniciar();
    }
}
