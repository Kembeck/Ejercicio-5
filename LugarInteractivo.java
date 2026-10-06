public class LugarInteractivo extends RecursoObstaculo {
    private TipoLugar tipo;

    public LugarInteractivo(
            int id,
            String nombre,
            int x,
            int y,
            int estabilidad,
            int durabilidad,
            int usosDisponibles,
            TipoLugar tipo) {

        super(id, nombre, x, y, estabilidad,
                durabilidad, usosDisponibles);

        setTipo(tipo);
    }

    public void interactuar(Estudiante estudiante) {
        if (estudiante == null) {
            throw new IllegalArgumentException(
                    "Debe seleccionar un estudiante.");
        }

        if (estudiante.haPerdido()) {
            throw new IllegalStateException(
                    "El estudiante perdió y no puede usar recursos.");
        }

        if (!estaDisponible()) {
            throw new IllegalStateException(
                    getNombre() + " ya no está disponible.");
        }

        int cambioEnergia;
        int cambioEstabilidad;

        switch (tipo) {
            case MAQUINA_CAFE:
                cambioEnergia = 20;
                cambioEstabilidad = -5;
                break;

            case SWITCH:
                cambioEnergia = -10;
                cambioEstabilidad = -10;
                break;

            case PUESTO_COMIDA:
                cambioEnergia = 30;
                cambioEstabilidad = -15;
                break;

            case MESA_TRABAJO:
                cambioEnergia = -10;
                cambioEstabilidad = 10;
                break;

            default:
                throw new IllegalArgumentException(
                        "Tipo de lugar no válido.");
        }

        estudiante.aplicarEfecto(
                cambioEnergia, cambioEstabilidad);

        consumirUso();
    }

    public TipoLugar getTipo() {
        return tipo;
    }

    public void setTipo(TipoLugar tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException(
                    "El tipo de lugar no puede ser nulo.");
        }

        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + ", tipo: " + tipo;
    }
}