package com.myorg;

import software.amazon.awscdk.App;

public final class CdkDemoS3L2App {
    public static void main(final String[] args) {
        App app = new App();

        new CdkDemoS3L2Stack(app, "CdkDemoS3L2Stack");

        app.synth();
    }
}
