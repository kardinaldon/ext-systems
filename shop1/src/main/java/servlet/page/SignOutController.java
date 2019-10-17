package servlet.page;

import servlet.AbstractController;
import utils.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign-out")
public class SignOutController extends AbstractController {

    private static final long serialVersionUID = -3857930706721407434L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        RoutingUtils.redirect("/products", req, resp);
    }
}
