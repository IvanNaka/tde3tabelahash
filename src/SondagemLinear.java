class SondagemLinear extends TabelaHash {
    private String[] tabela;
    private int numColisoes;

    public SondagemLinear(int capacity) {
        super(capacity);
        this.tabela = new String[capacity];
        this.numColisoes = 0;
    }

    @Override
    public void inserir(String key) {
        int index = hash(key);
        int i = 0;
        boolean colisaoContada = false;

        while (tabela[(index + i) % capacidade] != null) {
            if (tabela[(index + i) % capacidade].equals(key)) {
                return;
            }
            if (!colisaoContada) {
                numColisoes++;
                colisaoContada = true;
            }
            i++;
        }
        tabela[(index + i) % capacidade] = key;
        tamanho++;
    }
    @Override
    public int getColisoes() {
        return numColisoes;
    }
}