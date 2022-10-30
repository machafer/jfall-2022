package com.myorg;

import software.amazon.awscdk.Duration;
import software.amazon.awscdk.Resource;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.apigateway.LambdaRestApi;
import software.amazon.awscdk.services.codedeploy.LambdaDeploymentConfig;
import software.amazon.awscdk.services.codedeploy.LambdaDeploymentGroup;
import software.amazon.awscdk.services.codedeploy.TimeBasedCanaryTrafficRouting;
import software.amazon.awscdk.services.lambda.Alias;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Version;
import software.constructs.Construct;
import software.amazon.awscdk.services.lambda.Runtime;

public class CdkCanaryApiGatewayStack extends Stack {
    public CdkCanaryApiGatewayStack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public CdkCanaryApiGatewayStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);

        Function function = Function.Builder.create(this, "functionLambda")
                .code(Code.fromAsset("./lambda-application/target/lambda-application-0.1.jar"))
                .handler("com.myorg.CdkDemoApiGatewayLambdaHandler")
                .runtime(Runtime.JAVA_11).memorySize(256)
                .functionName("myFunction")
                .timeout(Duration.minutes(5)).build();

        LambdaRestApi api = LambdaRestApi.Builder.create(this, "myapi")
                .handler(function)
                .proxy(false)
                .build();

        Resource hello = api.getRoot().addResource("numbers").addMethod("GET");

        Version version = function.getCurrentVersion();

        Alias alias = Alias.Builder.create(this, "alias")
                .aliasName("prod")
                .version(version)
                .build();

        LambdaDeploymentConfig config = LambdaDeploymentConfig.Builder.create(this, "customConfig")
                .trafficRouting(TimeBasedCanaryTrafficRouting.Builder.create()
                        .interval(Duration.minutes(2))
                        .percentage(5)
                        .build())
                .build();

        LambdaDeploymentGroup.Builder.create(this, "deploymentGroup")
                .alias(alias)
                .deploymentConfig(config)
                .build();

    }
}
