abstract class TabelaHash {
    protected int size;
    protected int capacity;

    public TabelaHash(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    abstract void insert(String key);
    abstract boolean search(String key);
    abstract int getCollisions();

    // Função hash personalizada
    protected int hash(String key) {
        int hash = 7;
        int hashValue = 0;
        for (int i = 0; i < key.length(); i++) {
            hashValue = hash*31 + key.charAt(i);
        }
        return hashValue % capacity; // Calcula o índice com base na capacidade da tabela
    }
}