public class Estudiante extends Pieza {
    private int energia;

    public Estudiante(
            int id,
            String nombre,
            int x,
            int y,
            int estabilidad,
            int energia) {

        super(id, nombre, x, y, estabilidad);
        this.energia = Math.max(0, Math.min(100, energia));
    }

    @Override
    public void ejecutarTurno() {
        if (haPerdido()) {
            System.out.println(
                    getNombre() + " perdió y no puede ejecutar su turno.");
        } else {
            System.out.println(
                    getNombre() + " busca un recurso en el campus.");
        }
    }

    public void mover(int x, int y) {
        if (haPerdido()) {
            throw new IllegalStateException(
                    "El estudiante perdió y no puede moverse.");
        }

        setX(x);
        setY(y);
    }

    public void modificarEnergia(int cantidad) {
        aplicarEfecto(cantidad, 0);
    }

    public void aplicarEfecto(
            int cambioEnergia,
            int cambioEstabilidad) {

        if (haPerdido()) {
            throw new IllegalStateException(
                    "El estudiante ya perdió y no puede interactuar.");
        }

        energia = Math.max(
                0, Math.min(100, energia + cambioEnergia));

        int nuevaEstabilidad = Math.max(
                0, Math.min(100, getEstabilidad() + cambioEstabilidad));

        setEstabilidad(nuevaEstabilidad);
    }

    public boolean haPerdido() {
        return energia == 0 || getEstabilidad() == 100;
    }

    public int getEnergia() {
        return energia;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", energía: " + energia
                + ", perdió: " + (haPerdido() ? "sí" : "no");
    }
}
