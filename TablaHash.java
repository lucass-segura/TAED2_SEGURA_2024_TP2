import java.util.Arrays;

public class TablaHash {
    protected int[] tabla;

    public TablaHash(int tamaño) {
        tabla = new int[tamaño];
        Arrays.fill(tabla, -1); // Usamos -1 para indicar celdas vacías
    }

    protected int funcionHash(int clave) {
        return clave % 10;
    }

    public void insertar(int clave, String metodo) {
        int indice = 0;
        switch (metodo) {
            case "lineal":
                indice = sondeoLineal(clave);
                break;
            case "cuadratico":
                indice = sondeoCuadratico(clave);
                break;
        }
        tabla[indice] = clave;
    }

    public boolean buscar(int clave, String metodo) {
        int hash = funcionHash(clave);
        int indice = hash;
        switch (metodo) {
            case "lineal":
                while (tabla[indice] != -1) {
                    if (tabla[indice] == clave) {
                        return true;
                    }
                    indice = (indice + 1) % tabla.length;
                }
                break;
            case "cuadratico":
                int i = 1;
                while (tabla[indice] != -1) {
                    if (tabla[indice] == clave) {
                        return true;
                    }
                    indice = (hash + i * i) % tabla.length;
                    i++;
                }
                break;
        }
        return false;
    }

    public void eliminar(int clave, String metodo) {
        int hash = funcionHash(clave);
        int indice = hash;
        switch (metodo) {
            case "lineal":
                while (tabla[indice] != -1) {
                    if (tabla[indice] == clave) {
                        tabla[indice] = -1;
                        return;
                    }
                    indice = (indice + 1) % tabla.length;
                }
                break;
            case "cuadratico":
                int i = 1;
                while (tabla[indice] != -1) {
                    if (tabla[indice] == clave) {
                        tabla[indice] = -1;
                        return;
                    }
                    indice = (hash + i * i) % tabla.length;
                    i++;
                }
                break;
        }
    }

    protected int sondeoLineal(int clave) {
        int hash = funcionHash(clave);
        int indice = hash;
        while (tabla[indice] != -1) {
            indice = (indice + 1) % tabla.length;
        }
        return indice;
    }

    protected int sondeoCuadratico(int clave) {
        int hash = funcionHash(clave);
        int indice = hash;
        int i = 1;
        while (tabla[indice] != -1) {
            indice = (hash + i * i) % tabla.length;
            i++;
        }
        return indice;
    }
}
