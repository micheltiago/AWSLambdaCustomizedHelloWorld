package helloworld.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * POJO containing response object for API Proxy.
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProxyResponse {
    private final String body;
    private final Map<String, String> headers;
    private final int statusCode;
}
