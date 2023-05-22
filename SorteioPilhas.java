import java.util.Random;
import java.util.Stack;

public class SorteioPilhas {

    public static void main(String[] args) {
        Stack<Integer> pilha1 = new Stack<>();
        Stack<Integer> pilha2 = new Stack<>();
        Stack<Integer> pilha3 = new Stack<>();

        Random random = new Random();

        // Fase 1: Sorteio dos números de 1 a 9 e armazenamento nas pilhas correspondentes
        for (int i = 0; i < 100; i++) {
            int numeroSorteado = random.nextInt(9) + 1;

            if (numeroSorteado >= 1 && numeroSorteado <= 3) {
                pilha1.push(numeroSorteado);
            } else if (numeroSorteado >= 4 && numeroSorteado <= 6) {
                pilha2.push(numeroSorteado);
            } else {
                pilha3.push(numeroSorteado);
            }
        }

        // Fase 2: Sorteio dos números de 1 a 3 para determinar qual pilha será utilizada
        int contadorSorteio = 0;
        while (!pilha1.isEmpty() && !pilha2.isEmpty() && !pilha3.isEmpty() && contadorSorteio < 100) {
            int numeroSorteio = random.nextInt(3) + 1;

            if (numeroSorteio == 1) {
                if (!pilha2.isEmpty() && !pilha3.isEmpty()) {
                    int topoPilha2 = pilha2.pop();
                    int topoPilha3 = pilha3.pop();
                    pilha1.push(topoPilha2);
                    pilha1.push(topoPilha3);
                    System.out.println("Empilhando os números " + topoPilha2 + " e " + topoPilha3 + " na pilha 1");
                }
            } else if (numeroSorteio == 2) {
                if (!pilha1.isEmpty() && !pilha3.isEmpty()) {
                    int topoPilha1 = pilha1.pop();
                    int topoPilha3 = pilha3.pop();
                    pilha2.push(topoPilha1);
                    pilha2.push(topoPilha3);
                    System.out.println("Empilhando os números " + topoPilha1 + " e " + topoPilha3 + " na pilha 2");
                }
            } else {
                if (!pilha1.isEmpty() && !pilha2.isEmpty()) {
                    int topoPilha1 = pilha1.pop();
                    int topoPilha2 = pilha2.pop();
                    pilha3.push(topoPilha1);
                    pilha3.push(topoPilha2);
                    System.out.println("Empilhando os números " + topoPilha1 + " e " + topoPilha2 + " na pilha 3");
                }
            }

            contadorSorteio++;
        }

        // Impressão das pilhas
        System.out.println("\nPilha 1:");
        while (!pilha1.isEmpty()) {
            System.out.println(pilha1.pop());
        }

        System.out.println("\nPilha 2:");
        while (!pilha2.isEmpty()) {
            System.out.println(pilha2.pop());
        }

        System.out.println("\nPilha 3:");
        while (!pilha3.isEmpty()) {
            System.out.println(pilha3.pop());
        }

        // Verificação do motivo de encerramento do programa
        if (pilha1.isEmpty() || pilha2.isEmpty() || pilha3.isEmpty()) {
            System.out.println("\nO programa foi encerrado porque uma das pilhas ficou vazia.");
        } else {
            System.out.println("\nO programa foi encerrado porque o total de números sorteados foi atingido.");
        }
    }
}
