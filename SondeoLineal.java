public class SondeoLineal extends TablaHash {

    public SondeoLineal(int tamaño) {
        super(tamaño);
    }

    @Override
    protected int sondeoLineal(int clave) {
        int hash = funcionHash(clave);
        int indice = hash;
        while (tabla[indice] != -1) {
            indice = (indice + 1) % tabla.length;
        }
        return indice;
    }
}
