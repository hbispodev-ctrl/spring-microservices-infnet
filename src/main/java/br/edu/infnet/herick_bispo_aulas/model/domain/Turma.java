package br.edu.infnet.herick_bispo_aulas.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Turma {

    private String nome;
    private int anoLetivo;
    private boolean ativa;

    private Escola escola;

    private List<Comunicado> comunicados = new ArrayList<Comunicado>();

    public Turma(String nome, int anoLetivo, boolean ativa) {
        this.nome = nome;
        this.anoLetivo = anoLetivo;
        this.ativa = ativa;
    }

    public Turma (){}

    public void adicionarComunicado(Comunicado comunicado){
        if( comunicado == null){
            throw new IllegalArgumentException("O comunicado não pode ser nulo.");
        }

        comunicados.add(comunicado);
        comunicado.setTurma(this);
    }

    @Override
    public String toString() {

        String nomeEscola = escola != null ? getNome() : "Sem escola";

        return String.format("Turma {nome= %s, anoLetivo= %d, ativa= %s, escola= %s, comunicados= %d}",
                nome,
                anoLetivo,
                ativa ? "sim": "não",
                nomeEscola,
                comunicados.size()
        );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public List<Comunicado> getComunicados() {
        return Collections.unmodifiableList(comunicados);
    }

    public void setComunicados(List<Comunicado> comunicados) {
        this.comunicados = comunicados;
    }
}
