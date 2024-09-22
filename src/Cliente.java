import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cliente {
    private EstrategiaOrdenacao estrategia;

    public void setEstrategia(EstrategiaOrdenacao estrategia) {
        this.estrategia = estrategia;
    }

    public void executarOrdenacao(int[] array) {
        if (estrategia == null) {
            throw new IllegalStateException("Estratégia de ordenação não definida.");
        }
        estrategia.ordenar(array);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();

        Map<Integer, EstrategiaOrdenacao> estrategias = new HashMap<>();
        estrategias.put(1, new InsertionSort());
        estrategias.put(2, new SelectionSort());
        estrategias.put(3, new BubbleSort());

        System.out.println("Escolha o algoritmo de ordenação:");
        System.out.println("1: Insertion Sort");
        System.out.println("2: Selection Sort");
        System.out.println("3: Bubble Sort");

        int escolha = scanner.nextInt();

        cliente.setEstrategia(estrategias.get(escolha));


        System.out.println("Digite o tamanho do array:");
        int tamanho = scanner.nextInt();
        int[] array = new int[tamanho];

        System.out.println("Digite os elementos do array:");
        for (int i = 0; i < tamanho; i++) {
            array[i] = scanner.nextInt();
        }

        cliente.executarOrdenacao(array);

        System.out.println("Array ordenado:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
