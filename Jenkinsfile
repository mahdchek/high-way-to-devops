node('aws') {

    stage ("checkout"){
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'f18c2441-372d-4fb4-bcd3-56b3d0b1237a', url: 'https://github.com/mahdchek/high-way-to-devops']]])
    }

    stage ("build back end "){
        sh "chmod -R 777 high-way-to-devops/mvnw"
        sh "cd high-way-to-devops && ./mvnw clean package"
    }

    stage ("build front end"){
        sh "cd high-way-to-devops-front && npm install && ng build --prod"
    }

    stage ("deploy"){
        sh "docker-compose --build up -d"
    }
}
