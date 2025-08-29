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
        boolean res = s1.length() <= s2.length();

        int index = 0;


        while (res & index < s1.length() & index < s2.length()) {
            if (s1.charAt(index) == s2.charAt(index)) {
                index += 1;
            } else {
                res = false;
            }
        }

        return res;
    }

    String invertirString(String s1) {
        String res = "";
        int index = s1.length()-1;

        for (int i = index; i >= 0; i--) {
            res += s1.charAt(i);
        }

        return res;
    }

    boolean esSufijo(String s1, String s2) {
        boolean res = true;
        
        String auxS1 = invertirString(s1);
        String auxS2 = invertirString(s2);

        res = esPrefijo(auxS1, auxS2);

        return res;
    }

/***  Segunda parte: Debugging ***/

    boolean xor(boolean a, boolean b) {
        return (a || b) && !(a && b);
    }

    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;

        if (xs.length == ys.length) {
            for (int i = 0; i < xs.length; i++) {
                if (xs[i] != ys[i]) {
                    res = false;
                }
            }
        } else {
            res = false;
        }

        return res;
    }

    boolean ordenado(int[] xs) {
        boolean res = true;
        for (int i = 0; i < xs.length-1; i++) {
            if (xs[i] > xs [i+1]) {
                res = false;
            }
        }
        return res;
    }

    int maximo(int[] xs) {
        int res = xs[0];
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] > res) res = xs[i];
        }
        return res;
    }

    boolean todosPositivos(int[] xs) {
        boolean res = true;
        for (int x : xs) {
            if (x <= 0) {
                res = false;
            }
        }
        return res;
    }

}
