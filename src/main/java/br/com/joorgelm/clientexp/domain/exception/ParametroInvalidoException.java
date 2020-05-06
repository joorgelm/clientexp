package br.com.joorgelm.clientexp.domain.exception;

public class ParametroInvalidoException extends RuntimeException {

    public ParametroInvalidoException(String parametro) {
        super("O parâmetro '" + parametro + "' é inválido.");
    }

    public ParametroInvalidoException(String parametro, String valores) {
        super("O parâmetro '" + parametro + "' é inválido. Os valores possíveis são " + valores);
    }
}
