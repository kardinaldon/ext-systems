package servlet.page;

import model.CurrentAccount;
import model.SocialAccount;
import servlet.AbstractController;
import utils.RoutingUtils;
import utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/from-social")
public class FromSocialController extends AbstractController {

    private static final long serialVersionUID = -980555026751956467L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        if (code != null) {
            SocialAccount socialAccount = getSocialService().getSocialAccount(code);
            CurrentAccount currentAccount = getOrderService().authentificate(socialAccount);
            SessionUtils.setCurrentAccount(req, currentAccount);
            RoutingUtils.redirect("/my-orders", req, resp);
        } else {
            LOGGER.warn("Parameter code not found");
            RoutingUtils.redirect("/sign-in", req, resp);
        }
    }
}
