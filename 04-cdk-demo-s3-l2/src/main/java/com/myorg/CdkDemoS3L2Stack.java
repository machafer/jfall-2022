package com.myorg;

import software.amazon.awscdk.services.s3.Bucket;
import software.constructs.Construct;
import software.amazon.awscdk.RemovalPolicy;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

public class CdkDemoS3L2Stack extends Stack {
    public CdkDemoS3L2Stack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public CdkDemoS3L2Stack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);
        Bucket.Builder.create(this, "cdk-demo-s3-l2-app")
                .bucketName("cdk-demo-s3-l2")//you can choose a different bucket name
                .versioned(true)
                .removalPolicy(RemovalPolicy.DESTROY)//typically defaulting it to RETAIN.
                .build();
    }
}
