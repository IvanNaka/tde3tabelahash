import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/nomes.csv";
        List<String> nomes = lerNomesArquivo(filePath);

        int capacidade = 5001; // Tamanho da tabela hash
        TabelaHash sondagemLinear = new SondagemLinear(capacidade);
        TabelaHash encadeamento = new Encadeamento(capacidade);

        long tempoInicialSL = System.currentTimeMillis();
        for (String name : nomes) {
            sondagemLinear.inserir(name);
        }
        long tempoFinalSL = System.currentTimeMillis();
        long SondagemLinearTempo = tempoFinalSL - tempoInicialSL;

        long tempoInicialEncadeamento = System.currentTimeMillis();
        for (String name : nomes) {
            encadeamento.inserir(name);
        }
        long tempoFinalEncadeamento = System.currentTimeMillis();
        long EncadeamentoTempo = tempoFinalEncadeamento - tempoInicialEncadeamento;

        System.out.println("Relatório de Comparação de Tabelas Hash:");
        System.out.println("Tamanho da Tabela: " + capacidade);
        System.out.println("\nSondagem Linear:");
        System.out.println("Tempo de Inserção: " + SondagemLinearTempo + " ms");
        System.out.println("Colisões: " + sondagemLinear.getColisoes());
        System.out.println("\nEncadeamento:");
        System.out.println("Tempo de Inserção: " + EncadeamentoTempo + " ms");
        System.out.println("Colisões: " + encadeamento.getColisoes());
    }

    private static List<String> lerNomesArquivo(String filePath) {
        List<String> nomes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                nomes.add(linha.trim());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return nomes;
    }
}