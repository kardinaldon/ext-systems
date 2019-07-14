package servlet.page;

import constants.Constants;
import entity.Product;
import servlet.AbstractController;
import utils.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class AllProductsController extends AbstractController {

    private static final long serialVersionUID = 7008864443846770513L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = getProductService().listAllProducts(1, Constants.MAX_PRODUCTS_PER_HTML_PAGE);
        req.setAttribute("products", products);
        int totalCount = getProductService().countAllProducts();
        req.setAttribute("pageCount", getPageCount(totalCount, Constants.MAX_PRODUCTS_PER_HTML_PAGE));
        RoutingUtils.forwardToPage("products.jsp", req, resp);
    }
}
