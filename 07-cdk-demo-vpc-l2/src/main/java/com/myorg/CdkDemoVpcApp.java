package com.myorg;

import software.amazon.awscdk.App;

public final class CdkDemoVpcApp {
    public static void main(final String[] args) {
        App app = new App();

        new CdkDemoVpcStack(app, "CdkDemoVpcStack");

        app.synth();
    }
}
