pipeline {
    agent any

    stages {
        stage('Build') {
            steps{
                echo 'project is build'
            }
        }
        
        stage('Deploy to Dev') {
            steps{
                echo 'deploy to dev env'
            }
        }
        
        stage('RUN UTs') {
            steps{
                echo 'run unit test cases'
            }
        }
        
        stage('Deploy to QA') {
            steps{
                echo 'deploy to QA env'
            }
        }
        
        stage('RUN Regression Automationtest') {
            steps{
                echo 'run Regression Automation test cases'
            }
        }
        
        stage('Deploy to Stage') {
            steps{
                echo 'deploy to Stage env'
            }
        }
        
        stage('Run Sanity test') {
            steps{
                echo 'run Sanity test cases'
            }
        }
        
        stage('Deploy to PROD') {
            steps{
                echo 'deploy to PROD env'
            }
        }
        
    }
}