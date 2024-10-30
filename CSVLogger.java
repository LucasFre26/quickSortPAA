import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class CSVLogger {
    private String nomeArquivo;

    // Construtor que define o nome do arquivo CSV e o diretório
    public CSVLogger(String nomeArquivo) {
        String diretorio = "planilhas";
        // Certifique-se de que o diretório termina com uma barra
        if (!diretorio.endsWith(File.separator)) {
            diretorio += File.separator;
        }
        this.nomeArquivo = diretorio + nomeArquivo;
        inicializarCSV();
    }

    // Método para inicializar o arquivo CSV com o cabeçalho se ele não existir
    private void inicializarCSV() {
        File arquivo = new File(nomeArquivo);
        // Verifica se o arquivo já existe
        if (!arquivo.exists()) {
            // Verifica se o diretório existe, caso contrário, cria-o
            new File(arquivo.getParent()).mkdirs();
            try (FileWriter writer = new FileWriter(nomeArquivo)) {
                writer.write("Tamanho,Comparações,Trocas,Tempo(ms),M,TempoM(ms)\n");
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

    // Método para registrar M e seu tempo
    public void registrarM(int M, long tempo) {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) { // O parâmetro "true" permite adicionar ao arquivo
            writer.write("M," + M + "," + tempo + "\n");
            System.out.println("Registro adicionado: M=" + M + ", Tempo=" + tempo + " ms");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }
}
