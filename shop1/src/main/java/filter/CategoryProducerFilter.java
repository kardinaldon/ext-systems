package filter;


import constants.Constants;
import service.ProductService;
import service.impl.ServiceManager;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
    /*
    This filter is not working, because @WebFilter annotation is absent
    */
    public class CategoryProducerFilter extends AbstractFilter {

        private ProductService productService;

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            productService = ServiceManager.getInstance(filterConfig.getServletContext()).getProductService();
        }

        @Override
        public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
            request.setAttribute(Constants.CATEGORY_LIST, productService.listAllCategories());
            request.setAttribute(Constants.PRODUCER_LIST, productService.listAllProducers());
            chain.doFilter(request, response);
        }
    }
