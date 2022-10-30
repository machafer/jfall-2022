package com.myorg;

import software.amazon.awscdk.App;

public final class CdkDemoCanaryDeploymentLambdaApp {
    public static void main(final String[] args) {
        App app = new App();

        new CdkDemoCanaryDeploymentLambdaStack(app, "CdkDemoCanaryDeploymentLambdaStack");

        app.synth();
    }
}
