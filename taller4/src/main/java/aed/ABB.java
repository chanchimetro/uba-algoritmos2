package aed;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> {
    private Nodo _raiz;


    private class Nodo {
        T _valor;
        Nodo _der;
        Nodo _izq;
        Nodo _padre;

        Nodo (T valor) {
            _valor = valor;
            _der = null;
            _izq = null;
            _padre = null;
        }
    }

    public ABB() {
        _raiz = null;
    }

    public int cardinal() {
        int cardinal = 0;
        Nodo actual = _raiz;
        
        if (actual != null) {
            cardinal++;
            if (actual._der != null) {
                cardinal += cardinalRecursivo(actual._der);
            }
            if (actual._izq != null) {
                cardinal += cardinalRecursivo(actual._izq);
            }
        }

        return cardinal;
    }

    private int cardinalRecursivo(Nodo actual){
        int ret = 0;

        if (actual != null) {
            ret++;
            if (actual._der != null) {
                ret += cardinalRecursivo(actual._der);
            }
            if (actual._izq != null) {
                ret += cardinalRecursivo(actual._izq);
            }
        }

        return ret;
    }

    public T minimo(){
        Nodo actual = _raiz;
        T min = actual._valor;

        while (actual._izq != null) {
            actual = actual._izq; 
            min = actual._valor;
        }

        return min;
    }

    public T maximo(){
        Nodo actual = _raiz;
        T max = actual._valor;

        while (actual._der != null) {
            actual = actual._der; 
            max = actual._valor;
        }

        return max;
    }

    public void insertar(T elem){
        Nodo actual = _raiz;
        Nodo padreActual = null;
        Nodo nuevo = new Nodo(elem);

        while (actual != null) {
           if (elem.compareTo(actual._valor) > 0) {
            padreActual = actual;
            actual = actual._der;
           } else {
            padreActual = actual;
            actual = actual._izq;
           }
        }

        if (actual == _raiz) {
            _raiz = nuevo;
        } else {
            actual = nuevo;
            actual._padre = padreActual;
            if (elem.compareTo(padreActual._valor) > 0) {
                padreActual._der = nuevo;
            } else {
                padreActual._izq = nuevo;
            }
        }
    }

    public boolean pertenece(T elem){
        boolean pertenece = false;
        Nodo actual = _raiz;

        if (actual != null) {
            if (actual._valor == elem) {
                pertenece = true;
            } else {
                if (elem.compareTo(actual._valor) > 0) {
                    pertenece = perteneceRecursivo(actual._der, elem);
                } else {
                    pertenece = perteneceRecursivo(actual._izq, elem);
                }
            }
        }

        return pertenece;
    }

    private boolean perteneceRecursivo(Nodo actual, T elem) {
        boolean ret = false;

        if (actual != null) {
            if (actual._valor == elem) {
                ret = true;
            } else {
                if (elem.compareTo(actual._valor) > 0) {
                    ret = perteneceRecursivo(actual._der, elem);
                } else {
                    ret = perteneceRecursivo(actual._izq, elem);
                }
            }
        }

        return ret;
    }

    public void eliminar(T elem){
        Nodo actual = _raiz;

        //Encuentro el nodo que quiero eliminar.
        while(actual._valor != elem) {
            if (elem.compareTo(actual._valor) > 0) {
                actual = actual._der;
            } else {
                actual = actual._izq;
            }
        }

        //separo en casos!
        if(actual._der == null && actual._izq == null) {
            if (actual._padre != null) {
                actual._padre = null;
            }
            actual = null;
        } else if (actual._der != null && actual._izq == null) {
            if (actual._padre != null) {
                actual._padre._der = actual._der;
            }
            actual = actual._der;
        } else if (actual._izq != null && actual._der == null) {
            if (actual._padre != null) {
                actual._padre._izq = actual._izq;
            }
            actual = actual._izq;
        } else {
            T pred = predecesorInmediato(actual);
            eliminar(pred);
            if (actual._padre != null) {
                if (elem.compareTo(actual._padre._valor) > 0) {
                    actual._padre._der._valor = pred;
                } else {
                    actual._padre._izq._valor = pred;
                }
            }
            actual._valor = pred;
        }
    }

    private T predecesorInmediato(Nodo actual) {
        Nodo predecesor = actual._der;
        while (predecesor._izq != null) {
            predecesor = predecesor._izq;
        }

        return predecesor._valor;
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public class ABB_Iterador {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public ABB_Iterador iterador() {
        return new ABB_Iterador();
    }

}
