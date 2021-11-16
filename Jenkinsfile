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
            sh "mvn jar:jar deploy:deploy -Dusername=admin -Dpassword=Youssefkhadijafedi.1997*13"
          } catch (Exception e) {
            error("Packaging failed" + e)
          }
        }
      }
    }
    stage('Docker') {
        steps {
            sh 'docker build -t timesheet:v1 .'
        }
    }
  }
}
