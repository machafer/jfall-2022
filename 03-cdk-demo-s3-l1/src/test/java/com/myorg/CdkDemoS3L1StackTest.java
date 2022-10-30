package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.assertions.Template;
import java.io.IOException;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class CdkDemoS3L1StackTest {

    @Test
    public void testStack() throws IOException {
        App app = new App();
        CdkDemoS3L1Stack stack = new CdkDemoS3L1Stack(app, "cdk-demo-s3-l1");

        Template template = Template.fromStack(stack);

        template.hasResourceProperties("AWS::S3::Bucket", new HashMap<String, String>() {{
          put("BucketName", "cdk-demo-s3-l1");
        }});

        template.resourceCountIs("AWS::S3::Bucket", 1);
    }
}
