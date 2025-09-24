pipeline {
   
   agent any
   
   tools {
      maven 'maven'
      jdk 'jdk'
   }
   
   stages {
      
      stage("build") {
         steps {
            echo("build the project")
            
            
            
         }
      }
      
      stage("Run Unit test") {
         steps {
            echo("run UTs")
         }
      }
      
      stage("Run Integration test") {
         steps {
            echo("run ITs")
         }
      }
      
      stage("Deploy to dev") {
         steps {
            echo("deploy to dev")
         }
      }
      
      stage("Deploy to QA") {
         steps {
            echo("deploy to QA")
         }
      }
      
      stage('Run Regression Automation Tests') {
         
         steps {
            
            git branch: 'master', url: 'https://github.com/sudeeppanshikar/RestAssuredAPI.git'
            sh "mvn clean install"
            
         }
         
      }
      
      stage('Publish Allure Reports') {	
         steps {
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
      
      stage("Deploy to stage") {
         steps {
            echo("deploy to stage")
         }
      }
      
      stage("Run sanity test cases on Stage") {
         steps {
            echo("Run sanity test cases on Stage")
         }
      }
      
      stage("Deploy to uat") {
         steps {
            echo("deploy to stage")
         }
      }
      
      stage("Run sanity test cases on uat") {
         steps {
            echo("Run sanity test cases on UAT")
         }
      }
      
      stage("Deploy to PROD") {
         steps {
            echo("deploy to PROD")
         }
      }
      
      
      
   }
   
   post {
      always {
         script {
            echo "Build result is: ${currentBuild.result}"
         }
      }
   }
   
   
}
