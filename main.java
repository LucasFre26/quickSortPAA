class Main {

    public static void main(String[] args) {
        int tamanho = 1000;
        CSVLogger logger = new CSVLogger("dados_quicksort.csv");

        // Lendo o array salvo no arquivo e executando QuickSort para o melhor caso
        System.out.println("Lendo e executando QuickSort Recursivo no melhor caso:");
        int[] arrayLidoMelhorCaso_QuickSortRecursivo = GeradorTeste.lerArrayDeArquivo("melhor_caso_" + tamanho);
        QuickSortRecursivo.executarQuickSort(arrayLidoMelhorCaso_QuickSortRecursivo, logger);

        // Lendo o array salvo no arquivo e executando QuickSort para o caso médio
        System.out.println("\nLendo e executando QuickSort Recursivo no caso médio:");
        int[] arrayLidoCasoMedio_QuickSortRecursivo = GeradorTeste.lerArrayDeArquivo("caso_medio_" + tamanho);
        QuickSortRecursivo.executarQuickSort(arrayLidoCasoMedio_QuickSortRecursivo, logger);

        // Lendo o array salvo no arquivo e executando QuickSort para o pior caso
        System.out.println("\nLendo e executando QuickSort Recursivo no pior caso:");
        int[] arrayLidoPiorCaso_QuickSortRecursivo = GeradorTeste.lerArrayDeArquivo("pior_caso_" + tamanho);
        QuickSortRecursivo.executarQuickSort(arrayLidoPiorCaso_QuickSortRecursivo, logger);

        // Lendo o array salvo no arquivo e executando QuickSort para o melhor caso
        System.out.println("\n\n\nLendo e executando QuickSort com Insertion no melhor caso:");
        int[] arrayLidoMelhorCaso_QuickSortInsertion = GeradorTeste.lerArrayDeArquivo("melhor_caso_" + tamanho);
        QuickSortInsertion.executarQuickSort(arrayLidoMelhorCaso_QuickSortInsertion);

        // Lendo o array salvo no arquivo e executando QuickSort para o caso médio
        System.out.println("\nLendo e executando QuickSort com Insertion no caso médio:");
        int[] arrayLidoCasoMedio_QuickSortInsertion = GeradorTeste.lerArrayDeArquivo("caso_medio_" + tamanho);
        QuickSortInsertion.executarQuickSort(arrayLidoCasoMedio_QuickSortInsertion);

        // Lendo o array salvo no arquivo e executando QuickSort para o pior caso
        System.out.println("\nLendo e executando QuickSort com Insertion no pior caso:");
        int[] arrayLidoPiorCaso_QuickSortInsertion = GeradorTeste.lerArrayDeArquivo("pior_caso_" + tamanho);
        QuickSortInsertion.executarQuickSort(arrayLidoPiorCaso_QuickSortInsertion);

        // Lendo o array salvo no arquivo e executando QuickSort para o melhor caso
        System.out.println("\n\n\nLendo e executando QuickSort com Mediana de tres no melhor caso:");
        int[] arrayLidoMelhorCaso_QuickSortMedianaDeTres = GeradorTeste.lerArrayDeArquivo("melhor_caso_" + tamanho);
        QuickSortMedianaDeTres.executarQuickSort(arrayLidoMelhorCaso_QuickSortMedianaDeTres);

        // Lendo o array salvo no arquivo e executando QuickSort para o caso médio
        System.out.println("\nLendo e executando QuickSort com Mediana de tres no caso médio:");
        int[] arrayLidoCasoMedio_QuickSortMedianaDeTres = GeradorTeste.lerArrayDeArquivo("caso_medio_" + tamanho);
        QuickSortMedianaDeTres.executarQuickSort(arrayLidoCasoMedio_QuickSortMedianaDeTres);

        // Lendo o array salvo no arquivo e executando QuickSort para o pior caso
        System.out.println("\nLendo e executando QuickSort com Mediana de tres no pior caso:");
        int[] arrayLidoPiorCaso_QuickSortMedianaDeTres = GeradorTeste.lerArrayDeArquivo("pior_caso_" + tamanho);
        QuickSortMedianaDeTres.executarQuickSort(arrayLidoPiorCaso_QuickSortMedianaDeTres);

    }
}
