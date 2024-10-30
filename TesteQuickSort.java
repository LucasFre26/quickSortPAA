public class TesteQuickSort {

    int[] tamanhos = {25, 50, 100, 250, 500, 750, 1000, 1250, 1500}; // Defina os tamanhos de array para os testes
    CSVLogger logger_QuickSortRecursivo = new CSVLogger("dados_quicksortRecursivo.csv", "dadosM_quicksortRecursivo.csv");
    CSVLogger logger_QuickSortInsertion = new CSVLogger("dados_quicksortInsertion.csv", "dadosM_quicksortInsertion.csv");
    CSVLogger logger_QuickSortMedianaTres = new CSVLogger("dados_quicksortMedianaTres.csv", "dadosM_quicksortMedianaTres.csv"); 

    public void executarTestes() {
        // Testa cada algoritmo em cada tipo de caso e tamanho
        for (int tamanho : tamanhos) {
            System.out.println("\nExecutando QuickSort para arrays de tamanho: " + tamanho);

            // Inicializa QuickSortMedianaDeTres com um valor apropriado de M
            int M = 10; // Defina o valor de M conforme necessário
            QuickSortMedianaDeTres quickSortMedianaTres = new QuickSortMedianaDeTres(M);
            
            // Criando uma instância de QuickSortInsertion
            QuickSortInsertion quickSortInsertion = new QuickSortInsertion(M);

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

            // Executando QuickSort com Insertion para os três casos
            System.out.println("\n\n\nLendo e executando QuickSort com Insertion no melhor caso:");
            int[] arrayLidoMelhorCaso_QuickSortInsertion = GeradorTeste.lerArrayDeArquivo("melhor_caso_" + tamanho);
            quickSortInsertion.executarQuickSort(arrayLidoMelhorCaso_QuickSortInsertion, logger_QuickSortInsertion);

            System.out.println("\nLendo e executando QuickSort com Insertion no caso médio:");
            int[] arrayLidoCasoMedio_QuickSortInsertion = GeradorTeste.lerArrayDeArquivo("caso_medio_" + tamanho);
            quickSortInsertion.executarQuickSort(arrayLidoCasoMedio_QuickSortInsertion, logger_QuickSortInsertion);

            System.out.println("\nLendo e executando QuickSort com Insertion no pior caso:");
            int[] arrayLidoPiorCaso_QuickSortInsertion = GeradorTeste.lerArrayDeArquivo("pior_caso_" + tamanho);
            quickSortInsertion.executarQuickSort(arrayLidoPiorCaso_QuickSortInsertion, logger_QuickSortInsertion);
        }
    }
}
