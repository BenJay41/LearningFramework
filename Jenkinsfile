pipeline{

agent any

tools{
maven 'Maven3'
}

stages{

stage("build"){
steps{
git 'https://github.com/jglick/simple-maven-project-with-tests.git'
                 sh "mvn -Dmaven.test.failure.ignore=true clean package"
                 
}

post 
            {
                success
                {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }

}

stage("Deploy to Dev"){
steps{
echo ('deployed to dev env')
}

}

stage("Run Unit test"){
steps{
echo ('unit test cases performed')
}

}


stage("deploy to QA env"){
steps{
echo ('deployed to QA')
}
}


stage("perform regression testing"){
steps{
catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/BenJay41/LearningFramework.git'
                    sh "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regression.xml"
                    
                }
}

}


stage("publish allure report"){
steps{
script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: '/allure-results']]
                    ])
                }
}
}




stage("publish extent report"){
steps{
publishHTML([allowMissing: false,
                                  alwaysLinkToLastBuild: false, 
                                  keepAll: true, 
                                  reportDir: 'reports', 
                                  reportFiles: 'Spark.html', 
                                  reportName: 'HTML Extent Report', 
                                  reportTitles: ''])
}
}




stage("deploy to Stage env"){
steps{
catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/naveenanimation20/June2022POMUIFramework.git'
                    sh "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_sanity.xml"
                    
                }
}
}


stage("deploy to Stage env"){
steps{
echo ('deployed to stage')
}
}





}







}