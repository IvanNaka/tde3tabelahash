import java.util.LinkedList;
import java.util.List;

// Implementação de HashTable usando encadeamento
class Encadeamento extends TabelaHash {
    private List<String>[] table;
    private int collisions;

    public Encadeamento(int capacity) {
        super(capacity);
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        this.collisions = 0;
    }

    @Override
    public void insert(String key) {
        int index = hash(key);
        if (!table[index].isEmpty()) {
            collisions++;
        }
        table[index].add(key);
        size++;
    }

    @Override
    public boolean search(String key) {
        int index = hash(key);
        return table[index].contains(key);
    }

    @Override
    public int getCollisions() {
        return collisions;
    }
}
