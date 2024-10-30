import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

class CSVLogger {
    private String nomeArquivoDados;
    private String nomeArquivoM;

    // Construtor que define o nome dos arquivos CSV e o diretório
    public CSVLogger(String nomeArquivoDados, String nomeArquivoM) {
        String diretorio = "planilhas";
        // Certifique-se de que o diretório termina com uma barra
        if (!diretorio.endsWith(File.separator)) {
            diretorio += File.separator;
        }
        this.nomeArquivoDados = diretorio + nomeArquivoDados;
        this.nomeArquivoM = diretorio + nomeArquivoM;
        inicializarCSVDados();
        inicializarCSVM();
    }

    // Método para inicializar o arquivo CSV para dados gerais com o cabeçalho, se ele não existir
    private void inicializarCSVDados() {
        File arquivo = new File(nomeArquivoDados);
        if (!arquivo.exists()) {
            new File(arquivo.getParent()).mkdirs();
            try (FileWriter writer = new FileWriter(nomeArquivoDados)) {
                writer.write("Tamanho,Comparações,Trocas,Tempo(ms)\n");
            } catch (IOException e) {
                System.out.println("Erro ao inicializar o arquivo CSV de dados: " + e.getMessage());
            }
        }
    }

    // Método para inicializar o arquivo CSV para M com o cabeçalho, se ele não existir
    private void inicializarCSVM() {
        File arquivo = new File(nomeArquivoM);
        if (!arquivo.exists()) {
            new File(arquivo.getParent()).mkdirs();
            try (FileWriter writer = new FileWriter(nomeArquivoM)) {
                writer.write("M,TempoM(ms)\n");
            } catch (IOException e) {
                System.out.println("Erro ao inicializar o arquivo CSV de M: " + e.getMessage());
            }
        }
    }

    // Método para registrar uma linha com os dados fornecidos
    public void registrarDados(int tamanho, int comparacoes, int trocas, long tempo) {
        try (FileWriter writer = new FileWriter(nomeArquivoDados, true)) {
            writer.write(tamanho + "," + comparacoes + "," + trocas + "," + tempo + "\n");
            System.out.println("Registro adicionado: Tamanho=" + tamanho + ", Comparações=" + comparacoes + ", Trocas="
                    + trocas + ", Tempo=" + tempo + " ms");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo CSV de dados: " + e.getMessage());
        }
    }

    // Método para registrar M e o tempo formatado com ponto em vez de vírgula
    public void registrarM(int M, double tempo) {
        DecimalFormat format = new DecimalFormat("#.#####"); // Define o formato para 5 casas decimais
        String tempoFormatado = format.format(tempo).replace(',', '.');

        try (FileWriter writer = new FileWriter(nomeArquivoM, true)) {
            writer.write(M + "," + tempoFormatado + "\n");
            System.out.println("Registro adicionado: M=" + M + ", TempoM=" + tempoFormatado + " ms");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo CSV de M: " + e.getMessage());
        }
    }
}
