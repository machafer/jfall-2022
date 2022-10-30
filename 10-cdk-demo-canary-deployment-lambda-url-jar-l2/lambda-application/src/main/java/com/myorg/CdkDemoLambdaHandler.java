package com.myorg;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


import java.util.Random;

public class CdkDemoLambdaHandler  implements RequestHandler<Object, String> {
        Random random = new Random();


@Override
    public String handleRequest(Object event, Context context) {

    String output = String.format("{ \"body\": \"%s\" }", checkNumber());

    return output;
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