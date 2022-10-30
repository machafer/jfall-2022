# Welcome to your CDK Java project!

This example demonstrates how to create and automatically rollout a Java application with jar file archive and canary deployment strategy to test a new release to a small set of users before replacing it entirely.

It has a CDK app with an instance of a stack (`CdkDemoCanaryDeploymentLambdaStack`)
which contains an AWS Lambda using a high-level [AWS CDK construct](https://docs.aws.amazon.com/cdk/v2/guide/constructs.html), which we call L2(short for "layer 2")..

The `cdk.json` file tells the CDK Toolkit how to execute your app.

It is a [Maven](https://maven.apache.org/) based project, so you can open this project with any Maven compatible Java IDE to build and run tests.

## Useful commands

 * `mvn package`     compile and run tests
 * `cdk ls`          list all stacks in the app
 * `cdk synth`       emits the synthesized CloudFormation template
 * `cdk deploy`      deploy this stack to your default AWS account/region
 * `cdk diff`        compare deployed stack with current state
 * `cdk docs`        open CDK documentation

After the deployment, you can test your new API by continually calling the curl against the endpoint URL:

```
while true; do aws lambda invoke --function-name myFunction:prod out --log-type Tail \
--query 'LogResult' --output text |  base64 -d; done

```


