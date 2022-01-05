node{
    def MAVEN_HOME = tool "vmaven"
    env.PATH = "${env.PATH}:${MAVEN_HOME}/bin"
    
    stage ('checkout'){
        checkout([$class: 'GitSCM', branches: [[name: 'main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ved2728/profile-service.git']]])
    }
    
    stage('compile'){
       sh 'mvn clean compile'
    }
    stage('unit testing'){
        sh 'mvn test'
    }
    stage('code quality analysis')
    {
        withSonarQubeEnv('ved2000')
        {
            sh 'mvn sonar:sonar -Dsonar.organization=vedant1 -Dsonar.projectKey=profile1'
        }
    }
    stage("Quality Gate"){
          timeout(time: 1, unit: 'HOURS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
      }
}
