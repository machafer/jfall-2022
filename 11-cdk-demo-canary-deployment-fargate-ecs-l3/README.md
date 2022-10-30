# Welcome to your CDK Java project!

This example demonstrates a CDK app with an instance of a stack (`CdkDemoCanaryDeploymentFargateEcsStack`)
which contains an Amazon Fargate service running on an ECS cluster using an L3(short for "layer 3") [AWS CDK construct](https://docs.aws.amazon.com/cdk/v2/guide/constructs.html), which we call patterns.

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
URL=$(aws cloudformation describe-stacks --stack-name CdkDemoCanaryDeploymentFargateEcsStack --query "Stacks[0].Outputs[?OutputKey=='fargateServiceLoadBalancerDNS860F106E'].OutputValue" --output text)
curl $URL --w "\n"

```