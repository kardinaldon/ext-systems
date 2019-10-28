package servlet.ajax;

import constants.Constants;
import entity.Orders;
import servlet.AbstractController;
import utils.RoutingUtils;
import utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ajax/html/more/my-orders")
public class MyOrdersMoreController extends AbstractController {

    private static final long serialVersionUID = -6611481572806112858L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Orders> orders = getOrderService().listMyOrders(SessionUtils.getCurrentAccount(req), getPage(req), Constants.ORDERS_PER_PAGE);
        req.setAttribute("orders", orders);
        RoutingUtils.forwardToFragment("my-orders-tbody.jsp", req, resp);
    }
}
