pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/Thangamuneswaran/OpencartProjV2411.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                // deployment steps
            }
        }
    }
}
