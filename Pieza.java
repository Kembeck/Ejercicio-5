import java.util.Objects;

public class Pieza implements Comparable<Pieza> {
    private final int id;
    private String nombre;
    private int x;
    private int y;
    private int estabilidad;

    public Pieza(
            int id,
            String nombre,
            int x,
            int y,
            int estabilidad) {

        this.id = id;
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        setEstabilidad(estabilidad);
    }

    public void ejecutarTurno() {
        System.out.println(nombre + " permanece en su posición.");
    }

    @Override
    public int compareTo(Pieza otra) {
        return Integer.compare(this.estabilidad, otra.estabilidad);
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", nombre: " + nombre
                + ", posición: (" + x + ", " + y + ")"
                + ", estabilidad: " + estabilidad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Pieza)) {
            return false;
        }

        Pieza otra = (Pieza) obj;
        return this.id == otra.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getEstabilidad() {
        return estabilidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setEstabilidad(int estabilidad) {
        this.estabilidad = Math.max(0, Math.min(100, estabilidad));
    }
}