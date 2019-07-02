package com.myshop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListenerImpl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext();
        System.out.println("Servlet Context Listener");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext();
    }
}
