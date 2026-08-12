package br.edu.infnet.herick_bispo_aulas.exception;

public class IdentificadorDublicadoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IdentificadorDublicadoException(String message) {
        super(message);
    }
}
