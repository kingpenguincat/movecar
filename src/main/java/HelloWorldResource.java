import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by 猫猫 on 2017/6/4.
 */
@Path("helloworld")
public class HelloWorldResource {
    @GET
    @Produces("text/plain")
    public String getClichedMessage(){
        return "hello world,fuck u";
    }

}
