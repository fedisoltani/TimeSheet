pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        // Run Maven on a Unix agent.
        call "mvn -Dmaven.test.failure.ignore=true clean package"
      }
    }

    stage('Test') {
      steps {
        script {
          try {
            call 'mvn test'
            call 'mvn sonar:sonar'
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
            call "mvn clean"
            call "mvn jar:jar deploy:deploy -Dusername=admin -Dpassword=Youssefkhadijafedi.1997*13"
          } catch (Exception e) {
            error("Packaging failed" + e)
          }
        }
      }
    }
    stage('Docker') {
        steps {
            call 'docker build -t timesheet:v1 .'
        }
    }
  }
}
