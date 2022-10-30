package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.StackProps;

public class CdkCanaryLambdaDemoApp {
    public static void main(final String[] args) {
        App app = new App();

        new CdkCanaryLambdaDemoStack(app, "CdkCanaryLambdaDemoStack", StackProps.builder()
                .build());

        app.synth();
    }
}

