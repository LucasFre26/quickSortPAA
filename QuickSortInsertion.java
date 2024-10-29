import java.util.Random;

class QuickSortInsertion {
    static int comparacoes = 0;
    static int trocas = 0;
    static final int M = 10; // Inicializar com um valor de M, pode ser ajustado

    // Função para realizar a partição do array
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparacoes++;
            if (arr[j] <= pivot) {
                i++;
                if (i != j) {
                    // Troca de elementos
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    trocas++;
                }
            }
        }

        if (i + 1 != high) {
            // Troca o pivô com o elemento na posição correta
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            trocas++;
        }
        return i + 1;
    }

    // Função para o Insertion Sort
    static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                trocas++;
            }
            arr[j + 1] = key;
            if (j + 1 != i) trocas++;
        }
    }

    // Função recursiva para ordenar o array
    static void ordenar(int[] arr, int low, int high) {
        if (low < high) {
            // Se o tamanho do sub-vetor for menor que M, use Insertion Sort
            if (high - low + 1 < M) {
                insertionSort(arr, low, high);
            } else {
                int pi = partition(arr, low, high);
                ordenar(arr, low, pi - 1);
                ordenar(arr, pi + 1, high);
            }
        }
    }

    // Função para calcular o tempo de execução
    static void executarQuickSort(int[] arr) {
        comparacoes = 0;
        trocas = 0;
        long startTime = System.nanoTime(); // Marca o início

        ordenar(arr, 0, arr.length - 1);

        long endTime = System.nanoTime(); // Marca o fim
        long duracao = (endTime - startTime) / 1000000; // Tempo em milissegundos

        System.out.println("Tempo de execução: " + duracao + " ms");
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
    }

    // Função para gerar um array aleatório
    static int[] gerarArray(int tamanho) {
        Random rand = new Random();
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = rand.nextInt(10000); // Número aleatório entre 0 e 9999
        }
        return arr;
    }

    
}
