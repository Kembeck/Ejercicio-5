public class RecursoObstaculo extends Pieza {
    private int durabilidad;
    private int usosDisponibles;

    public RecursoObstaculo(int id, String nombre, int x, int y, int estabilidad, int durabilidad, int usosDisponibles) {
        super(id, nombre, x, y, estabilidad);
        this.durabilidad = durabilidad;
        this.usosDisponibles = Math.max(0, usosDisponibles);
    }

    @Override
    public void ejecutarTurno() {
        System.out.println(getNombre() + " tiene " + usosDisponibles
 + " usos disponibles.");
    }

    public boolean estaDisponible() {
        return durabilidad > 0 && usosDisponibles > 0;
    }

    public void consumirUso() {
        if (usosDisponibles > 0) {
            usosDisponibles--;
        }
        if (durabilidad > 0) {
            durabilidad--;
        }
    }

    public int getDurabilidad() {
        return durabilidad;
    }

    public int getUsosDisponibles() {
        return usosDisponibles;
    }

    public void setDurabilidad(int durabilidad) {
        this.durabilidad = Math.max(0, durabilidad);
    }

    public void setUsosDisponibles(int usosDisponibles) {
        this.usosDisponibles = Math.max(0, usosDisponibles);
    }

    @Override
    public String toString() {
        return super.toString()
                + ", durabilidad: " + durabilidad
                + ", usos disponibles: " + usosDisponibles;
    }
}
