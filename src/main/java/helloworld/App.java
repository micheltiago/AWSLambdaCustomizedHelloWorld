package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import helloworld.dto.ProxyRequest;
import helloworld.dto.ProxyResponse;

import static helloworld.util.ReadUtils.*;
import static java.util.Optional.ofNullable;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<ProxyRequest, ProxyResponse> {
    public ProxyResponse handleRequest(ProxyRequest request, Context context) {
        return ofNullable(request)
                .map(ProxyRequest::getUrl)
                .map(url -> getPageContents(url))
                .map(p -> createResponse(String.format(request.getMsg(), p), getHeaders(), 200))
                .orElse(createResponse("{}", getHeaders(), 500))
                ;
    }
}