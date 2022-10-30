package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ecs.Cluster;
import software.amazon.awscdk.services.ecs.ContainerImage;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedFargateService;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedTaskImageOptions;
import software.constructs.Construct;

public class CdkDemoCanaryDeploymentFargateEcsStack extends Stack {
    public CdkDemoCanaryDeploymentFargateEcsStack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public CdkDemoCanaryDeploymentFargateEcsStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);

        Vpc vpc = Vpc.Builder.create(this, "vpc")
                .maxAzs(3)  // Default is all AZs in region
                .build();

        Cluster cluster = Cluster.Builder.create(this, "cluster")
                .vpc(vpc).build();

        // Create a load-balanced Fargate service and make it public
        ApplicationLoadBalancedFargateService.Builder.create(this, "fargateService")
                .cluster(cluster)           // Required
                .cpu(512)                   // Default is 256
                .desiredCount(6)            // Default is 1
                .taskImageOptions(
                        ApplicationLoadBalancedTaskImageOptions.builder()
                                .image(ContainerImage.fromRegistry("amazon/amazon-ecs-sample"))
                                .build())
                .memoryLimitMiB(2048)       // Default is 512
                .publicLoadBalancer(true)   // Default is true
                .build();
    }
}
