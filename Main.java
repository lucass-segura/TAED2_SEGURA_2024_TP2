import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SondeoLineal tablaLineal = new SondeoLineal(10);
        SondeoCuadratico tablaCuadratica = new SondeoCuadratico(10);
        HashAbierto tablaAbierta = new HashAbierto(10);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Insertar");
            System.out.println("2. Buscar");
            System.out.println("3. Eliminar");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();

            if (opcion == 4) {
                break;
            }

            System.out.println("\nIngrese el método de manejo de colisiones (1-lineal, 2-cuadratico, 3-abierto):");
            String metodo = scanner.next();

            System.out.println("\nIngrese la clave (número de 6 dígitos):");
            int clave = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (metodo.equals("1")) {
                        tablaLineal.insertar(clave, "lineal");
                        System.out.println("\nClave insertada usando sondeo lineal.\n");
                    } else if (metodo.equals("2")) {
                        tablaCuadratica.insertar(clave, "cuadratico");
                        System.out.println("\nClave insertada usando sondeo cuadrático.\n");
                    } else if (metodo.equals("3")) {
                        tablaAbierta.insertar(clave);
                        System.out.println("\nClave insertada usando hash abierto.\n");
                    } else {
                        System.out.println("\nMétodo no válido.\n");
                    }
                    break;
                case 2:
                    boolean encontrado = false;
                    if (metodo.equals("1")) {
                        encontrado = tablaLineal.buscar(clave, "lineal");
                    } else if (metodo.equals("2")) {
                        encontrado = tablaCuadratica.buscar(clave, "cuadratico");
                    } else if (metodo.equals("3")) {
                        encontrado = tablaAbierta.buscar(clave);
                    } else {
                        System.out.println("\nMétodo no válido.\n");
                    }
                    System.out.println("\nClave " + (encontrado ? "encontrada" : "no encontrada") + ".\n");
                    break;
                case 3:
                    if (metodo.equals("1")) {
                        tablaLineal.eliminar(clave, "lineal");
                        System.out.println("\nClave eliminada usando sondeo lineal.\n");
                    } else if (metodo.equals("2")) {
                        tablaCuadratica.eliminar(clave, "cuadratico");
                        System.out.println("\nClave eliminada usando sondeo cuadrático.\n");
                    } else if (metodo.equals("3")) {
                        tablaAbierta.eliminar(clave);
                        System.out.println("\nClave eliminada usando hash abierto.\n");
                    } else {
                        System.out.println("\nMétodo no válido.\n");
                    }
                    break;
                default:
                    System.out.println("\nOpción no válida.");
            }
        }

        scanner.close();
    }
}
