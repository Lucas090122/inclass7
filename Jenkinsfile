pipeline {
    agent any
     environment {
            MAVEN_HOME = "C:\\program files\\maven"
            PATH = "${env.PATH};${env.MAVEN_HOME}\\bin"
            // Define Docker Hub credentials ID
            DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
            // Define Docker Hub repository name
            DOCKERHUB_REPO = 'atz7689/week7_inclass_test1'
            // Define Docker image tag
            DOCKER_IMAGE_TAG = 'latest_v1'
        }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Lucas090122/inclass7.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

         stage('Build Docker Image') {
                    steps {
                        // Build Docker image
                        script {
                            bat "docker build -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG} ."
                            }
                    }
                }
                stage('Push Docker Image to Docker Hub') {
                    steps {
                        // Push Docker image to Docker Hub
                        script {
                                    bat "docker login -u ${DOCKERHUB_CREDENTIALS_ID} -p ${DOCKERHUB_CREDENTIALS_PASSWORD}"
                                    bat "docker push ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}"
                                }
                        }
                    }
                }
    }
}
