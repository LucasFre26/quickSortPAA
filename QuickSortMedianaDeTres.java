import java.util.Random;

class QuickSortMedianaDeTres {
    static int comparacoes = 0;
    static int trocas = 0;
    private int M; // Valor de M agora é um atributo da classe

    // Construtor que recebe o valor de M
    public QuickSortMedianaDeTres(int M) {
        this.M = M;
    }

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

    // Função para escolher o pivô com a técnica de mediana de três
    static int medianaDeTres(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        // Organiza low, mid e high para garantir que a mediana seja escolhida
        if (arr[low] > arr[mid])
            swap(arr, low, mid);
        if (arr[low] > arr[high])
            swap(arr, low, high);
        if (arr[mid] > arr[high])
            swap(arr, mid, high);

        // A mediana está em mid, troque com o elemento high para usar como pivô
        swap(arr, mid, high);
        return arr[high];
    }

    // Função para trocar dois elementos no array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        trocas++;
    }

    // Função para o Insertion Sort
    static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;

            // Realiza comparações e movimenta os elementos maiores que key
            while (j >= low && arr[j] > key) {
                comparacoes++; // Contando comparações
                arr[j + 1] = arr[j]; // Move o elemento maior para frente
                j--;
            }

            // Só insere o elemento na posição correta se houve movimentação
            if (j + 1 != i) {
                arr[j + 1] = key;
                trocas++; // Conta a troca real
            }
        }
    }

    // Função recursiva para ordenar o array
    void ordenar(int[] arr, int low, int high) {
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
    void executarQuickSort(int[] arr, CSVLogger logger) {
        comparacoes = 0;
        trocas = 0;
        long startTime = System.nanoTime(); // Marca o início

        ordenar(arr, 0, arr.length - 1);

        long endTime = System.nanoTime(); // Marca o fim
        long duracao = (endTime - startTime) / 1000000; // Tempo em milissegundos

        logger.registrarDados(arr.length, comparacoes, trocas, duracao);

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
