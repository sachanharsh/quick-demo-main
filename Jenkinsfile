pipeline {
  agent any
  
    parameters {
    string(
      name: 'DUMMY',
      defaultValue: 'hello-world',
      description: 'A dummy parameter for demo'
    )
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