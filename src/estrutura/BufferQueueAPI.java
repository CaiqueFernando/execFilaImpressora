package estrutura;
import basica.Processo;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BufferQueueAPI {
    private Queue<Processo> fila;
    private int capacidadeMaxima;

    public BufferQueueAPI(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        // LinkedList implementa a interface Queue no Java SE
        this.fila = new LinkedList<>();
    }

    // Adicionar (enqueue)
    public boolean adicionar(Processo p) {
        if (fila.size() >= capacidadeMaxima) {
            System.out.println("[Queue API] Buffer cheio! Não foi possível adicionar " + p.getPid());
            return false;
        }
        boolean inserido = fila.offer(p);
        System.out.println("[Queue API] Processo enfileirado: " + p);
        return inserido;
    }

    // Remover (dequeue)
    public Processo remover() {
        if (fila.isEmpty()) {
            System.out.println("[Queue API] Buffer vazio, nada para imprimir.");
            return null;
        }
        Processo removido = fila.poll();
        System.out.println("[Queue API] Processo impresso/removido: " + removido);
        return removido;
    }

    // Verificar (peek)
    public Processo verificar() {
        if (fila.isEmpty()) {
            System.out.println("[Queue API] Fila vazia.");
            return null;
        }
        return fila.peek();
    }

    // Mostrar
    public void mostrar() {
        if (fila.isEmpty()) {
            System.out.println("[Queue API] Buffer de impressão vazio.");
            return;
        }
        System.out.println("--- Fila via java.util.Queue [Total: " + fila.size() + "] ---");
        int posicao = 1;
        for (Processo p : fila) {
            String tag = (posicao == 1) ? " (PRÓXIMO)" : "";
            System.out.println("  " + posicao + "º elemento: " + p + tag);
            posicao++;
        }
        System.out.println("-------------------------------------------------------------");
    }

    // Inverter fila com pilha auxiliar (java.util.Stack)
    public void inverter() {
        if (fila.isEmpty()) {
            System.out.println("[Queue API] Fila vazia, impossível inverter.");
            return;
        }
        Stack<Processo> pilhaAuxiliar = new Stack<>();
        while (!fila.isEmpty()) {
            pilhaAuxiliar.push(fila.poll());
        }
        while (!pilhaAuxiliar.isEmpty()) {
            fila.offer(pilhaAuxiliar.pop());
        }
        System.out.println("[Queue API] Fila invertida com sucesso utilizando java.util.Stack!");
    }
}
