import java.text.DecimalFormat;

class Main {

    public static void main(String[] args) {

        // testePerfomanceEstatico();

        testeMelhorM();

        // TesteQuickSort testeQuickSort = new TesteQuickSort();
        // testeQuickSort.executarTestes();

    }

    public static void testeMelhorM() {
        int melhorMQuickSort = 0;
        double melhorTempoQuickSort = Double.MAX_VALUE; // Inicializa o melhor tempo do QuickSort com um valor alto
        int melhorMInsertion = 0;
        double melhorTempoInsertion = Double.MAX_VALUE; // Inicializa o melhor tempo do Insertion Sort com um valor alto
        
        CSVLogger loggerQuickSort = new CSVLogger("dadosMedianaTres.csv", "dadosMedianaTresM.csv"); // Logger para QuickSort
        CSVLogger loggerInsertion = new CSVLogger("dadosInsertion.csv", "dadosInsertionM.csv"); // Logger para Insertion Sort
        DecimalFormat format = new DecimalFormat("#.#####"); // Define o formato para 5 casas decimais
    
        // Testando QuickSortMedianaDeTres
        for (int M = 0; M <= 1000; M += 1) { 
            QuickSortMedianaDeTres quickSort = new QuickSortMedianaDeTres(M);
            
            int[] arr = GeradorTeste.lerArrayDeArquivo("pior_caso_1000");
        
            long startTime = System.nanoTime(); // Marca o início
            quickSort.executarQuickSort(arr, loggerQuickSort);
            long endTime = System.nanoTime(); // Marca o fim
            
            double duracao = (endTime - startTime) / 1_000_000.0; // Tempo em milissegundos com precisão
        
            // Registra o M e o tempo no logger
            loggerQuickSort.registrarM(M, duracao);
        
            // Verifica se o tempo atual é melhor que o melhor tempo encontrado
            if (duracao < melhorTempoQuickSort) {
                melhorTempoQuickSort = duracao;
                melhorMQuickSort = M; // Atualiza o melhor M
            }
    
            // Exibe M e o tempo com 5 casas decimais
            System.out.println("QuickSort Mediana de tres- M: " + M + ", Tempo: " + format.format(duracao) + " ms");
        }
        
        // Testando QuickSortInsertion
        for (int M = 0; M <= 1000; M += 1) { 
            QuickSortInsertion quickSortInsertion = new QuickSortInsertion(M);
            
            int[] arr = GeradorTeste.lerArrayDeArquivo("pior_caso_1000");
        
            long startTime = System.nanoTime(); // Marca o início
            quickSortInsertion.executarQuickSort(arr, loggerInsertion);
            long endTime = System.nanoTime(); // Marca o fim
            
            double duracao = (endTime - startTime) / 1_000_000.0; // Tempo em milissegundos com precisão
        
            // Registra o M e o tempo no logger
            loggerInsertion.registrarM(M, duracao);
        
            // Verifica se o tempo atual é melhor que o melhor tempo encontrado
            if (duracao < melhorTempoInsertion) {
                melhorTempoInsertion = duracao;
                melhorMInsertion = M; // Atualiza o melhor M
            }
    
            // Exibe M e o tempo com 5 casas decimais
            System.out.println("Insertion Sort - M: " + M + ", Tempo: " + format.format(duracao) + " ms");
        }
    
        // Exibe os melhores resultados
        System.out.println("Melhor M para QuickSort: " + melhorMQuickSort + " com tempo: " + format.format(melhorTempoQuickSort) + " ms");
        System.out.println("Melhor M para Insertion Sort: " + melhorMInsertion + " com tempo: " + format.format(melhorTempoInsertion) + " ms");
    }
    
