node('aws') {

    stage ("checkout"){
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'f18c2441-372d-4fb4-bcd3-56b3d0b1237a', url: 'https://github.com/mahdchek/high-way-to-devops']]])
    }

    stage ("build back end "){
        sh "chmod -R 777 high-way-to-devops/mvnw"
        sh "cd high-way-to-devops && ./mvnw clean package -DskipTests"
    }

    stage ("build front end"){
        sh "cd high-way-to-devops-front && npm install && ng build --prod"
    }

    stage ("build docker images"){
        sh "cd high-way-to-devops && sudo docker build -t back ."
        sh "cd high-way-to-devops-front && sudo docker build -t front ."
    }

    stage("push images"){
        sh "sudo docker login --username $username --password $password"
        sh "sudo docker tag front mchekini/front:$version"
        sh "sudo docker tag back mchekini/back:$version"
        sh "sudo docker push mchekini/front:$version"
        sh "sudo docker push mchekini/back:$version"
    }

    stage("remove images from CI VM"){
        sh "sudo docker rmi mchekini/back:$version"
        sh "sudo docker rmi mchekini/front:$version"
        sh "sudo docker rmi front"
        sh "sudo docker rmi back"
    }

    stage ("deploy"){
        stash includes: 'kubernetes/**/*', name: 'kubernetes-resources'
        stash includes: 'helm/**/*', name: 'helm-chart'
        node ("kube-cluster"){
        unstash 'kubernetes-resources'
        unstash 'helm-chart'
        sh "cd kubernetes && chmod 777 kubernetes.sh && ./kubernetes.sh"
            sh "cd helm && helm install high-way ./"
        }
    }
}
