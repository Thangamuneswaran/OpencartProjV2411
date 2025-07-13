pipeline {
    agent any

    triggers {
        cron('0 19 * * *') // Runs every day at 7 PM
    }

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
            archiveArtifacts artifacts: '**/extent-report.html', allowEmptyArchive: true

            publishHTML([
                reportDir: 'target',
                reportFiles: 'extent-report.html',
                reportName: 'Extent Report',
                allowMissing: false,
                keepAll: true,
                alwaysLinkToLastBuild: true
            ])
        }
    }
}
