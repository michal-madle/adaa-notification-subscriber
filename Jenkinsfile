@Library('jenkins-pipeline-java') _
javaPipelineLibrary("java-app"){
    deploy =[
            applicationName : "DCS_K8S_OB",
            applicationProcess : "K8S_INSTALL_OR_UPGRADE",
            componentName: "adaa-notification-subscriber",
            environmentDev : "DEV",
            environmentFat : "SIT"
    ]
    sonar =[
            projectKey : "ob:open-banking-adaa-notification-subscriber",
            projectName : "OPEN-BANKING-ADAA-NOTIFICATION-SUBSCRIBER"
    ]
    buildImage =[
           label : "default"
    ]
}
