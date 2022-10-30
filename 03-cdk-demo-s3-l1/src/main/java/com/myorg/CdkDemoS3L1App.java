package com.myorg;

import software.amazon.awscdk.App;

public final class CdkDemoS3L1App {
    public static void main(final String[] args) {
        App app = new App();

        new CdkDemoS3L1Stack(app, "CdkDemoS3L1Stack");

        app.synth();
    }
}
