package exceptions;

public class ValidationException extends IllegalArgumentException {

    private static final long serialVersionUID = -6675830412793348683L;

    public ValidationException(String s) {
        super(s);
    }
}
