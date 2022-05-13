package helloworld;

import helloworld.dto.GatewayRequest;
import helloworld.dto.GatewayResponse;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void successfulResponse() {

        final String MSG = "{ \"message\": \"hello world\", \"location\": \"%s\" }";

        App app = new App();
        GatewayRequest request = new GatewayRequest("http://checkip.amazonaws.com",MSG);

        GatewayResponse result = app.handleRequest(request, null);

        Object expected = 200;

        assertEquals(expected, result.getStatusCode());
        assertEquals(result.getHeaders().get("Content-Type"), "application/json");

        String content = result.getBody();

        assertNotNull(content);
        assertTrue(content.contains("\"message\""));
        assertTrue(content.contains("\"hello world\""));
        assertTrue(content.contains("\"location\""));
        assertTrue(content.contains("\"189.6.250.96\""));
    }

    @Test
    public void errorResponse() {

        App app = new App();
        GatewayRequest request = new GatewayRequest("http://localhost","");

        GatewayResponse response = app.handleRequest(request, null);

        Object expected = 500;

        assertEquals(expected, response.getStatusCode());
    }
}
