package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] _listaRecordatorios; 

    public ArregloRedimensionableDeRecordatorios() {
        _listaRecordatorios = new Recordatorio[0];
    }

    public int longitud() {
        return _listaRecordatorios.length;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] listaRecordatoriosAux = new Recordatorio[_listaRecordatorios.length + 1];

        for (int x = 0; x < _listaRecordatorios.length; x++) {
            listaRecordatoriosAux[x] = _listaRecordatorios[x];
        }
        listaRecordatoriosAux[_listaRecordatorios.length] = i;

        _listaRecordatorios = listaRecordatoriosAux;
    }

    public Recordatorio obtener(int i) {
        return _listaRecordatorios[i];
    }

    public void quitarAtras() {
        Recordatorio[] listaRecordatoriosAux = new Recordatorio[_listaRecordatorios.length - 1];

        for (int x = 0; x < _listaRecordatorios.length-1; x++) {
            listaRecordatoriosAux[x] = _listaRecordatorios[x];
        }

        _listaRecordatorios = listaRecordatoriosAux;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        Recordatorio[] listaRecordatoriosAux = new Recordatorio[_listaRecordatorios.length];

        for (int x = 0; x < _listaRecordatorios.length; x++) {
            if (x == indice) {
                listaRecordatoriosAux[x] = valor;
            } else {
                listaRecordatoriosAux[x] = _listaRecordatorios[x];
            }
        }

        _listaRecordatorios = listaRecordatoriosAux;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        // Implementar
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        // Implementar
        return null;
    }
}
