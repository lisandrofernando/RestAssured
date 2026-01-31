pipeline{
    agent any
    tools {
        maven 'Maven'
      }
      triggers {
          githubPush()
      }
    stages{
        stage('Clone the project'){
            steps{
                  checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/lisandrofernando/RestAssured.git']])
            }
        }
        stage('Build the project'){
            steps{
                sh 'mvn clean install'
            }
        }
        stage('Test the project'){
            steps{
                sh 'mvn test'
            }
        }
    }
}
