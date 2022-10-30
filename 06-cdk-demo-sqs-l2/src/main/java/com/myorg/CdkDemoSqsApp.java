package com.myorg;

import software.amazon.awscdk.App;

public final class CdkDemoSqsApp {
    public static void main(final String[] args) {
        App app = new App();

        new CdkDemoSqsStack(app, "CdkDemoSqsStack");

        app.synth();
    }
}
