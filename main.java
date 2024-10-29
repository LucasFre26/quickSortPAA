class Main {

    public static void main(String[] args) {
        int tamanho = 1000; // Defina o tamanho dos arrays

        // Gerando e salvando o melhor, caso médio e pior caso
       /*  int[] melhorCaso = GeradorTeste.gerarMelhorCaso(tamanho);
        GeradorTeste.salvarArrayEmArquivo(melhorCaso, "melhor_caso");

        int[] casoMedio = GeradorTeste.gerarCasoMedio(tamanho);
        GeradorTeste.salvarArrayEmArquivo(casoMedio, "caso_medio");

        int[] piorCaso = GeradorTeste.gerarPiorCaso(tamanho);
        GeradorTeste.salvarArrayEmArquivo(piorCaso, "pior_caso"); */

        // Lendo o array salvo no arquivo e executando QuickSort para o melhor caso
        System.out.println("Lendo e executando QuickSort no melhor caso:");
        int[] arrayLidoMelhorCaso = GeradorTeste.lerArrayDeArquivo("melhor_caso");
        QuickSortMedianaDeTres.executarQuickSort(arrayLidoMelhorCaso);

        // Lendo o array salvo no arquivo e executando QuickSort para o caso médio
        System.out.println("\nLendo e executando QuickSort no caso médio:");
        int[] arrayLidoCasoMedio = GeradorTeste.lerArrayDeArquivo("caso_medio");
        QuickSortMedianaDeTres.executarQuickSort(arrayLidoCasoMedio);

        // Lendo o array salvo no arquivo e executando QuickSort para o pior caso
        System.out.println("\nLendo e executando QuickSort no pior caso:");
        int[] arrayLidoPiorCaso = GeradorTeste.lerArrayDeArquivo("pior_caso");
        QuickSortMedianaDeTres.executarQuickSort(arrayLidoPiorCaso);
        
    }
}
