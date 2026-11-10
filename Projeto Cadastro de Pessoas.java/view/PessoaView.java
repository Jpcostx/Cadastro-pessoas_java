package view;

import model.Pessoa;
import java.util.List;
import java.util.Scanner;

public class PessoaView {
    private Scanner scanner;

    public PessoaView() {
        this.scanner = new Scanner(System.in);
    }

    public int menu() {
        System.out.println("\n=== CADASTRO DE PESSOAS ===");
        System.out.println("1. Cadastrar Pessoa");
        System.out.println("2. Listar Pessoas");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Remover Pessoa");
        System.out.println("0. Sair");
        System.out.print("Opção: ");
        return lerInteiro();
    }

    public Pessoa lerDadosPessoa() {
        System.out.print("Informe o ID: ");
        int id = lerInteiro();

        System.out.print("Informe o Nome: ");
        String nome = scanner.nextLine().trim();

        // Valida se o nome está vazio ou se contém números
        while (nome.isEmpty() || !nome.matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
            if (nome.isEmpty()) {
                System.out.print("O nome não pode ser vazio. Digite novamente: ");
            } else {
                System.out.print("O nome não pode conter números ou caracteres especiais. Digite novamente: ");
            }
            nome = scanner.nextLine().trim();
        }

        System.out.print("Informe a Idade: ");
        int idade = lerInteiro();

        System.out.print("Informe a Altura (ex: 1.75): ");
        double altura = lerDouble();

        return new Pessoa(id, nome, idade, altura);
    }

    public int lerId() {
        System.out.print("Informe o ID desejado: ");
        return lerInteiro();
    }

    public void exibirPessoas(List<Pessoa> pessoas) {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }
        System.out.println("\n--- LISTA DE PESSOAS ---");
        for (Pessoa p : pessoas) {
            System.out.println(p);
        }
    }

    public void exibirPessoa(Pessoa pessoa) {
        if (pessoa == null) {
            System.out.println("Pessoa não encontrada.");
        } else {
            System.out.println("\n--- DADOS DA PESSOA ---");
            System.out.println(pessoa);
        }
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    public void exibirErro(String msg) {
        System.err.println("ERRO: " + msg);
    }

    private int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida! Digite um número inteiro: ");
            }
        }
    }

    private double lerDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida! Digite um número decimal válido (ex: 1.75): ");
            }
        }
    }
}