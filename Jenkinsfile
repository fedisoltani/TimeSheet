pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        // Run Maven on a Unix agent.
        bat "mvn -Dmaven.test.failure.ignore=true clean package"
      }
    }

    stage('Test') {
      steps {
        script {
          try {
            bat 'mvn test'
            bat 'mvn sonar:sonar'
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
            bat "mvn clean"
            bat "mvn jar:jar deploy:deploy -Dusername=admin -Dpassword=Youssefkhadijafedi.1997*13"
          } catch (Exception e) {
            error("Packaging failed" + e)
          }
        }
      }
    }
    stage('Docker') {
        steps {
            bat 'docker build -t timesheet:v1 .'
        }
    }
  }
}
