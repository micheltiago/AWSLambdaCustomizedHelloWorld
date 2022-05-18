package helloworld.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * POJO containing response object for API Proxy.
 */
@Getter
@Setter
public class ProxyRequest {
    private String url;
    private String msg;

    public ProxyRequest(String url, String msg) {
        this.url = url;
        this.msg = msg;
    }
}
