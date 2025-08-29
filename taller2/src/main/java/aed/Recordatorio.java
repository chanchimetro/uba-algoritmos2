package aed;

public class Recordatorio {
    private String _mensaje;
    private Fecha _fecha;
    private Horario _horario;


    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        _mensaje = mensaje;
        _fecha = new Fecha(fecha);
        _horario = horario;
    }

    public Horario horario() {
        return _horario;
    }

    public Fecha fecha() {
        return new Fecha(_fecha);
    }

    public String mensaje() {
        return _mensaje;
    }

    @Override
    public String toString() {
        return _mensaje + " @ " + _fecha.toString() + " " + _horario.toString();
    }

    @Override
    public boolean equals(Object otro) {
        Recordatorio otroRecordatorio = null;

        boolean otroNull = otro == null;

        if (otroNull) {
            return false;
        }

        boolean mismaClase = this.getClass() == otro.getClass();

        if (mismaClase) {
            otroRecordatorio = (Recordatorio) otro;
        } else {
            return false;
        }

        return this.toString().equals(otroRecordatorio.toString());
    }

}
