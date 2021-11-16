pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        // Run Maven on a Unix agent.
        sh "mvn -Dmaven.test.failure.ignore=true clean package"
      }
    }

    stage('Test') {
      steps {
        script {
          try {
            sh 'mvn test'
            sh 'mvn sonar:sonar'
          } catch (Exception e) {
            error('Test failed' + e)
          }
        }
      }
    }

    stage('Package') {
      steps {
        script {
          try {
            sh "mvn clean"
            sh "mvn jar:jar deploy:deploy -Dusername=admin -Dpassword=Goldina100g"
          } catch (Exception e) {
            error("Packaging failed" + e)
          }
        }
      }
    }
    stage('Docker') {
        steps {
            sh 'docker build -t yosriksonti/timesheet:v1 .'
            sh 'docker push yosriksonti/timesheet:v1'

        }
    }
  }
}
