import java.util.LinkedList;

public class HashAbierto {
    private LinkedList<Integer>[] tabla;

    @SuppressWarnings("unchecked")
    public HashAbierto(int tamaño) {
        tabla = new LinkedList[tamaño];
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    private int funcionHash(int clave) {
        return clave % 10;
    }

    public void insertar(int clave) {
        int hash = funcionHash(clave);
        tabla[hash].add(clave);
    }

    public boolean buscar(int clave) {
        int hash = funcionHash(clave);
        return tabla[hash].contains(clave);
    }

    public void eliminar(int clave) {
        int hash = funcionHash(clave);
        tabla[hash].remove(Integer.valueOf(clave));
    }
}
