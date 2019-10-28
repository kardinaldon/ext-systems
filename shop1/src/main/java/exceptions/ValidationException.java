package exceptions;

import javax.servlet.http.HttpServletResponse;

public class ValidationException extends AbstractApplicationException {

    private static final long serialVersionUID = -6675830412793348683L;

    public ValidationException(String s) {
        super(s, HttpServletResponse.SC_BAD_REQUEST);
    }
}
