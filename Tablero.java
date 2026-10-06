import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tablero {
    private ArrayList<Pieza> piezas;

    public Tablero() {
        piezas = new ArrayList<Pieza>();
    }

    public void agregarPieza(Pieza pieza) {
        if (!piezas.contains(pieza)) {
            piezas.add(pieza);
        }
    }

    public List<Pieza> listarPiezas() {
        return new ArrayList<Pieza>(piezas);
    }

    public Pieza buscarPieza(int id) {
        for (Pieza pieza : piezas) {
            if (pieza.getId() == id) {
                return pieza;
            }
        }
        return null;
    }

    public List<Pieza> buscarPieza(String nombre) {
        ArrayList<Pieza> encontradas = new ArrayList<Pieza>();

        for (Pieza pieza : piezas) {
            if (pieza.getNombre().equalsIgnoreCase(nombre)) {
                encontradas.add(pieza);
            }
        }
        return encontradas;
    }

    public List<Pieza> ordenarPorEstabilidad() {
        ArrayList<Pieza> ordenadas = new ArrayList<Pieza>(piezas);
        Collections.sort(ordenadas);
        return ordenadas;
    }
}
