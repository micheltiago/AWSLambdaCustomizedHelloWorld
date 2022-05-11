package helloworld.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * POJO containing response object for API Gateway.
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class GatewayResponse {
    private final String body;
    private final Map<String, String> headers;
    private final int statusCode;
}
