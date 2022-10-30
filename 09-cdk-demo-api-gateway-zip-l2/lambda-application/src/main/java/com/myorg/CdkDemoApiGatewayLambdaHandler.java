package com.myorg;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse;

import java.util.Map;
import java.util.Random;

public class CdkDemoApiGatewayLambdaHandler implements RequestHandler<APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse> {
    Random random = new Random();

    @Override
    public APIGatewayV2HTTPResponse handleRequest(APIGatewayV2HTTPEvent event, Context context) {
        return APIGatewayV2HTTPResponse.builder()
                .withStatusCode(200)
                .withHeaders(Map.of("Content-Type", "application/json"))
                .withBody(checkNumber())
                .build();
    }

    private String checkNumber(){
        String output = "Alpha version in production: ";
        int number = random.nextInt(6);
        if(number % 2 == 0)
            return output+ (number + " is even");
        else
            return output+ (number + " is odd");
    }
}
