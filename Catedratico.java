public class Catedratico extends Pieza {
    private int radioEfecto;

    public Catedratico(
            int id,
            String nombre,
            int x,
            int y,
            int estabilidad,
            int radioEfecto) {

        super(id, nombre, x, y, estabilidad);
        setRadioEfecto(radioEfecto);
    }

    @Override
    public void ejecutarTurno() {
    }

    public void asignarProyecto(Estudiante estudiante) {
        if (estudiante == null) {
            throw new IllegalArgumentException(
                    "Debe seleccionar un estudiante.");
        }

        if (estudiante.haPerdido()) {
            throw new IllegalStateException(
                    "El estudiante ya perdió y no puede interactuar.");
        }

        estudiante.aplicarEfecto(-30, 15);
    }

    public int getRadioEfecto() {
        return radioEfecto;
    }

    public void setRadioEfecto(int radioEfecto) {
        if (radioEfecto < 0) {
            throw new IllegalArgumentException(
                    "El radio de efecto no puede ser negativo.");
        }

        this.radioEfecto = radioEfecto;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", radio de efecto: " + radioEfecto;
    }
}