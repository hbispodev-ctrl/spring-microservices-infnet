package br.edu.infnet.herick_bispo_aulas.domain;
import java.time.LocalDateTime;

public class Comunicado implements Identificavel {

    private Long id;
    private String titulo;
    private String conteudo;
    private boolean publicado;
    private LocalDateTime dataPublicacao;

    private Turma turma;

    public Comunicado(Long id, String titulo, String conteudo, boolean publicado, LocalDateTime dataPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.publicado = publicado;
        this.dataPublicacao = dataPublicacao;
    }

    public Comunicado() {}

    @Override
    public String toString() {

        String nomeTurma = turma != null ? turma.getNome() : "Sem turma";

        return String.format("Comunicado {titulo= %s, conteudo= %s, publicado= %s, dataPublicacao= %s, turms= %s}",
                titulo,
                conteudo,
                publicado ? "sim": "não",
                dataPublicacao,
                nomeTurma
        );
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
