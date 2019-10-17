package exceptions;

import javax.servlet.http.HttpServletResponse;

public class AccessDeniedException extends AbstractApplicationException {


    private static final long serialVersionUID = -3556668130366453637L;

    public AccessDeniedException(String s) {
        super(s, HttpServletResponse.SC_FORBIDDEN);
    }
}
