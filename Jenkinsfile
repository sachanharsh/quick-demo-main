pipeline {
  agent any

  tools {
    // make sure JDK 11 is installed on your Jenkins nodes
    jdk 'jdk11'
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Run Automation') {
      steps {
        // ensure our script is executable
        sh 'chmod +x run.sh'
        // run the script
        sh './run.sh'
      }
    }
  }

  post {
    always {
      // publish TestNG or Surefire reports
      junit '**/target/surefire-reports/*.xml'
      // archive any built jars
      archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
    }
  }
}
