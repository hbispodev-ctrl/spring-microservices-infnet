package br.edu.infnet.herick_bispo_aulas.domain;

public class Pessoa implements Identificavel{

    private Long id;
    private String nome;
    private String email;

    public Pessoa(){}

    public Pessoa(Long id, String nome, String email) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toString() {

        return String.format("nome= %s, email= %s",
                nome,
                email
        );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
