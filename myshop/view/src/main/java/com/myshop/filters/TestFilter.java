package com.myshop.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName="TestFilter", urlPatterns="/*")
public class TestFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        filterConfig.getServletContext();
        System.out.println("filter");
    }
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        req.setAttribute("CURRENT_URL", req.getRequestURI());
        chain.doFilter(request, response);
    }
    public void destroy() {

    }
}
