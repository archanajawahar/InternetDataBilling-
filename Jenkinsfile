pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
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
        }

        stage('Verify') {
            steps {
                bat 'mvn verify'
            }
        }
    }

    post {
        success {
            echo 'Internet Data Billing System - Build Successful'
        }

        failure {
            echo 'Build Failed'
        }
    }
}
