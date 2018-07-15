import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClientIntegrationTest {

    private App service;

    @Before
    public void setUp() throws Exception {
        service = new App();
        service.start();
    }

    @After
    public void tearDown() {
        service.shutdown();
    }

    @Test
    public void testHealthcheck() {
        Client c = ClientBuilder.newClient();
        WebTarget target = c.target(App.BASE_URI);

        String response = target.path("query").request().get(String.class);
        System.out.println(response);
        assertThat(response, is("heartbeat"));
    }
}
