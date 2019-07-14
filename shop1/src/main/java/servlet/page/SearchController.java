package servlet.page;

import constants.Constants;
import entity.Product;
import form.SearchForm;
import servlet.AbstractController;
import utils.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchController extends AbstractController {


    private static final long serialVersionUID = -1594420159779203134L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SearchForm searchForm = createSearchForm(req);
        List<Product> products = getProductService().listProductsBySearchForm(searchForm, 1, Constants.MAX_PRODUCTS_PER_HTML_PAGE);
        req.setAttribute("products", products);
        int totalCount = getProductService().countProductsBySearchForm(searchForm);
        req.setAttribute("pageCount", getPageCount(totalCount, Constants.MAX_PRODUCTS_PER_HTML_PAGE));
        req.setAttribute("productCount", totalCount);
        req.setAttribute("searchForm", searchForm);
        RoutingUtils.forwardToPage("search-result.jsp", req, resp);
    }
}
