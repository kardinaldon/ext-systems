package listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.impl.ServiceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class IShopApplicationListener implements ServletContextListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(IShopApplicationListener.class);
    private ServiceManager serviceManager;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            serviceManager = ServiceManager.getInstance(sce.getServletContext());
        } catch (RuntimeException e) {
            LOGGER.error("Web application 'shop' init failed: "+e.getMessage(), e);
            throw e;
        }
        LOGGER.info("Web application 'shop' initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        serviceManager.close();
        LOGGER.info("Web application 'shop' destroyed");
    }
}
