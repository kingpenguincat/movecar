import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Created by 猫猫 on 2017/6/4.
 */
public class MainService {
    public static final Logger LOGGER = LoggerFactory.getLogger(MainService.class);

    public void start() throws Exception {

        try {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("OpenPlatformNotifyService initializing");
            }
            initWebservice();

        } catch (Exception e) {
            LOGGER.error("start error:", e);
        }
    }

    private void initWebservice() throws Exception {
        int port = 8899;
        Server server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        ServletHolder sh = new ServletHolder(ServletContainer.class);
        sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
        sh.setInitParameter("com.sun.jersey.config.property.packages", "HelloWorldResource");

        context.addServlet(sh, "/*");


        server.start();
        System.out.println("server start");
    }

    public void stop() throws Exception {

    }

    public static void main(String[] args) throws Exception {
        MainService server = new MainService();
        server.start();
    }
}
