package main;

import basica.Processo;
import estrutura.BufferQueueAPI;
import estrutura.FilaArray;
import estrutura.PilhaArray;

public class Principal {
    public static void main(String[] args) {

        executarItens1e2();
        executarItem3();
        executarItem4();
    }


    private static void executarItens1e2() {


        FilaArray bufferFila = new FilaArray(5);

        System.out.println("\n1. Adicionando processos ao buffer:");
        bufferFila.adicionar(new Processo(101, "Relatorio_Financeiro.pdf"));
        bufferFila.adicionar(new Processo(102, "Monografia_Final.docx"));
        bufferFila.adicionar(new Processo(103, "Contrato_Locacao.pdf"));
        bufferFila.adicionar(new Processo(104, "Slide_Apresentacao.pptx"));

        System.out.println("\n2. Mostrando a fila:");
        bufferFila.mostrar();

        System.out.println("\n3. Verificando o próximo processo a imprimir (sem remover):");
        Processo prox = bufferFila.verificar();
        System.out.println("Próximo da fila: " + prox);

        System.out.println("\n4. Imprimindo (removendo) o primeiro processo:");
        bufferFila.remover();
        bufferFila.mostrar();

        System.out.println("\n5. Invertendo a fila usando Pilha baseada em Array como auxiliar:");
        bufferFila.inverter();
        bufferFila.mostrar();

        System.out.println();
    }


    private static void executarItem3() {


        BufferQueueAPI bufferQueue = new BufferQueueAPI(5);

        System.out.println("\n1. Inserindo elementos via Queue API:");
        bufferQueue.adicionar(new Processo(201, "Folha_Pagamento.xlsx"));
        bufferQueue.adicionar(new Processo(202, "Projeto_Arquitetonico.dwg"));
        bufferQueue.adicionar(new Processo(203, "Exame_Admissional.pdf"));

        System.out.println("\n2. Exibindo buffer:");
        bufferQueue.mostrar();

        System.out.println("\n3. Verificando início (peek):");
        System.out.println("No início: " + bufferQueue.verificar());

        System.out.println("\n4. Removendo elemento (poll):");
        bufferQueue.remover();
        bufferQueue.mostrar();

        System.out.println("\n5. Invertendo fila:");
        bufferQueue.inverter();
        bufferQueue.mostrar();

        System.out.println();
    }

    private static void executarItem4() {

        PilhaArray pilhaProcessos = new PilhaArray(5);

        System.out.println("\n1. Empilhando processos (a):");
        pilhaProcessos.empilhar(new Processo(301, "Comprovante_Matricula.pdf"));
        pilhaProcessos.empilhar(new Processo(302, "Historico_Escolar.pdf"));
        pilhaProcessos.empilhar(new Processo(303, "Declaracao_Vinculo.pdf"));

        System.out.println("\n2. Imprimindo elementos da pilha (d):");
        pilhaProcessos.imprimirElementos();

        System.out.println("\n3. Verificando o topo da pilha (c):");
        Processo topo = pilhaProcessos.verificarTop();
        System.out.println("Elemento no topo: " + topo);

        System.out.println("\n4. Desempilhando elementos (b):");
        Processo desempilhado = pilhaProcessos.desempilhar();
        System.out.println("Processo desempilhado: " + desempilhado);

        System.out.println("\n5. Pilha após o desempilhamento:");
        pilhaProcessos.imprimirElementos();

    }
}
