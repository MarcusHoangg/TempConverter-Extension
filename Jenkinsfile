pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {

        stage('Checkout SCM') {
            steps {
                git branch: 'master',
                    credentialsId: 'github-pat',
                    url: 'https://github.com/MarcusHoangg/TempConverter-Extension.git'
            }
        }

        stage('Check') {
            steps {
                bat 'mvn --version'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/TEST-*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco execPattern: '**/target/jacoco.exec'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t marcushoangg/tempconverter:latest .'
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                bat 'docker login -u marcushoangg -p YOUR_PASSWORD'
                bat 'docker push marcushoangg/tempconverter:latest'
            }
        }
    }
}