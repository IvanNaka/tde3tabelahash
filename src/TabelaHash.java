abstract class TabelaHash {
    protected int tamanho;
    protected int capacidade;

    public TabelaHash(int capacity) {
        this.capacidade = capacity;
        this.tamanho = 0;
    }

    abstract void inserir(String key);
    abstract int getColisoes();

    protected int hash(String key) {
        int hash = 7;
        int hashValue = 0;
        for (int i = 0; i < key.length(); i++) {
            hashValue = hash*31 + key.charAt(i);
        }
        return hashValue % capacidade;
    }
}