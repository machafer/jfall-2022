package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.constructs.Construct;

public class CdkDemoVpcStack extends Stack {
    public CdkDemoVpcStack(final Construct parent, final String id) {
        this(parent, id, null);
    }
    public CdkDemoVpcStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);

        final Vpc vpc = Vpc.Builder.create(this, "vpc")
                .cidr("10.0.0.0/16")
                .build();
    }
}
