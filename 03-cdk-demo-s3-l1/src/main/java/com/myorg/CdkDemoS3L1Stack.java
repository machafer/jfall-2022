package com.myorg;

import software.amazon.awscdk.services.s3.CfnBucket;
import software.constructs.Construct;
import software.amazon.awscdk.RemovalPolicy;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

public class CdkDemoS3L1Stack extends Stack {
    public CdkDemoS3L1Stack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public CdkDemoS3L1Stack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);

        CfnBucket cfnBucket = new CfnBucket(this, "cdk-demo-s3-l1-app");
        cfnBucket.setBucketName("cdk-demo-s3-l1");
        cfnBucket.applyRemovalPolicy(RemovalPolicy.DESTROY);//typically defaulting it to RETAIN.
    }
}
