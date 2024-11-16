import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] array = null; // Inicialización del arreglo
        
        while (true) {
            // Menú
            System.out.println("\nMenú:");
            System.out.println("1. Generar Arreglos aleatorios con diferente tamaño");
            System.out.println("2. Ordenar por los 3 métodos");
            System.out.println("3. Buscar valores (Búsqueda Binaria y Búsqueda Binaria Recursiva)");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    System.out.println("Selecciona el tamaño del arreglo:");
                    System.out.println("1. Arreglo de tamaño 10");
                    System.out.println("2. Arreglo de tamaño 100");
                    System.out.println("3. Arreglo de tamaño 1000");
                    System.out.println("4. Arreglo de tamaño 5000");
                    System.out.println("5. Arreglo de tamaño 10000");
                    System.out.println("6. Arreglo de tamaño 30000");

                    int sizeOption = scanner.nextInt();
                    int size = 0;
                    if (sizeOption == 1) size = 10;
                    else if (sizeOption == 2) size = 100;
                    else if (sizeOption == 3) size = 1000;
                    else if (sizeOption == 4) size = 5000;
                    else if (sizeOption == 5) size = 10000;
                    else if (sizeOption == 6) size = 30000;

                    array = Metodos.generateArray(size);
                    System.out.print("Arreglo generado: ");
                    for (int num : array) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;

                case 2:
                    if (array == null) {
                        System.out.println("Primero genera un arreglo.");
                        break;
                    }
                    // Ordenar por los 3 métodos
                    System.out.println("Elige el método de ordenamiento:");
                    System.out.println("1. Bubble Sort");
                    System.out.println("2. Selection Sort");
                    System.out.println("3. Insertion Sort");
                    int sortOption = scanner.nextInt();
                    int[] arrayCopy = array.clone(); // Clonamos el arreglo para no sobrescribirlo
                    
                    switch (sortOption) {
                        case 1:
                            Metodos.bubbleSort(arrayCopy);
                            System.out.print("Arreglo ordenado con Bubble Sort: ");
                            break;
                        case 2:
                            Metodos.selectionSort(arrayCopy);
                            System.out.print("Arreglo ordenado con Selection Sort: ");
                            break;
                        case 3:
                            Metodos.insertionSort(arrayCopy);
                            System.out.print("Arreglo ordenado con Insertion Sort: ");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            continue;
                    }
                    System.out.println();
                    break;

                case 3:
                    if (array == null) {
                        System.out.println("Primero genera un arreglo.");
                        break;
                    }
                    // Buscar valores
                    System.out.print("Ingrese el valor a buscar: ");
                    int target = scanner.nextInt();

                    // Búsqueda binaria normal
                    long startTime = System.nanoTime();
                    int result = Metodos.binarySearch(array, target);
                    long endTime = System.nanoTime();
                    long duration = (endTime - startTime);
                    
                    if (result != -1) {
                        System.out.println("Valor encontrado en el índice: " + result);
                    } else {
                        System.out.println("Valor no encontrado");
                    }
                    System.out.println("Tiempo de búsqueda binaria (en segundos): " + duration / 1e9);
                    
                    // Búsqueda binaria recursiva
                    startTime = System.nanoTime();
                    result = Metodos.recursiveBinarySearch(array, target, 0, array.length - 1);
                    endTime = System.nanoTime();
                    duration = (endTime - startTime);
                    
                    if (result != -1) {
                        System.out.println("Valor encontrado en el índice (recursivo): " + result);
                    } else {
                        System.out.println("Valor no encontrado (recursivo)");
                    }
                    System.out.println("Tiempo de búsqueda binaria recursiva (en segundos): " + duration / 1e9);
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}