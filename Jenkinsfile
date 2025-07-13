pipeline {
  agent {
    docker {
      image 'maven:3.8.8-openjdk-11'
      args '-v $HOME/.m2:/root/.m2'
    }
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Run Automation') {
      steps {
        // run directly with mvn (no mvnw needed)
        sh 'mvn clean test -B'
      }
    }
  }

  post {
    always {
      junit '**/target/surefire-reports/*.xml'
      archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
    }
  }
}
