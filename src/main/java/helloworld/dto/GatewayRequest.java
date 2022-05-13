package helloworld.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GatewayRequest {
    private String url;
    private String msg;

    public GatewayRequest(String url, String msg) {
        this.url = url;
        this.msg = msg;
    }
}
