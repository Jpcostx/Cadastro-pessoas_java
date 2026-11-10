package model;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private double altura;

    public Pessoa(int id, String nome, int idade, double altura) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public String toCSV() {
        return id + ";" + nome + ";" + idade + ";" + altura;
    }

    public static Pessoa fromCSV(String linha) throws NumberFormatException, ArrayIndexOutOfBoundsException {
        String[] partes = linha.split(";");
        int id = Integer.parseInt(partes[0].trim());
        String nome = partes[1].trim();
        int idade = Integer.parseInt(partes[2].trim());
        double altura = Double.parseDouble(partes[3].trim());
        return new Pessoa(id, nome, idade, altura);
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Nome: %s | Idade: %d anos | Altura: %.2fm", id, nome, idade, altura);
    }
}