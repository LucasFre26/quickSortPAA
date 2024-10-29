import java.util.Arrays;

class QuickSortRecursivo {
    static int comparacoes = 0;
    static int trocas = 0;

    // Função para realizar a partição do array
    static int partition(int[] arr, int low, int high) {
        // Pivô é o último elemento
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Atualiza o contador de comparações
            comparacoes++;

            if (arr[j] <= pivot) {
                i++;
                // Troca de elementos somente se i e j são diferentes
                if (i != j) {
                    // Troca de elementos
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    trocas++; // Contando trocas
                }
            }
        }

        // Troca o pivô com o elemento na posição correta somente se necessário
        if (i + 1 != high) {
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            trocas++; // Contando trocas
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

    // Função para calcular o tempo de execução
    static void executarQuickSort(int[] arr) {
        comparacoes = 0;
        trocas = 0;
        long startTime = System.nanoTime(); // Marca o início

        ordenar(arr, 0, arr.length - 1);

        long endTime = System.nanoTime(); // Marca o fim
        long duracao = (endTime - startTime); // Tempo em nanosegundos

        // Conversão do tempo para milissegundos
        double duracaoEmMilissegundos = duracao / 1_000_000.0;

        // Imprime o array ordenado, se desejado
        // System.out.println("Array ordenado: " + Arrays.toString(arr));
        System.out.printf("Tempo de execução: %.2f ms%n", duracaoEmMilissegundos);
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
    }


}
