pipeline {
	agent any
	tools {
		maven 'my-maven'
		jdk 'my-jdk'
	}
	stages {
		stage('Clone'){
			steps {git url:'https://github.com/DevaNandaRadhakrishnan/SpringSecurity.git', branch:'main'}
		}
// 		stage('Pre-Steps'){
// 		steps{
// 		    bat '''
// 		        docker stop auth-container || true
// 		        docker rm auth-container || true
// 		        docker rmi -f gateway: latest || true
// 		    '''}}
		stage('Build'){
			steps {bat "mvn clean install -DskipTests"}
		}
		stage('Test'){
			steps{bat "mvn test"}
		}
		stage('Deploy') {
			steps { bat "docker build -t springsecurity ."
			        bat "docker run -p 8090:8090 -d --name springsecurity springsecurity"}
		}
	}
}

