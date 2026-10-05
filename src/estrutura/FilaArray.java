package estrutura;
import basica.Processo;

public class FilaArray {
        private Processo[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;
    private int capacidade;

    public FilaArray(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new Processo[capacidade];
        this.inicio = 0;
        this.fim = -1;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == capacidade;
    }

    public int getTamanho() {
        return tamanho;
    }

    // 2. Método: Adicionar (enqueue)
    public boolean adicionar(Processo p) {
        if (estaCheia()) {
            System.out.println("[Fila] Buffer de impressão lotado! Não foi possível enfileirar o PID " + p.getPid());
            return false;
        }
        fim = (fim + 1) % capacidade; // Lógica circular
        elementos[fim] = p;
        tamanho++;
        System.out.println("[Fila] Adicionado ao buffer: " + p);
        return true;
    }

    // 2. Método: Remover (dequeue)
    public Processo remover() {
        if (estaVazia()) {
            System.out.println("[Fila] Nenhum processo para imprimir no buffer (Fila vazia).");
            return null;
        }
        Processo removido = elementos[inicio];
        elementos[inicio] = null;
        inicio = (inicio + 1) % capacidade; // Avanço circular
        tamanho--;
        System.out.println("[Fila] Processo impresso/removido: " + removido);
        return removido;
    }

    // 2. Método: Verificar (peek no primeiro elemento)
    public Processo verificar() {
        if (estaVazia()) {
            System.out.println("[Fila] Fila vazia. Nenhum processo no início.");
            return null;
        }
        return elementos[inicio];
    }

    // 2. Método: Mostrar (exibir todos os elementos da fila)
    public void mostrar() {
        if (estaVazia()) {
            System.out.println("[Fila] Buffer de impressora vazio.");
            return;
        }
        System.out.println("--- Fila de Impressão (Início -> Fim) [Total: " + tamanho + "] ---");
        for (int i = 0; i < tamanho; i++) {
            int indiceReal = (inicio + i) % capacidade;
            String marcador = (i == 0) ? " (PRÓXIMO A IMPRIMIR)" : "";
            System.out.println("  Ordem " + (i + 1) + ": " + elementos[indiceReal] + marcador);
        }
        System.out.println("-----------------------------------------------------------------");
    }

    // 2. Método: Inverter a fila utilizando uma Pilha (feita com Array) como auxiliar
    public void inverter() {
        if (estaVazia()) {
            System.out.println("[Fila] Não é possível inverter uma fila vazia.");
            return;
        }

        // Instancia a pilha auxiliar com capacidade suficiente
        PilhaArray pilhaAuxiliar = new PilhaArray(this.capacidade);

        // 1º Passo: Desinfileirar todos os elementos da fila e empilhar na pilha auxiliar
        while (!this.estaVazia()) {
            Processo p = this.removerSilencioso();
            pilhaAuxiliar.empilhar(p);
        }

        // 2º Passo: Desempilhar da pilha e reinserir na fila
        while (!pilhaAuxiliar.estaVazia()) {
            Processo p = pilhaAuxiliar.desempilhar();
            this.adicionarSilencioso(p);
        }

        System.out.println("[Fila] A fila de impressão foi invertida com sucesso usando a Pilha auxiliar!");
    }

    // Métodos auxiliares internos sem log para operação de reversão
    private Processo removerSilencioso() {
        if (estaVazia()) return null;
        Processo removido = elementos[inicio];
        elementos[inicio] = null;
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return removido;
    }

    private void adicionarSilencioso(Processo p) {
        if (estaCheia()) return;
        fim = (fim + 1) % capacidade;
        elementos[fim] = p;
        tamanho++;
    }
}
