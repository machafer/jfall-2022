package com.myorg;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Random;

public class CdkDemoLambdaHandler implements RequestHandler<Object, String> {

    Random random = new Random();

    @Override
    public String handleRequest(Object o, Context context) {
        System.out.println("Alpha version in production");
        int number = random.nextInt(6);
        if(number % 2 == 0)
            System.out.println(number + " is even");
        else
            System.out.println(number + " is odd");
        return "success";
    }
}