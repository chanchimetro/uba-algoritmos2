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
        if (!pertenece(elem)) {
            if (_raiz == null) {
                _raiz = new Nodo(elem);
                return;
            }
            
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

            nuevo._padre = padreActual;
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
            if (elem.compareTo(actual._valor) == 0) {
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
            if (elem.compareTo(actual._valor) == 0) {
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

        while(elem.compareTo(actual._valor) != 0) {
            if (elem.compareTo(actual._valor) > 0) {
                actual = actual._der;
            } else {
                actual = actual._izq;
            }
        }

        if(actual._der == null && actual._izq == null) {
            if (actual._padre != null) {
                if (actual._valor.compareTo(actual._padre._valor) > 0) {
                    actual._padre._der = null;
                } else {
                    actual._padre._izq = null;
                }
            } else {
                _raiz = null;
            }
        } else if (actual._der != null && actual._izq == null) {
            if (actual._padre != null) {
                if (actual._valor.compareTo(actual._padre._valor) > 0) {
                    actual._padre._der = actual._der;
                } else {
                    actual._padre._izq = actual._der;
                }
                actual._der._padre = actual._padre;
            } else {
                _raiz = actual._der;
                _raiz._padre = null;
            }
        } else if (actual._izq != null && actual._der == null) {
            if (actual._padre != null) {
                if (actual._valor.compareTo(actual._padre._valor) > 0) {
                    actual._padre._der = actual._izq;
                } else {
                    actual._padre._izq = actual._izq;
                }
                actual._izq._padre = actual._padre;
            } else {
                _raiz = actual._izq;
                _raiz._padre = null;
            }
        } else {
            Nodo suc = sucesorInmediato(actual);
            eliminar(suc._valor);
            actual._valor = suc._valor;
        }
    }

    private Nodo sucesorInmediato(Nodo actual) {
        Nodo sucesor = actual._der;
        while (sucesor._izq != null) {
            sucesor = sucesor._izq;
        }

        return sucesor;
    }

    public String toString(){
        String str = "";
        ABB_Iterador iterador = new ABB_Iterador();

        if (cardinal() > 0) {
            while (iterador.haySiguiente()) {
                str += iterador.siguiente().toString();
                if (iterador.haySiguiente()) {
                    str += ",";
                }
            }
        }

        return "{"+str+"}";
    }

    public class ABB_Iterador {
        private Nodo _actual;

        public boolean haySiguiente() {            
            return (cardinal() > 0 && _actual == null) || _actual._valor.compareTo(maximo()) != 0;
        }
    
        public T siguiente() {
            if (_actual == null) {
                _actual = new Nodo(_raiz._valor);
                _actual._der = _raiz;
            }

            if (_actual._der != null) {
                _actual = sucesorInmediato(_actual);
            } else {
                Nodo auxNodo = _actual._padre;
                
                while(_actual._valor.compareTo(auxNodo._valor) > 0) {
                    auxNodo = auxNodo._padre;
                }

                _actual = auxNodo;
            }

            return _actual._valor;
        }
    }

    public ABB_Iterador iterador() {
        return new ABB_Iterador();
    }

}
