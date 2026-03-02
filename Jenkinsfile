pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'master',
                    credentialsId: 'github-pat',
                    url: 'https://github.com/MarcusHoangg/TempConverter-Extension.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    jacoco execPattern: '**/target/jacoco.exec'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t tempconverter:latest .'
            }
        }

        stage('Run Docker Container') {
            steps {
                bat 'docker run --rm tempconverter:latest'
            }
        }
    }
}