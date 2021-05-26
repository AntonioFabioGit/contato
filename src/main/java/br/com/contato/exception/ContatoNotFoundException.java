package br.com.contato.exception;

public class ContatoNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 361167219304015671L;

    private String errorCode;
    private String errorMessage;

    public ContatoNotFoundException(Throwable throwable){ super(throwable); }

    public ContatoNotFoundException(String msg){ super(msg); }

    public ContatoNotFoundException(String msg, Throwable throwable){ super(msg, throwable); }

    public ContatoNotFoundException(String errorCode, String errorMessage){
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


}
