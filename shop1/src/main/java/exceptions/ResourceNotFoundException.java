package exceptions;

import javax.servlet.http.HttpServletResponse;

public class ResourceNotFoundException extends AbstractApplicationException {

    private static final long serialVersionUID = -7276934995576677248L;

    public ResourceNotFoundException(String s) {
        super(s, HttpServletResponse.SC_NOT_FOUND);
    }
}
