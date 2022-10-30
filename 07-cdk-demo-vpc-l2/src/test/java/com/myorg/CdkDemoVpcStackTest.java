package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.assertions.Template;
import software.amazon.awscdk.assertions.Match;
import java.io.IOException;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class CdkDemoVpcStackTest {

    @Test
    public void testStack() throws IOException {
        App app = new App();
        CdkDemoVpcStack stack = new CdkDemoVpcStack(app, "test");

        Template template = Template.fromStack(stack);

        template.hasResourceProperties("AWS::EC2::VPC", new HashMap<String, String>() {{
          put("CidrBlock", "10.0.0.0/16");
        }});

        template.resourceCountIs("AWS::EC2::VPC", 1);
    }
}
