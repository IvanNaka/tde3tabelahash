import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/nomes.csv"; // Caminho para o arquivo CSV
        List<String> names = readNamesFromFile(filePath);

        int capacity = 5001; // Tamanho da tabela hash
        TabelaHash linearProbingTable = new SondagemLinear(capacity);
        TabelaHash chainingTable = new Encadeamento(capacity);

        // Inserção dos nomes nas tabelas hash e medições de tempo
        long startTime = System.currentTimeMillis();
        for (String name : names) {
            linearProbingTable.insert(name);
        }
        long endTime = System.currentTimeMillis();
        long SondagemLinearTempo = endTime - startTime;
//
        startTime = System.currentTimeMillis();
        for (String name : names) {
            chainingTable.insert(name);
        }
        endTime = System.currentTimeMillis();
        long EncadeamentoTempo = endTime - startTime;

        System.out.println("Relatório de Comparação de Tabelas Hash:");
        System.out.println("Tamanho da Tabela: " + capacity);
        System.out.println("\nSondagem Linear:");
        System.out.println("Tempo de Inserção: " + SondagemLinearTempo + " ms");
        System.out.println("Colisões: " + linearProbingTable.getCollisions());

        System.out.println("\nEncadeamento:");
        System.out.println("Tempo de Inserção: " + EncadeamentoTempo + " ms");
        System.out.println("Colisões: " + chainingTable.getCollisions());
    }

    private static List<String> readNamesFromFile(String filePath) {
        List<String> names = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                names.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return names;
    }
}