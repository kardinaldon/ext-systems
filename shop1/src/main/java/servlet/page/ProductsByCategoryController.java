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

@WebServlet("/products/*")
public class ProductsByCategoryController extends AbstractController {

    private static final int SUBSTRING_INDEX = "/products".length();
    private static final long serialVersionUID = 2962129736289381216L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryUrl = req.getRequestURI().substring(SUBSTRING_INDEX);
        List<Product> products = getProductService().listProductsByCategory(categoryUrl, 1, Constants.MAX_PRODUCTS_PER_HTML_PAGE);
        req.setAttribute("products", products);
        req.setAttribute("selectedCategoryUrl", categoryUrl);
        RoutingUtils.forwardToPage("products.jsp", req, resp);
    }
}
