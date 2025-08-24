package aed;

class Funciones {

/***  Primera parte: Funciones en java ***/

    int cuadrado(int x) {
        int res = x*x; 
        return res;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt(x*x+y*y);
        return res;
    }

    boolean esPar(int n) {
        return n%2 == 0;
    }

    boolean esBisiesto(int n) {
        return (n%4 == 0 & n%100 != 0) || n%400 == 0;
    }

    int factorialIterativo(int n) {
        int res = 1;

        for (int i = 1; i <= n; i++) {
            res = res * i;
        }

        return res;
    }

    int factorialRecursivo(int n) {
        int res = n;

        if (res == 0) {
            res = 1;
        } else {
            res = res * factorialRecursivo(n-1);
        }

        return res;
    }

    boolean esPrimo(int n) {
        int contador = 0;

        for (int i = 1; i <= n; i++) {
            if (n%i == 0) {
                contador++;
            }
        }

        return contador <= 2 & n!=0 & n!=1;
    }

    int sumatoria(int[] numeros) {
        int res = 0;

        for (int i = 0; i < numeros.length; i++) {
            res += numeros[i];
        }

        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int index = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                index = i;
            }
        }

        return index;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res = false;
        
        for (int i = 0; i < numeros.length; i++) {
            if (esPrimo(numeros[i])) {
                res = true;
            }
        }

        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;

        for (int i = 0; i < numeros.length; i++) {
            if (!esPar(numeros[i])) {
                res = false;
            }
        }

        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean res = true;

        if (s1.length() <= s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    res = false;
                }
            }
        } else {
            res = false;
        }

        return res;
    }

    boolean esSufijo(String s1, String s2) {
        boolean res = true;
        
        int s1index = s1.length()-1;
        int s2index = s2.length()-1;

        if (s1.length() <= s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    res = false;
                }
            }
        } else {
            res = false;
        }

        return res;
    }

/***  Segunda parte: Debugging ***/

    boolean xor(boolean a, boolean b) {
        return a || b && !(a && b);
    }

    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;

        for (int i = 0; i < xs.length; i++) {
            if (xs[i] != ys[i]) {
                res = false;
            }
        }
        return res;
    }

    boolean ordenado(int[] xs) {
        boolean res = true;
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] > xs [i+1]) {
                res = false;
            }
        }
        return res;
    }

    int maximo(int[] xs) {
        int res = 0;
        for (int i = 0; i <= xs.length; i++) {
            if (xs[i] > res) res = i;
        }
        return res;
    }

    boolean todosPositivos(int[] xs) {
        boolean res = false;
        for (int x : xs) {
            if (x > 0) {
                res = true;
            } else {
                res = false;
            }
        }
        return res;
    }

}
