package aed;

public class Horario {
    private int _hora;
    private int _minutos;

    public Horario(int hora, int minutos) {
        _hora = hora;
        _minutos = minutos;
    }

    public int hora() {
        return _hora;
    }

    public int minutos() {
        return _minutos;
    }

    @Override
    public String toString() {
        return Integer.toString(_hora) + ":" + Integer.toString(_minutos);
    }

    @Override
    public boolean equals(Object otro) {
        Horario otroHorario = null;

        boolean otroNull = otro == null;

        if (otroNull) {
            return false;
        }

        boolean mismaClase = this.getClass() == otro.getClass();

        if (mismaClase) {
            otroHorario = (Horario) otro;
        } else {
            return false;
        }

        return this.toString().equals(otroHorario.toString());
    }

}
