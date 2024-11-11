class SondagemLinear extends TabelaHash {
    private String[] table;
    private int collisions;

    public SondagemLinear(int capacity) {
        super(capacity);
        this.table = new String[capacity];
        this.collisions = 0;
    }

    @Override
    public void insert(String key) {
        int index = hash(key);
        int i = 0;
        boolean countedCollision = false; // Marca se a colisão foi contada para esta inserção

        while (table[(index + i) % capacity] != null) {
            // Verifica se já existe o valor na posição atual
            if (table[(index + i) % capacity].equals(key)) {
                return; // Valor já presente na tabela; não há necessidade de reinserir
            }
            if (!countedCollision) { // Conta a colisão apenas uma vez por inserção
                collisions++;
                countedCollision = true;
            }
            i++; // Sondagem linear: próxima posição
        }
        table[(index + i) % capacity] = key;
        size++;
    }
    @Override
    public boolean search(String key) {
        int index = hash(key);
        int i = 0;
        while (table[(index + i) % capacity] != null) {
            if (table[(index + i) % capacity].equals(key)) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public int getCollisions() {
        return collisions;
    }
}