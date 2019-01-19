folder('dockerfiles') {
    description('Personnal Dockerfiles')
}

def directory = new File("$WORKSPACE")
directory.eachFile (groovy.io.FileType.DIRECTORIES) { file ->
    def dockerFile = file.getName()
    if (dockerFile == ".git") {
        return
    }

    def dockerName = "jdecool/$dockerFile"
    def jenkinsPath = "dockerfiles/$dockerFile"

    freeStyleJob("$jenkinsPath") {
        scm {
            git("git@github.com:jdecool/dockerfiles.git")
        }

        logRotator {
            numToKeep(10)
        }

         triggers {
            cron('15 0 * * *')
        }

        steps {
            dockerBuildAndPublish {
                buildContext(file.toString())
                repositoryName("$dockerName")
                forceTag(false)
                registryCredentials('dockerio-registry')
                noCache(true)
            }
        }
    }
}