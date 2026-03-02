pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/MarcusHoangg/TempConverter-Extension.git'
            }
        }

        stage('Build + Test + Coverage') {
            steps {
                bat 'mvn -B clean test'
            }
            post {
                always {
                    junit 'target/surefire-reports/TEST-*.xml'
                    jacoco(execPattern: 'target/jacoco.exec')
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t tempconverter:latest .'
            }
        }

        stage('Run Docker') {
            steps {
                bat 'docker run --rm tempconverter:latest'
            }
        }
    }
}