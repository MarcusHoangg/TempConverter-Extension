pipeline {
    agent any

    tools { maven 'Maven3' }

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
                bat 'mvn -q clean package'
            }
        }

        stage('Test + JaCoCo') {
            steps {
                bat 'mvn -q test jacoco:report'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    jacoco execPattern: 'target/jacoco.exec'
                }
            }
        }
    }
}