public class SondeoCuadratico extends TablaHash {

    public SondeoCuadratico(int tamaño) {
        super(tamaño);
    }

    @Override
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
