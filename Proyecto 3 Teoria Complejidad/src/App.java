import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] sizes = {10, 20, 100, 1000, 5000, 10000, 30000};

        while (true) {
            System.out.println("\n"+"Menu:");
            System.out.println("1. Generar Arreglos aleatorios con diferente tamaño");
            System.out.println("2. Ordenar por los 3 métodos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int op = scanner.nextInt();

            switch (op) {
                case 1:
                    for (int size : sizes) {
                        int[] array = MetodosOrdenamiento.generateRandomArray(size);
                        System.out.println("Arreglo de tamaño " + size + ": " + Arrays.toString(array)+ "\n");
                    }
                    break;
                case 2:
                    for (int size : sizes) {
                        int[] array = MetodosOrdenamiento.generateRandomArray(size);
                        System.out.println("\n"+"Ordenando arreglo de tamaño " + size);

                        // Clonamos la matriz para cada método que se utilice la misma matriz en cada tamaño de arreglo
                        int[] ArrayBurbuja = array.clone();
                        int[] ArraySeleccion = array.clone();
                        int[] ArrayInsercion = array.clone();

                        // Burbuja Mejorada
                        long Tiempoinicio = System.nanoTime();
                        MetodosOrdenamiento.BurbujaMejorado(ArrayBurbuja);
                        long TiempoFinal = System.nanoTime();
                        System.out.println("Burbuja Mejorada con " + size + " valores, tuvo un tiempo de: " + (TiempoFinal - Tiempoinicio) / 1e6 + " ms");

                        // Selección
                        Tiempoinicio = System.nanoTime();
                        MetodosOrdenamiento.Seleccion(ArraySeleccion);
                        TiempoFinal = System.nanoTime();
                        System.out.println("Selección con " + size + " valores, tuvo un tiempo de: " + (TiempoFinal - Tiempoinicio) / 1e6 + " ms");

                        // Inserción
                        Tiempoinicio= System.nanoTime();
                        MetodosOrdenamiento.Insercion(ArrayInsercion);
                        TiempoFinal = System.nanoTime();
                        System.out.println("Inserción con " + size + " valores, tuvo un tiempo de: " + (TiempoFinal - Tiempoinicio) / 1e6 + " ms");
                    }
                    break;
                case 3:
                    System.out.println("Usted ha salido del programa. Muchas Gracias");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Ingrese una opcion del 1 al 3 del menu.");
             }
        }
    }
}