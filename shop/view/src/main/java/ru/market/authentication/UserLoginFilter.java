package ru.market.authentication;

import ru.market.authentication.domain.ShopUser;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {UserLoginFilter.USER_FILTER_URI+"*", UserLoginFilter.ADMIN_FILTER_URI+"*"})
public class UserLoginFilter implements Filter {

    protected static final String USER_FILTER_URI = "/user/";
    protected static final String ADMIN_FILTER_URI = "/admin/";


    @Inject
    private AuthBean authBean;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if(authBean.getRole() != null) {

            String uri = request.getRequestURI();
            String beginAdminOfUri = request.getContextPath() + ADMIN_FILTER_URI;
            if (uri.startsWith(beginAdminOfUri) && authBean.getRole() != ShopUser.Role.ADMIN) {
                response.sendRedirect(request.getContextPath()+"/errors.xhtml");
                return;
            }

            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }





        authBean.setRequestedPage(request.getRequestURI());
        response.sendRedirect(request.getContextPath()+"/login.xhtml");
    }

    @Override
    public void destroy() {
        //
    }
}
