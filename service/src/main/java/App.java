import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.UriBuilder;

import com.example.QueryResource;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

@ApplicationPath("/")
public class App extends ResourceConfig {

    public static final URI BASE_URI = UriBuilder.fromUri("http://localhost").port(8080).build();
    private HttpServer server;

    public App() {
        ResourceConfig rc = registerResources();

        server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    public void start() throws IOException {
        server.start();
    }

    public void shutdown() {
        server.shutdownNow();
    }

    private ResourceConfig registerResources() {
        return new ResourceConfig(QueryResource.class);
    }

    public static void main(String[] args) throws IOException {
        App service = new App();
        service.start();
    }

}