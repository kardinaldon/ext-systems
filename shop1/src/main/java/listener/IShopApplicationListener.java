package listener;

import constants.Constants;
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
            sce.getServletContext().setAttribute(Constants.CATEGORY_LIST, serviceManager.getProductService().listAllCategories());
            sce.getServletContext().setAttribute(Constants.PRODUCER_LIST, serviceManager.getProductService().listAllProducers());
        } catch (RuntimeException e) {
            LOGGER.error("Web application init failed: "+e.getMessage(), e);
            throw e;
        }
        LOGGER.info("Web application initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        serviceManager.close();
        LOGGER.info("Web application destroyed");
    }
}
