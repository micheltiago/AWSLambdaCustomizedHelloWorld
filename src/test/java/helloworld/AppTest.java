package helloworld;

import helloworld.dto.ProxyRequest;
import helloworld.dto.ProxyResponse;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void successfulResponse() {

        final String MSG = "{ \"message\": \"hello world\", \"location\": \"%s\" }";

        App app = new App();
        ProxyRequest request = new ProxyRequest("http://checkip.amazonaws.com",MSG);

        ProxyResponse result = app.handleRequest(request, null);

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
    public void errorInvalidHost() {

        App app = new App();
        ProxyRequest request = new ProxyRequest("http://localhost","");

        ProxyResponse response = app.handleRequest(request, null);

        Object expected = 500;

        assertEquals(expected, response.getStatusCode());
    }

    @Test
    public void errorRequestNull() {

        App app = new App();

        ProxyResponse response = app.handleRequest(null, null);

        Object expected = 500;

        assertEquals(expected, response.getStatusCode());
    }
}
