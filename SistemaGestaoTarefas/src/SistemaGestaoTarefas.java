import java.util.ArrayList;
import java.util.Scanner;

class Tarefa {
    private String descricao;

    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

class GerenciadorTarefas {
    private ArrayList<Tarefa> tarefas;

    public GerenciadorTarefas() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        tarefas.add(novaTarefa);
        System.out.println("Tarefa adicionada: " + descricao);
    }

    public void listarTarefas() {
        System.out.println("Lista de Tarefas:");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println((i + 1) + ". " + tarefas.get(i).getDescricao());
            System.out.println("---------------------");
        }
    }

    public void removerTarefa(int indice) {
        if (indice >= 1 && indice <= tarefas.size()) {
            String descricaoRemovida = tarefas.get(indice - 1).getDescricao();
            tarefas.remove(indice - 1);
            System.out.println("Tarefa removida: " + descricaoRemovida);
        } else {
            System.out.println("Índice inválido.");
        }
    }
}

public class SistemaGestaoTarefas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        int opcao;

        do {
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Remover Tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    gerenciador.adicionarTarefa(descricao);
                    break;
                case 2:
                    gerenciador.listarTarefas();
                    break;
                case 3:
                    gerenciador.listarTarefas();
                    System.out.print("Digite o número da tarefa a ser removida: ");
                    int indice = scanner.nextInt();
                    gerenciador.removerTarefa(indice);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
