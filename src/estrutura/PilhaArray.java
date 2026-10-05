package estrutura;
import basica.Processo;

public class PilhaArray {
        private Processo[] elementos;
    private int topo;
    private int capacidade;

    public PilhaArray(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new Processo[capacidade];
        this.topo = -1; 
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public boolean estaCheia() {
        return topo == capacidade - 1;
    }

    public int getTamanho() {
        return topo + 1;
    }

 
    public boolean empilhar(Processo p) {
        if (estaCheia()) {
            System.out.println("[Pilha] Erro: Buffer de pilha cheio. Não foi possível empilhar o processo " + p.getPid());
            return false;
        }
        elementos[++topo] = p;
        return true;
    }


    public Processo desempilhar() {
        if (estaVazia()) {
            System.out.println("[Pilha] Erro: Pilha vazia. Nenhum processo para desempilhar.");
            return null;
        }
        Processo removido = elementos[topo];
        elementos[topo] = null; 
        topo--;
        return removido;
    }

    public Processo verificarTop() {
        if (estaVazia()) {
            System.out.println("[Pilha] Pilha vazia. Não há elemento no topo.");
            return null;
        }
        return elementos[topo];
    }

    public void imprimirElementos() {
        if (estaVazia()) {
            System.out.println("[Pilha] A pilha está vazia.");
            return;
        }
        System.out.println("--- Estado Atual da Pilha (Topo -> Base) ---");
        for (int i = topo; i >= 0; i--) {
            String indicador = (i == topo) ? " (TOPO)" : "";
            System.out.println("  Posição [" + i + "]: " + elementos[i] + indicador);
        }

    }
}
