package com.myorg;

import software.amazon.awscdk.Duration;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.codedeploy.CustomLambdaDeploymentConfig;
import software.amazon.awscdk.services.codedeploy.CustomLambdaDeploymentConfigType;
import software.amazon.awscdk.services.codedeploy.LambdaDeploymentGroup;
import software.amazon.awscdk.services.lambda.Alias;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Version;
import software.amazon.awscdk.services.lambda.Runtime;
import software.constructs.Construct;

public class CdkCanaryLambdaDemoStack extends Stack {
    public CdkCanaryLambdaDemoStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public CdkCanaryLambdaDemoStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        Function function = Function.Builder.create(this, "functionLambda")
                .code(Code.fromAsset("./lambda-application/target/lambda-application-0.1.jar"))
                .handler("com.myorg.CdkDemoLambdaHandler")
                .runtime(Runtime.JAVA_11).memorySize(256)
                .functionName("myFunction")
                .timeout(Duration.minutes(5)).build();
        Version version = function.getCurrentVersion();
        Alias alias = Alias.Builder.create(this, "alias")
                .aliasName("prod")
                .version(version)
                .build();
        CustomLambdaDeploymentConfig config = CustomLambdaDeploymentConfig.Builder.create(this, "customConfig")
                .type(CustomLambdaDeploymentConfigType.CANARY)
                .interval(Duration.minutes(2))
                .percentage(5)
                .build();
        LambdaDeploymentGroup.Builder.create(this, "deploymentGroup")
                .alias(alias)
                .deploymentConfig(config)
                .build();

    }
}
