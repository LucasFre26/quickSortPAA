import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class CSVLogger {

    private String nomeArquivo;

    // Construtor que define o nome do arquivo CSV
    public CSVLogger(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        inicializarCSV();
    }

    // Método para inicializar o arquivo CSV com o cabeçalho se ele não existir
    private void inicializarCSV() {
        File arquivo = new File(nomeArquivo);
        // Verifica se o arquivo já existe
        if (!arquivo.exists()) {
            try (FileWriter writer = new FileWriter(nomeArquivo)) {
                writer.write("Tamanho,Comparações,Trocas,Tempo(ms)\n");
            } catch (IOException e) {
                System.out.println("Erro ao inicializar o arquivo CSV: " + e.getMessage());
            }
        }
    }

    // Método para registrar uma linha com os dados fornecidos
    public void registrarDados(int tamanho, int comparacoes, int trocas, long tempo) {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) { // O parâmetro "true" permite adicionar ao arquivo
            writer.write(tamanho + "," + comparacoes + "," + trocas + "," + tempo + "\n");
            System.out.println("Registro adicionado: Tamanho=" + tamanho + ", Comparações=" + comparacoes + ", Trocas="
                    + trocas + ", Tempo=" + tempo + " ms");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }
}
