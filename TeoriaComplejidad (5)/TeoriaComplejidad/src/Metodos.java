import java.util.Random;

public class Metodos {
 
    public static int[] generateArray(int size) {
        int[] baseArray = {23, 405, 12, 28001, 34, 5006, 78, 90, 11, 4443};

        int[] array = new int[size];
        for (int i = 0; i < 10 && i < size; i++) {
            array[i] = baseArray[i];
        }
        
        if (size > 10) {
            Random random = new Random();
            for (int i = 10; i < size; i++) {
                array[i] = random.nextInt(30000) + 1;
            }
        }
        
        return array;
    }

    // Método para realizar la Búsqueda Binaria Normal
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Si no se encuentra el elemento
    }

    // Algoritmo de ordenamiento Burbuja con ajuste
    public static void bubbleSort(int[] array) {
        long startTime = System.nanoTime();
        int n = array.length;
        boolean swapped;
        
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
        
        long endTime = System.nanoTime();
        System.out.println("Tiempo de ejecución (Burbuja con Ajuste): " + (endTime - startTime) + " nanosegundos");
    }

    // Algoritmo de ordenamiento por Selección
    public static void selectionSort(int[] array) {
        long startTime = System.nanoTime();
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        long endTime = System.nanoTime();
        System.out.println("Tiempo de ejecución (Selección): " + (endTime - startTime) + " nanosegundos");
    }

    // Algoritmo de ordenamiento por Inserción
    public static void insertionSort(int[] array) {
        long startTime = System.nanoTime();
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }

        long endTime = System.nanoTime();
        System.out.println("Tiempo de ejecución (Inserción): " + (endTime - startTime) + " nanosegundos");
    }


    // Búsqueda Binaria Recursiva
    public static int recursiveBinarySearch(int[] array, int left, int right, int value) {
        if (right >= left) {
            int middle = left + (right - left) / 2;

            if (array[middle] == value) {
                return middle;
            }

            if (array[middle] > value) {
                return recursiveBinarySearch(array, left, middle - 1, value);
            } else {
                return recursiveBinarySearch(array, middle + 1, right, value);
            }
        }
        return -1; // No encontrado
    }
    
    public static void searchAndMeasureTime(int[] array, int value) {
        long startTime = System.nanoTime();
        int result = recursiveBinarySearch(array, 0, array.length - 1, value);
        long endTime = System.nanoTime();
        System.out.println("Tiempo de ejecución (Búsqueda Binaria Recursiva): " + (endTime - startTime) + " nanosegundos");
        if (result == -1) {
            System.out.println("Valor no encontrado.");
        } else {
            System.out.println("Valor encontrado en la posición: " + result);
        }
    }
}
