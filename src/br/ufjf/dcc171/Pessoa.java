package br.ufjf.dcc171;

public class Pessoa {
    private String nome;
    private Integer idade;
    private String email;

    public Pessoa() {
        this(null, null, null);
    }

    public Pessoa(String nome, Integer idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
