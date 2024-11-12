import java.util.LinkedList;
import java.util.List;

class Encadeamento extends TabelaHash {
    private final List<String>[] tabela;
    private int numColisoes;

    public Encadeamento(int capacity) {
        super(capacity);
        this.tabela = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            tabela[i] = new LinkedList<>();
        }
        this.numColisoes = 0;
    }

    @Override
    public void inserir(String key) {
        int index = hash(key);
        if (!tabela[index].isEmpty()) {
            numColisoes++;
        }
        tabela[index].add(key);
        tamanho++;
    }

    @Override
    public int getColisoes() {
        return numColisoes;
    }
}
