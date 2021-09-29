node('aws') {

    stage ("checkout"){
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'f18c2441-372d-4fb4-bcd3-56b3d0b1237a', url: 'https://github.com/mahdchek/high-way-to-devops']]])
    }

    stage ("build back end "){
        sh "chmod -R 777 high-way-to-devops/mvnw"
        sh "cd high-way-to-devops && ./mvnw clean package -DskipTest"
    }

    stage ("build front end"){
        sh "cd high-way-to-devops-front && npm install && ng build --prod"
    }

//    stage ("sonarqube"){
//        sh "cd high-way-to-devops && ./mvnw sonar:sonar \\\n" +
//                "  -Dsonar.projectKey=devops \\\n" +
//                "  -Dsonar.host.url=http://3.226.252.73:9011 \\\n" +
//                "  -Dsonar.login=042c188795d9431ad438663e464799a16b526ffb"
//    }

    stage ("deploy"){

        try{
            sh "sudo docker-compose down"
        }catch(Exception e){
            println "aucun contenur n'est lancé"
        }
        sh "sudo docker-compose up --build -d"
    }
}
