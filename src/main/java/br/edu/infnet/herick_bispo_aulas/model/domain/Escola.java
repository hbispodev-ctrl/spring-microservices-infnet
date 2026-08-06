package br.edu.infnet.herick_bispo_aulas.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Escola {

    private String nome;
    private String cidade;
    private boolean ativa;
    private double avaliacao;

    private final List<Turma> turmas = new ArrayList<Turma>();

    public Escola(String nome, String cidade, boolean ativa, double avaliacao) {
        this.nome = nome;
        this.cidade = cidade;
        this.ativa = ativa;
        this.avaliacao = avaliacao;
    }

    public Escola(){}

    public void adicionarTurma(Turma turma){

        if(turma == null){
            throw new IllegalArgumentException("A turma não pode ser nula");
        }

        turmas.add(turma);
        turma.setEscola(this);
    }

    @Override
    public String toString() {

        return String.format("Escola {nome= %s, cidade= %s, ativa= %s, avalicao= %.2f, qtdeTurmas= %d}",
                nome,
                cidade,
                ativa ? "sim": "não",
                avaliacao,
                turmas.size()
        );
    }

    public String getNome() {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Turma> getTurmas() {
        return Collections.unmodifiableList(turmas);
    }


}
