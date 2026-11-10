package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    private static final String ARQUIVO = "pessoas.csv";
    private List<Pessoa> pessoas;

    public PessoaDAO() {
        this.pessoas = new ArrayList<>();
        carregarDoArquivo();
    }

    public void adicionar(Pessoa pessoa) throws IOException {
        pessoas.add(pessoa);
        salvarNoArquivo();
    }

    public List<Pessoa> listarTodas() {
        return new ArrayList<>(pessoas);
    }

    public Pessoa buscarPorId(int id) {
        for (Pessoa p : pessoas) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean remover(int id) throws IOException {
        Pessoa p = buscarPorId(id);
        if (p != null) {
            pessoas.remove(p);
            salvarNoArquivo();
            return true;
        }
        return false;
    }

    private void salvarNoArquivo() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Pessoa p : pessoas) {
                writer.write(p.toCSV());
                writer.newLine();
            }
        }
    }

    private void carregarDoArquivo() {
        File file = new File(ARQUIVO);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    try {
                        Pessoa p = Pessoa.fromCSV(linha);
                        pessoas.add(p);
                    } catch (Exception e) {
                        System.err.println("Aviso: Linha corrompida ignorada no CSV -> " + linha);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo: " + e.getMessage());
        }
    }
}