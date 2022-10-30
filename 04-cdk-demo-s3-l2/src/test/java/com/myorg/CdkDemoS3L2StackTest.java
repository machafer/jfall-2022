package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.assertions.Template;
import software.amazon.awscdk.assertions.Match;
import java.io.IOException;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class CdkDemoS3L2StackTest {

    @Test
    public void testStack() throws IOException {
        App app = new App();
        CdkDemoS3L2Stack stack = new CdkDemoS3L2Stack(app, "cdk-demo-s3-l2");

        Template template = Template.fromStack(stack);

        template.hasResourceProperties("AWS::S3::Bucket", Map.of(
                "VersioningConfiguration", Match.objectLike(Map.of(
                        "Status", "Enabled")),
                "BucketName", "cdk-demo-s3-l2")); //you can choose a different bucket name

        template.resourceCountIs("AWS::S3::Bucket", 1);
    }
}
