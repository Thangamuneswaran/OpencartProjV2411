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
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'target/extent-report.html', allowEmptyArchive: true
            publishHTML(target: [
                reportDir: 'target',
                reportFiles: 'extent-report.html',
                reportName: 'Extent Report',
                keepAll: true,
                allowMissing: false
            ])
        }
    }
}
