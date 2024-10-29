import java.util.Random;

class QuickSortRecursivo {
    static int comparacoes = 0;
    static int trocas = 0;

    // Função para realizar a partição do array
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparacoes++;

            if (arr[j] <= pivot) {
                i++;
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    trocas++;
                }
            }
        }

        if (i + 1 != high) {
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            trocas++;
        }

        return i + 1;
    }

    // Função recursiva para ordenar o array
    static void ordenar(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            ordenar(arr, low, pi - 1);
            ordenar(arr, pi + 1, high);
        }
    }

    // Função para executar o QuickSort e registrar os dados no logger
    static void executarQuickSort(int[] arr, CSVLogger logger) {
        comparacoes = 0;
        trocas = 0;
        long startTime = System.nanoTime();

        ordenar(arr, 0, arr.length - 1);

        long endTime = System.nanoTime();
        long duracao = (endTime - startTime) / 1_000_000; // Tempo em milissegundos

        logger.registrarDados(arr.length, comparacoes, trocas, duracao);

        System.out.printf("Tempo de execução: %.2f ms%n", (double) duracao);
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
