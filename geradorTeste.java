import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Random;

class GeradorTeste {

    // Função para salvar arrays no arquivo .txt
    static void salvarArrayEmArquivo(int[] arr, String nomeArquivo) {
        try {
            FileWriter writer = new FileWriter("test/" + nomeArquivo + ".txt");
            writer.write(Arrays.toString(arr));
            writer.close();
            System.out.println("Array salvo no arquivo: " + nomeArquivo + ".txt");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo.");
            e.printStackTrace();
        }
    }

    // Função para ler um arquivo .txt e converter para array de inteiros
    static int[] lerArrayDeArquivo(String nomeArquivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test/" + nomeArquivo + ".txt"));
            String linha = reader.readLine();
            reader.close();

            // Remove os colchetes e divide os elementos
            String[] numeros = linha.replace("[", "").replace("]", "").split(", ");
            int[] arr = new int[numeros.length];

            for (int i = 0; i < numeros.length; i++) {
                arr[i] = Integer.parseInt(numeros[i]);
            }

            return arr;
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }
        return null;
    }

    // Gerar melhor caso do QuickSort (array ordenado)
    static int[] gerarMelhorCaso(int tamanho) {
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    // Gerar caso médio do QuickSort (array aleatório)
    static int[] gerarCasoMedio(int tamanho) {
        Random rand = new Random();
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }

    // Gerar pior caso do QuickSort (array decrescente)
    static int[] gerarPiorCaso(int tamanho) {
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = tamanho - i;
        }
        return arr;
    }
}
