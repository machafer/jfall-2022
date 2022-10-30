package com.myorg;

import software.amazon.awscdk.App;

public final class CdkDemoSqsSnsApp {
    public static void main(final String[] args) {
        App app = new App();

        new CdkDemoSqsSnsStack(app, "CdkDemoSqsSnsStack");

        app.synth();
    }
}
