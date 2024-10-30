public class TesteQuickSort {

    int[] tamanhos = {25, 50, 100, 250, 500, 750, 1000, 1250, 1500}; // Defina os tamanhos de array para os testes
    CSVLogger logger_QuickSortRecursivo = new CSVLogger("dados_quicksortRecursivo.csv"); 
    CSVLogger logger_QuickSortInsertion = new CSVLogger("dados_quicksortInsertion.csv"); 
    CSVLogger logger_QuickSortMedianaTres = new CSVLogger("dados_quicksortMedianaTres.csv"); 

    public void executarTestes() {
        // Testa cada algoritmo em cada tipo de caso e tamanho
        for (int tamanho : tamanhos) {
            System.out.println("\nExecutando QuickSort para arrays de tamanho: " + tamanho);

            // Inicializa QuickSortMedianaDeTres com um valor apropriado de M
            int M = 10; // Defina o valor de M conforme necessário
            QuickSortMedianaDeTres quickSortMedianaTres = new QuickSortMedianaDeTres(M);

            // Gerando e executando QuickSort Mediana de Três para melhor caso
            int[] melhorCaso = GeradorTeste.gerarMelhorCaso(tamanho);
            System.out.println("QuickSort Mediana de Três - Melhor Caso:");
            quickSortMedianaTres.executarQuickSort(melhorCaso, logger_QuickSortMedianaTres);

            // Gerando e executando QuickSort Mediana de Três para caso médio
            int[] casoMedio = GeradorTeste.gerarCasoMedio(tamanho);
            System.out.println("QuickSort Mediana de Três - Caso Médio:");
            quickSortMedianaTres.executarQuickSort(casoMedio, logger_QuickSortMedianaTres);

            // Gerando e executando QuickSort Mediana de Três para pior caso
            int[] piorCaso = GeradorTeste.gerarPiorCaso(tamanho);
            System.out.println("QuickSort Mediana de Três - Pior Caso:");
            quickSortMedianaTres.executarQuickSort(piorCaso, logger_QuickSortMedianaTres);

            // Repete o processo para QuickSort Recursivo
            QuickSortRecursivo quickSortRecursivo = new QuickSortRecursivo();
            System.out.println("QuickSort Recursivo - Melhor Caso:");
            quickSortRecursivo.executarQuickSort(melhorCaso, logger_QuickSortRecursivo);

            System.out.println("QuickSort Recursivo - Caso Médio:");
            quickSortRecursivo.executarQuickSort(casoMedio, logger_QuickSortRecursivo);

            System.out.println("QuickSort Recursivo - Pior Caso:");
            quickSortRecursivo.executarQuickSort(piorCaso, logger_QuickSortRecursivo);

            // QuickSort com Insertion Sort
            QuickSortInsertion quickSortInsertion = new QuickSortInsertion();
            System.out.println("QuickSort com Insertion Sort - Melhor Caso:");
            quickSortInsertion.executarQuickSort(melhorCaso, logger_QuickSortInsertion);

            System.out.println("QuickSort com Insertion Sort - Caso Médio:");
            quickSortInsertion.executarQuickSort(casoMedio, logger_QuickSortInsertion);

            System.out.println("QuickSort com Insertion Sort - Pior Caso:");
            quickSortInsertion.executarQuickSort(piorCaso, logger_QuickSortInsertion);
        }
    }
}
