import java.util.Scanner;
import java.util.Stack;

public class VerificadorExpressao {

    public static boolean verificarExpressao(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                if (pilha.isEmpty()) {
                    return false; // Par�ntese fechando sem par�ntese abrindo correspondente
                } else {
                    char topo = pilha.pop();
                    if ((caractere == ')' && topo != '(') ||
                            (caractere == ']' && topo != '[') ||
                            (caractere == '}' && topo != '{')) {
                        return false; // Par�nteses/colchetes/chaves fechando em ordem errada
                    }
                }
            }
        }

        return pilha.isEmpty(); // Verifica se h� algum par�ntese/colchete/chave aberto sem fechar
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a express�o: ");
        String expressao = scanner.nextLine();

        if (verificarExpressao(expressao)) {
            System.out.println("Express�o correta!");
        } else {
            System.out.println("Express�o incorreta!");
        }
    }
}
