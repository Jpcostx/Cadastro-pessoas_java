package controller;

import model.Pessoa;
import model.PessoaDAO;
import view.PessoaView;
import java.io.IOException;
import java.util.List;

public class PessoaController {
    private PessoaDAO model;
    private PessoaView view;

    public PessoaController(PessoaDAO model, PessoaView view) {
        this.model = model;
        this.view = view;
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = view.menu();
            processarOpcao(opcao);
        } while (opcao != 0);
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarPessoa();
            case 2 -> listarPessoas();
            case 3 -> buscarPessoa();
            case 4 -> removerPessoa();
            case 0 -> view.exibirMensagem("Saindo do programa...");
            default -> view.exibirErro("Opção inválida.");
        }
    }

    private void cadastrarPessoa() {
        try {
            Pessoa pessoa = view.lerDadosPessoa();
            if (model.buscarPorId(pessoa.getId()) != null) {
                view.exibirErro("Já existe um registro com o ID " + pessoa.getId());
                return;
            }
            model.adicionar(pessoa);
            view.exibirMensagem("Pessoa cadastrada com sucesso!");
        } catch (IOException e) {
            view.exibirErro("Erro ao salvar no arquivo pessoas.csv: " + e.getMessage());
        }
    }

    private void listarPessoas() {
        List<Pessoa> pessoas = model.listarTodas();
        view.exibirPessoas(pessoas);
    }

    private void buscarPessoa() {
        int id = view.lerId();
        Pessoa pessoa = model.buscarPorId(id);
        view.exibirPessoa(pessoa);
    }

    private void removerPessoa() {
        int id = view.lerId();
        try {
            boolean removido = model.remover(id);
            if (removido) {
                view.exibirMensagem("Pessoa removida com sucesso!");
            } else {
                view.exibirErro("Nenhum registro encontrado para o ID " + id);
            }
        } catch (IOException e) {
            view.exibirErro("Erro ao atualizar o arquivo após a remoção: " + e.getMessage());
        }
    }
}