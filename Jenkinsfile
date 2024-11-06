pipeline{

agent any

tools{
maven 'Maven3'
}

stages{

stage("build"){
steps{
echo ('this is building stage')
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

}







}