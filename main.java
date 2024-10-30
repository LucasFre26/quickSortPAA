class Main {

    public static void main(String[] args) {

        // testePerfomanceEstatico();

        // testeMelhorM();

        TesteQuickSort testeQuickSort = new TesteQuickSort();
        testeQuickSort.executarTestes();

    }

    public static void testeMelhorM() {
        int melhorM = 0;
        long melhorTempo = Long.MAX_VALUE; // Inicializa o melhor tempo com um valor alto
        CSVLogger logger = new CSVLogger("testeEmpiricoM_quicksortMedianaTres.csv"); // Inicializa o logger fora do loop
    
        for (int M = 0; M <= 1000; M += 1) { 
            QuickSortMedianaDeTres quickSort = new QuickSortMedianaDeTres(M);
            
            int[] arr = GeradorTeste.lerArrayDeArquivo("pior_caso_1000");
        
            long startTime = System.nanoTime(); // Marca o início
            quickSort.executarQuickSort(arr, logger);
            long endTime = System.nanoTime(); // Marca o fim
            
            long duracao = (endTime - startTime) / 1000000; // Tempo em milissegundos
    
            // Registra o M e o tempo no logger
            logger.registrarM(M, duracao);
        
            // Verifica se o tempo atual é melhor que o melhor tempo encontrado
            if (duracao < melhorTempo) {
                melhorTempo = duracao;
                melhorM = M; // Atualiza o melhor M
            }
    
            System.out.println("M: " + M + ", Tempo: " + duracao + " ms");
        }
    
        System.out.println("Melhor M: " + melhorM + " com tempo: " + melhorTempo + " ms");
    }
    
    

    public static void testePerfomanceEstatico(){
        int tamanho = 1000;
        int M = 11;
        CSVLogger logger_QuickSortRecursivo = new CSVLogger("dados_quicksortRecursivo.csv");
        CSVLogger logger_QuickSortInsertion = new CSVLogger("dados_quicksortInsertion.csv");
        CSVLogger logger_QuickSortMedianaTres = new CSVLogger("dados_quicksortMedianaTres.csv");

        // Lendo o array salvo no arquivo e executando QuickSort para o melhor caso
        System.out.println("Lendo e executando QuickSort Recursivo no melhor caso:");
        int[] arrayLidoMelhorCaso_QuickSortRecursivo = GeradorTeste.lerArrayDeArquivo("melhor_caso_" + tamanho);
        QuickSortRecursivo.executarQuickSort(arrayLidoMelhorCaso_QuickSortRecursivo, logger_QuickSortRecursivo);

        // Lendo o array salvo no arquivo e executando QuickSort para o caso médio
        System.out.println("\nLendo e executando QuickSort Recursivo no caso médio:");
        int[] arrayLidoCasoMedio_QuickSortRecursivo = GeradorTeste.lerArrayDeArquivo("caso_medio_" + tamanho);
        QuickSortRecursivo.executarQuickSort(arrayLidoCasoMedio_QuickSortRecursivo, logger_QuickSortRecursivo);

        // Lendo o array salvo no arquivo e executando QuickSort para o pior caso
        System.out.println("\nLendo e executando QuickSort Recursivo no pior caso:");
        int[] arrayLidoPiorCaso_QuickSortRecursivo = GeradorTeste.lerArrayDeArquivo("pior_caso_" + tamanho);
        QuickSortRecursivo.executarQuickSort(arrayLidoPiorCaso_QuickSortRecursivo, logger_QuickSortRecursivo);

        // Lendo o array salvo no arquivo e executando QuickSort para o melhor caso
        System.out.println("\n\n\nLendo e executando QuickSort com Insertion no melhor caso:");
        int[] arrayLidoMelhorCaso_QuickSortInsertion = GeradorTeste.lerArrayDeArquivo("melhor_caso_" + tamanho);
        QuickSortInsertion.executarQuickSort(arrayLidoMelhorCaso_QuickSortInsertion, logger_QuickSortInsertion);

        // Lendo o array salvo no arquivo e executando QuickSort para o caso médio
        System.out.println("\nLendo e executando QuickSort com Insertion no caso médio:");
        int[] arrayLidoCasoMedio_QuickSortInsertion = GeradorTeste.lerArrayDeArquivo("caso_medio_" + tamanho);
        QuickSortInsertion.executarQuickSort(arrayLidoCasoMedio_QuickSortInsertion, logger_QuickSortInsertion);

        // Lendo o array salvo no arquivo e executando QuickSort para o pior caso
        System.out.println("\nLendo e executando QuickSort com Insertion no pior caso:");
        int[] arrayLidoPiorCaso_QuickSortInsertion = GeradorTeste.lerArrayDeArquivo("pior_caso_" + tamanho);
        QuickSortInsertion.executarQuickSort(arrayLidoPiorCaso_QuickSortInsertion, logger_QuickSortInsertion);

        // Lendo o array salvo no arquivo e executando QuickSort para o melhor caso
        System.out.println("\n\n\nLendo e executando QuickSort com Mediana de três no melhor caso:");
        int[] arrayLidoMelhorCaso_QuickSortMedianaDeTres = GeradorTeste.lerArrayDeArquivo("melhor_caso_" + tamanho);
        QuickSortMedianaDeTres quickSortMelhorCaso = new QuickSortMedianaDeTres(M); // Inicialize M conforme necessário
        quickSortMelhorCaso.executarQuickSort(arrayLidoMelhorCaso_QuickSortMedianaDeTres, logger_QuickSortMedianaTres);

        // Lendo o array salvo no arquivo e executando QuickSort para o caso médio
        System.out.println("\nLendo e executando QuickSort com Mediana de três no caso médio:");
        int[] arrayLidoCasoMedio_QuickSortMedianaDeTres = GeradorTeste.lerArrayDeArquivo("caso_medio_" + tamanho);
        QuickSortMedianaDeTres quickSortCasoMedio = new QuickSortMedianaDeTres(M); // Inicialize M conforme necessário
        quickSortCasoMedio.executarQuickSort(arrayLidoCasoMedio_QuickSortMedianaDeTres, logger_QuickSortMedianaTres);

        // Lendo o array salvo no arquivo e executando QuickSort para o pior caso
        System.out.println("\nLendo e executando QuickSort com Mediana de três no pior caso:");
        int[] arrayLidoPiorCaso_QuickSortMedianaDeTres = GeradorTeste.lerArrayDeArquivo("pior_caso_" + tamanho);
        QuickSortMedianaDeTres quickSortPiorCaso = new QuickSortMedianaDeTres(M); // Inicialize M conforme necessário
        quickSortPiorCaso.executarQuickSort(arrayLidoPiorCaso_QuickSortMedianaDeTres, logger_QuickSortMedianaTres);

    }
}
