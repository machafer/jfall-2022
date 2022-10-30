package com.myorg;

import software.amazon.awscdk.App;

public final class CdkCanaryApiGatewayApp {
    public static void main(final String[] args) {
        App app = new App();

        new CdkCanaryApiGatewayStack(app, "CdkCanaryApiGatewayDemoApp");

        app.synth();
    }
}
