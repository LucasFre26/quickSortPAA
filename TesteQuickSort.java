public class TesteQuickSort {

    int[] tamanhos = {100, 500, 1000}; // Defina os tamanhos de array para os testes

    public void executarTestes() {
        // Gera e salva os arrays de teste
        for (int tamanho : tamanhos) {
            int[] melhorCaso = GeradorTeste.gerarMelhorCaso(tamanho);
            int[] casoMedio = GeradorTeste.gerarCasoMedio(tamanho);
            int[] piorCaso = GeradorTeste.gerarPiorCaso(tamanho);

            GeradorTeste.salvarArrayEmArquivo(melhorCaso, "melhor_caso_" + tamanho);
            GeradorTeste.salvarArrayEmArquivo(casoMedio, "caso_medio_" + tamanho);
            GeradorTeste.salvarArrayEmArquivo(piorCaso, "pior_caso_" + tamanho);
        }

        // Testa cada algoritmo em cada tipo de caso e tamanho
        for (int tamanho : tamanhos) {
            System.out.println("\nExecutando QuickSort para arrays de tamanho: " + tamanho);

            // Lendo o array salvo para o melhor caso e executando o QuickSort Mediana de Três
            int[] arrayLidoMelhorCaso = GeradorTeste.lerArrayDeArquivo("melhor_caso_" + tamanho);
            System.out.println("QuickSort Mediana de Três - Melhor Caso:");
            QuickSortMedianaDeTres.executarQuickSort(arrayLidoMelhorCaso);

            // Lendo o array salvo para o caso médio e executando o QuickSort Mediana de Três
            int[] arrayLidoCasoMedio = GeradorTeste.lerArrayDeArquivo("caso_medio_" + tamanho);
            System.out.println("QuickSort Mediana de Três - Caso Médio:");
            QuickSortMedianaDeTres.executarQuickSort(arrayLidoCasoMedio);

            // Lendo o array salvo para o pior caso e executando o QuickSort Mediana de Três
            int[] arrayLidoPiorCaso = GeradorTeste.lerArrayDeArquivo("pior_caso_" + tamanho);
            System.out.println("QuickSort Mediana de Três - Pior Caso:");
            QuickSortMedianaDeTres.executarQuickSort(arrayLidoPiorCaso);

            // Repita o processo para QuickSort Padrão e QuickSort com Insertion Sort
            // Exemplo para QuickSort Padrão
            arrayLidoMelhorCaso = GeradorTeste.lerArrayDeArquivo("melhor_caso_" + tamanho);
            System.out.println("QuickSort Padrão - Melhor Caso:");
            QuickSortRecursivo.executarQuickSort(arrayLidoMelhorCaso);

            arrayLidoCasoMedio = GeradorTeste.lerArrayDeArquivo("caso_medio_" + tamanho);
            System.out.println("QuickSort Padrão - Caso Médio:");
            QuickSortRecursivo.executarQuickSort(arrayLidoCasoMedio);

            arrayLidoPiorCaso = GeradorTeste.lerArrayDeArquivo("pior_caso_" + tamanho);
            System.out.println("QuickSort Padrão - Pior Caso:");
            QuickSortRecursivo.executarQuickSort(arrayLidoPiorCaso);

            // QuickSort com Insertion Sort
            arrayLidoMelhorCaso = GeradorTeste.lerArrayDeArquivo("melhor_caso_" + tamanho);
            System.out.println("QuickSort com Insertion Sort - Melhor Caso:");
            QuickSortInsertion.executarQuickSort(arrayLidoMelhorCaso);

            arrayLidoCasoMedio = GeradorTeste.lerArrayDeArquivo("caso_medio_" + tamanho);
            System.out.println("QuickSort com Insertion Sort - Caso Médio:");
            QuickSortInsertion.executarQuickSort(arrayLidoCasoMedio);

            arrayLidoPiorCaso = GeradorTeste.lerArrayDeArquivo("pior_caso_" + tamanho);
            System.out.println("QuickSort com Insertion Sort - Pior Caso:");
            QuickSortInsertion.executarQuickSort(arrayLidoPiorCaso);
        }
    }
}
