# Welcome to your CDK Java project!

This sample demonstrates a CDK app with an instance of a stack (`CdkDemoSqsSnsStack`)
which contains an Amazon SQS queue that is subscribed to an Amazon SNS topic. Everything using a high-level [AWS CDK construct](https://docs.aws.amazon.com/cdk/v2/guide/constructs.html), which we call L2(short for "layer 2")..

To see how to test your stack resources look into src/main/test/java/com/myorg.

The `cdk.json` file tells the CDK Toolkit how to execute your app.

It is a [Maven](https://maven.apache.org/) based project, so you can open this project with any Maven compatible Java IDE to build and run tests.

## Useful commands

 * `mvn package`     compile and run tests
 * `cdk ls`          list all stacks in the app
 * `cdk synth`       emits the synthesized CloudFormation template
 * `cdk deploy`      deploy this stack to your default AWS account/region
 * `cdk diff`        compare deployed stack with current state
 * `cdk docs`        open CDK documentation


