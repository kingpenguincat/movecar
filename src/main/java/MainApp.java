import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created by 猫猫 on 2017/6/4.
 */
public class MainApp {
    private static int getPort(int defaultPort){
        String port = System.getenv("JERSEY_HTTP_PORT");
        if(null !=port){
            try{
                return Integer.parseInt(port);

            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        return defaultPort;
    }

    private static URI getBaseURI(){
        return UriBuilder.fromUri("http://localhost/").port(getPort(9998)).build();
    }

    public static final URI BASE_URI = getBaseURI();
}
