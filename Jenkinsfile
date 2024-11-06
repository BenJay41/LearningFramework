pipeline{

agent any

tools{
maven 'MAVEN_HOME'
}

stages{

stage("build"){
steps{

echo ('project is built')

}}

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
                    git 'https://github.com/BenJay41/LearningFramework'
                    sh "mvn clean install -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regression.xml"
                    
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
echo ('deployed to stage')
}
}















}







}