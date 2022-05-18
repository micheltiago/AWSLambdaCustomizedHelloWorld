package helloworld.util;

import helloworld.dto.ProxyResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadUtils {

    public static String getPageContents(String address) {
        try {
            URL url = new URL(address);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (Exception e) {
            return null;
        }
    }

    public static Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");
        return headers;
    }

    public static ProxyResponse createResponse(String body, Map<String, String> headers, int statusCode) {
        return ProxyResponse
                .builder()
                .body(body)
                .headers(headers)
                .statusCode(statusCode)
                .build();
    }
}