    public static void testePerfomanceEstatico() {
        int tamanho = 1000;
        int M = 11;
        
        // Logger para dados de execução e logger específico para M
        CSVLogger logger_QuickSortRecursivo = new CSVLogger("dados_quicksortRecursivo.csv", "dadosM_quicksortRecursivo.csv");
        CSVLogger logger_QuickSortInsertion = new CSVLogger("dados_quicksortInsertion.csv", "dadosM_quicksortInsertion.csv");
        CSVLogger logger_QuickSortMedianaTres = new CSVLogger("dados_quicksortMedianaTres.csv", "dadosM_quicksortMedianaTres.csv");
    
        // Lendo o array salvo no arquivo e executando QuickSort para o melhor caso
        System.out.println("Lendo e executando QuickSort Recursivo no melhor caso:");
        int[] arrayLidoMelhorCaso_QuickSortRecursivo = GeradorTeste.lerArrayDeArquivo("melhor_caso_" + tamanho);
        QuickSortRecursivo.executarQuickSort(arrayLidoMelhorCaso_QuickSortRecursivo, logger_QuickSortRecursivo);
    
        // Executando outros casos (caso médio e pior caso) com QuickSort Recursivo
        System.out.println("\nLendo e executando QuickSort Recursivo no caso médio:");
        int[] arrayLidoCasoMedio_QuickSortRecursivo = GeradorTeste.lerArrayDeArquivo("caso_medio_" + tamanho);
        QuickSortRecursivo.executarQuickSort(arrayLidoCasoMedio_QuickSortRecursivo, logger_QuickSortRecursivo);
    
        System.out.println("\nLendo e executando QuickSort Recursivo no pior caso:");
        int[] arrayLidoPiorCaso_QuickSortRecursivo = GeradorTeste.lerArrayDeArquivo("pior_caso_" + tamanho);
        QuickSortRecursivo.executarQuickSort(arrayLidoPiorCaso_QuickSortRecursivo, logger_QuickSortRecursivo);
        // Criando uma instância de QuickSortInsertion
        QuickSortInsertion quickSortInsertion = new QuickSortInsertion(M);

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
    
        // Executando QuickSort com Mediana de Três e registrando M
        System.out.println("\n\n\nLendo e executando QuickSort com Mediana de três no melhor caso:");
        int[] arrayLidoMelhorCaso_QuickSortMedianaDeTres = GeradorTeste.lerArrayDeArquivo("melhor_caso_" + tamanho);
        QuickSortMedianaDeTres quickSortMelhorCaso = new QuickSortMedianaDeTres(M);
        long tempoInicio = System.currentTimeMillis();
        quickSortMelhorCaso.executarQuickSort(arrayLidoMelhorCaso_QuickSortMedianaDeTres, logger_QuickSortMedianaTres);
        long tempoFim = System.currentTimeMillis();
        logger_QuickSortMedianaTres.registrarM(M, tempoFim - tempoInicio); // Registrando M e tempoM
    
        System.out.println("\nLendo e executando QuickSort com Mediana de três no caso médio:");
        int[] arrayLidoCasoMedio_QuickSortMedianaDeTres = GeradorTeste.lerArrayDeArquivo("caso_medio_" + tamanho);
        QuickSortMedianaDeTres quickSortCasoMedio = new QuickSortMedianaDeTres(M);
        tempoInicio = System.currentTimeMillis();
        quickSortCasoMedio.executarQuickSort(arrayLidoCasoMedio_QuickSortMedianaDeTres, logger_QuickSortMedianaTres);
        tempoFim = System.currentTimeMillis();
        logger_QuickSortMedianaTres.registrarM(M, tempoFim - tempoInicio);
    
        System.out.println("\nLendo e executando QuickSort com Mediana de três no pior caso:");
        int[] arrayLidoPiorCaso_QuickSortMedianaDeTres = GeradorTeste.lerArrayDeArquivo("pior_caso_" + tamanho);
        QuickSortMedianaDeTres quickSortPiorCaso = new QuickSortMedianaDeTres(M);
        tempoInicio = System.currentTimeMillis();
        quickSortPiorCaso.executarQuickSort(arrayLidoPiorCaso_QuickSortMedianaDeTres, logger_QuickSortMedianaTres);
        tempoFim = System.currentTimeMillis();
        logger_QuickSortMedianaTres.registrarM(M, tempoFim - tempoInicio);
    }
    
}
