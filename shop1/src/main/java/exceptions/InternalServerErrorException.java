package exceptions;

public class InternalServerErrorException extends RuntimeException {

    private static final long serialVersionUID = -1533442096084778928L;

    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(Throwable cause) {
        super(cause);
    }

    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }

}
