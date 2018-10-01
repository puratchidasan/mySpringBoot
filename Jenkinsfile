pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Building'
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'My_GIT_HUB_REPO_DETAILS', url: 'https://github.com/puratchidasan/mySpringBoot.git']]])
        echo 'Checkout done.'
      }
    }
    stage('Some Testing') {
      steps {
        parallel(
          "Step 1": {
            echo 'Step 1'
           },
          "Step 2": {
            echo 'Step 2'
           }
        )
      }
    }
    stage('Send Mail') {
      steps {
        echo "sending mail"
        cleanWs()

      }
    }
    stage('Workspace CleanUP') {
      steps {
        echo "clean up..."
        //cleanWs()
      }
    }
  }
}
