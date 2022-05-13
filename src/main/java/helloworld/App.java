package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import helloworld.dto.GatewayRequest;
import helloworld.dto.GatewayResponse;

import static helloworld.util.ReadUtils.*;
import static java.util.Optional.ofNullable;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<GatewayRequest, GatewayResponse> {
    public GatewayResponse handleRequest(GatewayRequest request, Context context) {
        return ofNullable(getPageContents(request.getUrl()))
                .map(silva -> createResponse(String.format(request.getMsg(), silva), getHeaders(), 200))
                .orElse(createResponse("{}", getHeaders(), 500))
                ;
    }
}