pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }

    stage('Test') {
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }

      }
      steps {
        sh 'mvn test'
        echo 'Test involve the test cases for Email attachment and Multipart Email classes'
      }
    }

    stage('Deliver') {
      steps {
        sh './deliver.sh'
      }
    }

  }
}