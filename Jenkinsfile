node {
    def commit_id
    stage('Preparation') {
        checkout scm
        sh "git rev-parse --short HEAD > .git/commit-id"
        commit_id = readFile('.git/commit-id').trim()
    }
    stage('Test in container') {
        def testContainer = docker.image('adoptopenjdk/maven-openjdk8')
        testContainer.pull()
        testContainer.inside {
        sh 'mvn test'
        }
    }
    stage('Push to Docker') {
        docker.withRegistry('https://index.docker.io/v1/', 'dockerhub') {
            def app = docker.build("lsmarsden/time-teller:${commit_id}", '.').push()
        }
    }
}