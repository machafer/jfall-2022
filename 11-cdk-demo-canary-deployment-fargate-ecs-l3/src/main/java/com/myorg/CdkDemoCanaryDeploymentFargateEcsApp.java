package com.myorg;

import software.amazon.awscdk.App;

public final class CdkDemoCanaryDeploymentFargateEcsApp {
    public static void main(final String[] args) {
        App app = new App();

        new CdkDemoCanaryDeploymentFargateEcsStack(app, "CdkDemoCanaryDeploymentFargateEcsStack");

        app.synth();
    }
}
