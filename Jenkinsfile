pipeline {
    agent any
    environment {
        PATH = "${env.PATH};C:\\Windows\\System32" // Update the PATH to include the directory of cmd.exe
        GIT_CREDENTIALS = credentials('amirdirin')
    }
     tools {
        maven 'M3'  // This tells Jenkins to auto-setup Maven in the PATH
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', credentialsId: 'ADirin', url: 'https://github.com/ADirin/TempConverter.git'
            }
        }
        stage('Build') {
           steps {
               bat 'mvn clean install'
           }
        }
        stage('Test') {
           steps{
               bat 'mvn test'
           }    
            post {
                success {
                    // Publish JUnit test results
                    junit '**/target/surefire-reports/TEST-*.xml'
                    // Generate JaCoCo code coverage report
                    jacoco(execPattern: '**/target/jacoco.exec')
                }
            }
        }
    }
}
